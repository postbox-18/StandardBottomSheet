package com.example.standardbottomsheet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView_list;
    private ArrayList<String> stringArrayList = new ArrayList<>();
    private ItemAdapters itemAdapters;
    private String itemName, itemCount, TAG = "MainActivity";
    private List<ItemList> itemLists = new ArrayList<>();
    private LinkedHashMap<String, String> map = new LinkedHashMap<>();
    private ConstraintLayout constraintLayout;




    //Bottomsheet
    private RecyclerView recyclerView_bottom;
    private Adapters adapters;
    private LinearLayout mBottomSheetLayout;
    private BottomSheetBehavior sheetBehavior;

    private ItemAdapters.AddItem addItem = new ItemAdapters.AddItem() {
        @Override
        public void AddItem(LinkedHashMap<String, String> map) {
            Log.e(TAG, "s_count>>map>>" + map);
            map = map;
            Set<String> stringSet = map.keySet();
            List<String> aList = new ArrayList<String>(stringSet.size());
            for (String x : stringSet)
                aList.add(x);
            itemLists = new ArrayList<>();
            for (int i = 0; i < aList.size(); i++) {
                itemName = aList.get(i);
                ItemList list = new ItemList();
                itemCount = map.get(itemName);
                list.setItemName(itemName);
                list.setItemCount(itemCount);
                itemLists.add(list);

            }
            if(itemLists.size()>0) {
                constraintLayout.setVisibility(View.VISIBLE);
                adapters = new Adapters(getApplication(), itemLists);
                recyclerView_bottom.setAdapter(adapters);
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
            else
            {
                constraintLayout.setVisibility(View.GONE);
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView_list = findViewById(R.id.recyclerView_list);
        constraintLayout = findViewById(R.id.constraintLayout);

        stringArrayList.add("APPLE");
        stringArrayList.add("ORANGE");
        stringArrayList.add("BANANA");
        stringArrayList.add("GRAPE");




        recyclerView_list.setHasFixedSize(true);
        recyclerView_list.setLayoutManager(new LinearLayoutManager(getApplication(), LinearLayoutManager.VERTICAL, false));
        itemAdapters = new ItemAdapters(getApplication(), stringArrayList, addItem, map);
        recyclerView_list.setAdapter(itemAdapters);
        itemAdapters.notifyDataSetChanged();


        //Bottom sheet
        mBottomSheetLayout = findViewById(R.id.mBottomSheetLayout);
        sheetBehavior = BottomSheetBehavior.from(mBottomSheetLayout);
        recyclerView_bottom = findViewById(R.id.recyclerView_bottom);
        recyclerView_bottom.setHasFixedSize(true);
        recyclerView_bottom.setLayoutManager(new LinearLayoutManager(getApplication(), LinearLayoutManager.VERTICAL, false));

        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }




       /* sheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
            }
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                list.setRotation(slideOffset * 180);
            }
        });*/


    }
}