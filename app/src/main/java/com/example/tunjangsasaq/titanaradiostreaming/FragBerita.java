package com.example.tunjangsasaq.titanaradiostreaming;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.app.Service;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.tunjangsasaq.titanaradiostreaming.MyService;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragBerita extends Fragment {

    WebView wvPage1;
    String url = "http://titanaradiostreaming.lombokutarakab.go.id/";


    public FragBerita() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_program_unggulan, container, false);
        wvPage1 = (WebView)v.findViewById(R.id.activity_main_webview);
        WebSettings settings = wvPage1.getSettings();
        settings.setJavaScriptEnabled(true);
        wvPage1.setWebViewClient(new MyWebViewClient());

        wvPage1.loadUrl(url);
        return v;
    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            final Uri uri = Uri.parse(url);
            return true;
        }

        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

    }
}
