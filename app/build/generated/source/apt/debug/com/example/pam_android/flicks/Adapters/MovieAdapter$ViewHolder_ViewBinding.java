// Generated code from Butter Knife. Do not modify!
package com.example.pam_android.flicks.Adapters;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.example.pam_android.flicks.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MovieAdapter$ViewHolder_ViewBinding<T extends MovieAdapter.ViewHolder> implements Unbinder {
  protected T target;

  public MovieAdapter$ViewHolder_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.poster = finder.findRequiredViewAsType(source, R.id.ivPoster, "field 'poster'", ImageView.class);
    target.title = finder.findRequiredViewAsType(source, R.id.tvTitle, "field 'title'", TextView.class);
    target.overfiew = finder.findRequiredViewAsType(source, R.id.tvOverview, "field 'overfiew'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.poster = null;
    target.title = null;
    target.overfiew = null;

    this.target = null;
  }
}
