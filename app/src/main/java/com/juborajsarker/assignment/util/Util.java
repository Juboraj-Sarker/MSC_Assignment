package com.juborajsarker.assignment.util;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
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


    public void sendSMS (Activity activity, String number){
        Uri uri = Uri.parse("smsto:" + number);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", "The SMS text");
        activity.startActivity(intent);
    }

    public void  openUrl(Activity activity, String url){
        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(browserIntent);
    }


    public void showDialog(final Activity activity, final String number){

        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Light_Dialog);
        } else {
            builder = new AlertDialog.Builder(activity);
        }
        builder
                .setTitle("Call or SMS me !")
                .setMessage("Choose whether action do you want?")
                .setPositiveButton("CALL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                       call(activity, number);
                    }
                })
                .setNegativeButton("SMS", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        sendSMS(activity, number);
                        //dialog.cancel();
                    }
                })
                .show();
    }



}
