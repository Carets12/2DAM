package com.iesvirgendelcarmen.noticiasdeportesmvp.Noticias;

import com.iesvirgendelcarmen.noticiasdeportesmvp.modelos.Noticia;

import java.util.List;

/**
 * Created by luis on 11/12/17.
 */

public interface NoticiasContract {
    interface View {
        void mostrarNoticias(List<Noticia> noticias);

        void mostrarError();
    }

    interface Presenter {
        void cargaDatos();
    }
}
