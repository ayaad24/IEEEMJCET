package com.example.ayaad.ieeemjcet;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;


public class Magazines extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readpdf);
        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
        pdfView.fromAsset("magwie.pdf").load();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    }
    public void download (View v)
    {
                    WebView mWebView = new WebView(this);
                    mWebView.loadUrl("https://drive.google.com/open?id=0B3ZSNWKj-r6wYXpHZWVmTnp4RGM");
            }
        };


