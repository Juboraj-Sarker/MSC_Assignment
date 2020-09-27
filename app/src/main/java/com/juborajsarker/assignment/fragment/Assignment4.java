package com.juborajsarker.assignment.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.juborajsarker.assignment.R;
import com.juborajsarker.assignment.activity.MapsActivity;
import com.juborajsarker.assignment.util.Util;


public class Assignment4 extends Fragment {
    View view;

    TextView tvLocation;
    TextView tvEmail;
    TextView tvCall;
    TextView tvLinkedin;
    TextView tvGithub;
    TextView tvFacebook;
    TextView tvWebsite;
    TextView tvAndroidApp;

    LinearLayout layoutLocation;
    LinearLayout layoutEmail;
    LinearLayout layoutCall;
    LinearLayout layoutLinkedin;
    LinearLayout layoutGithub;
    LinearLayout layoutFacebook;
    LinearLayout layoutWebsite;

    Util util;

    public Assignment4() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_assignment4, container, false);

        util = new Util();
        init();

        return view;
    }

    private void init() {
        tvLocation = (TextView) view.findViewById(R.id.tv_location);
        tvEmail = (TextView) view.findViewById(R.id.tv_email);
        tvCall = (TextView) view.findViewById(R.id.tv_call);
        tvLinkedin = (TextView) view.findViewById(R.id.tv_linkedin);
        tvGithub = (TextView) view.findViewById(R.id.tv_github);
        tvFacebook = (TextView) view.findViewById(R.id.tv_facebook);
        tvWebsite = (TextView) view.findViewById(R.id.tv_website);
        tvAndroidApp = (TextView) view.findViewById(R.id.tv_android_app);


        layoutLocation = (LinearLayout) view.findViewById(R.id.layout_location);
        layoutEmail = (LinearLayout) view.findViewById(R.id.layout_email);
        layoutCall = (LinearLayout) view.findViewById(R.id.layout_call);
        layoutLinkedin = (LinearLayout) view.findViewById(R.id.layout_linkedin);
        layoutGithub = (LinearLayout) view.findViewById(R.id.layout_github);
        layoutFacebook = (LinearLayout) view.findViewById(R.id.layout_facebook);
        layoutWebsite = (LinearLayout) view.findViewById(R.id.layout_website);


        layoutLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(getContext(), MapsActivity.class));
            }
        });

        layoutEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = tvEmail.getText().toString();
                util.sendEmail(getActivity(), email, null);
            }
        });

        layoutCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cellPhone = tvCall.getText().toString();
                util.call(getActivity(), cellPhone);
            }
        });

        layoutLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = tvLinkedin.getText().toString();
                util.openUrl(getActivity(), url);
            }
        });

        layoutGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = tvGithub.getText().toString();
                util.openUrl(getActivity(), url);
            }
        });

        layoutFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = tvFacebook.getText().toString();
                util.openUrl(getActivity(), url);
            }
        });

        layoutWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = tvWebsite.getText().toString();
                util.openUrl(getActivity(), url);
            }
        });

        tvAndroidApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://play.google.com/store/apps/dev?id=6155570899607409709";
                util.openUrl(getActivity(), url);
            }
        });
    }
}