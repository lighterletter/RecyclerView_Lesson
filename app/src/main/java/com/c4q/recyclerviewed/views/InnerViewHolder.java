package com.c4q.recyclerviewed.views;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.c4q.recyclerviewed.R;

public class InnerViewHolder extends RecyclerView.ViewHolder {

    public InnerViewHolder(ViewGroup parent) {
        super(inflateLayout(parent));
    }

    private static View inflateLayout(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.inner_item, parent, false);
    }


    public void bind(String color, int position){
        itemView.setBackgroundColor(Color.parseColor(color));
        TextView textView = (TextView) itemView.findViewById(R.id.item_position_text_view);
        textView.setText(String.valueOf(position));
    }
}
