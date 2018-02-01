package danielymiguel.tiendamvp.modelos.api;


import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

import danielymiguel.tiendamvp.AppContexto;
import danielymiguel.tiendamvp.modelos.Articulo;
import danielymiguel.tiendamvp.modelos.ArticulosDataSource;

/**
 * Created by luis on 9/12/17.
 */

public class ApiRest implements ArticulosDataSource{

    @Override
    public void getArticulos(final CargaArticulosCallback callback) {
        String urlArticulos = "http://ec2-52-47-184-191.eu-west-3.compute.amazonaws.com:3000/articulos";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, urlArticulos, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        // respuesta del get devuelve un array json, a implementar
                        //Uso Gson para deserializar el array automaticamente
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<Articulo>>(){}.getType();
                        List<Articulo> articulos = gson.fromJson(response.toString(), type);
                        Log.e("Errores::", "ApiRest::Antes de cargar articulos");
                        callback.onArticulosCargadas(articulos);
                        Log.e("Errores::", "ApiRest::Articulos Cargados");
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.e("Errores::", "ApiRest::Error en la respuesta");
                    }
                });

        MiSinglentonVolley.getInstance(AppContexto.getContexto()).addToRequestQueue(jsonArrayRequest);
    }

    @Override
    public void getArticulo(int posicion, CargaArticuloCallback callback) {
        // sin implementar aun
    }



}


