package es.vcarmen.sensores08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;

public class Sensores08 extends AppCompatActivity implements SensorEventListener{

    double luz = 0;
    int x,y,centrox = 250,centroy = 250;
    ShapeDrawable mDibujo = new ShapeDrawable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores08);

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.layout);

       class MiVistaPersonal extends  View{

           final static int ancho = 100;
           final static int alto = 100;

           public MiVistaPersonal(Context context) {
               super(context);

               mDibujo = new ShapeDrawable(new OvalShape());
               mDibujo.getPaint().setColor(0xff74AC23);
               mDibujo.setBounds(x,y,x + ancho, y + alto);

           }

           protected void onDraw (Canvas canvas){
               RectF oval = new RectF(Sensores08.this.x,Sensores08.this.y,Sensores08.this.x+ancho,Sensores08.this.y+alto);
               Paint pincel = new Paint();
               pincel.setColor(Color.GREEN);
               //canvas.drawOval(oval,pincel);
               canvas.drawRect(oval,pincel);
               invalidate();
           }
       }

        MiVistaPersonal miVista = new MiVistaPersonal(this);
        mainLayout.addView(miVista);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //Sensor sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        //super.onResume();
        //sensorManager.registerListener(this, sensorLuz,SensorManager.SENSOR_DELAY_FASTEST);
        sensorManager.registerListener(this,acelerometro,SensorManager.SENSOR_DELAY_NORMAL);
        /*super.onStop();
        sensorManager.unregisterListener(this);*/


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
       /* luz =  sensorEvent.values[0];
        if(luz < 100) ;
        else if (luz < 2000) ;
        else if (luz < 6000);
        else ;*/

        x = centrox+(int) Math.pow(sensorEvent.values[1],2);
        y = centroy+(int) Math.pow(sensorEvent.values[2],2);



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
