package com.example.moviedetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClickListener {
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_CREATOR = "creatorName";
    public static final String EXTRA_LIKES = "likeCount";
    public static final String EXTRA_COMMENTS = "comments";

    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private ArrayList<MovieDetails> mMovieDetails;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mMovieDetails = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();


    }

    private void parseJSON() {

        String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=movie&image_type=photo&pretty=true";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);


                                String creatorName = hit.getString("user");
                                String imageUrl = hit.getString("webformatURL");
                                int likeCount = hit.getInt("likes");
                                String comments = hit.getString("comments");
                                mMovieDetails.add(new MovieDetails(imageUrl, creatorName, likeCount, comments));
                            }
                            mAdapter = new Adapter(MainActivity.this,mMovieDetails);
                            mRecyclerView.setAdapter(mAdapter);
                            mAdapter.setOnItemClickListener(MainActivity.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }


    @Override
    public void onItemClick(int position) {
        Intent activity_2Intent = new Intent(this, Activity2.class);
        MovieDetails clickedItem = mMovieDetails.get(position);

        activity_2Intent.putExtra(EXTRA_URL, clickedItem.getImageUrl());
        activity_2Intent.putExtra(EXTRA_CREATOR, clickedItem.getCreator());
        activity_2Intent.putExtra(EXTRA_LIKES, clickedItem.getLikeCount());
        activity_2Intent.putExtra(EXTRA_COMMENTS, clickedItem.getComments());

        startActivity(activity_2Intent);

    }
}
