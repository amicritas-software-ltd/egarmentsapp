package com.amicritas.e_graments.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.adapter.PostAdapter;
import com.amicritas.e_graments.modals.PostDemo;
import com.mlsdev.animatedrv.AnimatedRecyclerView;

import java.util.ArrayList;
import java.util.List;



public class TimelineFragment extends Fragment {
    RecyclerView postRv;
    private List<PostDemo> postDemoList;

    Button categoryTv, datefilterBtn;
    ImageButton searchViewImgBtn, closeSearchImgBtn;
    LinearLayout searchViewLayout, filterViewLayout;
    AppCompatAutoCompleteTextView searchAc;





    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
        categoryTv = view.findViewById(R.id.btnAllCategory);
        datefilterBtn = view.findViewById(R.id.btnDate);
        searchViewImgBtn = view.findViewById(R.id.iBtnSearch);
        closeSearchImgBtn = view.findViewById(R.id.iBtnCloseSearch);
        filterViewLayout = view.findViewById(R.id.filterLayout);
        searchViewLayout = view.findViewById(R.id.searchLayout);
        searchAc = view.findViewById(R.id.acSearch);


        setCategoryFilter();
        setDateFilter();
        setSearchView();
        if (searchAc.getText().toString().trim().isEmpty()){
            setCloseSearchView();
        }

        searchAc.addTextChangedListener(textChange);


        postDemoList = new ArrayList<>();

        setValue();

        postRv = view.findViewById(R.id.rvPost);
        postRv.setLayoutManager(new LinearLayoutManager(getContext()));

        final PostAdapter postAdapter = new PostAdapter(postDemoList);
        AnimatedRecyclerView recyclerView = new AnimatedRecyclerView.Builder(view.getContext())
                .orientation(LinearLayoutManager.VERTICAL)
                .layoutManagerType(AnimatedRecyclerView.LayoutManagerType.LINEAR)
                .animation(R.anim.layout_animation_from_bottom)
                .animationDuration(3000)
                .reverse(false)
                .build();
        recyclerView.scheduleLayoutAnimation();
        postRv.setAdapter(postAdapter);

        /*int SPLASH_TIMR_OUT = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        },SPLASH_TIMR_OUT);*/

        return view;

    }

    private void setCloseSearchView() {
        closeSearchImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchViewLayout.setVisibility(View.GONE);
                filterViewLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    private void setSearchView() {
        searchViewImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterViewLayout.setVisibility(View.GONE);
                searchViewLayout.setVisibility(View.VISIBLE);
            }
        });
    }


    private void setDateFilter() {
        datefilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dateFilterLayout.setVisibility(View.VISIBLE);
                Intent intent  =  new Intent(getActivity().getBaseContext(),
                        CategoryFragment.class);
                intent.putExtra("date", "date");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_out_bottom, R.anim.slide_out_bottom);

                fragmentTransaction.remove(new TimelineFragment());
                fragmentTransaction.replace(R.id.filter_frame, new DateFilterFragment());
                fragmentTransaction.commit();
                //startActivity(intent);
            }
        });
    }

    private void setValue() {
        postDemoList.add(new PostDemo("Elastic", "Mr. Sourav", "10", R.drawable.img_zipper, "1", "0"));
        postDemoList.add(new PostDemo("Pocketing fabric", "Mr. Estiak", "20", R.drawable.img_zipper2, "0", "1"));
        postDemoList.add(new PostDemo("Ribbon", "Md. Aasif", "8", R.drawable.img_zipper, "0", "0"));
        postDemoList.add(new PostDemo("Elastic", "Bilal Ahmed", "12", R.drawable.img_zipper2, "1", "0"));
        postDemoList.add(new PostDemo("Toggles", "MD. Ebrahim", "17", R.drawable.lnterlining, "0", "1"));
        postDemoList.add(new PostDemo("Lining", "Kafeel", "17", R.drawable.img_zipper2, "1", "0"));
        postDemoList.add(new PostDemo("Lining", "Kamal", "16", R.drawable.img_zipper2, "0", "1"));
        postDemoList.add(new PostDemo("lnterlining", "Rahmat", "17", R.drawable.lnterlining, "0", "0"));
        postDemoList.add(new PostDemo("Rivet", "Sadaqat", "5", R.drawable.img_zipper, "0", "0"));
        postDemoList.add(new PostDemo("Collar bone.", "Iqbal Karik", "15", R.drawable.img_zipper2, "1", "0"));
        postDemoList.add(new PostDemo("Elastic", "Mr. Sourav", "10", R.drawable.img_zipper, "1", "0"));
        postDemoList.add(new PostDemo("Pocketing fabric", "Mr. Estiak", "20", R.drawable.img_zipper2, "0", "1"));
        postDemoList.add(new PostDemo("Ribbon", "Md. Aasif", "8", R.drawable.img_zipper, "0", "0"));
        postDemoList.add(new PostDemo("Elastic", "Bilal Ahmed", "12", R.drawable.img_zipper2, "1", "0"));
        postDemoList.add(new PostDemo("Toggles", "MD. Ebrahim", "17", R.drawable.lnterlining, "0", "1"));
        postDemoList.add(new PostDemo("Lining", "Kafeel", "17", R.drawable.img_zipper2, "1", "0"));
        postDemoList.add(new PostDemo("Lining", "Kamal", "16", R.drawable.img_zipper2, "0", "1"));
        postDemoList.add(new PostDemo("lnterlining", "Rahmat", "17", R.drawable.lnterlining, "0", "0"));
        postDemoList.add(new PostDemo("Rivet", "Sadaqat", "5", R.drawable.img_zipper, "0", "0"));
        postDemoList.add(new PostDemo("Collar bone.", "Iqbal Karik", "15", R.drawable.img_zipper2, "1", "0"));

    }

    private void setCategoryFilter() {
        categoryTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  =  new Intent(getActivity().getBaseContext(),
                        CategoryFragment.class);
                intent.putExtra("category", "category");
                //categoryLayout.setVisibility(View.VISIBLE);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_out_bottom, R.anim.slide_out_bottom);

                fragmentTransaction.remove(new TimelineFragment());
                fragmentTransaction.replace(R.id.filter_frame, new CategoryFragment());
                fragmentTransaction.commit();
                //startActivity(intent);
            }
        });
    }

    private TextWatcher textChange = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String searchKey = searchAc.getText().toString().toLowerCase().trim();
            if (searchKey.isEmpty()){
                closeSearchImgBtn.setImageResource(R.drawable.ic_close_gray);
                setCloseSearchView();
            }else if (!searchKey.isEmpty()){
                closeSearchImgBtn.setImageResource(R.drawable.ic_close_black);
                closeSearchImgBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        searchAc.setText(null);
                    }
                });
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

}
