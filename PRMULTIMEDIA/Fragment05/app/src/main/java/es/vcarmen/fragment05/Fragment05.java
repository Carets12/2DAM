package es.vcarmen.fragment05;

import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Fragment05 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment05);
        FragmentManager FM = getFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();

        Fragmento1 preferencias = new Fragmento1();

        FT.replace(android.R.id.content, preferencias);
        FT.commit();
        }
}
