package com.iesvirgendelcarmen.noticiasdeportes.modelos;

import java.util.List;


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
