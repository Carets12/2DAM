package es.vcarmen.examendaniel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ExamenDaniel extends AppCompatActivity {

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_daniel);

        boton = findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            llamada();

            }
        });
    }

   public void llamada (){

       Calendar calendarNow = new GregorianCalendar(TimeZone.getTimeZone("Europe/Madrid"));
       int anio = calendarNow.get(Calendar.YEAR);
       int mes = calendarNow.get(Calendar.MONTH);
       int dia = calendarNow.get(Calendar.DAY_OF_MONTH);

       Intent intent = new Intent(getApplicationContext(), Segunda.class);
       String.valueOf(mes);

       if (mes < 10){
           intent.putExtra("mes", "0"+(mes+1));
       }else{
           intent.putExtra("mes", mes+1);
       }

       String.valueOf(anio);
       String.valueOf(dia);

       intent.putExtra("name","Daniel Sierra Ráez");
       intent.putExtra("anio", anio);
       intent.putExtra("dia", dia);
       intent.putExtra("extra","Esto es un Extra dentro de un textView");

       startActivity(intent);

    }

}
