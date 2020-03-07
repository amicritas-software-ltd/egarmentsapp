package com.amicritas.e_graments.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.amicritas.e_graments.R;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;



public class TitleParentViewHolder extends ParentViewHolder {
    public TextView _textView;
    public ImageButton _imageButton;

    public TitleParentViewHolder(View itemView) {
        super(itemView);
        _textView = (TextView)itemView.findViewById(R.id.tvCategoryParentTitle);
        //_imageButton = (ImageButton) itemView.findViewById(R.id.expandArrow);
    }
}
