package es.vcarmen.material07;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Material07 extends AppCompatActivity {

    private  final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material07);

        //final TabLayout tabLayout;
        // tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        TabLayout.Tab primerTab = tabLayout.newTab();
        primerTab.setText("PRIMERO");
        primerTab.setIcon(R.drawable.emoticon);
        tabLayout.addTab(primerTab);

        TabLayout.Tab segundoTab = tabLayout.newTab();
        segundoTab.setText("SEGUNDO");
        segundoTab.setIcon(R.drawable.ic_cliente);
        tabLayout.addTab(primerTab);

        TabLayout.Tab terceroTab = tabLayout.newTab();
        terceroTab.setText("TERCERO");
        terceroTab.setIcon(R.drawable.ic_correo);
        tabLayout.addTab(primerTab);

    }
}
