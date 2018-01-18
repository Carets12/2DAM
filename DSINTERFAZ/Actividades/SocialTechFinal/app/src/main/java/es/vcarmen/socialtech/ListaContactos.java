package es.vcarmen.socialtech;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.vcarmen.socialtech.Firebase.FireBaseRT;


/**
 * Created by Daniel Sierra Ráez
 */

//Clase que gestiona el layout ListVIEW
public class ListaContactos extends FragmentActivity{

    AdaptadorContacto adaptador;

    public final static String LISTA = "LISTA";
    @BindView(R.id.listaContactos)ListView listaVista;
    Button borrarLista;
    protected ArrayList<Contacto> contactos;
    protected ArrayList<String> keys;
    protected MainActivity main = new MainActivity();
    private FireBaseRT bd = new FireBaseRT();

    protected Contacto contacto;
    protected String nombre, apellidos, telefono, email, formacion, provincia, edad, key;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_contactos);
        ButterKnife.bind(this);

        bd.conectarFirebaseContactos();
        Log.v("ARRAYTEST00",bd.getListaContactos().toString());
        contactos = main.getListaContactos();
        Log.v("CONTACTOSFIRE03",contactos.toString());

        adaptador = new AdaptadorContacto(this, contactos);
        listaVista.setAdapter(adaptador);

        borrarLista = findViewById(R.id.borrarLista);

        listaVista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> customerAdapter, View footer, int selectedInt, long selectedLong) {
                contacto = (Contacto) listaVista.getItemAtPosition(selectedInt);

                    nombre = contacto.getNombre();
                    apellidos = contacto.getApellidos();
                    telefono = contacto.getTelefono();
                    email = contacto.getEmail();
                    formacion = contacto.getFormacion();
                    provincia = contacto.getProvincia();
                    edad = contacto.getEdad()+"";

                anadirDetalles();
                Log.v("LISTAVISTA1",contactos.toString() );

            }
        });

        listaVista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            int posicion;
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dialogoBorrarContacto = new AlertDialog.Builder(ListaContactos.this);
                dialogoBorrarContacto.setTitle("BORRAR CONTACTO");
                dialogoBorrarContacto.setMessage("¿Estas seguro de borrar este contacto?");
                dialogoBorrarContacto.setCancelable(false);
                posicion = i;
                dialogoBorrarContacto.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        keys = bd.getKeys();
                        Log.e("EE", keys.toString());
                        key = keys.get(posicion).toString();
                        bd.borrarContacto(key);
                        Toast.makeText(getBaseContext(), "CONTACTO BORRADO", Toast.LENGTH_LONG).show();

                        AlertDialog.Builder dialogoContacto = new AlertDialog.Builder(ListaContactos.this);
                        dialogoContacto.setTitle("¿DONDE QUIERE IR?");
                        dialogoContacto.setCancelable(false);

                        dialogoContacto.setPositiveButton("Pantalla Principal",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        });

                        dialogoContacto.setNegativeButton("Lista Contactos", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getBaseContext(), ListaContactos.class);
                                startActivity(intent);
                            }
                        });

                        dialogoContacto.show();

                    }
                });

                dialogoBorrarContacto.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        Toast.makeText(getBaseContext(), "CANCELADO", Toast.LENGTH_LONG).show();

                        AlertDialog.Builder dialogoContacto = new AlertDialog.Builder(ListaContactos.this);
                        dialogoContacto.setTitle("¿DONDE QUIERE IR?");
                        dialogoContacto.setCancelable(false);

                        dialogoContacto.setPositiveButton("Pantalla Principal",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        });

                        dialogoContacto.setNegativeButton("Lista Contactos", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getBaseContext(), ListaContactos.class);
                                startActivity(intent);
                            }
                        });

                        dialogoContacto.show();
                    }
                });
                dialogoBorrarContacto.show();
                return false;
            }
        });

        if(savedInstanceState != null){
            contactos = (ArrayList<Contacto>) savedInstanceState.getSerializable(LISTA);
        }

        borrarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               for (int i = 0; i < contactos.size() ;i++){
                   keys = bd.getKeys();
                   key = keys.get(i);
                   bd.borrarContacto(key);
               }
                Toast.makeText(getBaseContext(), "CONTACTOS BORRADOS", Toast.LENGTH_LONG).show();

                AlertDialog.Builder dialogoContacto = new AlertDialog.Builder(ListaContactos.this);
                dialogoContacto.setTitle("¿DONDE QUIERE IR?");
                dialogoContacto.setCancelable(false);

                dialogoContacto.setPositiveButton("Pantalla Principal",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });

                dialogoContacto.setNegativeButton("Lista Contactos", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getBaseContext(), ListaContactos.class);
                        startActivity(intent);
                    }
                });

                dialogoContacto.show();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(LISTA, contactos);
    }

    public void anadirDetalles(){
        setContentView(R.layout.detalles_contacto);

        TextView nombreD = findViewById(R.id.nD);
        TextView telefonoD = findViewById(R.id.tD);
        TextView emailD = findViewById(R.id.eD);
        TextView formacionD = findViewById(R.id.fD);
        TextView provinciaD = findViewById(R.id.pD);
        TextView sexoD = findViewById(R.id.sD);
        TextView edadD = findViewById(R.id.eDD);

        if (contacto.getSexo() == true){
            sexoD.setText("Masculino");
        }else sexoD.setText("Femenino");

        nombreD.setText(nombre+" "+ apellidos);
        telefonoD.setText(telefono);
        emailD.setText(email);
        formacionD.setText(formacion);
        provinciaD.setText(provincia);
        edadD.setText(edad);
    }

}
