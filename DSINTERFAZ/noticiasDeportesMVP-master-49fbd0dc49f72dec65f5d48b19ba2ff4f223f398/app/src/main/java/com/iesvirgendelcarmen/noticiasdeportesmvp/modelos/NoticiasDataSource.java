package com.iesvirgendelcarmen.noticiasdeportesmvp.modelos;

import java.util.List;

/**
 * Created by luis on 19/12/17.
 */

public interface NoticiasDataSource {

    void getNoticias(CargaNoticiasCallback callback);

    void getNoticia(int posicion, CargaNoticiaCallback callback);

    interface CargaNoticiasCallback {
        void onNoticiasCargadas(List<Noticia> noticias);

        void onNoticiaError();
    }

    interface CargaNoticiaCallback {
        void onNoticiaCargada(Noticia noticia);

        void onNoticiaError();
    }

}
