package com.iesvirgendelcarmen.noticiasdeportes.NoticiaDetalle;

import com.iesvirgendelcarmen.noticiasdeportes.modelos.Noticia;


public interface NoticiaDetalleContract {
    interface View {
        void mostrarNoticia(Noticia noticia);
    }

    interface Presenter {
        void cargaNoticia(int posicion);
    }

}
