package com.cyberwith.imageparsing.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cyberwith.imageparsing.R;
import com.cyberwith.imageparsing.adapters.ImageListAdapter;
import com.cyberwith.imageparsing.models.ImageModel;
import com.cyberwith.imageparsing.network.MyApiservice;
import com.cyberwith.imageparsing.network.NetworkCall;
import com.cyberwith.imageparsing.network.ResponseCallback;

import java.util.List;

public class FragmentImageList extends Fragment{

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_list, container, false);

        recyclerView = view.findViewById(R.id.imageListRecyclerViewID);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentImageView fragmentImageView = new FragmentImageView();
//                getFragmentManager().beginTransaction().replace(android.R.id.content, fragmentImageView)
//                        .addToBackStack(null)
//                        .commit();
//            }
//        });
        getData();
        return view;
    }


    private void getData() {
        MyApiservice myApiservice = new NetworkCall();
        myApiservice.getImage(new ResponseCallback() {
            @Override
            public void onSuccess(List<ImageModel> imageModels) {
                List<ImageModel> imageModelList = imageModels;
                recyclerView.setAdapter(new ImageListAdapter(getContext(), imageModelList));
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

}
