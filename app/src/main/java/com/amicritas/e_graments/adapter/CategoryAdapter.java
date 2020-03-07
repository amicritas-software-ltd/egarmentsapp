package com.amicritas.e_graments.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.ViewHolders.TitleChildViewHolder;
import com.amicritas.e_graments.ViewHolders.TitleParentViewHolder;
import com.amicritas.e_graments.modals.TitleChild;
import com.amicritas.e_graments.modals.TitleParent;
import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

public class CategoryAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder, TitleChildViewHolder> {

    LayoutInflater inflater;

    public CategoryAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
       View view = inflater.inflate(R.layout.parent_category_layout,viewGroup,false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.child_category_layout,viewGroup,false);
        return new TitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent title = (TitleParent)o;
        titleParentViewHolder._textView.setText(title.getTitle());

    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChildViewHolder, int i, Object o) {
        TitleChild title = (TitleChild)o;
        titleChildViewHolder.option1.setText(title.getOption1());
        titleChildViewHolder.option2.setText(title.getOption2());

    }
}
