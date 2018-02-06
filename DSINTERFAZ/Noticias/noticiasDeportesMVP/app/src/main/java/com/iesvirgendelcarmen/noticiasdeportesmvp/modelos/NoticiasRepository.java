package com.iesvirgendelcarmen.noticiasdeportesmvp.modelos;

import com.iesvirgendelcarmen.noticiasdeportesmvp.modelos.api.NewsApi;

import java.util.List;

/**
 * Created by luis on 19/12/17.
 */

public class NoticiasRepository implements NoticiasDataSource {

    private static NoticiasRepository INSTANCIA = null;
    private List<Noticia> listaNoticias = null;

    public static NoticiasRepository getInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new NoticiasRepository();
        }
        return INSTANCIA;
    }

    @Override
    public void getNoticias(final CargaNoticiasCallback callback) {
        if (listaNoticias == null) {
            NewsApi api = new NewsApi();
            api.getNoticias(new CargaNoticiasCallback() {
                @Override
                public void onNoticiasCargadas(List<Noticia> noticias) {
                    listaNoticias = noticias;
                    callback.onNoticiasCargadas(noticias);
                }

                @Override
                public void onNoticiaError() {
                    callback.onNoticiaError();
                }
            });
        } else {
            callback.onNoticiasCargadas(listaNoticias);
        }
    }

    /*
        @Override
        public void getNoticias(final CargaNoticiasCallback callback) {
            NoticiasMock mock = new NoticiasMock();
            mock.getNoticias(new CargaNoticiasCallback() {
                @Override
                public void onNoticiasCargadas(List<Noticia> noticias) {
                    listaNoticias = noticias;
                    callback.onNoticiasCargadas(noticias);
                }

                @Override
                public void onNoticiaError() {
                    callback.onNoticiaError();
                }
            });
        }
    */
    @Override
    public void getNoticia(int posicion, CargaNoticiaCallback callback) {
        if (posicion < listaNoticias.size())
            callback.onNoticiaCargada(listaNoticias.get(posicion));
        else
            callback.onNoticiaError();
    }
}
