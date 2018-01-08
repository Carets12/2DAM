// Generated code from Butter Knife. Do not modify!
package es.vcarmen.chatapp;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131427422;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.historial = Utils.findRequiredViewAsType(source, R.id.historial, "field 'historial'", TextView.class);
    view = Utils.findRequiredView(source, R.id.enviar, "field 'enviar' and method 'enviarMensaje'");
    target.enviar = Utils.castView(view, R.id.enviar, "field 'enviar'", Button.class);
    view2131427422 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.enviarMensaje();
      }
    });
    target.entrada = Utils.findRequiredViewAsType(source, R.id.entrada, "field 'entrada'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.historial = null;
    target.enviar = null;
    target.entrada = null;

    view2131427422.setOnClickListener(null);
    view2131427422 = null;
  }
}
