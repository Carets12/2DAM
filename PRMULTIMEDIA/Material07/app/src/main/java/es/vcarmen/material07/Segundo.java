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

public class Segundo extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.segundo, container, false);

        WebView myWebView2 = view.findViewById(R.id.webView2);

        myWebView2.getSettings().setJavaScriptEnabled(true);
        myWebView2.loadUrl("https://github.com/");

        return view;
    }

}
