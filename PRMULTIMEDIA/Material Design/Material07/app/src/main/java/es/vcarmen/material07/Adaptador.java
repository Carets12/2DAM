package es.vcarmen.material07;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by matinal on 23/11/17.
 */

public class Adaptador extends FragmentStatePagerAdapter {

    private int numTab;

    public Adaptador(FragmentManager fm, int numTab) {
        super(fm);
        this.numTab = numTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Primero primero = new Primero();
                return primero;

            case 1:
                Segundo segundo = new Segundo();
                return segundo;

            case 2:
                Tercero tercero = new Tercero();
                return tercero;
        }
        return null;
    }

    @Override
    public int getCount() {
        return numTab;
    }

}
