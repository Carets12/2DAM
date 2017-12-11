package es.vcarmen.socialtech;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.vcarmen.socialtech.Firebase.FireBaseRT;


/**
 * Created by Daniel Sierra Ráez
 */

public class FormularioEmpresa extends Fragment implements Serializable {

    private String[] provincias = {"Jaén","Granada","Córdoba","Sevilla","Málaga","Almería","Cádiz","Huelva"};

    private Empresa empresa;

    public final static String EMPRESA = "EMPRESA";

    protected ArrayList<Empresa> empresas;
    protected MainActivity main;
    private FireBaseRT bd = new FireBaseRT();

    @BindView(R.id.anadirEmpresa)Button anadir;
    @BindView(R.id.spinnerProvinciaEmpresa)Spinner spinner;
    @BindView(R.id.numeroEmpresas)TextView numeroEmpresas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.formulario_empresa, container, false);
        ButterKnife.bind(this,view);
        bd.conectarFirebaseEmpresas();
        empresas = main.getListaEmpesas();

        spinner.setAdapter(new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item,provincias));

        //Añade la primera vez que iniciamos 0 ya que los contactos no están almacenados en
        //ninguna base de datos y por lo tanto al estar en memoria se borraran los contactos
        //siempre que iniciamos la aplicación tendremos 0 contactos.

        numeroEmpresas.setText(" "+empresas.size());

        if(savedInstanceState != null){
            empresas = (ArrayList<Empresa>) savedInstanceState.getSerializable(EMPRESA);
            numeroTotalEmpresas();
        }

        return view;
    }

    @OnClick(R.id.anadirEmpresa)
    public void onClick(){
        crearEmpresa();
        numeroTotalEmpresas();

        Intent intent = new Intent(getActivity(), ListaEmpresas.class);
        startActivity(intent);
    }

    public void numeroTotalEmpresas(){
        int numero = empresas.size();
        numeroEmpresas.setText(" "+numero);

    }

    public ArrayList<Empresa> crearEmpresa(){

        String nombre = ((EditText)getActivity().findViewById(R.id.nombreEmpresa)).getText().toString();
        String direccion = ((EditText)getActivity().findViewById(R.id.direccionEmpresa)).getText().toString();
        String localidad = ((EditText)getActivity().findViewById(R.id.localidadEmpresa)).getText().toString();
        String provincia = spinner.getSelectedItem().toString();
        String telefono =((EditText)getActivity().findViewById(R.id.telefonoEmpresa)).getText().toString();
        String email = ((EditText)getActivity().findViewById(R.id.emailEmpresa)).getText().toString();
        String observaciones = ((EditText)getActivity().findViewById(R.id.observacionesEmpresa)).getText().toString();
        String contactoAsociado = ((EditText)getActivity().findViewById(R.id.editContactoEmpresa)).getText().toString();

        empresa = new Empresa(nombre,direccion,localidad,provincia,telefono,email,observaciones,contactoAsociado);
        empresas.add(empresa);

        Log.v("EMPRESAS",empresas.toString());
        bd.guardarEmpresa(empresa);
        return empresas;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(EMPRESA, empresas);
    }

}
