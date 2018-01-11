package es.vcarmen.dialogos08;

import android.app.DatePickerDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class Dialogos08 extends FragmentActivity implements DatePickerDialog.OnDateSetListener {

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos08);

        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialogo fragment = new Dialogo();
                fragment.show(fragmentManager,"PERSONALIZADO");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

        Toast.makeText(this,"FECHA ELEGIDA " + day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();

    }
}
