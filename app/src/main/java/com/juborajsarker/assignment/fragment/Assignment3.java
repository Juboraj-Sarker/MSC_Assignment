package com.juborajsarker.assignment.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.juborajsarker.assignment.R;
import com.juborajsarker.assignment.activity.DetailsActivity;


public class Assignment3 extends Fragment {

    View view;
    Spinner spBrand;
    Button btnSearchBike;
    TextView tvMessage;

    public Assignment3() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_assignment3, container, false);

        init();

        return view;
    }

    private void init() {
        spBrand = (Spinner) view.findViewById(R.id.sp_brand);
        btnSearchBike = (Button) view.findViewById(R.id.btn_searchBike);

        tvMessage = (TextView) view.findViewById(R.id.tv_message);

        btnSearchBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (spBrand.getSelectedItemPosition() == 0){
                    Toast.makeText(getContext(), "Please select a valid bike brand", Toast.LENGTH_SHORT).show();
                }else {

                    String brand = spBrand.getSelectedItem().toString();
                    Intent intent = new Intent(getContext(), DetailsActivity.class);
                    intent.putExtra("brand", brand);
                    startActivity(intent);

                }
            }
        });

    }
}