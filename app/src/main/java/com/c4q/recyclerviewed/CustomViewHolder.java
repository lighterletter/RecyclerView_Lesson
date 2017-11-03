package com.c4q.recyclerviewed;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A view holder is responsible to taking care of what happens in one individual item.
 * These View holders are reused as objects as the user scrolls through the adapter; which simply
 * binds the new info to the created view-holder, instead of creating a new one, which it only does if it needs to.
 */

//Implement an OnClickListener interface
class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView textView;
    private String backgroundColor;

    //Constructor takes in the view created with our specific layout. This view is passed in from the adapter.
    public CustomViewHolder(View itemView) {
        super(itemView);
    }

    //This bind method is a method we created to handle the logic of what should happen with the information passed at the index
    public void bind(String color, int position) {
        // in our case we are setting a background color based on the list index and setting a textview's text to the index of the list item.
        itemView.setBackgroundColor(Color.parseColor(color));
        itemView.getRootView().setOnClickListener(this); //set the onclicklistener to the root view
        backgroundColor = color; //assign the color to the background color for use in the onClick method

        textView = itemView.findViewById(R.id.item_position_text_view);

        textView.setText(String.valueOf(position));

        //create a reference to the button
        Button button = (Button) itemView.findViewById(R.id.share_button);
        //set click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //create intent and specify the action the intent will be used for
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                //put extras, EXTRA_TEXT will be automatically accessed by the OS
                sendIntent.putExtra(Intent.EXTRA_TEXT, textView.getText());
                //the MIME type tells the OS the format type of our text
                sendIntent.setType("text/plain");

                //check if the device contains an app capable of executing the action
                if(sendIntent.resolveActivity(view.getContext().getPackageManager()) != null){

                    //get the context from the view then start the activity
                    view.getContext().startActivity(sendIntent);

                }else{
                    //if there is no app that can perform the action let the user know
                    Toast.makeText(view.getContext(), "Action can't be completed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        //create an intent and put extras to send over to the second activity
        Intent intent = new Intent(view.getContext(),SecondActivity.class);
        intent.putExtra("text", textView.getText());
        intent.putExtra("color",backgroundColor);
        //intents require context so we get the context from our view
        view.getContext().startActivity(intent);
    }

}
