package com.todo.liszt.todoliszt.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.todo.liszt.todoliszt.Constants;
import com.todo.liszt.todoliszt.R;
import com.todo.liszt.todoliszt.adapters.CategoryListAdapter;
import com.todo.liszt.todoliszt.adapters.FirebaseCategoryViewHolder;
import com.todo.liszt.todoliszt.models.Category;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.categoryGridView) GridView mCategoryGridView;
    @Bind(R.id.newCategoryButton) Button mNewCategoryButton;
    @Bind(R.id.categoryRecyclerView) RecyclerView mCategoryRecyclerView;

    private DatabaseReference mCategoryReference;
    private ValueEventListener mCategoryReferenceListener;

    private CategoryListAdapter mAdapter;
    public ArrayList<Category> mCategories = new ArrayList<>();

    String[] categoryNames = new String[] {"Wok", "Kvlt", "Handbeezies", "NigNogs", "Bill Withers, Sr.", "Africa Night"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mCategoryReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_CATEGORY);

        mCategoryReferenceListener = mCategoryReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot categorySnapshot : dataSnapshot.getChildren()) {
                    String name = (String) categorySnapshot.child("name").getValue();
                    String description = (String) categorySnapshot.child("description").getValue();
                    Category cat = new Category(name, description);
                    mCategories.add(cat);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //mCategoryGridView.setAdapter(new CategoryListAdapter(this, mCategoryReference));

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
