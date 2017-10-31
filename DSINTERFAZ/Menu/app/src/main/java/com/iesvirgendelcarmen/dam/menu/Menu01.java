package com.iesvirgendelcarmen.dam.menu;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Toast;


    public class Menu01 extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu01);
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu01, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            String mensaje = "";

            switch (item.getItemId()) {

                case R.id.MnuOpc1:
                    mensaje = "¡¡¡Opción A Pulsada!!!";
                    Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.MnuOpc2:
                    mensaje = "¡¡¡Opción B Pulsada!!!";
                    Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.MnuOpc3:
                    mensaje = "¡¡¡Opción C Pulsada!!!";
                    Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }
        }
    }
