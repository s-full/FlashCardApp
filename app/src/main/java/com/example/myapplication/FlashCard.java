package com.example.myapplication;

import java.io.Serializable;
import java.util.Objects;

public class FlashCard implements Serializable {
    private String frontText;
    private String backText;

    public FlashCard(String frontText, String backText) {
        this.frontText = frontText;
        this.backText = backText;
    }

    public String getFrontText() {
        return frontText;
    }

    public String getBackText() {
        return backText;
    }

    public void setBackText(String backText) {
        this.backText = backText;
    }

    public void setFrontText(String frontText) {
        this.frontText = frontText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlashCard flashCard = (FlashCard) o;
        return Objects.equals(frontText, flashCard.frontText) && Objects.equals(backText, flashCard.backText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frontText, backText);
    }
}
