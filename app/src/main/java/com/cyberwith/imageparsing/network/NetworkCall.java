package com.cyberwith.imageparsing.network;

import com.cyberwith.imageparsing.models.ImageModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall implements MyApiservice {
    @Override
    public void getImage(final ResponseCallback callback) {
        RetrofitApiInterface retrofitApiInterface = RetrofitApiClient.getClient().create(RetrofitApiInterface.class);
        Call<List<ImageModel>> call = retrofitApiInterface.getImageList();

        call.enqueue(new Callback<List<ImageModel>>() {
            @Override
            public void onResponse(Call<List<ImageModel>> call, Response<List<ImageModel>> response) {
                List<ImageModel> imageModelList = response.body();
                if (imageModelList != null){
                    callback.onSuccess(imageModelList);
                }else {
                    callback.onError(new Exception(response.message()));
                }
            }

            @Override
            public void onFailure(Call<List<ImageModel>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
