package es.vcarmen.material09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Material09 extends AppCompatActivity {

    LinearLayout detalle;
    ImageView icono;
    boolean giro;
    private static final int Duracion = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material09);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("EL RAPTO DE LAS MALVINAS");
        toolbar.setSubtitle("Jacques-louis David");

        detalle = (LinearLayout) findViewById(R.id.linear2);
        giro = false;
        icono = (ImageView) findViewById(R.id.imagen2);
    }

    private void rotate(float angulo){

        Animation animacion = new RotateAnimation(0.0f,angulo,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animacion.setFillAfter(true);
        animacion.setDuration(Duracion);
        icono.startAnimation(animacion);
    }

    public void tocado(View view){

        if(giro == true){

            icono.setImageResource(R.mipmap.mas);
            rotate(-180.0f);
            giro = false;
            Dinamizador.contrae(detalle, Duracion);
        }

        if(giro == false){

            icono.setImageResource(R.mipmap.mas);
            rotate(180.0f);
            giro = true;
            Dinamizador.expande(detalle, Duracion);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String mensaje = "";

        switch (item.getItemId()) {

            case R.id.opcion1:
                mensaje = "¡¡¡Opción A Pulsada!!!";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.opcion2:
                mensaje = "¡¡¡Opción B Pulsada!!!";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.opcion3:
                mensaje = "¡¡¡Opción C Pulsada!!!";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
