package es.vcarmen.video02;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video02 extends AppCompatActivity {

    VideoView reproductor;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video02);

        reproductor = findViewById(R.id.video);

       reproductor.setVideoURI(Uri.parse("android.resource://"+getPackageName() + "/" +R.raw.the_animated_history_of_poland));
       reproductor.setMediaController(new MediaController(this));

        reproductor.setMediaController(mediaController);
        //mediaController.setAnchorView(reproductor);
        reproductor.requestFocus();
        reproductor.start();


    }
}
