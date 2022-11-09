package com.example.landmarks;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {
    // obj
    WebView webview;

    private String name;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        System.out.println(" \nCALLING WEBVIEW\n ");

        fetchWebPage();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void fetchWebPage() {
        // wire
        webview = findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);

        webview.setWebViewClient(new MyWebViewClient());

        url = getIntent().getStringExtra("url");

        name = getIntent().getStringExtra("name");

        if (url.length() != 0) {
            webview.loadUrl(url);
        }
    }
}

