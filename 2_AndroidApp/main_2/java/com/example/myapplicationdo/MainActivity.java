package com.example.myapplicationdo;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private boolean isLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Item> items = new ArrayList<>();
        items.add(new Item(R.mipmap.ic_launcher, "آیتم اول", "توضیح آیتم اول"));
        items.add(new Item(R.mipmap.ic_launcher, "آیتم دوم", "توضیح آیتم دوم"));
        items.add(new Item(R.mipmap.ic_launcher, "آیتم سوم", "توضیح آیتم سوم"));

        adapter = new ItemAdapter(this, items, isLandscape);
        recyclerView.setAdapter(adapter);
    }

    // مخصوص حالت افقی برای نمایش عکس در سمت راست
    public void showDetailFragment(int imageRes) {
        DetailFragment fragment = DetailFragment.newInstance(imageRes);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.detailContainer, fragment)
                .commit();
    }
}
