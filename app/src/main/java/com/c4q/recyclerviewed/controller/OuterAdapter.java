package com.c4q.recyclerviewed.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.c4q.recyclerviewed.views.OuterViewHolder;
import com.c4q.recyclerviewed.R;
import com.c4q.recyclerviewed.model.DataModel;

import java.util.List;

/**
 * The Recycler view adapter is a class that receives data from a source,
 * and binds that data to a defined View called a ViewHolder.
 *
 * This View Holder is analogous to each item in your list.
 *
 * @see OuterViewHolder
 */

public class OuterAdapter extends RecyclerView.Adapter {

    private List<DataModel> dataModelList;

    public OuterAdapter(List<DataModel> dataForAdapter) { // constructor takes in list of data to use
        this.dataModelList = dataForAdapter; //That data is then assigned as the data for our adapter.
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // We first define a layout for our view holders to use in: R.layout.recycler_view_item.
        // This can be done within our view holder class itself but you will also see the layout defined in the adapter as such
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false); // We inflate an instance of our view holder
        //The view is then passed to an instance of our OuterViewHolder
        return new OuterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //This method gets called to bind data based on item index to a view holder that is returned from onCreateViewHolder().

        //We cast the ViewHolder returned to our specific type of ViewHolder so that we can utilize our methods. Namely the bind() method we created.
        OuterViewHolder OuterViewHolder = (OuterViewHolder) holder;
        //We call the bind method and pass in the information from the list which is our DataModel object.
        OuterViewHolder.bind(dataModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataModelList.size(); // the size must always be set to the number of items in our collection
    }

}
