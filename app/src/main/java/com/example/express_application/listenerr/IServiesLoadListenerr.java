package com.example.express_application.listenerr;

import com.example.express_application.model.ServiceModel;

import java.util.List;

public interface IServiesLoadListenerr {
    void onServiesLoadSuccess(List<ServiceModel> serviceModelList);
    void onServiesLoadFailed(String message);
}
