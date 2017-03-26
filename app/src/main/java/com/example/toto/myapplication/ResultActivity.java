package com.example.toto.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

public class ResultActivity extends AppCompatActivity implements OnVideoSelectedListener{

    private static final String URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE);

        getVideos(message);
    }

    private void getVideos(String request) {
        Constant c= new Constant();
        StringRequest videosRequest = new StringRequest(URL +"&q="+ request + "&key=" + c.getApiKey(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Result r = new Gson().fromJson(response, Result.class);
                List <Result.ItemsBean> beans = r.getItems();
                Videos liste= new Videos();
                for(int i =0; i<beans.size(); i++)
                {
                    Video v = new Video(
                            beans.get(i).getSnippet().getTitle(),
                            beans.get(i).getSnippet().getPublishedAt(),
                            beans.get(i).getSnippet().getChannelId(),
                            beans.get(i).getSnippet().getChannelTitle(),
                            beans.get(i).getSnippet().getDescription(),
                            beans.get(i).getSnippet().getLiveBroadcastContent(),
                            beans.get(i).getSnippet().getThumbnails().getHigh().getUrl()
                    );
                    liste.add(v);
                }
                setAdapter(liste);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Videos", "Error");
            }
        });

        Volley.newRequestQueue(this).add(videosRequest);
    }

    private void setAdapter(Videos videos) {
        VideosAdapter adapter = new VideosAdapter(videos);
        adapter.setOnVideoSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }

    public void onVideoSelected(Video video) {
        //VideoActivity.start(this, video.getName()); à faire
    }
}
