package es.vcarmen.material07;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Material07 extends AppCompatActivity {

    private TabLayout tabLayout;
    private FragmentManager fm;
    private FragmentTransaction ft;
    ViewPager paginador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material07);

        paginador = (ViewPager) findViewById(R.id.contenedor2);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        final TabLayout.Tab primerTab = tabLayout.newTab();
        primerTab.setText("PRIMERO");
        primerTab.setIcon(R.drawable.emoticon);
        tabLayout.addTab(primerTab);

        final TabLayout.Tab segundoTab = tabLayout.newTab();
        segundoTab.setText("SEGUNDO");
        segundoTab.setIcon(R.drawable.ic_cliente);
        tabLayout.addTab(segundoTab);

        final TabLayout.Tab terceroTab = tabLayout.newTab();
        terceroTab.setText("TERCERO");
        terceroTab.setIcon(R.drawable.ic_correo);
        tabLayout.addTab(terceroTab);

        Adaptador adaptador = new Adaptador(getSupportFragmentManager(), tabLayout.getTabCount());
        paginador.setAdapter(adaptador);
        paginador.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;

                switch (tab.getPosition()){
                    case 0:
                        fragment = new Primero();
                        break;

                    case 1:
                        fragment = new Segundo();
                        break;

                    case 2:
                        fragment = new Tercero();
                        break;
                }

                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.add(R.id.contenedor, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.replace(R.id.contenedor, fragment);
                ft.commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
