package com.iesvirgendelcarmen.noticiasdeportesmvp.Noticias;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.iesvirgendelcarmen.noticiasdeportesmvp.NoticiasDetalleActivity;
import com.iesvirgendelcarmen.noticiasdeportesmvp.R;
import com.iesvirgendelcarmen.noticiasdeportesmvp.modelos.Noticia;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoticiasActivity extends AppCompatActivity implements NoticiasContract.View {

    public static final String EXTRA_NOTICIA = "EXTRA_NOTICIA";
    @BindView(R.id.noticias)
    ListView listViewNoticias;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private NoticiasPresenter noticiasPresenter;
    private NoticiasAdapter noticiasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        noticiasPresenter = new NoticiasPresenter(this);
        noticiasPresenter.cargaDatos();
        setLayout();
    }

    /**
     * Configuración de la vista
     */
    private void setLayout() {
        //Establece la toolbar de la libreria de soporte
        setSupportActionBar(toolbar);

        //crea el adaptador
        noticiasAdapter = new NoticiasAdapter(this, new ArrayList<Noticia>(0));
        listViewNoticias.setAdapter(noticiasAdapter);

        //Evento click en item de la lista
        listViewNoticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Se lanza la Activity de detalles de la noticia
                Intent intent = new Intent(NoticiasActivity.this, NoticiasDetalleActivity.class);
                intent.putExtra(EXTRA_NOTICIA, noticiasPresenter.listaNoticias.get(i));
                startActivity(intent);
            }
        });
    }


    @Override
    public void mostrarNoticias(List<Noticia> noticias) {
        noticiasAdapter.updateNoticias(noticias);
    }
}
