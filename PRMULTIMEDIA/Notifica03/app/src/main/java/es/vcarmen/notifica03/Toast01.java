package es.vcarmen.notifica03;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Toast01 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast01);

        Button boton = findViewById(R.id.boton);
        final TextView texto = findViewById(R.id.texto);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context contexto = getApplicationContext();
                CharSequence texto = "EJEMPLO TOAST";
                int duracion = Toast.LENGTH_SHORT;
                int posX = 300;
                int posY = 600;

                Toast toast1 = Toast.makeText(contexto, texto, duracion);
                toast1.setGravity(Gravity.RIGHT | Gravity.TOP,posX, posY);
                toast1.show();


            }
        });
    }
}
