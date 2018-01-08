package com.iesvirgendelcarmen.noticiasdeportes.Noticias;

import com.iesvirgendelcarmen.noticiasdeportes.modelos.Noticia;

import java.util.List;


public interface NoticiasContract {
    interface View {
        void mostrarNoticias(List<Noticia> noticias);
    }
}
