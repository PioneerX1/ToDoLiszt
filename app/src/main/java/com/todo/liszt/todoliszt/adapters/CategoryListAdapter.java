package com.todo.liszt.todoliszt.adapters;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.todo.liszt.todoliszt.R;
import com.todo.liszt.todoliszt.models.Category;

import java.util.ArrayList;

public class CategoryListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Category> mCategories = new ArrayList<>();

    public CategoryListAdapter(Context context, ArrayList<Category> categories) {
        this.mContext = context;
        this.mCategories = categories;
    }




    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            gridView = inflater.inflate(R.layout.category_list_grid_item, null);
            TextView categoryName = (TextView) gridView.findViewById(R.id.categoryGridItem);
            categoryName.setText(mCategories.get(position).getName());
            Log.d("SUCCESS!!!!", "BUT NOT REALLY");
        } else {
            gridView = (View) convertView;
            Log.d("DOGHAT", "EMPTY!!!!!!!!!!!");
        }

        return gridView;
    }
}
