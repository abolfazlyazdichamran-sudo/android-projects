package com.example.myapplicationdo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    public static DetailFragment newInstance(int imageRes) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt("imageRes", imageRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ImageView imageView = view.findViewById(R.id.detailImage);
        if (getArguments() != null) {
            imageView.setImageResource(getArguments().getInt("imageRes"));
        }
        return view;
    }
}
