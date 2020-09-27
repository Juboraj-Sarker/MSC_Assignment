package com.juborajsarker.assignment.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.juborajsarker.assignment.R;
import com.juborajsarker.assignment.adapter.CustomAdapter;
import com.juborajsarker.assignment.helper.BikeHelper;
import com.juborajsarker.assignment.helper.GridSpacingItemDecoration;
import com.juborajsarker.assignment.model.Bike;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    String brand = "";
    RecyclerView rvBikeList;
    List<Bike> bikeList = new ArrayList<>();
    BikeHelper bikeHelper = new BikeHelper(this);
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setHomeButtonEnable();

        brand = getIntent().getStringExtra("brand");

        init(brand);
    }

    private void init(String brand) {
        rvBikeList = (RecyclerView) findViewById(R.id.rv_bike_list);

        bikeList.clear();

        bikeList = bikeHelper.getBikeListWithBrand(brand);

        adapter = new CustomAdapter(DetailsActivity.this, bikeList, rvBikeList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(DetailsActivity.this, 1);
        rvBikeList.setLayoutManager(layoutManager);
        rvBikeList.addItemDecoration(new GridSpacingItemDecoration(1, 0, true));
        rvBikeList.setItemAnimator(new DefaultItemAnimator());

        rvBikeList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:{
                super.onBackPressed();
            }default:{
                return super.onOptionsItemSelected(item);
            }
        }
    }

    private void setHomeButtonEnable(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }
}