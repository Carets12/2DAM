package es.vcarmen.examendaniel;

import android.Manifest;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

                Intent llamar = new Intent(Intent.ACTION_CALL, Uri.parse("tel:697869813"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(llamar);

               // llamada();
            /*
            Intent ejemplo = new Intent(Intent.ACTION_VIEW);
                ejemplo.setData(Uri.parse("https://www.iesvirgendelcarmen.com/"));
                startActivity(ejemplo);
             */
            /*
            Intent ejemplo = new Intent(Intent.ACTION_WEB_SEARCH);
               ejemplo.putExtra(SearchManager.QUERY,"Jaén");
               startActivity(ejemplo);
            */
            /*Intent llamada = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:1234567890"));
                startActivity(llamada);
            */
            /*
            Intent ejemplo = new Intent(Intent.ACTION_VIEW);
            ejemplo.setData(Uri.parse("geo:0,0?z=4&q=restaurantes"));
            startActivity(ejemplo);
            */

            /*
                Intent eje = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(eje);
            */

            /*Intent eje = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
            startActivity(eje);
            */

            }
        });
    }
/*
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

       intent.putExtra("enero","Enero");
       intent.putExtra("febrero","Febrero");
       intent.putExtra("marzo","Marzo");
       intent.putExtra("abril","Abril");
       intent.putExtra("mayo","Mayo");

       startActivity(intent);

    }*/


}
