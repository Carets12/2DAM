package danielymiguel.tiendamvp.menu;

import android.view.MenuItem;

/**
 * Created by matinal on 01/02/2018.
 */

public interface MenuInterface {
    interface Presenter {
        boolean onNavigationItemSelected(MenuItem item);
        boolean onOptionsItemSelected(MenuItem item);
        boolean onCreateOptionsMenu(MenuPresenter menu);
        void onBackPressed();
    }

    interface View {

    }

}
