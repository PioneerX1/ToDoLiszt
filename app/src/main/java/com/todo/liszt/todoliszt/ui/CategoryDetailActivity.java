package com.todo.liszt.todoliszt.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.todo.liszt.todoliszt.R;

public class CategoryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        Log.d("CATEGORY DETAIL", " ACTIVITY");
    }
}
