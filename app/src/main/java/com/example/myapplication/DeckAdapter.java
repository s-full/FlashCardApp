package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DeckAdapter extends RecyclerView.Adapter<DeckAdapter.ViewHolder> {
    private FlashCardDeck deck;
    static boolean toggle = true;


    public DeckAdapter(FlashCardDeck deck) {
        this.deck = deck;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        }
    }


    @NonNull
    @Override
    public DeckAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item,parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DeckAdapter.ViewHolder holder, int position) {

        final FlashCard myFlashCard = deck.getCardAtPos(position);
        holder.textView.setText(myFlashCard.getFrontText());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggle) {
                    holder.textView.setText(myFlashCard.getBackText());
                    toggle = false;
                }
                else {
                    holder.textView.setText(myFlashCard.getFrontText());
                    toggle = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return deck.getSize();
    }

    public void setDeck(FlashCardDeck newDeck) {
        this.deck = newDeck;
        this.notifyDataSetChanged();
    }
//    public DeckAdapter getAdapter() {
//        return
//    }
}
