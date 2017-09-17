package com.example.home.studenttoolkit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ZoomButtonsController;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by HOME on 29.08.2017.
 */

public class ActivityTwo  extends AppCompatActivity {
   WebView wv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        wv = (WebView) findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setFocusable(true);
        wv.setFocusableInTouchMode(true);
        wv.loadUrl("http://ptksakhgu.ru/raspisanie/25.htm");
        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setSupportZoom(true);
        wv.getSettings().setBuiltInZoomControls(true);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            // Use the API 11+ calls to disable the controls
            // Use a seperate class to obtain 1.6 compatibility
            // Zoom v Webview!!!!!!!!!!!!!!!!!!!!!!!!!
            new Runnable() {
                public void run() {
                    wv.getSettings().setDisplayZoomControls(false);
                }
            }.run();
        } else {
            ZoomButtonsController zoom_controll = null;
            try {
                zoom_controll = (ZoomButtonsController) wv.getClass().getMethod("getZoomButtonsController").invoke(wv, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            zoom_controll.getContainer().setVisibility(View.GONE);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
