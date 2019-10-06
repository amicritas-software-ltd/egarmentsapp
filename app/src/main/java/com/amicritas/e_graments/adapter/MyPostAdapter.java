package com.amicritas.e_graments.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.modals.PostDemo;

import org.w3c.dom.Text;

import java.util.List;

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.ViewHolder> {
    private List<PostDemo> postDemoList;
    private Context context;

    public MyPostAdapter(List<PostDemo> postDemoList, Context context) {
        this.postDemoList = postDemoList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyPostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_post_card_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyPostAdapter.ViewHolder holder, int position) {
        final PostDemo postDemo = postDemoList.get(position);
        holder.titleTv.setText(postDemo.getTitle());
        holder.postByTv.setText(postDemo.getPostedBy());
        holder.pricetv.setText(postDemo.getPrice()+"৳");
        holder.productImg.setImageResource(postDemo.getImg());
        holder.menuTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, holder.menuTv);
                popupMenu.inflate(R.menu.my_post_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.menu_post_update:
                                Toast.makeText(context, "Update", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_post_unpublished:
                                Toast.makeText(context, "Unpublished", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_post_delete:
                                Toast.makeText(context, "Delete", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
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
        TextView titleTv, postByTv, pricetv, menuTv;
        ImageView productImg;
        LinearLayout itemLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.tvProductTitle);
            postByTv = itemView.findViewById(R.id.tvPostAuthorName);
            pricetv = itemView.findViewById(R.id.tvProductPrice);
            productImg = itemView.findViewById(R.id.ivProductImg);
            itemLayout = itemView.findViewById(R.id.itemLayout);
            menuTv = itemView.findViewById(R.id.tvMenu);
        }
    }
}
