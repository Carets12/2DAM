package danielymiguel.tiendamvp.modelos;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by matinal on 8/01/18.
 */

public class ArticulosMock implements ArticulosDataSource {

    @Override
    public void getArticulos(CargaArticulosCallback callback) {
        ArrayList<Articulo> lista = new ArrayList<>();

        Articulo n = new Articulo();
        n.setCodigo(10);
        n.setNombre("Nombre del artículo 10");
        n.setDescripcion("Descripción del artículo 10...");
        n.setStock(100);
        n.setCategoria("Categoría 10");

        lista.add(n);

        n.setCodigo(10);
        n.setNombre("Nombre del artículo 11");
        n.setDescripcion("Descripción del artículo 11...");
        n.setStock(111);
        n.setCategoria("Categoría 11");

        lista.add(n);

        callback.onArticulosCargadas(lista);
    }

    @Override
    public void getArticulo(int posicion, CargaArticuloCallback callback) {

        Articulo n1 = new Articulo();
        n1.setCodigo(10);
        n1.setNombre("Nombre del artículo 10");
        n1.setDescripcion("Descripción del artículo 10...");
        n1.setStock(100);
        n1.setCategoria("Categoría 10");

        Articulo n2 = new Articulo();
        n2.setCodigo(10);
        n2.setNombre("Nombre del artículo 12");
        n2.setDescripcion("Descripción del artículo 12...");
        n2.setStock(122);
        n2.setCategoria("Categoría 12");

        if (posicion == 0) callback.onArticuloCargada(n1);
        else callback.onArticuloCargada(n2);
    }

}
