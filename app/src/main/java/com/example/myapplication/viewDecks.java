package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class viewDecks extends AppCompatActivity implements FlashDeckListAdapter.AdapterCallBack {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_decks);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.flashcard_recycle_view);
        ArrayList<FlashCardDeck> decks = new ArrayList<FlashCardDeck>();

        decks = (ArrayList<FlashCardDeck>) getIntent().getSerializableExtra("decks");
        FlashDeckListAdapter adapter = new FlashDeckListAdapter(this, decks);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onMethodCallback(FlashCardDeck deck) {
        launchShowDecks(deck);
    }
    public void launchShowDecks(FlashCardDeck deck) {
        Intent intent = new Intent(this, showDeck.class);
        intent.putExtra("deck", deck);
        startActivity(intent);
    }
}