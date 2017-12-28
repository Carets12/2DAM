package es.vcarmen.sensores04;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores04 extends AppCompatActivity implements SensorEventListener {

    int contador;
    boolean continuar = true;
    double x = 0,y = 0,z = 0,a = 0,amax = 0;
    double campoTierraMax = SensorManager.MAGNETIC_FIELD_EARTH_MAX;
    double campoTierraMin = SensorManager.MAGNETIC_FIELD_EARTH_MIN;
    TextView tvax, tvay, tvaz, tva, tvaMax, tvG, cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores04);

       tvax = (TextView) findViewById(R.id.aceleracionx);
       tvay = (TextView) findViewById(R.id.aceleraciony);
       tvaz = (TextView) findViewById(R.id.aceleracionz);
       tva = (TextView)  findViewById(R.id.campoTotal);
       tvaMax = (TextView) findViewById(R.id.campoTerrestre);
       tvG = (TextView) findViewById(R.id.campoTierra);
       cont = (TextView) findViewById(R.id.contador);

       SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
       Sensor campo = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
       sensorManager.registerListener(this,campo,SensorManager.SENSOR_DELAY_NORMAL);

       class MiAsyncTask extends AsyncTask <Void,Void,Void>{
           @Override
           protected Void doInBackground(Void... voids) {
               while (true){
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   contador++;
                   publishProgress();
               }
           }

           @Override
           protected void onProgressUpdate(Void... values) {
               super.onProgressUpdate(values);

               tvax.setText(""+x);
               tvay.setText(""+y);
               tvaz.setText(""+z);
               tva.setText(""+a);
               tvaMax.setText(""+amax);
               tvG.setText(""+campoTierraMin+"-"+campoTierraMax);
               cont.setText("CONTADOR:"+contador);
           }
       }

        new MiAsyncTask().execute();
        super.onPause();
        continuar = false;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x = sensorEvent.values[0];
        y = sensorEvent.values[1];
        z = sensorEvent.values[2];
        a = Math.sqrt(x*x+y*y+z*z);
        if (a > amax){
            amax = a;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
