package com.example.pam_android.flicks;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.pam_android.flicks.Adapters.MovieAdapter;
import com.example.pam_android.flicks.Models.Movie;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseActivity {
    MovieAdapter movieAdapter;
    ArrayList<Movie> movies;
    Handler mHandler;
    @BindView(R.id.swipeContainer) SwipeRefreshLayout swipeContainer;
    @BindView(R.id.lvMovies) ListView lvMovies;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        ButterKnife.bind(this);
        movies = new ArrayList<>();
        movieAdapter = new MovieAdapter(this,movies);
        lvMovies.setAdapter(movieAdapter);
        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = movies.get(position);
                Intent goToDetails = new Intent(MainActivity.this,MovieDetailsActivity.class);
                goToDetails.putExtra("overview",movie.getOverview());
                goToDetails.putExtra("popularity",movie.getPopularity());
                goToDetails.putExtra("rate",movie.getVoteAverage());
                startActivity(goToDetails);
            }
        });

        url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
        //getMoviesFromApiAsync(url);
        getMovieFromApiOkHttp(url);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //getMoviesFromApiAsync(url);
                getMovieFromApiOkHttp(url);
            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


    }



    public void getMoviesFromApiAsync(String url){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    movies = Movie.fromJSONArray(response.getJSONArray("results"));
                    movieAdapter.clear();
                    movieAdapter.addAll(movies);
                    movieAdapter.notifyDataSetChanged();
                    swipeContainer.setRefreshing(false);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

    public void getMovieFromApiOkHttp(String url){
        mHandler = new Handler(Looper.getMainLooper());
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                try {
                    String responseData = response.body().string();
                    JSONObject json = new JSONObject(responseData);
                    JSONArray jsonArray = json.getJSONArray("results");
                    movies = Movie.fromJSONArray(jsonArray);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            movieAdapter.clear();
                            movieAdapter.addAll(movies);
                            movieAdapter.notifyDataSetChanged();
                            swipeContainer.setRefreshing(false);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
