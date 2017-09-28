package com.todo.liszt.todoliszt.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.todo.liszt.todoliszt.R;
import com.todo.liszt.todoliszt.models.Category;

import org.parceler.Parcels;

import java.util.ArrayList;

public class CategoryDetailActivity extends AppCompatActivity {
    Category mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        mCategory = Parcels.unwrap(getIntent().getParcelableExtra("category"));


        Log.d("CATEGORY", mCategory.getName());


    }
}
