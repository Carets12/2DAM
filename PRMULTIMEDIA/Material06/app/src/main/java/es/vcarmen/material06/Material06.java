package es.vcarmen.material06;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Material06 extends AppCompatActivity implements View.OnClickListener {

    TabLayout tabLayout;
    Button anadir, quitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material06);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        anadir = (Button) findViewById(R.id.anadirTab);
        quitar = (Button) findViewById(R.id.quitarTab);

        TabLayout.Tab primerTab = tabLayout.newTab();
        primerTab.setText("TAB 01");
        primerTab.setIcon(R.mipmap.ic_launcher);
        tabLayout.addTab(primerTab);

        TabLayout.Tab segundoTab = tabLayout.newTab();
        segundoTab.setText("TAB 02");
        segundoTab.setIcon(R.drawable.icono1);
        tabLayout.addTab(segundoTab);

        TabLayout.Tab tercerTab = tabLayout.newTab();
        tercerTab.setText("TAB 03");
        tercerTab.setIcon(R.drawable.ic_action_name);
        tabLayout.addTab(tercerTab,1,true);

        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        //tabLayout.setTabTextColors(Color.RED, Color.WHITE);
        tabLayout.setTabTextColors(Color.argb(255,50,50,50), Color.argb(255,0,200,200));
        //tabLayout.setTabTextColors(Color.rgb(50,50,50), Color.rgb(0,200,200));
        tabLayout.setSelectedTabIndicatorColor(Color.GREEN);
        tabLayout.setSelectedTabIndicatorHeight(12);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int elegida = tabLayout.getSelectedTabPosition();
                Toast.makeText(getBaseContext(),"HA TOCADO LA "+(elegida+1),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        anadir.setOnClickListener(this);
        quitar.setOnClickListener(this);
    }

    int numero;

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.anadirTab:
                if (tabLayout.getTabCount() < 6){
                    numero = tabLayout.getTabCount();
                    tabLayout.addTab(tabLayout.newTab().setText("TAB "+(numero+1)));
                }
                if(tabLayout.getTabCount() == 6){
                    Snackbar snackbar = Snackbar.make(view, "NO SE PUEDEN AÑADIR MAS TABS", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                break;

            case R.id.quitarTab:
                if(tabLayout.getTabCount() > 3){
                    tabLayout.removeTabAt(tabLayout.getSelectedTabPosition());
                        numero = tabLayout.getTabCount()-1;
                }

                if(tabLayout.getTabCount() == 3){
                    Snackbar snackbar = Snackbar.make(view, "NO SE PUEDEN BORRAR MAS TABS", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                break;
        }
    }
}

