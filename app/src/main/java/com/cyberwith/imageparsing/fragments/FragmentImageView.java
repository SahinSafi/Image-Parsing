package com.cyberwith.imageparsing.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.cyberwith.imageparsing.R;
import com.cyberwith.imageparsing.models.ImageViewModel;

public class FragmentImageView extends Fragment {

    private ImageViewModel imageViewModel;
    private TextView name;
    private ImageView imageView;

    public FragmentImageView() {
    }

    public FragmentImageView(ImageViewModel imageViewModel) {
        this.imageViewModel = imageViewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_view, container, false);
        name = view.findViewById(R.id.nameTextID);
        imageView = view.findViewById(R.id.imageViewID);

        Glide.with(getContext()).load(imageViewModel.getImageURL()).into(imageView);
        name.setText(imageViewModel.getAuthor());

        return view;
    }
}
