package es.vcarmen.material07;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by matinal on 17/11/17.
 */

public class Primero extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.primero, container, false);

        WebView myWebView1 = view.findViewById(R.id.webView1);

        myWebView1.getSettings().setJavaScriptEnabled(true);
        myWebView1.loadUrl("https://www.google.es/");
       return view;
    }

}
