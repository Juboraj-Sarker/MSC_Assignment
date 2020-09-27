package com.juborajsarker.assignment.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class Util {

    public void sendEmail(Activity activity, String sendTo, String cc) {
        String[] TO = {sendTo};
        String[] CC = {cc};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.addCategory(Intent.CATEGORY_DEFAULT);


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            activity.startActivity(Intent.createChooser(emailIntent, "Send mail with"));
          //  activity.finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(activity,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void call(Activity activity, String number){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        activity.startActivity(intent);
    }

    public void  openUrl(Activity activity, String url){
        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(browserIntent);
    }



}
