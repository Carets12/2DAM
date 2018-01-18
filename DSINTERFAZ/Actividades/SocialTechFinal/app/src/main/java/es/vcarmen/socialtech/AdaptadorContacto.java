package es.vcarmen.socialtech;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Daniel Sierra Ráez
 */

public class AdaptadorContacto extends ArrayAdapter<Contacto> {

    public AdaptadorContacto(@NonNull Context context, @NonNull ArrayList<Contacto> contactos) {

        super(context, 0, contactos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Contacto c = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contacto_item, parent, false);
        }

        TextView nombreContacto = convertView.findViewById(R.id.contactoNombre);
        TextView emailContacto = convertView.findViewById(R.id.contactoEmail);
        ImageView foto = convertView.findViewById(R.id.foto1);


        nombreContacto.setText(c.getNombre()+" "+c.getApellidos());
        emailContacto.setText(c.getEmail());

        if(c.getSexo() == true){
            foto.setImageResource(R.drawable.hombre);
        }else {
            foto.setImageResource(R.drawable.mujer);
        }

        return convertView;

    }
}
