package es.vcarmen.tabs3;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost TabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        TabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        TabHost.addTab(
                TabHost.newTabSpec("tab1").setIndicator("Tab 1", null),
                Fragmento1.class, null);

        TabHost.addTab(
                TabHost.newTabSpec("tab2").setIndicator("Tab 2", null),
                Fragmento2.class, null);

        TabHost.addTab(
                TabHost.newTabSpec("tab3").setIndicator("Tab 3", null),
                Fragmento3.class, null);
    }
}
