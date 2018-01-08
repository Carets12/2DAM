// Generated code from Butter Knife. Do not modify!
package com.iesvirgendelcarmen.noticiasdeportes.Noticias;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iesvirgendelcarmen.noticiasdeportes.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NoticiasActivity_ViewBinding implements Unbinder {
  private NoticiasActivity target;

  @UiThread
  public NoticiasActivity_ViewBinding(NoticiasActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NoticiasActivity_ViewBinding(NoticiasActivity target, View source) {
    this.target = target;

    target.listViewNoticias = Utils.findRequiredViewAsType(source, R.id.noticias, "field 'listViewNoticias'", ListView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NoticiasActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listViewNoticias = null;
    target.toolbar = null;
  }
}
