package com.amicritas.e_graments.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.activitys.ProductDetailsActivity;
import com.amicritas.e_graments.adapter.MyPostAdapter;
import com.amicritas.e_graments.adapter.PostAdapter;
import com.amicritas.e_graments.modals.PostDemo;
import com.mlsdev.animatedrv.AnimatedRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPostFragment extends Fragment implements MyPostAdapter.PostAdapterEvent{
    RecyclerView postRv;
    private List<PostDemo> postDemoList;
    //ImageView imgBackArrow;


    public MyPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_post, container, false);

        //imgBackArrow = view.findViewById(R.id.imgBackArrow);

        //setBackPress();

        postDemoList = new ArrayList<>();

        postDemoList.add(new PostDemo("Elastic", "Mr. Sourav", "10", R.drawable.img_zipper));
        postDemoList.add(new PostDemo("Pocketing fabric", "Mr. Estiak", "20", R.drawable.img_zipper2));
        postDemoList.add(new PostDemo("Ribbon", "Md. Aasif", "8", R.drawable.img_zipper));
        postDemoList.add(new PostDemo("Elastic", "Bilal Ahmed", "12", R.drawable.img_zipper2));
        postDemoList.add(new PostDemo("Toggles", "MD. Ebrahim", "17", R.drawable.lnterlining));
        postDemoList.add(new PostDemo("Lining", "Kafeel", "17", R.drawable.img_zipper2));
        postDemoList.add(new PostDemo("Lining", "Kamal", "16", R.drawable.img_zipper2));
        postDemoList.add(new PostDemo("lnterlining", "Rahmat", "17", R.drawable.lnterlining));
        postDemoList.add(new PostDemo("Rivet", "Sadaqat", "5", R.drawable.img_zipper));
        postDemoList.add(new PostDemo("Collar bone.", "Iqbal Karik", "15", R.drawable.img_zipper2));
        postDemoList.add(new PostDemo("Elastic", "Mr. Sourav", "10", R.drawable.img_zipper));
        postDemoList.add(new PostDemo("Pocketing fabric", "Mr. Estiak", "20", R.drawable.img_zipper2));
        postDemoList.add(new PostDemo("Ribbon", "Md. Aasif", "8", R.drawable.img_zipper));
        postDemoList.add(new PostDemo("Elastic", "Bilal Ahmed", "12", R.drawable.img_zipper2));
        postDemoList.add(new PostDemo("Toggles", "MD. Ebrahim", "17", R.drawable.lnterlining));
        postDemoList.add(new PostDemo("Lining", "Kafeel", "17", R.drawable.img_zipper2));


        postRv = view.findViewById(R.id.rvPost);
        postRv.setLayoutManager(new LinearLayoutManager(getContext()));

        final MyPostAdapter myPostAdapter = new MyPostAdapter(this,postDemoList,getContext());
        postRv.setAdapter(myPostAdapter);

        AnimatedRecyclerView recyclerView = new AnimatedRecyclerView.Builder(view.getContext())
                .orientation(LinearLayoutManager.VERTICAL)
                .layoutManagerType(AnimatedRecyclerView.LayoutManagerType.LINEAR)
                .animation(R.anim.layout_animation_from_bottom)
                .animationDuration(600)
                .reverse(false)
                .build();
        recyclerView.scheduleLayoutAnimation();

        return view;
    }

    /*private void setBackPress() {
        imgBackArrow.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.replace(R.id.main_frame, new MyProfileFragment());
            fragmentTransaction.commit();
        });
    }*/

    @Override
    public void onProductClicked(PostDemo postDemo) {
        Intent intent = new Intent(getContext(), ProductDetailsActivity.class);
        startActivity(intent);
    }
}
