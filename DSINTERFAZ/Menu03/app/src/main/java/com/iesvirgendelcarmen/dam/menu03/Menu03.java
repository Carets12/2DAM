package com.iesvirgendelcarmen.dam.menu03;

/**
 * Created by matinal on 31/10/17.
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
public class Menu03 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu03);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu03, menu);
        return true;
    }
}
