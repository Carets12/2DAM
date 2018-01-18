package es.vcarmen.tabs04;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
    }
}

    class MyAdapter extends FragmentStatePagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        if (i == 0) {
            fragment = new Fragmento1();
        }
        if (i == 1) {
            fragment = new Fragmento2();
        }
        if (i == 2) {
            fragment = new Fragmento3();
        }
        return fragment;
    }

        @Override
        public int getCount() {
            return 3;
        }

    public CharSequence getPageTitle(int position){
        if(position==0)
        {
            return "Tab 1";
        }
        if(position==1)
        {
            return "Tab 2";
        }
        if(position==2)
        {
            return "Tab 3";
        }
        return null;
    }

}
