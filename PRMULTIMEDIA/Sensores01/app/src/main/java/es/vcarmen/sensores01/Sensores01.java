package es.vcarmen.sensores01;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Sensores01 extends AppCompatActivity {

    SensorManager sensorManager;
    TextView salida;
    List<Sensor> listaSensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores01);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        salida = (TextView) findViewById(R.id.listado);

        for (Sensor sensor:listaSensores){
            salida.append(sensor.getName() + "\n");
        }

    }
}
