package com.juborajsarker.assignment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.juborajsarker.assignment.R;
import com.juborajsarker.assignment.adapter.CustomAdapter;
import com.juborajsarker.assignment.helper.BikeHelper;
import com.juborajsarker.assignment.helper.GridSpacingItemDecoration;
import com.juborajsarker.assignment.model.Bike;

import java.util.ArrayList;
import java.util.List;


public class Assignment2 extends Fragment {

    View view;
    Spinner spBrand;
    Button btnSearchBike;
    TextView tvMessage;
    RecyclerView rvBikeList;
    List<Bike> bikeList = new ArrayList<>();
    BikeHelper bikeHelper = new BikeHelper(getContext());
    CustomAdapter adapter;

    public Assignment2() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_assignment2, container, false);

        init();

        return view;
    }

    private void init() {
        spBrand = (Spinner) view.findViewById(R.id.sp_brand);
        btnSearchBike = (Button) view.findViewById(R.id.btn_searchBike);
        tvMessage = (TextView) view.findViewById(R.id.tv_message);
        rvBikeList = (RecyclerView) view.findViewById(R.id.rv_bike_list);

        btnSearchBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (spBrand.getSelectedItemPosition() == 0){
                    Toast.makeText(getContext(), "Please select a valid bike brand", Toast.LENGTH_SHORT).show();
                }else {
                    tvMessage.setVisibility(View.GONE);
                    String brand = spBrand.getSelectedItem().toString();
                    setRecyclerView(brand);

                }
            }
        });
    }

    private void setRecyclerView(String brand) {
        bikeList.clear();

        bikeList = bikeHelper.getBikeListWithBrand(brand);

        adapter = new CustomAdapter(getContext(), bikeList, rvBikeList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        rvBikeList.setLayoutManager(layoutManager);
        rvBikeList.addItemDecoration(new GridSpacingItemDecoration(1, 0, true));
        rvBikeList.setItemAnimator(new DefaultItemAnimator());

        rvBikeList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}