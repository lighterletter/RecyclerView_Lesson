package com.c4q.recyclerviewed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.c4q.recyclerviewed.controller.OuterAdapter;
import com.c4q.recyclerviewed.model.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A RecyclerView is an android component used for scrolling a list of content. This content can be anything
 * Usually it comes in the form of objects whose information can then be displayed in a collection of views.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Our recycler-view is added as a view in our layout's xml file.

        populateColorList(); // we create a list to pass on to the recycler view. This list can be composed of a collection of any type.

        initRecyclerView(); // we initialize and pass on our data to the recycler view in this method.
    }

    /**
     * Our data is based on an Object Model that we define as a DataModel type
     *
     * @return A list of DataModel for us to pass to our adapter
     * @see DataModel
     */
    private List<DataModel> populateColorList() {
        List<DataModel> dataForAdapter;
        //We will use a list of DataModel objects to create a nested Recycler View where each item is itself a recycler view
        dataForAdapter = new ArrayList<>();
        dataForAdapter.add(new DataModel("#ffffff")); // Our objects are added to the list.
        dataForAdapter.add(new DataModel("#f9982f"));
        dataForAdapter.add(new DataModel("#e3ee31"));
        dataForAdapter.add(new DataModel("#4366b0"));
        dataForAdapter.add(new DataModel("#2f90f9"));
        dataForAdapter.add(new DataModel("#bbbbbb"));
        dataForAdapter.add(new DataModel("#aaaaaa"));

        /**
         * For each item in our list of objects call the getColorList() method
         * and set that list to be the list of colors.
         *
         * We will use that list to populate the inner recycler view
         */
        for (int i = 0; i < dataForAdapter.size(); i++) {
            DataModel model = dataForAdapter.get(i);
            model.setColorList(getColorList());
        }
        return dataForAdapter;
    }

    /**
     * @return A list of colors for each item view of the outer recycler view to use
     */
    private List<String> getColorList() {
        List<String> colors = new ArrayList<>();
        colors.add("#ffffff");
        colors.add("#f9982f");
        colors.add("#e3ee31");
        colors.add("#4366b0");
        colors.add("#2f90f9");
        colors.add("#bbbbbb");
        colors.add("#aaaaaa");
        return colors;
    }

    /**
     * Although we can create a class to extend the LinearLayoutManager so that we alter it's behavior
     * such as speed, we only do that for custom implementations. For our purposes the default is fine.
     * <p>
     * The only component we really need to create is the adapter itself,
     * which is where we define how we bind our data to our views.
     */
    private void initRecyclerView() {
        // We first obtain a view reference from the layout
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // With that, there are three main components to set up a recycler view

        // 1: you'll need a layout manager, this manager will denote how many items to display per row and in what orientation
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // create layout manager for recycler view (Default orientation is vertical)
        recyclerView.setLayoutManager(layoutManager); // add layout manager to recycler-view

        // 2: You'll need an adapter which will bind your data to your item views.
        OuterAdapter outerAdapter = new OuterAdapter(populateColorList()); // create adapter and pass the list of data to it through the adapter's constructor
        recyclerView.setAdapter(outerAdapter); // we use the setAdapter() method of the recycler view to attach the adapter we just created.

        // The third item is the View Holder which you will find referenced within the adapter.
    }
}
