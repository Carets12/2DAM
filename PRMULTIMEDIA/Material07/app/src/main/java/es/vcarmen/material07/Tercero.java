package es.vcarmen.material07;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by matinal on 17/11/17.
 */

public class Tercero extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tercero, container, false);

        WebView myWebView3 = view.findViewById(R.id.webView3);

        myWebView3.getSettings().setJavaScriptEnabled(true);
        myWebView3.loadUrl("https://www.android.com/");

        return view;
    }
}
