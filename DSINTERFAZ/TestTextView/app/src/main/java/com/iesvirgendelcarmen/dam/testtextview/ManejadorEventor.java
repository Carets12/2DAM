package com.iesvirgendelcarmen.dam.testtextview;

import android.view.View;
import android.widget.Button;

/**
 * Created by matinal on 2/10/17.
 */

public class ManejadorEventor implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        btn.setText("Botón Pulsado");


    }

}
