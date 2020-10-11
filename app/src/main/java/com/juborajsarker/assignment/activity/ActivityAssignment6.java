package com.juborajsarker.assignment.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.juborajsarker.assignment.R;

import java.util.Locale;

public class ActivityAssignment6 extends AppCompatActivity {

    Button btnReset;
    ImageView ivStart;
    Button btnStop;
    Button btnAddLap;
    TextView timeView;
    TextView tvLap;
    TextView tvLifecycle;

    private int seconds = 0;
    private boolean running = false;
    private boolean wasRunning;
    String lap = "";
    String lifecycle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment6);
        setHomeButtonEnable();
        lifecycle = lifecycle + "onCreate\n";

        receiveBundle(savedInstanceState);
        init();

    }


    private void receiveBundle(Bundle savedInstanceState){

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
            lifecycle = savedInstanceState.getString("lifecycle");
            lap = savedInstanceState.getString("lap");
        }
    }


    private void init() {

        btnReset = (Button) findViewById(R.id.btn_reset);
        ivStart = (ImageView) findViewById(R.id.iv_start);
        btnStop = (Button) findViewById(R.id.btn_stop);
        btnAddLap = (Button) findViewById(R.id.btn_add_lap);
        timeView = (TextView) findViewById(R.id.timeView);
        tvLap = (TextView) findViewById(R.id.tv_lap);
        tvLifecycle = (TextView) findViewById(R.id.tv_lifecycle);

        tvLifecycle.setText(lifecycle);
        tvLap.setText(lap);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ivStart.setImageDrawable(ContextCompat.getDrawable(ActivityAssignment6.this, R.drawable.ic_play));
                running = false;
                seconds = 0;
                tvLap.setText("");
                tvLifecycle.setText("");
                lap = "";
                lifecycle = "";
            }
        });

        ivStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (running){
                    running = false;
                    ivStart.setImageDrawable(ContextCompat.getDrawable(ActivityAssignment6.this, R.drawable.ic_play));
                }else {
                    running = true;
                    ivStart.setImageDrawable(ContextCompat.getDrawable(ActivityAssignment6.this, R.drawable.ic_pause));
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                running = false;
                ivStart.setImageDrawable(ContextCompat.getDrawable(ActivityAssignment6.this, R.drawable.ic_play));

            }
        });

        btnAddLap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lap = lap + timeView.getText().toString() + "\n";
                tvLap.setText(lap);
            }
        });



        runTimer();

    }



    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault(),
                        "%02d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 0);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
        savedInstanceState.putString("lap", lap);
        savedInstanceState.putString("lifecycle", lifecycle);
    }



    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
        lifecycle = lifecycle + "onPause\n";
        tvLifecycle.setText(lifecycle);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }

        lifecycle = lifecycle + "onResume\n";
        tvLifecycle.setText(lifecycle);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        lifecycle = lifecycle + "onRestart\n";
        tvLifecycle.setText(lifecycle);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycle = lifecycle + "onDestroy\n";
        tvLifecycle.setText(lifecycle);
    }


    @Override
    protected void onStart() {
        super.onStart();
        lifecycle = lifecycle + "onStart\n";
        tvLifecycle.setText(lifecycle);
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifecycle = lifecycle + "onStop\n";
        tvLifecycle.setText(lifecycle);
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