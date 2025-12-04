package com.example.myapplicationdo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> items;
    private Context context;
    private boolean isLandscape;

    public ItemAdapter(Context context, List<Item> items, boolean isLandscape) {
        this.context = context;
        this.items = items;
        this.isLandscape = isLandscape;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getDescription());
        holder.image.setImageResource(item.getImageRes());

        holder.itemView.setOnClickListener(v -> {
            if (isLandscape && context instanceof MainActivity) {
                ((MainActivity) context).showDetailFragment(item.getImageRes());
            } else {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("imageRes", item.getImageRes());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, desc;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.itemImage);
            title = itemView.findViewById(R.id.itemTitle);
            desc = itemView.findViewById(R.id.itemDesc);
        }
    }
}
