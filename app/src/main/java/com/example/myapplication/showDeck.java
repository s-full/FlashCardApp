package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class showDeck extends AppCompatActivity {

    public FlashCardDeck deck;
    private EditText editText;
    private DeckAdapter adapter;
    private static final int MAKE_NEW_CARD_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_deck);

//        addCardButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(showDeck.this, addNewCard.class);
//                intent.putExtra("deck", deck);
//                startActivityForResult(intent, MAKE_NEW_CARD_REQUEST_CODE);
//                adapter.setDeck(deck);
//                Log.d("foo", deck.toString());
//            }
//        });

        deck = new FlashCardDeck();
        Intent intent = getIntent();
        deck = (FlashCardDeck) intent.getSerializableExtra("deck");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.flashcard_recycle_view);
        adapter = new DeckAdapter(deck);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        FloatingActionButton addCardButton = findViewById(R.id.fab);
        addCardButton.setOnClickListener(view -> launchNewCard());


    }

    private void launchNewCard() {
        Intent intent = new Intent(showDeck.this, addNewCard.class);
        intent.putExtra("deck", deck);
        startActivityForResult(intent, MAKE_NEW_CARD_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MAKE_NEW_CARD_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "RESULT", Toast.LENGTH_SHORT).show();
                String frontText = data.getStringExtra("front");
                String backText = data.getStringExtra("back");
                FlashCard newCard = new FlashCard(frontText, backText);
                deck.addCard(newCard);

                adapter.setDeck(deck);
            }
        }
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


