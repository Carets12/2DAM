package vcarmen.es.tabs02;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs02);
        Resources res = getResources();
        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec fotospec = tabs.newTabSpec("fotos");
        fotospec.setIndicator("",
                res.getDrawable(R.drawable.icon_fotos_tab));
        Intent photosIntent = new Intent(this, Fotografia.class);
        fotospec.setContent(photosIntent);
        TabHost.TabSpec musicaspec = tabs.newTabSpec("musica");
        musicaspec.setIndicator("",
                res.getDrawable(R.drawable.icon_musica_tab));
        Intent songsIntent = new Intent(this, Musica.class);
        musicaspec.setContent(songsIntent);
        TabSpec videospec = tabs.newTabSpec("videos");
        videospec.setIndicator("",
                res.getDrawable(R.drawable.icon_videos_tab));
        Intent videosIntent = new Intent(this, Videos.class);
        videospec.setContent(videosIntent);
        tabs.addTab(fotospec);
        tabs.addTab(musicaspec);
        tabs.addTab(videospec);
    }
}
}
