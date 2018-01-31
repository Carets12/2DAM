package com.example.matinal.sonido03;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by matinal on 31/01/2018.
 */

public class Servicio extends Service {

    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this,R.raw.elbano);
        player.setLooping(true);
        Toast.makeText(this, "Creado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destruido", Toast.LENGTH_SHORT).show();
        player.stop();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this, "Iniciado", Toast.LENGTH_SHORT).show();
        player.start();
    }


}
