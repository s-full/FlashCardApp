package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button newButton, viewButton;
    private ArrayList<FlashCardDeck> deckList = new ArrayList<>();
    private static final int MAKE_NEW_DECK_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateOneDeck();

        newButton = findViewById(R.id.new_deck_button);
        viewButton = findViewById(R.id.view_deck_button);

        newButton.setOnClickListener(view -> launchMakeNewDeck());

        viewButton.setOnClickListener(view -> launchViewDecks());
    }

    public void launchMakeNewDeck() {
        Intent intent = new Intent(this, makeNewDeck.class);
        startActivityForResult(intent, MAKE_NEW_DECK_REQUEST_CODE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == MAKE_NEW_DECK_REQUEST_CODE) {
            if (resultCode == RESULT_OK ) {
                String newDeckName = data.getStringExtra("name");
                deckList.add(new FlashCardDeck(newDeckName));
            }
        }
    }

    public void launchViewDecks() {
        Intent intent = new Intent(this, viewDecks.class);
        intent.putExtra("decks", deckList);
        startActivity(intent);
    }

    public void populateOneDeck() {
        FlashCardDeck spanishNumbers = new FlashCardDeck("Spanish numbers");
        spanishNumbers.addCard(new FlashCard("One", "Uno"));
        spanishNumbers.addCard(new FlashCard("Two","Dos"));
        spanishNumbers.addCard(new FlashCard("Three","Tres"));
        spanishNumbers.addCard(new FlashCard("Four","Cuatro"));
        spanishNumbers.addCard(new FlashCard("Five","Cinco"));
        spanishNumbers.addCard(new FlashCard("Six", "Seis"));
        spanishNumbers.addCard(new FlashCard("Seven","Siete"));
        spanishNumbers.addCard(new FlashCard("Eight","Ocho"));
        spanishNumbers.addCard(new FlashCard("Nine","Nueve"));
        spanishNumbers.addCard(new FlashCard("Ten","Diez"));

        deckList.add(spanishNumbers);

        FlashCardDeck germanNumbers = new FlashCardDeck("German numbers");
        germanNumbers.addCard(new FlashCard("One", "Eins"));
        germanNumbers.addCard(new FlashCard("Two","Zwei"));
        germanNumbers.addCard(new FlashCard("Three","Drei"));
        germanNumbers.addCard(new FlashCard("Four","Vier"));
        germanNumbers.addCard(new FlashCard("Five","Funf"));
        germanNumbers.addCard(new FlashCard("Six", "Sechs"));
        germanNumbers.addCard(new FlashCard("Seven","Sieben"));
        germanNumbers.addCard(new FlashCard("Eight","Oct"));
        germanNumbers.addCard(new FlashCard("Nine","Neun"));
        germanNumbers.addCard(new FlashCard("Ten","Zehn"));

        deckList.add(germanNumbers);
    }
}