package danielymiguel.tiendamvp.modelos;

import android.util.Log;

import java.util.List;

import danielymiguel.tiendamvp.modelos.api.ApiRest;

/**
 * Created by matinal on 9/01/18.
 */

public class ArticulosRepository implements ArticulosDataSource {

    private static ArticulosRepository INSTANCIA = null;
    private List<Articulo> listaArticulos = null;

    public static ArticulosRepository getInstance(){
        if (INSTANCIA == null){
            INSTANCIA = new ArticulosRepository();
        }
        return INSTANCIA;
    }

    @Override
    public void getArticulos(final CargaArticulosCallback callback) {
        if (listaArticulos == null){
            ApiRest api = new ApiRest();
            api.getArticulos(new CargaArticulosCallback() {
                @Override
                public void onArticulosCargadas(List<Articulo> noticias) {
                    listaArticulos = noticias;
                    callback.onArticulosCargadas(noticias);
                    Log.e("Errores::", "ArticulosRepository::Noticias cargadas");
                }

                @Override
                public void onArticulosError() {
                    callback.onArticulosError();
                }
            });
        }else{
            callback.onArticulosCargadas(listaArticulos);
            Log.e("Errores::", "ArticulosRepository::Noticias cargadas");
        }
    }

    @Override
    public void getArticulo(int posicion, CargaArticuloCallback callback) {
        if (posicion < listaArticulos.size()){
            callback.onArticuloCargada(listaArticulos.get(posicion));
        }else{
            callback.onArticuloError();
        }
    }
}
