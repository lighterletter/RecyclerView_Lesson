package com.c4q.recyclerviewed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * The Recycler view adapter is a class that receives data from a source and uses that data to create
 * A view for each item called a ViewHolder.
 *
 * @see CustomViewHolder
 */

class CustomAdapter extends RecyclerView.Adapter {

    private List<String> colorList;

    public CustomAdapter(List<String> dataForAdapter) { // constructor takes in list of data to use
        this.colorList = dataForAdapter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // We first define a layout for our view holders to use.
        // This can be done within our view holder class itself but you will also see the layout defined in the adapter as such
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        //The view is then passed to an instance of our CustomViewHolder
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //This gets called to bind data based on item index to a view holder that is returned from onCreateViewHolder().

        //We cast the ViewHolder returned to our specific type of ViewHolder so that we can utilize our methods. Namely the bind() method we created.
        CustomViewHolder customViewHolder = (CustomViewHolder) holder;

        //We call the bind method and pass in the information from the list which is our color and also an index so that we can update a textview with the item index.
        customViewHolder.bind(colorList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return colorList.size(); // the size must always be set to the number of items in our collection
    }
}
