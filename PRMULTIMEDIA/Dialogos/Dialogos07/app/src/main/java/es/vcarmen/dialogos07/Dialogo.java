package es.vcarmen.dialogos07;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import android.text.format.DateFormat;
import android.support.v4.app.DialogFragment;
import java.util.Calendar;

/**
 * Created by matinal on 11/01/18.
 */

public class Dialogo extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return  dialogo();
    }

    public TimePickerDialog dialogo(){

        final Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int minutos = c.get(Calendar.MINUTE);

        return new TimePickerDialog(
                getActivity(),(TimePickerDialog.OnTimeSetListener) getActivity(), hora, minutos, DateFormat.is24HourFormat(getActivity()));

    }
}
