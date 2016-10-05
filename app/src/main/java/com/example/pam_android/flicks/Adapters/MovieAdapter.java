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

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static com.example.pam_android.flicks.R.id.ivPoster;
import static com.example.pam_android.flicks.R.id.tvTitle;

/**
 * Created by PAM-Android on 10/5/2016.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        ImageView poster;
        TextView title;
        TextView overfiew;
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
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie,parent,false);
            viewHolder.poster = (ImageView) convertView.findViewById(ivPoster);
            viewHolder.title = (TextView) convertView.findViewById(tvTitle);
            viewHolder.overfiew = (TextView) convertView.findViewById(R.id.tvOverview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if(getContext().getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE){
            Picasso.with(getContext()).load(movie.getBackdropPath()).into(viewHolder.poster);
        } else {
            Picasso.with(getContext()).load(movie.getPoster()).into(viewHolder.poster);
        }

        viewHolder.title.setText(movie.getTitle());
        viewHolder.overfiew.setText(movie.getOverview());
        return convertView;
    }
}
