package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);
        ArrayList<Song> songs = new ArrayList<Song>(10);
        songs.add(new Song("Stairway to Heaven", "Led Zeppelin"));
        songs.add(new Song("Bohemian Rhapsody", "Queen"));
        songs.add(new Song("Hotel California", "The Eagles"));
        songs.add(new Song("Baba O'Riley", "The Who"));
        songs.add(new Song("Free Bird", "Lynyrd Skynyrd"));
        songs.add(new Song("Paint It Black", "The Rolling Stones"));
        songs.add(new Song("Carry on Wayward Son", "Kansas"));
        songs.add(new Song("Comfortably Numb", "Pink Floyd"));
        songs.add(new Song("A Day in the Life", "The Beatles"));
        songs.add(new Song("Wish You Were Here", "Pink Floyd"));
        final SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Song song = adapter.getItem(position);
                Intent playerIntent = new Intent(LibraryActivity.this, PlayerActivity.class);
                String songName = song.getSongName();
                String artistName = song.getArtistName();
                playerIntent.putExtra("Song Name", songName);
                playerIntent.putExtra("Artist Name", artistName);
                startActivity(playerIntent);
            }
        });
    }
}
