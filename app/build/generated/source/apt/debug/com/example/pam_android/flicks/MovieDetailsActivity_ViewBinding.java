// Generated code from Butter Knife. Do not modify!
package com.example.pam_android.flicks;

import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MovieDetailsActivity_ViewBinding<T extends MovieDetailsActivity> implements Unbinder {
  protected T target;

  public MovieDetailsActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.tvDetailOverview = finder.findRequiredViewAsType(source, R.id.tvDetailOverview, "field 'tvDetailOverview'", TextView.class);
    target.rbAveragePopularity = finder.findRequiredViewAsType(source, R.id.rbAveragePopularity, "field 'rbAveragePopularity'", RatingBar.class);
    target.tvDetailPopularity = finder.findRequiredViewAsType(source, R.id.tvDetailPopularity, "field 'tvDetailPopularity'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvDetailOverview = null;
    target.rbAveragePopularity = null;
    target.tvDetailPopularity = null;

    this.target = null;
  }
}
