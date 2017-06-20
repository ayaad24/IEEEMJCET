package com.example.ayaad.ieeemjcet;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.R.attr.id;


public class follow extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);

    }
    public static String FACEBOOK_URL = "https://www.facebook.com/ieeemjcet/";
    public static String FACEBOOK_PAGE_ID = "IEEE MJCET";

    //method to get the right URL to use in the intent
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "https://www.facebook.com/ieeemjcet/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL;//normal web url

        }
    }


    public void fbpage(View view) {
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = getFacebookPageURL(this);
        facebookIntent.setData(Uri.parse(facebookUrl));
        try {
            startActivity(facebookIntent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/ieeemjcet/")));
        }
    }



    public void insta(View view) {
        Uri uri = Uri.parse("http://instagram.com/_u/ieee_mjcet");
        Intent insta = new Intent(Intent.ACTION_VIEW, uri);

        insta.setPackage("com.instagram.android");

        try {
            startActivity(insta);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/ieee_mjcet")));
        }
}
}


