package es.vcarmen.dialogos07;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class Dialogos07 extends FragmentActivity implements  TimePickerDialog.OnTimeSetListener {

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos07);
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
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

        Toast.makeText(this,"TIEMPO: " +  hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();

    }
}
