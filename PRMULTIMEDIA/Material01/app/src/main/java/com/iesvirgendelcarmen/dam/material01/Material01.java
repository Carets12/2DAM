package com.iesvirgendelcarmen.dam.material01;



import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import java.util.regex.Pattern;

public class Material01 extends AppCompatActivity {

    private TextInputLayout controlNombre;
    private EditText campoNombre;
    private Button aceptar;

    private TextInputLayout controlTelefono;
    private EditText campoTelefono;

    private TextInputLayout controlCorreo;
    private EditText campoCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material01);

        controlTelefono = (TextInputLayout) findViewById(R.id.control_telefono);
        campoTelefono = (EditText) findViewById(R.id.campo_telefono);

        controlNombre = (TextInputLayout) findViewById(R.id.control_nombre);
        campoNombre = (EditText) findViewById(R.id.campo_nombre);
        aceptar = (Button) findViewById(R.id.boton_aceptar);

        controlCorreo = (TextInputLayout) findViewById(R.id.control_correo);
        campoCorreo = (EditText) findViewById(R.id.campo_correo);

        campoNombre.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                controlNombre.setError(null);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        aceptar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                validarDatos();
            }
        });

        campoCorreo.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                controlCorreo.setError(null);
               // esCorreoValido(String.valueOf(null));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        campoTelefono.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                controlTelefono.setError(null);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private boolean esNombreValido(String nombre){
        Pattern patron = Pattern.compile("^[a-zA-Z]+$");

        if(!patron.matcher(nombre).matches() || nombre.length() > 30){
            controlNombre.setError("ERROR EN NOMBRE");
            return false;
        }else {
            controlNombre.setError(null);
        }
        return true;
    }

    private boolean esCorreoValido(String correo){
        if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            controlCorreo.setError("ERROR EN CORREO");
            return false;
        }else {
            controlCorreo.setError(null);
        }
        return true;
    }

    private boolean esTelefonoValido(String telefono){
        if(!Patterns.PHONE.matcher(telefono).matches()){
            controlTelefono.setError("ERROR EN TELEFONO");
            return false;
        }else {
            controlTelefono.setError(null);
        }
        return true;
    }

    private void validarDatos(){
        String nombre = controlNombre.getEditText().getText().toString();
        boolean a = esNombreValido(nombre);
        String correo = controlCorreo.getEditText().getText().toString();
        boolean b = esCorreoValido(correo);
        String telefono = controlTelefono.getEditText().getText().toString();
        boolean c = esTelefonoValido(telefono);

        if (a&&b&&c) {
            Toast.makeText(this,"REGISTRO CORRECTO", Toast.LENGTH_LONG).show();
        }

    }

}
