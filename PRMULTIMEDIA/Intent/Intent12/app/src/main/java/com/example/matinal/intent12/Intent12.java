package com.example.matinal.intent12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Intent12 extends AppCompatActivity {

    Button boton;
    private static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent12);

        boton = findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent llamada = new Intent(getApplicationContext(), activity.class);
                startActivityForResult(llamada, REQUEST_CODE);
            }
        });
    }

    protected void onActivityResult(int resquestCode, int resulCode, Intent data){
        if(resulCode == RESULT_OK && resquestCode == REQUEST_CODE){
            if(data.hasExtra("RETORNO")){
                Toast.makeText(this, data.getExtras().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
