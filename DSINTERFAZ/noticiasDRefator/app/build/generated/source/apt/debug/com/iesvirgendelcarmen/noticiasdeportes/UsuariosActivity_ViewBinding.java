// Generated code from Butter Knife. Do not modify!
package com.iesvirgendelcarmen.noticiasdeportes;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UsuariosActivity_ViewBinding implements Unbinder {
  private UsuariosActivity target;

  @UiThread
  public UsuariosActivity_ViewBinding(UsuariosActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UsuariosActivity_ViewBinding(UsuariosActivity target, View source) {
    this.target = target;

    target.listViewUsuarios = Utils.findRequiredViewAsType(source, R.id.listaUsuarios, "field 'listViewUsuarios'", ListView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UsuariosActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listViewUsuarios = null;
    target.toolbar = null;
  }
}
