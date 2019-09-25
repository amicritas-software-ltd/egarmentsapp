package com.amicritas.e_graments.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.adapter.PostAdapter;
import com.amicritas.e_graments.modals.PostDemo;

import java.util.ArrayList;
import java.util.List;

public class TimelineFragment extends Fragment {
    RecyclerView postRv;
    private List<PostDemo> postDemoList;


    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
        postDemoList = new ArrayList<>();

        postDemoList.add(new PostDemo("Elastic", "Mr. Sourav", "10"));
        postDemoList.add(new PostDemo("Pocketing fabric", "Mr. Estiak", "20"));
        postDemoList.add(new PostDemo("Ribbon", "Md. Aasif", "8"));
        postDemoList.add(new PostDemo("Elastic", "Bilal Ahmed", "12"));
        postDemoList.add(new PostDemo("Toggles", "MD. Ebrahim", "17"));
        postDemoList.add(new PostDemo("Lining", "Kafeel", "17"));
        postDemoList.add(new PostDemo("Lining", "Kamal", "16"));
        postDemoList.add(new PostDemo("Interlining", "Rahmat", "17"));
        postDemoList.add(new PostDemo("Rivet", "Sadaqat", "5"));
        postDemoList.add(new PostDemo("Collar bone.", "Iqbal Karik", "15"));


        postRv = view.findViewById(R.id.rvPost);
        postRv.setLayoutManager(new LinearLayoutManager(getContext()));

        final PostAdapter postAdapter = new PostAdapter(postDemoList);
        postRv.setAdapter(postAdapter);

        return view;
    }

}
