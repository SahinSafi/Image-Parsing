package com.cyberwith.imageparsing.network;

import com.cyberwith.imageparsing.models.ImageModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiInterface {

    @GET("v2/list")
    Call<List<ImageModel>> getImageList();
}
