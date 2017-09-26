package com.todo.liszt.todoliszt.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.todo.liszt.todoliszt.R;
import com.todo.liszt.todoliszt.models.Category;

public class FirebaseCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebaseCategoryViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindCategory(Category category) {
        TextView categoryGridItem = (TextView) mView.findViewById(R.id.categoryGridItem);

        categoryGridItem.setText(category.getName());
    }

    @Override
    public void onClick(View view) {

        // more code later
    }

}
