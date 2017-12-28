package es.vcarmen.sensores03;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

        public class Sensores03 extends AppCompatActivity implements SensorEventListener {

            int contador;
            double x = 0, y = 0, z = 0;
            TextView tvax,tvay,tvaz,cont;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_sensores03);

                tvax = (TextView) findViewById(R.id.aceleracionx);
                tvay = (TextView) findViewById(R.id.aceleraciony);
                tvaz = (TextView) findViewById(R.id.aceleracionz);
                cont = (TextView) findViewById(R.id.contador);

                SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                Sensor gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
                sensorManager.registerListener(this, gyro, SensorManager.SENSOR_DELAY_FASTEST);

                class  MiAsyncTask extends AsyncTask<Void,Void,Void>{

                    @Override
                    protected Void doInBackground(Void... voids) {

                        while (true){
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            contador ++;
                            publishProgress();
                        }

                    }

                    @Override
                    protected void onProgressUpdate(Void... values) {
                        super.onProgressUpdate(values);
                        tvax.setText(""+x);
                        tvay.setText(""+y);
                        tvaz.setText(""+z);
                        cont.setText("CONTADOR:"+contador);
                    }
                }

                new MiAsyncTask().execute();
            }

            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

                x = sensorEvent.values[0];
                y = sensorEvent.values[1];
                z = sensorEvent.values[2];

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}
