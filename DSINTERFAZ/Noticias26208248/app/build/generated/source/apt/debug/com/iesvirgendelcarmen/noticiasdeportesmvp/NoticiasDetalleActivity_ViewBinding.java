// Generated code from Butter Knife. Do not modify!
package com.iesvirgendelcarmen.noticiasdeportesmvp;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.android.volley.toolbox.NetworkImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NoticiasDetalleActivity_ViewBinding implements Unbinder {
  private NoticiasDetalleActivity target;

  @UiThread
  public NoticiasDetalleActivity_ViewBinding(NoticiasDetalleActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NoticiasDetalleActivity_ViewBinding(NoticiasDetalleActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.titulo = Utils.findRequiredViewAsType(source, R.id.detalletitulo, "field 'titulo'", TextView.class);
    target.autor = Utils.findRequiredViewAsType(source, R.id.detalleAutor, "field 'autor'", TextView.class);
    target.descripcion = Utils.findRequiredViewAsType(source, R.id.detalleDescripcion, "field 'descripcion'", TextView.class);
    target.fecha = Utils.findRequiredViewAsType(source, R.id.detalleFecha, "field 'fecha'", TextView.class);
    target.imagen = Utils.findRequiredViewAsType(source, R.id.detalleImagen, "field 'imagen'", NetworkImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NoticiasDetalleActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.titulo = null;
    target.autor = null;
    target.descripcion = null;
    target.fecha = null;
    target.imagen = null;
  }
}
