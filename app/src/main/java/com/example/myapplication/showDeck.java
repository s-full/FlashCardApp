package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class showDeck extends AppCompatActivity {

    public FlashCardDeck deck;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_deck);
        deck = new FlashCardDeck();
        Intent intent = getIntent();
        deck = (FlashCardDeck) intent.getSerializableExtra("deck");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.flashcard_recycle_view);
        DeckAdapter adapter = new DeckAdapter(deck);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
    public boolean OnCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu_deck, menu);
        return true;
    }
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.add_card:
//
//                return true;
//            case R.id.delete_card:
//
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//
//        }
//    }
}


