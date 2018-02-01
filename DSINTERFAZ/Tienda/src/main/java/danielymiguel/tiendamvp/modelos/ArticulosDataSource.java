package danielymiguel.tiendamvp.modelos;

import java.util.List;

/**
 * Created by matinal on 8/01/18.
 */

public interface ArticulosDataSource {

    void getArticulos(CargaArticulosCallback callback);
    void getArticulo(int posicion, CargaArticuloCallback callback);

    interface CargaArticulosCallback {
        void onArticulosCargadas(List<Articulo> articulos);
        void onArticulosError();
    }

    interface CargaArticuloCallback {
        void onArticuloCargada(Articulo articulo);
        void onArticuloError();
    }

}
