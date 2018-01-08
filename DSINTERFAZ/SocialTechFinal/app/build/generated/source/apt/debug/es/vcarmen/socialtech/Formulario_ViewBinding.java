// Generated code from Butter Knife. Do not modify!
package es.vcarmen.socialtech;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Formulario_ViewBinding implements Unbinder {
  private Formulario target;

  private View view2131558598;

  @UiThread
  public Formulario_ViewBinding(final Formulario target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.anadir, "field 'anadir' and method 'onClick'");
    target.anadir = Utils.castView(view, R.id.anadir, "field 'anadir'", Button.class);
    view2131558598 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    target.numeroContactos = Utils.findRequiredViewAsType(source, R.id.numeroContactos, "field 'numeroContactos'", TextView.class);
    target.spinner = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'spinner'", Spinner.class);
    target.sb = Utils.findRequiredViewAsType(source, R.id.seekBar, "field 'sb'", SeekBar.class);
    target.rg = Utils.findRequiredViewAsType(source, R.id.opciones_sexo, "field 'rg'", RadioGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Formulario target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.anadir = null;
    target.numeroContactos = null;
    target.spinner = null;
    target.sb = null;
    target.rg = null;

    view2131558598.setOnClickListener(null);
    view2131558598 = null;
  }
}
