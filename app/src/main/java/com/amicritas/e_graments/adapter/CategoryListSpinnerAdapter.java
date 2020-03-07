package com.amicritas.e_graments.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.modals.Category;

import java.util.ArrayList;


public class CategoryListSpinnerAdapter extends ArrayAdapter<Category> {

    public CategoryListSpinnerAdapter(Context context, ArrayList<Category> companyArrayList) {
        super(context, 0,  companyArrayList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    private View initView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.category_name_spinner_layout, parent,false);
        }

        TextView categoryNameTv = convertView.findViewById(R.id.tvCategoryNameSpinner);

        Category category = getItem(position);

        if (category != null){
            categoryNameTv.setText(category.getCategory_name());
        }
        return convertView;
    }
}
