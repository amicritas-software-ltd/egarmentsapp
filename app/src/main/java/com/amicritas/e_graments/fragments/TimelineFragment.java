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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.activitys.MainActivity;
import com.amicritas.e_graments.activitys.MapsActivity;
import com.amicritas.e_graments.activitys.MessengerDialogsListActivity;
import com.amicritas.e_graments.activitys.ProductDetailsActivity;
import com.amicritas.e_graments.adapter.PostAdapter;
import com.amicritas.e_graments.modals.PostDemo;
import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.mlsdev.animatedrv.AnimatedRecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class TimelineFragment extends Fragment implements PostAdapter.PostAdapterEvent {
    private RecyclerView postRv;
    private TextView mainMenuTv;
    private List<PostDemo> postDemoList;

    private Button categoryTv, datefilterBtn, locationFilterBtn;
    private ImageView messageIv;
    private ImageButton searchViewImgBtn, closeSearchImgBtn;
    private LinearLayout searchViewLayout, filterViewLayout;
    private AppCompatAutoCompleteTextView searchAc;





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
        locationFilterBtn = view.findViewById(R.id.btnLocationFilter);
        searchAc = view.findViewById(R.id.acSearch);
        mainMenuTv = view.findViewById(R.id.tvMainMenu);
        messageIv = view.findViewById(R.id.ivMessage);




        setCategoryFilter();
        setDateFilter();
        setSearchView();
        setPopupMeny();
        setMessage();

        setLocationFilterView();
        if (searchAc.getText().toString().trim().isEmpty()){
            setCloseSearchView();
        }

        searchAc.addTextChangedListener(textChange);


        postDemoList = new ArrayList<>();

        setValue();

        postRv = view.findViewById(R.id.rvPost);
        postRv.setLayoutManager(new LinearLayoutManager(getContext()));

        final PostAdapter postAdapter = new PostAdapter(this, postDemoList);
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

    private void setMessage() {
        messageIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MessengerDialogsListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setPopupMeny() {
        mainMenuTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(v.getContext(), mainMenuTv);
                popupMenu.inflate(R.menu.my_post_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.menu_post_update:
                                Toast.makeText(v.getContext(), "Update", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_post_unpublished:
                                Toast.makeText(v.getContext(), "Unpublished", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_post_delete:
                                Toast.makeText(v.getContext(), "Delete", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    private void setLocationFilterView() {
        locationFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });
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
                /*Intent intent  =  new Intent(getActivity().getBaseContext(),
                        CategoryFragment.class);
                intent.putExtra("date", "date");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_out_bottom, R.anim.slide_out_bottom);

                fragmentTransaction.remove(new TimelineFragment());
                fragmentTransaction.replace(R.id.filter_frame, new DateFilterFragment());
                fragmentTransaction.commit();
                //startActivity(intent);*/

                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        (view1, year, monthOfYear, dayOfMonth, yearEnd, monthOfYearEnd, dayOfMonthEnd) -> getActivity(),
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setThemeDark(false);
                dpd.show(getActivity().getFragmentManager()," ");
                dpd.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
                        Toast.makeText(getContext(), "set: "+dayOfMonth+"to"+dayOfMonthEnd, Toast.LENGTH_SHORT).show();
                    }
                });

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

    @Override
    public void onProductClicked(PostDemo postDemo) {

        /*FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        fragmentTransaction.remove(new TimelineFragment());
        fragmentTransaction.replace(R.id.product_details_frame, new ProductDetilsFragment());
        fragmentTransaction.commit();*/

        Intent intent = new Intent(getContext(), ProductDetailsActivity.class);
        startActivity(intent);
    }
}
