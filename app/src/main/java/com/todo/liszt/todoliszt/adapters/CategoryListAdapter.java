package com.todo.liszt.todoliszt.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.todo.liszt.todoliszt.R;

public class CategoryListAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mCategoryNames;

    public CategoryListAdapter(Context context, String[] categoryNames) {
        this.mContext = context;
        this.mCategoryNames = categoryNames;
    }


    @Override
    public int getCount() {
        return mCategoryNames.length;
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
            TextView categoryName = (TextView) gridView
                    .findViewById(R.id.category_grid_item);
            categoryName.setText(mCategoryNames[position]);
        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }
}
