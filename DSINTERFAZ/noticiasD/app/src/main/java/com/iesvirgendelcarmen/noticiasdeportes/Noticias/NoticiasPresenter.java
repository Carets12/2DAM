package com.iesvirgendelcarmen.noticiasdeportes.Noticias;

import com.iesvirgendelcarmen.noticiasdeportes.modelos.Noticia;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.api.NewsApi;


import java.util.List;

public class NoticiasPresenter {
    List<Noticia> listaNoticias;
    private NoticiasContract.View noticiasView;

    public NoticiasPresenter(NoticiasContract.View noticiasView) {
        this.noticiasView = noticiasView;
    }

    /**
     * Obtiene una lista de noticias usando la API pública newsapi.org
     * <p>
     * Se usa un callback para recibir la lista.
     */
    void cargaDatos() {
        NewsApi api = new NewsApi();
        api.ultimasNoticias(new NewsApi.Callback() {
            @Override
            public void getLista(List<Noticia> noticias) {
                listaNoticias = noticias;
                //Se instancia adaptador
                noticiasView.mostrarNoticias(listaNoticias);
            }
        });

    }
}