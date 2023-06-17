package com.example.express_application;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class edit_admin extends AppCompatActivity {
    private ImageView imageupload;
    private   EditText uplodname, priceeserv, Deseserv;
    private   Button uploadserv;

    private Uri image;

    final private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Servies");
    final private StorageReference storageReference = FirebaseStorage.getInstance().getReference();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_admin);

        uploadserv = findViewById(R.id.uploadserv);
        uplodname = findViewById(R.id.uplodname);
        priceeserv = findViewById(R.id.priceeserv);
        Deseserv = findViewById(R.id.Deseserv);
        imageupload = findViewById(R.id.imageupload);


        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            image = data.getData();
                            imageupload.setImageURI(image);
                        } else {
                            Toast.makeText(edit_admin.this, "No image selection", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        );


        imageupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        uploadserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (image != null) {
                    uploadToFirebase(image);

                } else {
                    Toast.makeText(edit_admin.this, "please select image", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void uploadToFirebase(Uri uri) {
        String name = uplodname.getText().toString();
        String Price = priceeserv.getText().toString();
        String Description = Deseserv.getText().toString();
        final StorageReference imageReference = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(uri));

        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Servies")
                .child(uri.getLastPathSegment());

        AlertDialog.Builder builder = new AlertDialog.Builder(edit_admin.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layoy);
        AlertDialog dialog = builder.create();
        dialog.show();

        imageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Servies servies = new Servies(name, Price,uri.toString(),Description);
                        String key = databaseReference.push().getKey();
                        databaseReference.child(key).setValue(servies);
                        Toast.makeText(edit_admin.this, "uploaded", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(edit_admin.this, Servies_page.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(edit_admin.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getFileExtension(Uri fileUri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(fileUri));
    }
}