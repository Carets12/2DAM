package com.example.matinal.audio01;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class audio01 extends AppCompatActivity {

    Button b1,b2,b3,b4;
    SeekBar seekBar1, seekBar2, seekBar3;
    int laser, boom,gato,disparo;
    GestorSonido snd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio01);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);

        snd = new GestorSonido(getApplicationContext());
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        laser = snd.carga(R.raw.laser);
        boom = snd.carga(R.raw.explosion);
        gato = snd.carga(R.raw.gato);
        disparo = snd.carga(R.raw.disparo);

        seekBar1 = findViewById(R.id.simpleSeekBar1);
        seekBar2 = findViewById(R.id.simpleSeekBar2);
        seekBar3 = findViewById(R.id.simpleSeekBar3);

        SeekBar.OnSeekBarChangeListener barChange;
        barChange = new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progess, boolean fromUser) {
                switch (seekBar.getId()){
                    case R.id.simpleSeekBar1:
                        snd.ajustarVolumen((float) progess/100.f);
                        break;

                    case R.id.simpleSeekBar2:
                        snd.ajustarBalance((float) progess/100.f);
                        break;

                    case R.id.simpleSeekBar3:
                        snd.ajustarFrecuencia((float) progess/100.0f);
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        seekBar1.setOnSeekBarChangeListener(barChange);
        seekBar2.setOnSeekBarChangeListener(barChange);
        seekBar3.setOnSeekBarChangeListener(barChange);

    }

    public void pulsado(View v){
        int id = v.getId();
        switch (id){
            case R.id.b1:
                snd.suena(laser);
                break;

            case R.id.b2:
                snd.suena(boom);
                break;

            case R.id.b3:
                snd.suena(disparo);
                break;

            case R.id.b4:
                snd.suena(gato);
                break;
        }
    }
}
