package com.example.express_application.listenerr;

import com.example.express_application.model.CartModel;

import java.util.List;

public interface ICartLoadListenerr {
    void onCartLoadSuccess(List<CartModel> cartModelList);

     void onCartLoadFailed(String message);
}
