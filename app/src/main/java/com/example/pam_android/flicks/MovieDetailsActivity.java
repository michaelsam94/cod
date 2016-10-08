package com.example.pam_android.flicks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by michael on 10/8/16.
 */

public class MovieDetailsActivity extends BaseActivity {

    @BindView(R.id.tvDetailOverview)
    TextView tvDetailOverview;
    @BindView(R.id.rbAveragePopularity)
    RatingBar rbAveragePopularity;
    @BindView(R.id.tvDetailPopularity)
    TextView tvDetailPopularity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_details);
        ButterKnife.bind(this);
        Intent fromMain = getIntent();
        tvDetailOverview.setText(fromMain.getStringExtra("overview"));
        tvDetailPopularity.setText(String.valueOf(fromMain.getDoubleExtra("popularity",0)));
        rbAveragePopularity.setNumStars(5);
        rbAveragePopularity.setStepSize(0.1f);
        rbAveragePopularity.setRating((float)(fromMain.getDoubleExtra("rate",0)/2.0d));
        rbAveragePopularity.setIsIndicator(true);

    }
}
