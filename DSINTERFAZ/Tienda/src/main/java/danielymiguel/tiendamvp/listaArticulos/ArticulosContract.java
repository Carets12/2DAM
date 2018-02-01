package danielymiguel.tiendamvp.listaArticulos;

import java.util.List;

import danielymiguel.tiendamvp.modelos.Articulo;

/**
 * Interfaz para desacoplar el activity y el presentador
 * También llamado interactor o contract
 *
 * Created by matinal on 18/12/17.
 */

public interface ArticulosContract {

    interface View {
        void mostrarArticulos(List<Articulo> articulos);
        void mostrarError();
    }

    interface Presenter {
        void cargaDatos();
    }

}
