package es.vcarmen.exameniu2017;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * DANIEL SIERRA RÁEZ
 */

public class AdaptadorLista extends BaseAdapter {

    Context context;
    ArrayList<Producto> productos;

    public AdaptadorLista(Context context, ArrayList<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int i) {
        return productos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Producto p = (Producto) getItem(i);

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_producto, viewGroup, false);
        }

        ImageView foto = (ImageView) view.findViewById(R.id.fotoi);
        TextView titulo = (TextView) view.findViewById(R.id.tituloi);
        TextView precio = (TextView) view.findViewById(R.id.precioi);
        TextView categoria = (TextView) view.findViewById(R.id.categoriai);
        TextView fecha = (TextView) view.findViewById(R.id.fechai);

        //foto.setImageResource(R.drawable.producto);
        //foto.getResources();
        titulo.setText(p.getTitulo());
        precio.setText(p.getPrecio());
        categoria.setText(p.getCategoria());
        fecha.setText(p.getFecha());

        Log.v("lie",titulo.toString());

        return view;
    }
}
