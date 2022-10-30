package com.example.futballive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LivescoresActivity extends AppCompatActivity {

    ListView matchesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livescores);

        matchesList = findViewById(R.id.matches);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apiv2.allsportsapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MatchesEndpoint matchesEndpoint = retrofit.create(MatchesEndpoint.class);

        Call<List<Match>> call = matchesEndpoint.getMatches();

        call.enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                if(!response.isSuccessful()) {
                    Toast.makeText(LivescoresActivity.this, "error", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Match> matches = response.body();
                System.out.println(matches);
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {
                Toast.makeText(LivescoresActivity.this, "error again", Toast.LENGTH_SHORT).show();
            }
        });

    }
}