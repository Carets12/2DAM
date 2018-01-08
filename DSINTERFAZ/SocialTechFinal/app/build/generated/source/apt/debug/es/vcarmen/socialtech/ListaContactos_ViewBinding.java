// Generated code from Butter Knife. Do not modify!
package es.vcarmen.socialtech;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListaContactos_ViewBinding implements Unbinder {
  private ListaContactos target;

  @UiThread
  public ListaContactos_ViewBinding(ListaContactos target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ListaContactos_ViewBinding(ListaContactos target, View source) {
    this.target = target;

    target.listaVista = Utils.findRequiredViewAsType(source, R.id.listaContactos, "field 'listaVista'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListaContactos target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listaVista = null;
  }
}
