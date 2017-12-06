package com.example.tharani.androidversions;


import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static android.R.color.*;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    public Palette mPalette;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    int defaultColor;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar =  findViewById(R.id.toolbar);

        if (toolbar != null){

            setSupportActionBar(toolbar);

        }

        getSupportActionBar().setTitle("Android Versions");

        //this.getSupportActionBar().hide();

        defaultColor = ContextCompat.getColor(getApplicationContext(), holo_green_dark);

        fab =  findViewById(R.id.fab);
        mRecyclerView =  findViewById(R.id.my_recycler_view);

        getPhoto();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final String[] myDataset = { "Alpha", "Beta", "CupCake", "Donut",
                "Eclair", "Froyo", "Gingerbread", "Honeycomb",
                "Ice Cream Sandwitch", "JellyBean", "KitKat", "LollyPop","MarshMallow" };




        //  this setting is used to improve performance if we  know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // using the linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        mAdapter = new CardViewDataAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        // Implementation of onItemClick on RecycleView


        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Toast.makeText(getApplicationContext(),
                                "Data : " + myDataset[position],
                                Toast.LENGTH_SHORT).show();

                    }
                }));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflating the menu; this will adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Settings Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_search) {
            Toast.makeText(getApplicationContext(), "Search Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_add) {
            Toast.makeText(getApplicationContext(), "Add Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_delete) {
            Toast.makeText(getApplicationContext(), "Delete Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getPhoto() {
        Bitmap photo = BitmapFactory.decodeResource(getResources(),R.drawable.ic_action_delete);
        colorize(photo);
    }

    private void colorize(Bitmap photo) {
        mPalette = Palette.generate(photo);
        applyPalette();
    }

    private void applyPalette() {
        getWindow().setBackgroundDrawable(new ColorDrawable(mPalette.getDarkMutedColors(defaultColor)));
        mRecyclerView.setBackgroundColor(mPalette.getLightVibrantColor(defaultColor));
        toolbar.setBackgroundColor(mPalette.getLightVibrantColor(defaultColor));
        fab.setBackgroundTintList(ColorStateList.valueOf(mPalette.getLightVibrantColor(defaultColor)));

    }
}