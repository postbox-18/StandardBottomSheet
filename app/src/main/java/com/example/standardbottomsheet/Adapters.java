package com.example.standardbottomsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapters extends RecyclerView.Adapter<Adapters.ViewHolder> {
    private Context context;
    private List<ItemList> itemLists=new ArrayList<>();


    public Adapters(Context context, List<ItemList> itemLists) {
        this.context = context;
        this.itemLists = itemLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapters_layout, parent, false);
        return new ViewHolder(view);
        //return view;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemList itemLists1=itemLists.get(position);
        holder.item.setText(String.valueOf(itemLists1.getItemName()));
        holder.count.setText(String.valueOf(itemLists1.getItemCount()));


    }


    @Override
    public int getItemCount() {

        return itemLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView item,count;


        public ViewHolder(View view) {
            super(view);
            item = view.findViewById(R.id.item);
            count = view.findViewById(R.id.count);


        }
    }
}
