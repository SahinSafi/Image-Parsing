package com.cyberwith.imageparsing.network;

import com.cyberwith.imageparsing.models.ImageModel;

import java.util.List;

public interface ResponseCallback {

    void onSuccess(List<ImageModel> imageModels);
    void onError(Throwable throwable);
}
