package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {
    int isClicked;
    ImageButton playImageButton, backImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        String songName;
        String artistName;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                songName = null;
                artistName = null;
            } else {
                songName = extras.getString("Song Name");
                artistName = extras.getString("Artist Name");
            }
        } else {
            songName = (String) savedInstanceState.getSerializable("Song Name");
            artistName = (String) savedInstanceState.getSerializable("Song Artist Name");
        }
        TextView songNameView = findViewById(R.id.songName);
        songNameView.setText(songName);
        TextView artistNameView = findViewById(R.id.artistName);
        artistNameView.setText(artistName);
        playImageButton = findViewById(R.id.playButton);
        isClicked = 0;
        playImageButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                if (isClicked == 0){
                    playImageButton.setImageResource(R.drawable.pausebutton);
                    isClicked = 1;
                }
                else {
                    playImageButton.setImageResource(R.drawable.playbutton);
                    isClicked = 0;
                }
            }
        });

        backImageButton = findViewById(R.id.backButton);

        backImageButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(PlayerActivity.this, LibraryActivity.class);
                startActivity(backIntent);
            }
        });
    }
}
