package com.example.matinal.intent12;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class activity extends AppCompatActivity {

    EditText texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity);

        texto = findViewById(R.id.Etext);
    }

    public void finish(){
        Intent data = new Intent();
        data.putExtra("RETORNO",texto.getText());
        setResult(RESULT_OK,data);
        super.finish();
    }
}
