package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class addNewCard extends AppCompatActivity {

    public FlashCardDeck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_card);

        EditText frontEditText = findViewById(R.id.frontEditText);


        EditText backEditText = findViewById(R.id.backEditText);


//        deck = new FlashCardDeck();
//        Intent intent = getIntent();
//        deck = (FlashCardDeck) intent.getSerializableExtra("deck");


        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(addNewCard.this, "Card Added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                String backText = backEditText.getText().toString();
                String frontText = frontEditText.getText().toString();
                intent.putExtra("front", frontText);

                intent.putExtra("back", backText);
                setResult(RESULT_OK, intent);
                Log.d("finish", "back to show");
                finish();
            }
        });

    }
}