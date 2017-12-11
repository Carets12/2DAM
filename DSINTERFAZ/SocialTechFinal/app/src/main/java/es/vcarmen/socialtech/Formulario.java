package es.vcarmen.socialtech;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
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

public class Formulario extends Fragment implements SeekBar.OnSeekBarChangeListener,Serializable {

    private String[] formacion = {"SMR","DAM","DAW","ASIR",
            "Ingeniería técnica informática", "Ingeniería Informática","Grado","Otros"};

    private String[] provincias = {"Jaén","Granada","Córdoba","Sevilla","Málaga","Almería","Cádiz","Huelva"};

    private Contacto contacto;
    private FireBaseRT bd = new FireBaseRT();

    public final static String CONTACTO = "CONTACTO";

    protected ArrayList<Contacto> contactos;
    protected MainActivity main;

    @BindView(R.id.anadir)Button anadir;
    @BindView(R.id.numeroContactos)TextView numeroContactos;
    @BindView(R.id.spinner)Spinner spinner;
    @BindView(R.id.seekBar)SeekBar sb;
    @BindView(R.id.opciones_sexo)RadioGroup rg;

    private int idSexo;
    private boolean sexo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.formulario, container, false);
        ButterKnife.bind(this,view);
        bd.conectarFirebaseContactos();
        contactos = main.getListaContactos();

        spinner.setAdapter(new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item,provincias));

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                (this.getActivity(), android.R.layout.simple_dropdown_item_1line,formacion);

        MultiAutoCompleteTextView multiTexto = (MultiAutoCompleteTextView)
               view.findViewById(R.id.TextoMultiAuto);

        multiTexto.setAdapter(adaptador);
        multiTexto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        sb.setMax(150);

        sb.setOnSeekBarChangeListener(this);

        //Añade la primera vez que iniciamos 0 ya que los contactos no están almacenados en
        //ninguna base de datos y por lo tanto al estar en memoria se borraran los contactos
        //siempre que iniciamos la aplicación tendremos 0 contactos.
        numeroContactos.setText(" "+contactos.size());

        if(savedInstanceState != null){
            contactos= (ArrayList<Contacto>) savedInstanceState.getSerializable(CONTACTO);
            numeroTotalContactos();
        }

        return view;
    }

    @OnClick(R.id.anadir)
    public void onClick(){
        crearContacto();
        numeroTotalContactos();

        Intent intent = new Intent(getActivity(), ListaContactos.class);
        startActivity(intent);
    }

    public ArrayList<Contacto> crearContacto(){
        comprobarSexo();

        String nombre = ((EditText)getActivity().findViewById(R.id.nombre)).getText().toString();
        String apellidos = ((EditText)getActivity().findViewById(R.id.apellidos)).getText().toString();
        String telefono = ((EditText)getActivity().findViewById(R.id.telefono)).getText().toString();
        String email = ((EditText)getActivity().findViewById(R.id.email)).getText().toString();
        String formacion = ((EditText)getActivity().findViewById(R.id.TextoMultiAuto)).getText().toString();
        String provincia = spinner.getSelectedItem().toString();

        int edad = sb.getProgress();

        contacto = new Contacto(nombre,apellidos,telefono,email,formacion,provincia,sexo,edad);
        contactos.add(contacto);

        bd.guardarContacto(contacto);
        return contactos;
    }

    public boolean comprobarSexo(){
        idSexo = rg.getCheckedRadioButtonId();

        if (idSexo%2 == 1){
            sexo = false;
            //Sexo masculino

        }else {
            sexo = true;
            //Sexo femenino
        }

        return sexo;
    }

    //Método que cuenta los Contactos en tenemos en la Agenda
    public void numeroTotalContactos(){
        int numero = contactos.size();
        numeroContactos.setText(" "+numero);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progreso, boolean desdeUsuario) {
        TextView textView = (TextView)getActivity().findViewById(R.id.textViewSeekBar);
        textView.setText(progreso + 0 + "");

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(CONTACTO,contactos);
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

}
