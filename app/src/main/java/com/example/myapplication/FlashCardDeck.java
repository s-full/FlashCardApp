package com.example.myapplication;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class FlashCardDeck implements Serializable {

    private ArrayList<FlashCard> flashDeck;
    String deckName;
    public FlashCardDeck(){
        flashDeck = new ArrayList<>();
        deckName = "";
    }
    public FlashCard getCardAtPos(int i) {
        return flashDeck.get(i);
    }

    public FlashCardDeck(String dn) {
        flashDeck = new ArrayList<>();
        deckName = dn;
    }
    public void randomizeOrder() {
        Collections.shuffle(flashDeck);
    }
    public void addCard(FlashCard newCard) {
        flashDeck.add(newCard);
    }
    public void removeCard(FlashCard cardToDelete) {
        flashDeck.removeIf(card -> card.equals(cardToDelete));
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }
    public int getSize() {
        return flashDeck.size();
    }

    @Override
    public String toString() {
        return "FlashCardDeck{" +
                "flashDeck=" + flashDeck +
                '}';
    }
}
