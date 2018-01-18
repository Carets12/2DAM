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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.vcarmen.socialtech.Firebase.FireBaseRT;

/**
 * Created by Daniel Sierra Ráez
 */

public class ListaEmpresas extends FragmentActivity {

    AdaptadorEmpresa adaptadorE;

    public final static String LISTAE = "LISTAE";
    @BindView(R.id.listaEmpresas)ListView listaVista;
    Button borrarListaEmpresas;
    protected ArrayList<Empresa> empresas;
    protected ArrayList<String> keysE;
    private FireBaseRT bd = new FireBaseRT();
    protected MainActivity main;

    private Empresa empresa;
    protected String nombre, direccion, telefono, email, observaciones, contacto, localidad, provincia, keyE;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_empresas);
        ButterKnife.bind(this);
        bd.conectarFirebaseEmpresas();
        empresas = main.getListaEmpesas();
        keysE = bd.getKeysE();

        adaptadorE = new AdaptadorEmpresa(this, empresas);
        listaVista.setAdapter(adaptadorE);

        borrarListaEmpresas = findViewById(R.id.borrarListaEmpresas);

        listaVista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> customerAdapter, View footer, int selectedInt, long selectedLong) {

                empresa = (Empresa) listaVista.getItemAtPosition(selectedInt);

                nombre = empresa.getNombre();
                direccion = empresa.getDireccion();
                localidad = empresa.getLocalidad();
                provincia = empresa.getProvincia();
                telefono = empresa.getTelefonoCorporativo();
                email = empresa.getEmailCorporativo();
                observaciones = empresa.getObservaciones();
                contacto = empresa.getContacto();

                anadirDetalles();
            }
        });

        listaVista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            int posicionE;
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dialogoBorrarEmpresa = new AlertDialog.Builder(ListaEmpresas.this);
                dialogoBorrarEmpresa.setTitle("BORRAR EMPRESA");
                dialogoBorrarEmpresa.setMessage("¿Estas seguro de borrar esta empresa?");
                dialogoBorrarEmpresa.setCancelable(false);
                posicionE = i;
                dialogoBorrarEmpresa.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        keysE = bd.getKeysE();
                        keyE = keysE.get(posicionE);
                        bd.borrarEmpresa(keyE);
                        Toast.makeText(getBaseContext(), "EMPRESA BORRADA", Toast.LENGTH_LONG).show();

                        AlertDialog.Builder dialogoEmpresa = new AlertDialog.Builder(ListaEmpresas.this);
                        dialogoEmpresa.setTitle("¿DONDE QUIERE IR?");
                        dialogoEmpresa.setCancelable(false);

                        dialogoEmpresa.setPositiveButton("Pantalla Principal",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        });

                        dialogoEmpresa.setNegativeButton("Lista Empresas", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getBaseContext(), ListaEmpresas.class);
                                startActivity(intent);
                            }
                        });

                        dialogoEmpresa.show();

                    }
                });

                dialogoBorrarEmpresa.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        Toast.makeText(getBaseContext(), "CANCELADO", Toast.LENGTH_LONG).show();

                        AlertDialog.Builder dialogoEmpresa = new AlertDialog.Builder(ListaEmpresas.this);
                        dialogoEmpresa.setTitle("¿DONDE QUIERE IR?");
                        dialogoEmpresa.setCancelable(false);

                        dialogoEmpresa.setPositiveButton("Pantalla Principal",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        });

                        dialogoEmpresa.setNegativeButton("Lista Empresas", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getBaseContext(), ListaEmpresas.class);
                                startActivity(intent);
                            }
                        });

                        dialogoEmpresa.show();
                    }
                });
                dialogoBorrarEmpresa.show();
                return false;
            }
        });

        if(savedInstanceState != null){
            empresas = (ArrayList<Empresa>) savedInstanceState.getSerializable(LISTAE);
        }
        Log.v("LISTAVISTA", empresas.toString());

        borrarListaEmpresas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < empresas.size() ;i++){
                    keysE = bd.getKeysE();
                    keyE = keysE.get(i);
                    bd.borrarEmpresa(keyE);
                }
                Toast.makeText(getBaseContext(), "EMPRESAS BORRADAS", Toast.LENGTH_LONG).show();
                AlertDialog.Builder dialogoEmpresa = new AlertDialog.Builder(ListaEmpresas.this);
                dialogoEmpresa.setTitle("¿DONDE QUIERE IR?");
                dialogoEmpresa.setCancelable(false);

                dialogoEmpresa.setPositiveButton("Pantalla Principal",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });

                dialogoEmpresa.setNegativeButton("Lista Empresas", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getBaseContext(), ListaEmpresas.class);
                        startActivity(intent);
                    }
                });

                dialogoEmpresa.show();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(LISTAE, empresas);
    }

    public void anadirDetalles(){
        setContentView(R.layout.detalles_empresa);

        TextView nombreDE = findViewById(R.id.nDE);
        TextView direccionDE = findViewById(R.id.dDE);
        TextView localidadDE = findViewById(R.id.lDE);
        TextView provinciaDE = findViewById(R.id.pDE);
        TextView telefonoDE = findViewById(R.id.tDE);
        TextView emailDE = findViewById(R.id.eDE);
        TextView observacionesDE = findViewById(R.id.oDE);
        TextView contactoDE = findViewById(R.id.cDE);

        nombreDE.setText(nombre);
        telefonoDE.setText(telefono);
        direccionDE.setText(direccion);
        localidadDE.setText(localidad);
        provinciaDE.setText(provincia);
        emailDE.setText(email);
        observacionesDE.setText(observaciones);
        contactoDE.setText(contacto);
    }
}
