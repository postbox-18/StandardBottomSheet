package com.example.standardbottomsheet;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ItemAdapters extends RecyclerView.Adapter<ItemAdapters.ViewHolder> {
    private Context context;
    private ArrayList<String> itemList = new ArrayList<>();
    private int s_count = -1;
    private String TAG = "ItemAdapters";
    AddItem addItem;
    private LinkedHashMap<String, String> map = new LinkedHashMap<>();

    public interface AddItem {

        void AddItem(LinkedHashMap<String, String> map);
    }

    public ItemAdapters(Context context, ArrayList<String> itemList, AddItem addItem, LinkedHashMap<String, String> map) {
        this.context = context;
        this.itemList = itemList;
        this.addItem = addItem;
        this.map = map;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.itemadapters_layout, parent, false);
        return new ViewHolder(view);
        //return view;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String listNames1 = itemList.get(position);
        holder.item.setText(String.valueOf(listNames1));



        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e(TAG, "s_count>>minus>>map>>itemadapters>>" + map);
                if (map == null) {
                    s_count = 0;
                    Log.e(TAG, "s_count>>minus>>map>>itemadapters>>map is null ");

                } else {
                    if (map.get(listNames1) == null) {
                        s_count = 0;
                        Log.e(TAG, "s_count>>minus>>map>>itemadapters>map get null");

                    } else {
                        s_count = Integer.parseInt(map.get(listNames1));
                        Log.e(TAG, "s_count>>minus>>map>>itemadapters>s_count>>"+s_count);

                    }

                }






                s_count--;
                if (s_count < 0) {
                    holder.count.setText("0");
                    map.put(listNames1, "0");
                    addItem.AddItem(map);

                } else {
                    holder.count.setText(String.valueOf(s_count));
                    map.put(listNames1, String.valueOf(s_count));
                    addItem.AddItem(map);

                }
                Log.e(TAG, "s_count>>minus>>" + s_count);

            }
        });

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e(TAG, "s_count>>plus>>map>>itemadapters>>" + map);
                if (map == null) {
                    s_count = 0;
                    Log.e(TAG, "s_count>>plus>>map>>itemadapters>>map is null ");

                } else {
                    if (map.get(listNames1) == null) {
                        s_count = 0;
                        Log.e(TAG, "s_count>>plus>>map>>itemadapters>map get null");

                    } else {
                        s_count = Integer.parseInt(map.get(listNames1));
                        Log.e(TAG, "s_count>>plus>>map>>itemadapters>s_count>>"+s_count);

                    }

                }






                s_count++;
                holder.count.setText(String.valueOf(s_count));
                Log.e(TAG, "s_count>>plus>>" + s_count);
                Log.e(TAG, "s_count>>plus>>listNames1>>" + listNames1);
                map.put(listNames1, String.valueOf(s_count));
                addItem.AddItem(map);

            }
        });


    }


    @Override
    public int getItemCount() {

        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView item, count;
        private ImageView plus, minus;


        public ViewHolder(View view) {
            super(view);
            item = view.findViewById(R.id.item);
            count = view.findViewById(R.id.count);
            plus = view.findViewById(R.id.plus);
            minus = view.findViewById(R.id.minus);


        }
    }
}

