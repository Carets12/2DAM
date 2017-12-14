package es.vcarmen.fragment05;

import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fragment05 extends AppCompatActivity {
    FragmentManager FM;
    FragmentTransaction FT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment05);

        Button mostrar = (Button) findViewById(R.id.boton);
        mostrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FM = getFragmentManager();
                FT = FM.beginTransaction();
                Fragmento1 preferencias = new Fragmento1();

                FT.add(R.id.content, preferencias);
               // FT.replace(android.R.id.content, preferencias);
                FT.commit();
            }

        });
    }
}
