package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class makeNewDeck extends AppCompatActivity {

    private Button addButton;
    private EditText mEdit;
    private String deckName;
    ArrayList<FlashCardDeck> flashDecks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_new_deck);

        mEdit = (EditText) findViewById(R.id.editText_deck_name);
        addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deckName = mEdit.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("name", deckName);
                showToast("Deck created!");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void showToast(String text) {
        Toast.makeText(makeNewDeck.this, text, Toast.LENGTH_SHORT).show();
    }
}