package danielymiguel.tiendamvp.listaArticulos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import danielymiguel.tiendamvp.R;
import danielymiguel.tiendamvp.modelos.Articulo;

public class ArticulosActivity extends AppCompatActivity implements ArticulosContract.View{

    public static final String EXTRA_NOTICIA = "EXTRA_NOTICIA";

    @BindView(R.id.lv_articulos)
    ListView listViewArticulos;

    private ArticulosContract.Presenter articulosPresenter;
    private ArticulosAdapter articulosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articulos_main);
        ButterKnife.bind(this);


        articulosPresenter = new ArticulosPresenter(this);
        articulosPresenter.cargaDatos();

        setLayout();
    }

    /**
     * Configuración de la vista
     */
    private void setLayout() {
        //Crear adaptador
        articulosAdapter = new ArticulosAdapter(this, new ArrayList<Articulo>());
        listViewArticulos.setAdapter(articulosAdapter);

        //Evento click en item de la lista
//        listViewArticulos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //Se lanza la Activity de detalles de la noticia
//                Intent intent = new Intent(NoticiasActivity.this, NoticiasDetalleActivity.class);
//                intent.putExtra(EXTRA_NOTICIA, i);
//                startActivity(intent);
//            }
//        });
    }

    public void mostrarArticulos(List<Articulo> articulos){
        articulosAdapter.updateArticulos(articulos);
        Log.e("Errores::", "ArticulosActivity::mostrarArticulos");
    }

    @Override
    public void mostrarError() {
        Toast.makeText(this, "Error al cargar los Artículos", Toast.LENGTH_SHORT).show();
    }

}
