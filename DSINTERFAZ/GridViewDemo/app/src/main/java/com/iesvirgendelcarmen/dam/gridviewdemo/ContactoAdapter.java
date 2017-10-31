package com.iesvirgendelcarmen.dam.gridviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by matinal on 30/10/17.
 */

public class ContactoAdapter extends BaseAdapter {

    private List<Contacto> lista;
    private Context mContext;

    public ContactoAdapter(Context mContext, List<Contacto> lista){
        this.mContext = mContext;
        this.lista = lista;

    }

    @Override
    public int getCount() {
        return lista.size();

    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contacto c = (Contacto) getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gripview_contacto, parent,false);
        }

        ImageView foto  = convertView.findViewById(R.id.foto);
        TextView nombre = convertView.findViewById(R.id.nombre);
        TextView apellidos = convertView.findViewById(R.id.apellidos);

        nombre.setText(c.getNombre());
        apellidos.setText(c.getApellidos());
        foto.setImageResource(c.getFoto());



        return convertView;
    }
}
