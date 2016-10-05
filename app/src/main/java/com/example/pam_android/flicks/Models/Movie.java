package com.example.pam_android.flicks.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by PAM-Android on 10/5/2016.
 */

public class Movie {
    private String poster;
    private String backdropPath;
    private String title;
    private String overview;

    public Movie(JSONObject jsonObject) throws JSONException{
        this.poster = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.backdropPath = jsonObject.getString("backdrop_path");
    }

    public String getPoster() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", poster);
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w780/%s", backdropPath);
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray jsonArray){
        ArrayList<Movie> results = new ArrayList<>();
        for(int i=0;i<jsonArray.length();i++){
            try {
                Movie movie = new Movie(jsonArray.getJSONObject(i));
                results.add(movie);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }


}
