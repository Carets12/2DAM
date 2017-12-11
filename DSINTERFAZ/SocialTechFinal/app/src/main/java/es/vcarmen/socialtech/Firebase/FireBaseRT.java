package es.vcarmen.socialtech.Firebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

import es.vcarmen.socialtech.Contacto;
import es.vcarmen.socialtech.Empresa;


/**
 * Created by Daniel Sierra Ráez
 */

public class FireBaseRT extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    String key, keyE;
    ArrayList<String> keys = new ArrayList<String>();
    ArrayList<String> keysE = new ArrayList<String>();
    final ArrayList<Contacto> listaTodosContactos = new ArrayList<>();
    final ArrayList<Empresa> listaTodasEmpresas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        conectarFirebaseContactos();
        conectarFirebaseEmpresas();
    }

    public void conectarFirebaseContactos() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Contactos");

        cargarContactosBD();

    }

    public void conectarFirebaseEmpresas() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Empresas");

        cargarEmpresasBD();

    }

    public void borrarContacto(String key) {
        if (key != null)
            myRef.child(key).removeValue();
    }

    public void borrarEmpresa(String key) {
        if (key != null)
            myRef.child(key).removeValue();
    }

    //Función que nos carga un array de contactos obtenido de la base de datos
    public void cargarContactosBD() {
        final DatabaseReference contactosBD = FirebaseDatabase.getInstance().getReference().child("Contactos");
        contactosBD.keepSynced(true);
        contactosBD.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listaTodosContactos.clear();
                Iterator<DataSnapshot> dataSnapshots = dataSnapshot.getChildren().iterator();
                while (dataSnapshots.hasNext()) {
                    DataSnapshot dataSnapShotChild = dataSnapshots.next();
                    Contacto contacto = dataSnapShotChild.getValue(Contacto.class);
                    key = dataSnapShotChild.getKey();
                    keys.add(key);
                    listaTodosContactos.add(contacto);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    //Función que nos carga un array de empresas obtenida de la base de datos
    public void cargarEmpresasBD() {
        DatabaseReference allContacsBD = FirebaseDatabase.getInstance().getReference().child("Empresas");
        allContacsBD.keepSynced(true);
        allContacsBD.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listaTodasEmpresas.clear();
                Iterator<DataSnapshot> dataSnapshots = dataSnapshot.getChildren().iterator();
                while (dataSnapshots.hasNext()) {
                    DataSnapshot dataSnapShotChild = dataSnapshots.next();
                    Empresa empresa = dataSnapShotChild.getValue(Empresa.class);
                    keyE = dataSnapShotChild.getKey();
                    keysE.add(keyE);
                    listaTodasEmpresas.add(empresa);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public ArrayList<Contacto> getListaContactos() {
        return listaTodosContactos;
    }

    public ArrayList<Empresa> getListaEmpresas() {
        return listaTodasEmpresas;
    }

    public ArrayList<String> getKeys() {
        return keys;
    }

    public ArrayList<String> getKeysE() {
        return keysE;
    }

    public void guardarContacto(Contacto contacto) {
        myRef.push().setValue(contacto);
    }

    public void guardarEmpresa(Empresa empresa) {
        myRef.push().setValue(empresa);
    }
}

