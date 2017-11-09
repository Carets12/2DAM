package es.vcarmen.material04;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Material04 extends AppCompatActivity implements View.OnClickListener {

    CoordinatorLayout coordinatorLayout;
    FloatingActionButton fab;
    Button btnSimple, btnInteractivo, btnPersonalizado;

    Snackbar snackbar, snackbar1, snackbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material04);

        btnSimple = (Button) findViewById(R.id.btnSimple);
        btnInteractivo = (Button) findViewById(R.id.btnInteractivo);
        btnPersonalizado = (Button) findViewById(R.id.btnPersonalizado);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        btnSimple.setOnClickListener(this);
        btnInteractivo.setOnClickListener(this);
        btnPersonalizado.setOnClickListener(this);
        fab.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnSimple:
                snackbar = Snackbar.make(coordinatorLayout, "MENSAJE BORRADO", Snackbar.LENGTH_LONG);
                snackbar.show();
                break;

            case R.id.btnInteractivo:
                snackbar = Snackbar.make(coordinatorLayout, "MENSAJE BORRADO", Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar1 = Snackbar.make(coordinatorLayout, "MENSAJE RESTAURADO", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
                snackbar.show();
                break;

            case R.id.btnPersonalizado:
                snackbar = Snackbar.make(coordinatorLayout, "MENSAJE BORRADO", Snackbar.LENGTH_LONG).setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar2 = Snackbar.make(coordinatorLayout, "NO ENCUENTRO LA RED", Snackbar.LENGTH_SHORT);
                        snackbar2.show();

                    }
                });
                View sbView = snackbar.getView();
                TextView texto = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                texto.setTextColor(Color.YELLOW);
                snackbar.setActionTextColor(Color.CYAN);
                snackbar.show();
                break;

            case R.id.fab:
                snackbar = Snackbar.make(coordinatorLayout, "NOMBRE: ---------------------> ", Snackbar.LENGTH_LONG).setAction("PRESIONAR", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar2 = Snackbar.make(coordinatorLayout, "DANIEL SIERRA RÁEZ", Snackbar.LENGTH_SHORT);
                        View sb1View = snackbar2.getView();
                        TextView texto1 = (TextView) sb1View.findViewById(android.support.design.R.id.snackbar_text);
                        texto1.setTextColor(Color.MAGENTA);
                        snackbar2.show();
                    }
                });
                View sb2View = snackbar.getView();
                TextView texto2 = (TextView) sb2View.findViewById(android.support.design.R.id.snackbar_text);
                texto2.setTextColor(Color.GREEN);
                snackbar.setActionTextColor(Color.CYAN);
                snackbar.show();
                break;


        }

    }
}
