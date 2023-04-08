package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FlashDeckListAdapter extends RecyclerView.Adapter<FlashDeckListAdapter.ViewHolder> {
    private ArrayList<FlashCardDeck> deckList;
    private AdapterCallBack adapterCallBack;

    public FlashDeckListAdapter(Context context, ArrayList<FlashCardDeck> fd) {
        deckList = fd;
        adapterCallBack = ((AdapterCallBack) context);
    }

    @NonNull
    @Override
    public FlashDeckListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        }
    }

    @Override
    public void onBindViewHolder(FlashDeckListAdapter.ViewHolder holder, int position) {
        final FlashCardDeck myFlashCardDeck = deckList.get(position);
        holder.textView.setText(myFlashCardDeck.getDeckName());
        //holder.imageView.setImageResource();
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "clicked on "+ myFlashCardDeck.getDeckName(),
                        Toast.LENGTH_LONG).show();
                adapterCallBack.onMethodCallback(myFlashCardDeck);

            }
        });
    }
    public static interface AdapterCallBack {
        void onMethodCallback(FlashCardDeck s);
    }


    @Override
    public int getItemCount() {
        if (deckList == null) {return 0;}
        else return deckList.size();
    }
}
