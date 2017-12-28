package es.vcarmen.sensores05;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores05 extends AppCompatActivity implements SensorEventListener{

    int contador;
    double azimut = 0, vertical = 0, lateral = 0;
    String orientacion = "posición";
    TextView tvA, tvV, tvL, tvO, tvC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores05);

       tvA = (TextView) findViewById(R.id.azimut);
       tvV = (TextView) findViewById(R.id.verticalidad);
       tvL = (TextView) findViewById(R.id.lateralidad);
       tvO = (TextView) findViewById(R.id.orientacion);
       tvC = (TextView) findViewById(R.id.contador);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor orienta = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensorManager.registerListener(this,orienta,SensorManager.SENSOR_DELAY_NORMAL);
/*
        class CambiaTexto implements Runnable{

            @Override
            public void run() {
                tvA.setText(""+azimut);
                tvV.setText(""+vertical);
                tvL.setText(""+lateral);
                tvO.setText(""+orientacion);
                tvC.setText(""+contador);
            }
        }

        runOnUiThread(new CambiaTexto());
*/
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        azimut = sensorEvent.values[0];
        vertical = sensorEvent.values[1];
        lateral = sensorEvent.values[2];
        contador++;

        if(azimut < 22) orientacion = "NORTE";
        else if(azimut < 67) orientacion = "NORESTE";
        else if(azimut < 112) orientacion = "ESTE";
        else if(azimut < 157) orientacion = "SURESTE";
        else if(azimut < 202) orientacion = "SUR";
        else if(azimut < 247) orientacion = "SUROESTE";
        else if(azimut < 292) orientacion = "OESTE";
        else if(azimut < 337) orientacion = "NOROESTE";
        else orientacion = "NORTE";

        if(vertical < -50) orientacion = "VERTICAL ARRIBA";
        if(vertical > 50) orientacion = "VERTICAL ABAJO";

        if(lateral < -50) orientacion = "LATERAL DERECHA";
        if(lateral > 50) orientacion = "LATERAL IZQUIERDA";

        tvA.setText(""+azimut);
        tvV.setText(""+vertical);
        tvL.setText(""+lateral);
        tvO.setText(""+orientacion);
        tvC.setText(""+contador);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
