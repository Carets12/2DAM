package es.vcarmen.sensores07;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores07 extends AppCompatActivity implements SensorEventListener{

    double luz = 0;
    int contador = 0;
    String luminosidad = "NORMAL";
    TextView tvLuz, tvLuminosidad, tvContador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores07);

       tvLuminosidad = (TextView) findViewById(R.id.iluminacion);
       tvLuz = (TextView) findViewById(R.id.cantidad);
       tvContador = (TextView) findViewById(R.id.contador);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(this, sensorLuz,SensorManager.SENSOR_DELAY_FASTEST);

       /* class CambiaTexto implements Runnable{

            @Override
            public void run() {
                tvLuz.setText(""+luz);
                tvLuminosidad.setText(""+luminosidad);
                tvContador.setText(""+contador);

            }

        }
        runOnUiThread(new CambiaTexto());
        super.onResume();
        sensorManager.registerListener(this, sensorLuz,SensorManager.SENSOR_DELAY_FASTEST);
        super.onPause();
        sensorManager.unregisterListener(this);*/

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        luz = sensorEvent.values[0];
        contador++;
        if(luz < 100)luminosidad = "OSCURO";
         else if (luz < 2000) luminosidad = "LUZ NORMAL";
         else if (luz < 6000) luminosidad = "BRILLANTE";
         else luminosidad = "MUCHA LUZ";

        tvLuz.setText(""+luz);
        tvLuminosidad.setText(""+luminosidad);
        tvContador.setText(""+contador);
        
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
