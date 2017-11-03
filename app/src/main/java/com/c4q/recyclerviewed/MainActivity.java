package com.c4q.recyclerviewed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A RecyclerView is an android component used for scrolling a list of content. This content can be anything
 * Usually it comes in the form of objects whose information can then be displayed in a collection of views.
 */
public class MainActivity extends AppCompatActivity {

    private List<String> dataForAdapter; //our data
    // 2: You'll need an adapter which will bind your data to your item views.
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Our recycler-view is added as a view in our layout's xml file.

        populateColorList(); // we create a list to pass on to the recycler view. This list can be composed of a collection of any type.

        initRecyclerView(); // we initialize and pass on our data to the recycler view in this method.
    }

    private void populateColorList() {
        //We will use a list of colors to change the background of each view-holder
        dataForAdapter = new ArrayList<>();
        dataForAdapter.add("#ffffff");
        dataForAdapter.add("#f9982f");
        dataForAdapter.add("#e3ee31");
        dataForAdapter.add("#4366b0");
        dataForAdapter.add("#2f90f9");
        dataForAdapter.add("#bbbbbb");
        dataForAdapter.add("#aaaaaa");
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view); // we first obtain a view reference from the layout
        //There are three main components to set up a recycler view

        // 1: you'll need a layout manager, this manager will denote how many items to display per row and in what orientation
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // create layout manager for recycler view
        recyclerView.setLayoutManager(layoutManager); // add layout manager to recycler-view

         // create adapter and pass the list of data to it through it's constructor
        customAdapter = new CustomAdapter(dataForAdapter);
        recyclerView.setAdapter(customAdapter); // we use the setAdapter() method of the recyclerview to attach the adapter we just created.

        // The third item is the View Holder which you will find referenced in the adapter.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item_menu_button:
                Random random = new Random();
                int randomColorId = random.nextInt(dataForAdapter.size()-1);
                dataForAdapter.add(dataForAdapter.get(randomColorId));
                customAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}
