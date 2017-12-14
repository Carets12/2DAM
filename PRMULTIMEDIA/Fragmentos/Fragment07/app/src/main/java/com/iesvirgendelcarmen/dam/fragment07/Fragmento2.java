package com.iesvirgendelcarmen.dam.fragment07;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by matinal on 19/10/17.
 */

public class Fragmento2 extends Fragment {
    @Override
    public void onStart() {
        super.onStart();
        Button btn2 = (Button) getActivity().findViewById(R.id.exportarTexto1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView texto = (TextView)getActivity().findViewById(R.id.texto4);
                texto.setText("TOCADO FRAG1");
            }
        });

        Button btn4 = (Button) getActivity().findViewById(R.id.exportarTexto2);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView texto = (TextView)getActivity().findViewById(R.id.texto2);
                texto.setText("TOCADO FRAG2");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
        return  inflater.inflate(R.layout.fragmento2,container,false);
    }

}
