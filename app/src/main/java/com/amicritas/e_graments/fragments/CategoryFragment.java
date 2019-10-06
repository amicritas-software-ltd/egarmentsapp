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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.adapter.CategoryAdapter;
import com.amicritas.e_graments.modals.TitleChild;
import com.amicritas.e_graments.modals.TitleCreator;
import com.amicritas.e_graments.modals.TitleParent;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {

    private ImageView backIv;
    private LinearLayout categoryBlankLayout;
    RecyclerView categoryRecyclerView;
    LinearLayout categoryLayout, dateFilterLayout;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((CategoryAdapter)categoryRecyclerView.getAdapter()).onSaveInstanceState(outState);
    }


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        categoryLayout = view.findViewById(R.id.layoutCategory);
        dateFilterLayout = view.findViewById(R.id.layoutDateFilter);

        Intent intent = new Intent();
        String filterType;
        filterType = intent.getStringExtra("date");
        filterType = intent.getStringExtra("category");

       /* if (filterType.equals("category")) {
            dateFilterLayout.setVisibility(View.GONE);
            categoryLayout.setVisibility(View.VISIBLE);
        } else if (filterType.equals("date")) {
            categoryLayout.setVisibility(View.GONE);
            dateFilterLayout.setVisibility(View.VISIBLE);
        }*/
        backIv = view.findViewById(R.id.imgBackArrow);
        categoryBlankLayout = view.findViewById(R.id.categoryBlankLayout);

        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);

                fragmentTransaction.remove(new TimelineFragment());
                fragmentTransaction.replace(R.id.main_frame, new TimelineFragment());
                fragmentTransaction.commit();*/
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_out_bottom, R.anim.slide_out_top).remove(CategoryFragment.this).commit();

            }
        });

        categoryBlankLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_out_bottom, R.anim.slide_out_top).remove(CategoryFragment.this).commit();
            }
        });

        categoryRecyclerView = (RecyclerView)view.findViewById(R.id.rvCategory);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        CategoryAdapter adapter = new CategoryAdapter(getContext(),initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        categoryRecyclerView.setAdapter(adapter);


        return view;
    }

    private List<ParentObject> initData() {
        TitleCreator titleCreator = TitleCreator.get(getContext());
        List<TitleParent> titles = titleCreator.getAll();
        List<ParentObject> parentObject = new ArrayList<>();
        for(TitleParent title:titles)
        {
            List<Object> childList = new ArrayList<>();
            childList.add(new TitleChild("Shart","T-Shart"));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        return parentObject;

    }

}
