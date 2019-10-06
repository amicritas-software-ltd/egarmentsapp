package com.amicritas.e_graments.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.amicritas.e_graments.R;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;



public class TitleChildViewHolder extends ChildViewHolder {
    public TextView option1,option2, option3;
    public TitleChildViewHolder(View itemView) {
        super(itemView);
        option1 = (TextView)itemView.findViewById(R.id.tvCategory1ChildTitle);
        option2 = (TextView)itemView.findViewById(R.id.tvCategory2ChildTitle);
        option3 = (TextView)itemView.findViewById(R.id.tvCategory3ChildTitle);
    }
}
