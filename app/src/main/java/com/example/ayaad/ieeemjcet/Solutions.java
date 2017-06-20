package com.example.ayaad.ieeemjcet;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import static com.example.ayaad.ieeemjcet.R.attr.title;

public class Solutions extends AppCompatActivity
{
    private WebView mywebview;
    SwipeRefreshLayout Refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solutions);
        Refresh= (SwipeRefreshLayout) this.findViewById(R.id.refresh);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String url = "http://ieeesolution.com/?reqp=1&reqr=";
        mywebview = (WebView) this.findViewById(R.id.wv11);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.getBuiltInZoomControls();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(true);

        mywebview.loadUrl("http://ieeesolution.com/?reqp=1&reqr=");

        Refresh.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener(){
                    @Override
                    public void onRefresh(){
                        mywebview.reload();

                    }
                }
        );


        mywebview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                getSupportActionBar().setSubtitle(mywebview.getUrl());
                super.onPageStarted(view, url, favicon);

                findViewById(R.id.progressBar).setVisibility(View.VISIBLE);




            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Refresh.setRefreshing(false);
                findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);

            }
        });


        ProgressBar pr = (ProgressBar) this.findViewById(R.id.progressBar);
        pr.getProgress();
    }

    @Override
    public void onBackPressed() {

        if (mywebview.canGoBack()) {
            mywebview.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

