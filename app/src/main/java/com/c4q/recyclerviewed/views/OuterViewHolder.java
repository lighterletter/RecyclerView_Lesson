package com.c4q.recyclerviewed.views;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.c4q.recyclerviewed.R;
import com.c4q.recyclerviewed.controller.InnerAdapter;
import com.c4q.recyclerviewed.model.DataModel;

/**
 * A view holder is responsible to taking care of what happens in one individual item.
 * These View holders are reused objects as the user scrolls through the adapter; which simply
 * binds the new info to the created view-holder, instead of creating a new one.
 * The adapter only creates a new view holder if it needs to.
 *
 * For example if it needs to create a Type of view holder that is has not created yet.
 */

public class OuterViewHolder extends RecyclerView.ViewHolder {

    //Constructor takes in the view created with our specific layout. This view is passed in from the adapter.
    public OuterViewHolder(View itemView) {
        super(itemView);
    }

    //This bind method is a method we created to handle the logic of what should happen with the information passed at the index
    public void bind(DataModel data) {
        // In this case we are initializing a recycler view for each item in our list.
        // These items have a list as a parameter which is the list that we pass on to this inner recycler view
        RecyclerView innerRV = (RecyclerView) itemView.findViewById(R.id.inner_rv);

        //Here we set the orientation of the LinearLayoutManager to be Horizontal by using an overloaded constructor.
        LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        innerRV.setLayoutManager(layoutManager);
        //We set the adapter with a list of colors.
        innerRV.setAdapter(new InnerAdapter(data.getColorList()));
    }
}
