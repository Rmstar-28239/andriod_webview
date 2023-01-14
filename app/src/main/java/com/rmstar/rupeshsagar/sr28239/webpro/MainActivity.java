package com.rmstar.rupeshsagar.sr28239.webpro;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.rmstar.rupeshsagar.sr28239.webpro.Nointernet.InternetResiver;
import com.rmstar.rupeshsagar.sr28239.webpro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
  ActivityMainBinding binding;
  WebView webView;
    BroadcastReceiver broadcastReceiver=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        webView = (WebView) binding.web;
        /////////////////////bordcast/////////////////
        broadcastReceiver=new InternetResiver();
        InternetConnectionCheck();


        //////////////////////////////web setting/////////////////////
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                binding.background.setVisibility(View.VISIBLE);
                binding.web.setVisibility(View.GONE);
                binding.bookloading.start();
                view.loadUrl(url);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                binding.bookloading.stop();
                binding.background.setVisibility(View.GONE);
                binding.web.setVisibility(View.VISIBLE);
            }
        });

        webView.loadUrl("https://manmeshind.com");


    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
    public void InternetConnectionCheck()
    {
        registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }
}