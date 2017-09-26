package com.todo.liszt.todoliszt.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.todo.liszt.todoliszt.Constants;
import com.todo.liszt.todoliszt.R;
import com.todo.liszt.todoliszt.adapters.CategoryListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.categoryGridView) GridView mCategoryGridView;
    @Bind(R.id.newCategoryButton) Button mNewCategoryButton;

    //private DatabaseReference mCategoryReference;

    String[] categoryNames = new String[] {"Wok", "Kvlt", "Handbeezies", "NigNogs", "Bill Withers, Sr.", "Africa Night"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        mCategoryReference = FirebaseDatabase
//                .getInstance()
//                .getReference()
//                .child(Constants.FIREBASE_CHILD_CATEGORY);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCategoryGridView.setAdapter(new CategoryListAdapter(this, categoryNames));

        mNewCategoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mNewCategoryButton) {
            Intent intent = new Intent(MainActivity.this, AddCategoryActivity.class);
            startActivity(intent);
        }
    }
}
