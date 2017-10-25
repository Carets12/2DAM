package es.vcarmen.fragment08;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;

/**
 * Created by danic on 24/10/2017.
 */

public class Cabecera extends ListFragment {

    CabeceraListener mCallback;

    @Override
    public void onAttach(Context context) {
            mCallback = (CabeceraListener) context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, Elementos.Cabeceras));


        return super.onCreateView(inflater, container, savedInstanceState);

    }
    public interface CabeceraListener{

        public void tocado(int position);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mCallback.tocado(position);
        super.onListItemClick(l, v, position, id);
    }
}
