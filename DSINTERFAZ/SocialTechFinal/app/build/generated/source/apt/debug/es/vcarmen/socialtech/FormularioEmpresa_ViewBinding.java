// Generated code from Butter Knife. Do not modify!
package es.vcarmen.socialtech;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormularioEmpresa_ViewBinding implements Unbinder {
  private FormularioEmpresa target;

  private View view2131558608;

  @UiThread
  public FormularioEmpresa_ViewBinding(final FormularioEmpresa target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.anadirEmpresa, "field 'anadir' and method 'onClick'");
    target.anadir = Utils.castView(view, R.id.anadirEmpresa, "field 'anadir'", Button.class);
    view2131558608 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    target.spinner = Utils.findRequiredViewAsType(source, R.id.spinnerProvinciaEmpresa, "field 'spinner'", Spinner.class);
    target.numeroEmpresas = Utils.findRequiredViewAsType(source, R.id.numeroEmpresas, "field 'numeroEmpresas'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FormularioEmpresa target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.anadir = null;
    target.spinner = null;
    target.numeroEmpresas = null;

    view2131558608.setOnClickListener(null);
    view2131558608 = null;
  }
}
