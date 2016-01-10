package com.example.bcmb.personalvocab.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

public class WordTouchHelper extends ItemTouchHelper.SimpleCallback {
   private WordsAdapter mMovieAdapter;
   private Context mContext;

    public WordTouchHelper(WordsAdapter movieAdapter, Context mContext){
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.mMovieAdapter = movieAdapter;
        this.mContext = mContext;
        }

            @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
    //TODO: Not implemented here
    return false;
        }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Toast.makeText(mContext, "siped", Toast.LENGTH_SHORT).show();
    // mMovieAdapter.remove(viewHolder.getAdapterPosition());
    }
}
