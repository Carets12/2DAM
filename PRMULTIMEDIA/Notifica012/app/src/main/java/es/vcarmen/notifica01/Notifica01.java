package es.vcarmen.notifica01;

import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notifica01 extends AppCompatActivity {

    private NotificationManager notificador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifica01);

        Button boton = (Button) findViewById(R.id.button1);
        notificador = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notification(1, android.R.drawable.stat_sys_warning,"NOTIFICACIÓN", "EJEMPLO DE NOTIFICACIÓN");

            }
        });
    }

    public void notification(int id, int iconId, String titulo, String contenido ){

        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this).setSmallIcon(iconId).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).setContentTitle(titulo).setContentText(contenido).setColor(getResources().getColor(R.color.colorAccent)).setVibrate(new long[] {1000,1000,1000,1000,1000});
        //Contruir la notificacion y emitirla
        notificador.notify(id,builder.build());
    }
}
