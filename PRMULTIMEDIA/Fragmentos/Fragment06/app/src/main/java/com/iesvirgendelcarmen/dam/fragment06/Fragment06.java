package com.iesvirgendelcarmen.dam.fragment06;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Fragment06 extends AppCompatActivity{

    Button mostrar;

    FragmentManager FM;
    FragmentTransaction FT ;
    Fragmento1 fragmento1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment06);

        mostrar = (Button) findViewById(R.id.mostrar);
        mostrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FM = getFragmentManager();
                FT = FM.beginTransaction();
                fragmento1 = new Fragmento1();

                FT.add(R.id.contenedor, fragmento1);
                FT.commit();
            }
        });

    }

}
