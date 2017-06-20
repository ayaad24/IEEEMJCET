package com.example.ayaad.ieeemjcet;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readpdf);
        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
        pdfView.fromAsset("form.pdf").load();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    }
    public void download (View v)
    {
        WebView mWebView = new WebView(this);
        mWebView.loadUrl("https://drive.google.com/open?id=0B3ZSNWKj-r6wREZJTmxHWmJVekk");
    }

}