package com.iesvirgendelcarmen.dam.fragment03;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by matinal on 11/10/17.
 */

public class Fragmento1 extends ListFragment {

    private String[]artistas = {"Alberto Durero","Miguel Ángel", "Rafael Sanzio",
            "Tizia","Donatello","Paolo Uccello","Giotto","Peter Breughel",
            "F. Brunelleschi","Fra Argelico", "A. Mantegna","Lonardo","G. Bellini",
            "S. Botticelli","Cosimo Rosselli","Masaccio","Ghirlandaio","Giorgione",
            "Filippino Lippi","P.della Francesca","Rafaella Carra", "Gina Lollobrigida"
            ,"Ornella Muti","Gigliola Cinquetti"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento1, container, false);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line
        ,artistas));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(),"Ha pulsado " + artistas[position], Toast.LENGTH_SHORT).show();
    }
}
