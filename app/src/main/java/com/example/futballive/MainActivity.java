package com.example.futballive;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CardView liveScoresCard, liveStreamCard, leaguesCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        liveScoresCard= findViewById(R.id.liveScoresCard);
        liveStreamCard = findViewById(R.id.liveStreamCard);
        leaguesCard = findViewById(R.id.leaguesCard);
        liveScoresCard.setOnClickListener(this::onClick);
        liveStreamCard.setOnClickListener(this::onClick);
        leaguesCard.setOnClickListener(this::onClick);

    }
    
        public void onClick(View view) {
        switch (view.getId()) {
            case R.id.liveScoresCard:
                Toast.makeText(this, "First Button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.liveStreamCard:
                Toast.makeText(this, "Second Button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.leaguesCard:
                Toast.makeText(this, "CardView", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
