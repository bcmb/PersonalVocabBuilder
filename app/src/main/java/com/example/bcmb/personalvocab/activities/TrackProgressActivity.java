package com.example.bcmb.personalvocab.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.bcmb.personalvocab.R;
import com.example.bcmb.personalvocab.adapters.WordTouchHelper;
import com.example.bcmb.personalvocab.adapters.WordsAdapter;
import com.example.bcmb.personalvocab.db.WordsManager;

public class TrackProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_add_words);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.list_words_container);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        WordsAdapter mAdapter = new WordsAdapter(new WordsManager(getApplicationContext()).getAllWords());
        mRecyclerView.setAdapter(mAdapter);
        ItemTouchHelper.Callback callback = new WordTouchHelper(mAdapter, getApplicationContext());
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecyclerView);
    }
}
