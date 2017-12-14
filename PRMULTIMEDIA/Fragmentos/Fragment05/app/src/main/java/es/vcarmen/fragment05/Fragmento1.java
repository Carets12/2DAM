package es.vcarmen.fragment05;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by danic on 18/10/2017.
 */

public class Fragmento1 extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }
}
