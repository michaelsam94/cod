// Generated code from Butter Knife. Do not modify!
package com.example.pam_android.flicks;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  public MainActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.swipeContainer = finder.findRequiredViewAsType(source, R.id.swipeContainer, "field 'swipeContainer'", SwipeRefreshLayout.class);
    target.lvMovies = finder.findRequiredViewAsType(source, R.id.lvMovies, "field 'lvMovies'", ListView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.swipeContainer = null;
    target.lvMovies = null;

    this.target = null;
  }
}
