package com.c4q.recyclerviewed.controller;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.c4q.recyclerviewed.views.InnerViewHolder;
import java.util.List;

/**
 * This is the adapter for the recycler view of each item in our outer recyclew view
 */
public class InnerAdapter extends RecyclerView.Adapter {

    private List<String> colorList;

    public InnerAdapter(List<String> colorList) {
        this.colorList = colorList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // We are passing the view group so that we can inflate the layout within our view holder,
        // Passing in the viewgroup allows us to inflate our layout from within our view holder class
        return new InnerViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //This is another way of casting our object so that we don't have to declare it.
        //This is called an inline cast.
        // We are passing in a list of colors and a position to our view holder
        ((InnerViewHolder) holder).bind(colorList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return colorList.size(); //Don't forget your item count :) 
    }
}
