package com.iesvirgendelcarmen.noticiasdeportes.Noticias;

import com.iesvirgendelcarmen.noticiasdeportes.modelos.Noticia;

import java.util.List;

/**
 * Created by luis on 11/12/17.
 */

public interface NoticiasContract {
    interface View {
        void mostrarNoticias(List<Noticia> noticias);
    }
}
