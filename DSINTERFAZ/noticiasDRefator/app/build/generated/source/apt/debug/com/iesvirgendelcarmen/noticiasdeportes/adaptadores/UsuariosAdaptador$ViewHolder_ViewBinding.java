// Generated code from Butter Knife. Do not modify!
package com.iesvirgendelcarmen.noticiasdeportes.adaptadores;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iesvirgendelcarmen.noticiasdeportes.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UsuariosAdaptador$ViewHolder_ViewBinding implements Unbinder {
  private UsuariosAdaptador.ViewHolder target;

  @UiThread
  public UsuariosAdaptador$ViewHolder_ViewBinding(UsuariosAdaptador.ViewHolder target,
      View source) {
    this.target = target;

    target.id = Utils.findRequiredViewAsType(source, R.id.id, "field 'id'", TextView.class);
    target.first_name = Utils.findRequiredViewAsType(source, R.id.first_name, "field 'first_name'", TextView.class);
    target.last_name = Utils.findRequiredViewAsType(source, R.id.last_name, "field 'last_name'", TextView.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.email, "field 'email'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UsuariosAdaptador.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.id = null;
    target.first_name = null;
    target.last_name = null;
    target.email = null;
  }
}
