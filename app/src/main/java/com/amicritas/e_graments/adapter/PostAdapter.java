package com.amicritas.e_graments.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.modals.PostDemo;

import java.util.List;

import static com.amicritas.e_graments.R.drawable.ic_favorite_border_red;
import static com.amicritas.e_graments.R.drawable.ic_favorite_red;

import static com.amicritas.e_graments.R.drawable.not_intersted_black;
import static com.amicritas.e_graments.R.drawable.not_intersted_gray;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<PostDemo> postDemoList;

    public PostAdapter(List<PostDemo> postDemoList) {
        this.postDemoList = postDemoList;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.timeline_card_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        final PostDemo postDemo = postDemoList.get(position);
        holder.titleTv.setText(postDemo.getTitle());
        holder.postByTv.setText(postDemo.getPostedBy());
        holder.pricetv.setText(postDemo.getPrice()+"৳");
        holder.productImg.setImageResource(postDemo.getImg());
        String favoritStatus = postDemo.getFevoriteStatus();
        if (favoritStatus.equals("1")) {
            holder.addFavoriteIv.setImageResource(ic_favorite_border_red);
        }else {
            holder.addFavoriteIv.setImageResource(ic_favorite_red);
        }

        String flagStatus = postDemo.getFlagStatus();
        if (flagStatus.equals("1")) {
            holder.addFlagIv.setImageResource(not_intersted_black);
        }else {
            holder.addFlagIv.setImageResource(not_intersted_gray);
        }


        holder.addFavoriteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Favorite Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "layout", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return postDemoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, postByTv, pricetv;
        ImageView addFavoriteIv, addFlagIv, productImg;
        LinearLayout itemLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.tvProductTitle);
            postByTv = itemView.findViewById(R.id.tvPostAuthorName);
            pricetv = itemView.findViewById(R.id.tvProductPrice);
            addFavoriteIv = itemView.findViewById(R.id.ivAddFavorite);
            addFlagIv = itemView.findViewById(R.id.ivAddFlag);
            productImg = itemView.findViewById(R.id.ivProductImg);
            itemLayout = itemView.findViewById(R.id.itemLayout);
        }
    }
}
