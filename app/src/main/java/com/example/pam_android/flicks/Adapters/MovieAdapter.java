package com.example.pam_android.flicks.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pam_android.flicks.Models.Movie;
import com.example.pam_android.flicks.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

/**
 * Created by PAM-Android on 10/5/2016.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {

    static class ViewHolder {
        @BindView(R.id.ivPoster) ImageView poster;
        @BindView(R.id.tvTitle) TextView title;
        @BindView(R.id.tvOverview) TextView overfiew;
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.item_movie,movies);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if(getContext().getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE){
            Picasso.with(getContext()).load(movie.getBackdropPath()).fit().centerCrop()
                    .placeholder(R.drawable.no_movie_780x439).into(viewHolder.poster);
        } else {
            Picasso.with(getContext()).load(movie.getPoster())
                    .placeholder(R.drawable.no_movie_342x513).into(viewHolder.poster);
        }
        viewHolder.title.setText(movie.getTitle());
        viewHolder.overfiew.setText(movie.getOverview());
        return convertView;
    }
}
