package com.amicritas.e_graments.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.modals.PostDemo;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    List<PostDemo> postDemoList;

    public PostAdapter(List<PostDemo> postDemoList) {
        this.postDemoList = postDemoList;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.timeline_card_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        final PostDemo postDemo = postDemoList.get(position);
        holder.titleTv.setText(postDemo.getTitle());
        holder.postByTv.setText(postDemo.getPostedBy()+"৳");
        holder.pricetv.setText(postDemo.getPrice());
        
        holder.addFavoriteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Favorite Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return postDemoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, postByTv, pricetv;
        ImageView addFavoriteIv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.tvProductTitle);
            postByTv = itemView.findViewById(R.id.tvPostAuthorName);
            pricetv = itemView.findViewById(R.id.tvProductPrice);
            addFavoriteIv = itemView.findViewById(R.id.ivAddFavorite);
        }
    }
}
