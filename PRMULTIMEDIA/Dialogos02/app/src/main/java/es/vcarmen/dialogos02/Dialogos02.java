package es.vcarmen.dialogos02;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Dialogos02 extends AppCompatActivity {
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos02);

        boton = findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            showDialog(0);
            }
        });

    }

    protected Dialog onCreateDialog(int id){
        Dialog dialog = new Dialog(this);
        Window w = dialog.getWindow();
        int flag = WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
        w.setFlags(flag,flag);
        dialog.setTitle("DIÁLOGO PERSONAL");
        dialog.setContentView(R.layout.dialogo);
        boton.setOnClickListener(new Dialogos02.Aceptar);
        return dialog;
    }

    class Aceptar implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            EditText editText1 = findViewById(R.id.EditText1);
            EditText editText2 = findViewById(R.id.EditText2);
            String username = editText1.getText().toString().trim();
            String password = editText2.getText().toString().trim();

            if(username.matches("Leonardo") && password.matches("Davinci")){

                dismissDialog(id);

            }else {
                tvd.setText("Datos Incorrectos");
            }
        }
    }
}
