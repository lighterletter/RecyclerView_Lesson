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

class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView textView;

    //Constructor takes in the view created with our specific layout. This view is passed in from the adapter.
    public CustomViewHolder(View itemView) {
        super(itemView);
    }

    //This bind method is a method we created to handle the logic of what should happen with the information passed at the index
    public void bind(String color, int position) {
        // in our case we are setting a background color based on the list index and setting a textview's text to the index of the list item.
        itemView.setBackgroundColor(Color.parseColor(color));

        textView = (TextView) itemView.findViewById(R.id.item_position_text_view);
        Button button = (Button) itemView.findViewById(R.id.share_button);
        textView.setText(String.valueOf(position));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(Intent.ACTION_SEND)
                        .putExtra(Intent.EXTRA_TEXT, textView.getText())
                        .setType("text/plain");
                if(sendIntent
                        .resolveActivity(view.getContext()
                                .getPackageManager()) != null){
                    view
                            .getContext()
                            .startActivity(sendIntent);
                }else{
                    Toast.makeText(view.getContext(), "DOesnt work", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
