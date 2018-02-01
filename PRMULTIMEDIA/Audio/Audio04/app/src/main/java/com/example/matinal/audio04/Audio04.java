package com.example.matinal.audio04;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

public class Audio04 extends AppCompatActivity {

    ImageButton play, pause, grabar;
    private MediaRecorder miGrabadora;
    private String salida = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio04);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        grabar = findViewById(R.id.grabar);

        grabar.setEnabled(true);
        play.setEnabled(false);
        pause.setEnabled(false);

        salida = Environment.getExternalStorageDirectory().getAbsolutePath()+"/grabado.3gp";
        iniciar();


        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciar();
                try {
                    miGrabadora.prepare();
                    miGrabadora.start();
                    Toast.makeText(Audio04.this, "Estas grabando", Toast.LENGTH_SHORT).show();
                    grabar.setEnabled(false);
                    pause.setEnabled(true);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer repro = new MediaPlayer();
             try{
               repro.setDataSource(salida);

             }catch (IllegalStateException e){

             }catch (IllegalArgumentException e){

             }catch (SecurityException e){

             } catch (IOException e) {
                 e.printStackTrace();
             }

             try{
                    repro.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                repro.start();
                Toast.makeText(Audio04.this, "Reproduciendo", Toast.LENGTH_SHORT).show();
                grabar.setEnabled(true);
                play.setEnabled(false);
                pause.setEnabled(false);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miGrabadora.stop();
                miGrabadora.release();
                miGrabadora = null;
                play.setEnabled(true);
                pause.setEnabled(false);
                Toast.makeText(Audio04.this, "Pausado", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void iniciar (){
        miGrabadora = new MediaRecorder();
        miGrabadora.setAudioSource(MediaRecorder.AudioSource.MIC);
        miGrabadora.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        miGrabadora.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        miGrabadora.setOutputFile(salida);
    }
}
