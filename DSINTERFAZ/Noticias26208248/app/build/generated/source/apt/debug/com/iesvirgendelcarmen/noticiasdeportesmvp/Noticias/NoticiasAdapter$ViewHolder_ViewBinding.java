// Generated code from Butter Knife. Do not modify!
package com.iesvirgendelcarmen.noticiasdeportesmvp.Noticias;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.android.volley.toolbox.NetworkImageView;
import com.iesvirgendelcarmen.noticiasdeportesmvp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NoticiasAdapter$ViewHolder_ViewBinding implements Unbinder {
  private NoticiasAdapter.ViewHolder target;

  @UiThread
  public NoticiasAdapter$ViewHolder_ViewBinding(NoticiasAdapter.ViewHolder target, View source) {
    this.target = target;

    target.titulo = Utils.findRequiredViewAsType(source, R.id.titulo, "field 'titulo'", TextView.class);
    target.autor = Utils.findRequiredViewAsType(source, R.id.autor, "field 'autor'", TextView.class);
    target.fecha = Utils.findRequiredViewAsType(source, R.id.fecha, "field 'fecha'", TextView.class);
    target.imagen = Utils.findRequiredViewAsType(source, R.id.imagen, "field 'imagen'", NetworkImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NoticiasAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.titulo = null;
    target.autor = null;
    target.fecha = null;
    target.imagen = null;
  }
}
