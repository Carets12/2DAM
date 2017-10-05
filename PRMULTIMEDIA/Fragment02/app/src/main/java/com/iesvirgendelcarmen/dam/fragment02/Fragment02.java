package com.iesvirgendelcarmen.dam.fragment02;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fragment02 extends AppCompatActivity implements View.OnClickListener {

    FragmentManager FM = getSupportFragmentManager();
    FragmentTransaction FT = FM.beginTransaction();
    Fragmento1 fragment = new Fragmento1();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment02);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }
    
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:

                FT.add(R.id.contenedor, fragment);
                FT.commit();

        }
    }
}

