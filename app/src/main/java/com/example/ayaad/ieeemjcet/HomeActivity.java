package com.example.ayaad.ieeemjcet;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;
import android.widget.AdapterViewFlipper;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /*public void onClick(View v) {
            Intent intent = new Intent(this, LoginActivity2.class);
            startActivity(intent);
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "You are not admin user", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_notices) {
            Toast.makeText(getApplicationContext(), "Please login to access", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_anouncements) {
            Toast.makeText(getApplicationContext(), "Please login to access", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_membership_card) {
            Toast.makeText(getApplicationContext(), "Please login to access", Toast.LENGTH_LONG).show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }

        else if (id == R.id.nav_societies) {
            Intent intent = new Intent(this, Societies.class);
            startActivity(intent);
        }

        else if (id == R.id.nav_benifts) {
            Intent intent = new Intent(this, benifts.class);
            startActivity(intent);
        }
            /*if (isNetworkAvailable(getApplicationContext())) {
                WebView mWebView = new WebView(this);
                mWebView.loadUrl("https://drive.google.com/open?id=0B3ZSNWKj-r6wM0ViV0pQeWM3YUU");
            } else
                Toast.makeText(getApplicationContext(), "Check your network connection", Toast.LENGTH_LONG).show();
        }*/

        else if (id == R.id.nav_form) {
            Intent intent = new Intent(this, form.class);
            startActivity(intent);
        }
            /*if (isNetworkAvailable(getApplicationContext())) {
                WebView mWebView = new WebView(this);
                mWebView.loadUrl("https://drive.google.com/open?id=0B3ZSNWKj-r6wREZJTmxHWmJVekk");
            } else
                Toast.makeText(getApplicationContext(), "Check your network connection", Toast.LENGTH_LONG).show();

               this.close();
        }*/

        else if (id == R.id.nav_events) {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.sohail.events");
            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {

                intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("market://details?id=" + "com.sohail.events"));
                startActivity(intent);
            }
        }

        else if (id == R.id.nav_gallery) {
            Toast.makeText(getApplicationContext(), "under construction", Toast.LENGTH_LONG).show();

        }
        else if (id == R.id.nav_magazines) {
            Intent intent = new Intent(this, Magazines.class);
            startActivity(intent);
        }
          //  if (isNetworkAvailable(getApplicationContext())) {
            //    WebView mWebView = new WebView(this);
              //  mWebView.loadUrl("https://drive.google.com/open?id=0B3ZSNWKj-r6wYXpHZWVmTnp4RGM");
            //} else
             //   Toast.makeText(getApplicationContext(), "Check your network connection", Toast.LENGTH_LONG).show();
        //}

        else if (id == R.id.nav_contact) {
            Intent intent = new Intent(this, contacts.class);
            startActivity(intent);

        }

        else if (id == R.id.nav_follow) {
            Intent intent = new Intent(this, follow.class);
            startActivity(intent);

        }

        else if (id == R.id.nav_about) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);

        }

        else if (id == R.id.nav_solutions) {
            if (isNetworkAvailable(getApplicationContext())) {
                Intent intent = new Intent(this, Solutions.class);
                startActivity(intent);

            } else
                Toast.makeText(getApplicationContext(), "Check your network connection", Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean isNetworkAvailable(Context applicationContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
