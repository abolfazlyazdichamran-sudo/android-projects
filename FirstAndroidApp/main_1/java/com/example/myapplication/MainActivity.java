package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextUrl;
    Button buttonAdd;
    ListView listViewUrls;
    ArrayList<String> urls;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUrl = findViewById(R.id.editTextUrl);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewUrls = findViewById(R.id.listViewUrls);

        urls = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, urls);
        listViewUrls.setAdapter(adapter);

        // افزودن سایت
        buttonAdd.setOnClickListener(v -> {
            String url = editTextUrl.getText().toString().trim();
            if (!url.isEmpty()) {
                urls.add(url);
                adapter.notifyDataSetChanged();
                editTextUrl.setText("");
            } else {
                Toast.makeText(this, "Please enter a URL", Toast.LENGTH_SHORT).show();
            }
        });

        // حذف سایت با لمس طولانی
        listViewUrls.setOnItemLongClickListener((parent, view, position, id) -> {
            urls.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Item removed", Toast.LENGTH_SHORT).show();
            return true;
        });

        // باز کردن سایت با کلیک ساده
        listViewUrls.setOnItemClickListener((parent, view, position, id) -> {
            String url = urls.get(position);
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }
}
