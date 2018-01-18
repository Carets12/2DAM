package com.iesvirgendelcarmen.noticiasdeportes.NoticiaDetalle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.iesvirgendelcarmen.noticiasdeportes.Noticias.NoticiasActivity;
import com.iesvirgendelcarmen.noticiasdeportes.R;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.Noticia;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.api.VolleySingleton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoticiaDetalleActivity extends AppCompatActivity implements NoticiaDetalleContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.detalletitulo)
    TextView titulo;
    @BindView(R.id.detalleAutor)
    TextView autor;
    @BindView(R.id.detalleDescripcion)
    TextView descripcion;
    @BindView(R.id.detalleFecha)
    TextView fecha;
    @BindView(R.id.detalleImagen)
    NetworkImageView imagen;

    private NoticiaDetallePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias_detalle);
        ButterKnife.bind(this);

        int posNoticia = getIntent().getExtras().getInt(NoticiasActivity.EXTRA_NOTICIA);
        setLayout();
        presenter = new NoticiaDetallePresenter(this);
        presenter.cargaNoticia(posNoticia);
    }


    private void setLayout() {
        //Establece la toolbar de la libreria de soporte
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * Establece valores para los views de la noticia
     *
     * @param noticia Objeto noticia
     */
    @Override
    public void mostrarNoticia(Noticia noticia) {
        if (noticia != null) {
            titulo.setText(noticia.getTitle());
            autor.setText(noticia.getAuthor());
            descripcion.setText(noticia.getDescription());
            fecha.setText(noticia.getFormatPublishedAt());
            imagen.setImageUrl(noticia.getUrlToImage(), VolleySingleton.getInstance(this).getImageLoader());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }


}
