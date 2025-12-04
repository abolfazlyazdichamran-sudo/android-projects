package com.example.myapplicationse;

import android.os.Bundle;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Switch switchLayout;
    private ItemAdapter adapter;
    private ArrayList<Item> itemList;
    private boolean isGrid = false; // حالت پیش‌فرض: لیست عمودی

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        switchLayout = findViewById(R.id.switchLayout);

        // ساخت داده‌ها
        itemList = new ArrayList<>();
        itemList.add(new Item("کتاب اول", "نویسنده ۱", R.drawable.book1));
        itemList.add(new Item("کتاب دوم", "نویسنده ۲", R.drawable.book2));
        itemList.add(new Item("کتاب سوم", "نویسنده ۳", R.drawable.book3));
        itemList.add(new Item("کتاب چهارم", "نویسنده ۴", R.drawable.book4));

        adapter = new ItemAdapter(this, itemList);

        // حالت پیش‌فرض: لیست عمودی
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // واکنش به تغییر وضعیت Switch
        switchLayout.setOnCheckedChangeListener((buttonView, isChecked) -> {
            isGrid = isChecked;
            if (isGrid) {
                recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // حالت شبکه‌ای
            } else {
                recyclerView.setLayoutManager(new LinearLayoutManager(this)); // حالت عمودی
            }
            recyclerView.setAdapter(adapter);
        });
    }
}
