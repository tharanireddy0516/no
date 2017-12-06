package com.example.tharani.androidversions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Tharani on 12/6/2017.
 */

public class CardViewDataAdapter extends RecyclerView.Adapter<CardViewDataAdapter.ViewHolder> {
    public  String[] mDataset;



    //  Creating the constructor as per requirement
    public CardViewDataAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Creating new views
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        //  new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cardview_row, null);

        // creating ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replacing the contents of a view
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {



        viewHolder.tvtinfo_text.setText(mDataset[position].toString());

    }


    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    // This  class  hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder   {

        public TextView tvtinfo_text;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            tvtinfo_text =  itemLayoutView
                    .findViewById(R.id.action_add);

        }


    }





}


