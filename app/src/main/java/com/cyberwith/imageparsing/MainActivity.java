package com.cyberwith.imageparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cyberwith.imageparsing.fragments.FragmentImageList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameID, new FragmentImageList())
                .commit();
    }
}
