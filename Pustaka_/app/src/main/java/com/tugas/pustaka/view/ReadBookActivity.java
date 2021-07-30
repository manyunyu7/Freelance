package com.tugas.pustaka.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tugas.pustaka.R;
import com.tugas.pustaka.util.RestClient;

public class ReadBookActivity extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_book);

        // WebView and ProgressBar
        webView = (WebView) findViewById(R.id.webview);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        progressBar.setVisibility(View.VISIBLE);

        // Set Up WebView
        setUpWebView();

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setUpWebView() {
        WebSettings webSettings = webView.getSettings();

        // Enabling JavaScript
        webSettings.setJavaScriptEnabled(true);

        // Gets whether the WebView supports zoom
        webSettings.setSupportZoom(false);

        //  Settings to enable/disable cache in WebView
        webView.setDrawingCacheEnabled(true);

        // Settings to disable text selection in WebView
        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });


        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // Page Started
                webView.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // Page Finished
                progressBar.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Toast.makeText(getApplicationContext(), "Gagal Memuat Buku", Toast.LENGTH_SHORT).show();
            }
        });

        // Use remote resource
        String pdf = RestClient.REAL_URL + getIntent().getStringExtra("book");
        Log.d("url-buku", pdf);
        webView.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
    }

    // Function for reload WebView
    private void webViewReload() {
        webView.reload();
    }

}