package es.vcarmen.fragment08;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by danic on 24/10/2017.
 */

public class Contenido extends Fragment {
    final static String ARG_POSITION = "position";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_fragment08, container,false);

    }

    @Override
    public void onStart() {
        Bundle args = getArguments();
        TextView contenido = (TextView) getActivity().findViewById(R.id.contenido);
        contenido.setText(Elementos.Contenidos[args.getInt(ARG_POSITION)]);
        super.onStart();
    }
}
