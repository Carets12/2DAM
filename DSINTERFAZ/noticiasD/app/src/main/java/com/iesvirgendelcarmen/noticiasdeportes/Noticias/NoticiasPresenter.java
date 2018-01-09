package com.iesvirgendelcarmen.noticiasdeportes.Noticias;

import com.iesvirgendelcarmen.noticiasdeportes.modelos.Noticia;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.NoticiasDataSource;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.NoticiasRepository;

import java.util.List;

public class NoticiasPresenter implements NoticiasContract.Presenter {
    private NoticiasRepository noticiasRepository;
    private NoticiasContract.View noticiasView;

    public NoticiasPresenter(NoticiasContract.View noticiasView) {
        this.noticiasView = noticiasView;
        this.noticiasRepository = NoticiasRepository.getInstance();
    }

    /**
     * Obtiene una lista de noticias usando la API pública newsapi.org
     * <p>
     * Se usa un callback para recibir la lista.
     */
    public void cargaDatos() {
        noticiasRepository.getNoticias(new NoticiasDataSource.CargaNoticiasCallback() {
            @Override
            public void onNoticiasCargadas(List<Noticia> noticias) {
                //Se manda la lista a la vista para que la muestre
                noticiasView.mostrarNoticias(noticias);
            }

            @Override
            public void onNoticiaError() {
                noticiasView.mostrarError();
            }
        });
    }


}