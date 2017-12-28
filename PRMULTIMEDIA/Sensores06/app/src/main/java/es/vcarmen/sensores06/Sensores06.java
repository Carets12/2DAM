package es.vcarmen.sensores06;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores06 extends AppCompatActivity implements SensorEventListener{

    double distancia = 0;
    int contador = 0;
    String proximidad = "LEJOS";
    TextView tvProximidad, tvDistancia, tvContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores06);

        tvProximidad = (TextView) findViewById(R.id.distancia);
        tvDistancia = (TextView) findViewById(R.id.proximidad);
        tvContador = (TextView) findViewById(R.id.contador);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensorProximo = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(this,sensorProximo,SensorManager.SENSOR_DELAY_FASTEST);
        /*
        class CambiaTexto implements Runnable{

            @Override
            public void run() {
                tvDistancia.setText(""+distancia);
                tvProximidad.setText(""+proximidad);
                tvContador.setText(""+contador);
            }
        }
        runOnUiThread(new CambiaTexto());
        super.onResume();
        sensorManager.registerListener(this,sensorProximo,SensorManager.SENSOR_DELAY_FASTEST);
        super.onPause();
        sensorManager.unregisterListener(this);*/
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        distancia = sensorEvent.values[0];
        System.out.println("Distancia "+distancia);
        contador++;
        if(distancia < 1){
            proximidad = "CERCA";
        }else  proximidad = "LEJOS";


        tvDistancia.setText(""+distancia);
        tvProximidad.setText(""+proximidad);
        tvContador.setText(""+contador);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
