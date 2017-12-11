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

public class AdaptadorEmpresa extends ArrayAdapter<Empresa> {

    public AdaptadorEmpresa(@NonNull Context context, @NonNull ArrayList<Empresa> empresas) {
        super(context, 0, empresas);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Empresa e = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.empresa_item, parent, false);
        }

        TextView nombreEm = convertView.findViewById(R.id.empresaNombre);
        TextView emailEm= convertView.findViewById(R.id.empresaEmail);
        ImageView foto = convertView.findViewById(R.id.foto2);

        nombreEm.setText(e.getNombre());
        emailEm.setText(e.getEmailCorporativo());
        foto.setImageResource(R.drawable.empresaico);

        return convertView;

    }

}
