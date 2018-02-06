package com.iesvirgendelcarmen.noticiasdeportesmvp.NoticiaDetalle;

import android.util.Log;

import com.iesvirgendelcarmen.noticiasdeportesmvp.modelos.Noticia;
import com.iesvirgendelcarmen.noticiasdeportesmvp.modelos.NoticiasDataSource;
import com.iesvirgendelcarmen.noticiasdeportesmvp.modelos.NoticiasRepository;

/**
 * Created by luis on 19/12/17.
 */

public class NoticiaDetallePresenter implements NoticiaDetalleContract.Presenter {

    private NoticiaDetalleContract.View noticiaVista;
    private NoticiasRepository noticiasRepository;

    NoticiaDetallePresenter(NoticiaDetalleContract.View vista) {
        this.noticiaVista = vista;
        noticiasRepository = NoticiasRepository.getInstance();
    }

    @Override
    public void cargaNoticia(int posicion) {
        noticiasRepository.getNoticia(posicion, new NoticiasDataSource.CargaNoticiaCallback() {
            @Override
            public void onNoticiaCargada(Noticia noticia) {
                Log.i("NoticiaDetalle", noticia.toString());
                noticiaVista.mostrarNoticia(noticia);
            }

            @Override
            public void onNoticiaError() {

            }
        });
    }
}
