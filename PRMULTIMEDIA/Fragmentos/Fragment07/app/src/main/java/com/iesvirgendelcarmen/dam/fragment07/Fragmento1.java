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

public class Fragmento1 extends Fragment {
    @Override
    public void onStart() {
        super.onStart();
        Button btn1 = (Button) getActivity().findViewById(R.id.importarTexto1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView lbl = (TextView)getActivity().findViewById(R.id.texto3);
                Toast.makeText(getActivity(),lbl.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        Button btn2 = (Button) getActivity().findViewById(R.id.importarTexto2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView lbl = (TextView)getActivity().findViewById(R.id.texto1);
                Toast.makeText(getActivity(),lbl.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
        return  inflater.inflate(R.layout.fragmento1,container,false);
    }

}
