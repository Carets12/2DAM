package vcarmen.es.butterk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.titulo)
    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        titulo.setText("Texto cambiado con ButterKnife");

    }

    @OnClick(R.id.titulo)
    public void cambiaNombre() {
        titulo.setText("Se ha hecho click");
    }
    
}
