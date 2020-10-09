package com.juborajsarker.assignment.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.juborajsarker.assignment.R;
import com.juborajsarker.assignment.util.Stopwatch;

import java.util.Locale;

public class Assignment5 extends Fragment {
    View view;

    Button btnReset;
    ImageView ivStart;
    Button btnStop;
    Button btnAddLap;
    Chronometer cmStopwatch;
    TextView tvLap;
    String lap = "";

    boolean isResume;
    Handler handler;
    long tMillSec, tStart, tBuff, tUpdate = 0L;
    int sec, min, milliSec;

    int click = 1;

    public Assignment5() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null){
            Toast.makeText(getContext(), "On Create", Toast.LENGTH_SHORT).show();
            isResume = savedInstanceState.getBoolean("isResume");
            tMillSec = savedInstanceState.getLong("tMills");
            tBuff = savedInstanceState.getLong("tBuff");
            tStart = savedInstanceState.getLong("tStart");
            click = savedInstanceState.getInt("click");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_assignment5, container, false);

     //   Toast.makeText(getContext(), "On Create View", Toast.LENGTH_SHORT).show();

        init();
        return view;
    }

    private void init() {

        btnReset = (Button) view.findViewById(R.id.btn_reset);
        ivStart = (ImageView) view.findViewById(R.id.iv_start);
        btnStop = (Button) view.findViewById(R.id.btn_stop);
        btnAddLap = (Button) view.findViewById(R.id.btn_add_lap);

        cmStopwatch = (Chronometer) view.findViewById(R.id.cm_stopwatch);
        cmStopwatch.setText("00:00:00");
        tvLap = (TextView) view.findViewById(R.id.tv_lap);

        setText();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handler.removeCallbacks(runnable);
                cmStopwatch.stop();
                isResume = false;

                tMillSec = 0L;
                tStart = 0L;
                tBuff = 0L;
                tUpdate = 0L;
                sec = 0;
                min = 0;
                milliSec = 0;
                cmStopwatch.setText("00:00:00");
                lap = "";
                tvLap.setText("");
                click = 1;
                ivStart.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_play));

            }
        });

        ivStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click++;
                if (click %2 == 0){
                    ivStart.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_pause));
                }else {
                    ivStart.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_play));
                }

                if (!isResume){
                    tStart = SystemClock.uptimeMillis();
                    handler.postDelayed(runnable, 0);
                    cmStopwatch.start();
                    isResume = true;

                }else {
                    tBuff += tMillSec;
                    handler.removeCallbacks(runnable);
                    cmStopwatch.stop();
                    isResume = false;
                }

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handler.removeCallbacks(runnable);
                cmStopwatch.stop();
                isResume = false;
                tMillSec = 0L;
                tStart = 0L;
                tBuff = 0L;
                tUpdate = 0L;
                sec = 0;
                min = 0;
                milliSec = 0;
                cmStopwatch.setText("00:00:00");
                click = 1;
                ivStart.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_play));

            }
        });

        btnAddLap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cmStopwatch.getText().toString().equals("00:00:00") || cmStopwatch.getText().toString().equals("00:00")){
                    Toast.makeText(getContext(), "Please start the stopwatch first", Toast.LENGTH_SHORT).show();
                }else {
                    lap = lap + cmStopwatch.getText().toString() + "\n";
                    tvLap.setText(lap);
                }

            }
        });



        runTimer();

    }


    private void runTimer(){

        handler = new Handler();


    }

    public  Runnable runnable = new Runnable() {
        @Override
        public void run() {
            tMillSec = SystemClock.uptimeMillis() - tStart;
            tUpdate = tBuff + tMillSec;
            sec = (int) (tUpdate / 1000);
            min = sec / 60;
            sec = sec % 60;
            milliSec = (int) (tUpdate % 100);
            cmStopwatch.setText(String.format("%02d", min) + ":" + String.format("%02d", sec) + ":" + String.format("%02d", milliSec));

            handler.postDelayed(this, 60);
        }
    };


    @Override
    public void onSaveInstanceState(@NonNull Bundle saveInstanceSate) {

        super.onCreate(null);

        saveInstanceSate.putBoolean("isResume", false);
        saveInstanceSate.putLong("tMills", tMillSec);
        saveInstanceSate.putLong("tBuff", tBuff);
       // tUpdate = tBuff + tMillSec;
        saveInstanceSate.putLong("tStart", tStart);
        saveInstanceSate.putInt("click", click);
    }


    private void setText(){
        tUpdate = tBuff + 0 ;
        sec = (int) (tUpdate / 1000);
        min = sec / 60;
        sec = sec % 60;
        milliSec = (int) (tUpdate % 100);
        cmStopwatch.setText(String.format("%02d", min) + ":" + String.format("%02d", sec) + ":" + String.format("%02d", milliSec));
    }
}