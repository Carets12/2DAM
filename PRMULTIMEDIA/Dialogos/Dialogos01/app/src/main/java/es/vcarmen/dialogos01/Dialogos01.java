package es.vcarmen.dialogos01;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dialogos01 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos01);

        Button boton = findViewById(R.id.boton);
        Button boton1 = findViewById(R.id.boton1);
        Button boton2 = findViewById(R.id.boton2);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            showDialog(0);

            }
        });

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(1);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(2);
            }
        });
    }

    protected Dialog onCreateDialog(int id){
     Dialog dialog = null;
     if(id == 0){
         AlertDialog.Builder builder = new AlertDialog.Builder(this);
         builder = builder.setIcon(R.mipmap.ic_launcher);
         builder = builder.setTitle("EJEMPLO DE DIÁLOGO");
         dialog = builder.create();

     }
     if(id == 1){
         AlertDialog.Builder builder = new AlertDialog.Builder(this);
         builder = builder.setIcon(R.mipmap.ic_launcher);
         builder = builder.setTitle("EJEMPLO DE DIÁLOGO2");
         dialog = builder.create();

     }
     if(id == 2){
         AlertDialog.Builder builder = new AlertDialog.Builder(this);
         builder = builder.setIcon(R.mipmap.ic_launcher);
         builder = builder.setTitle("EJEMPLO DE DIÁLOGO3");
         dialog = builder.create();

     }
        return  dialog;
    }
}
