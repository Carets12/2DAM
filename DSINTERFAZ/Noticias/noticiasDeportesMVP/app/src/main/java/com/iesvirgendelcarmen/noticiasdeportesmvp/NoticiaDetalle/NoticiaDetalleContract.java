package com.iesvirgendelcarmen.noticiasdeportesmvp.NoticiaDetalle;

import com.iesvirgendelcarmen.noticiasdeportesmvp.modelos.Noticia;

/**
 * Created by luis on 19/12/17.
 */

public interface NoticiaDetalleContract {
    interface View {
        void mostrarNoticia(Noticia noticia);
    }

    interface Presenter {
        void cargaNoticia(int posicion);
    }

}
