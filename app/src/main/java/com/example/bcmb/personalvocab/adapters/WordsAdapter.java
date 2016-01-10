package com.example.bcmb.personalvocab.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bcmb.personalvocab.R;
import com.example.bcmb.personalvocab.model.Word;

import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordsViewHolder> {
    private List<Word> mWordsList;

    public WordsAdapter (List words) {
        mWordsList = words;
    }


    public static class WordsViewHolder extends RecyclerView.ViewHolder{
        public TextView mWord;
        public TextView mTranslation;

        public WordsViewHolder(View v) {
            super(v);
            this.mWord = (TextView) v.findViewById(R.id.list_item_word);
            this.mTranslation = (TextView) v.findViewById(R.id.list_item_translation);
        }
    }

    @Override
    public WordsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_item, parent, false);
        return new WordsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WordsViewHolder holder, int position) {
        holder.mWord.setText(mWordsList.get(position).getWord());
        holder.mTranslation.setText(mWordsList.get(position).getTranslation());
    }

    @Override
    public int getItemCount() {
        return mWordsList.size();
    }


}
