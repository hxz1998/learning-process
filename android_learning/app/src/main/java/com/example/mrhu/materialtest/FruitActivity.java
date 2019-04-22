package com.example.mrhu.materialtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int imageId = intent.getIntExtra("imageID", 0);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        ImageView imageView = findViewById(R.id.fruit_image_view);
        TextView textView = findViewById(R.id.fruit_content_text);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(name);
        Glide.with(this)
                .load(imageId)
                .into(imageView);
        textView.setText(generateContent(name));
    }

    private String generateContent(String name) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i < 500;i++) {
            builder.append(name);
        }
        return builder.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
