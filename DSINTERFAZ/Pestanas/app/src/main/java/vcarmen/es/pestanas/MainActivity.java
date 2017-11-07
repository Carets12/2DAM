package vcarmen.es.pestanas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
/*
    @BindView(android.R.id.tabhost)
    TabHost tabs;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
       // findViewById(android.R.id.tabhost);
        tabs.setup();

        //Creamos la pestaña 1 y la añadimos a tabs
        TabHost.TabSpec spec;
        spec = tabs.newTabSpec("tab1");
        spec.setIndicator("Pestaña 1");
        spec.setContent(R.id.tabs1);
        tabs.addTab(spec);

        //Creamos la pestaña 2 y la añadimos a tabs
        spec = tabs.newTabSpec("tab2");
        spec.setIndicator("Pestaña 2");
        spec.setContent(R.id.tabs2);
        tabs.addTab(spec);

        tabs.setCurrentTab(0);
    }
}
