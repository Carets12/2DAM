package danielymiguel.tiendamvp.listaArticulos;


import java.util.List;

import danielymiguel.tiendamvp.modelos.Articulo;
import danielymiguel.tiendamvp.modelos.ArticulosDataSource;
import danielymiguel.tiendamvp.modelos.ArticulosMock;
import danielymiguel.tiendamvp.modelos.ArticulosRepository;

public class ArticulosPresenter implements ArticulosContract.Presenter {
    private ArticulosContract.View noticiasView;
    private ArticulosRepository articulosRepository;
    //private ArticulosMock articulosRepository;

    public ArticulosPresenter(ArticulosContract.View noticiasView) {
        this.noticiasView = noticiasView;
        this.articulosRepository = ArticulosRepository.getInstance();
        //this.articulosRepository = new ArticulosMock();
    }

    public void cargaDatos() {
        articulosRepository.getArticulos(new ArticulosDataSource.CargaArticulosCallback() {
            @Override
            public void onArticulosCargadas(List<Articulo> articulos) {
                noticiasView.mostrarArticulos(articulos);
            }

            @Override
            public void onArticulosError() {
                noticiasView.mostrarError();
            }
        });
    }

}