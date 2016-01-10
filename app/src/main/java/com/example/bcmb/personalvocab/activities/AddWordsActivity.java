package com.example.bcmb.personalvocab.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.bcmb.personalvocab.R;
import com.example.bcmb.personalvocab.adapters.WordsAdapter;
import com.example.bcmb.personalvocab.db.WordsManager;

public class AddWordsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_words);
        mRecyclerView = (RecyclerView) findViewById(R.id.list_words_container);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new WordsAdapter(new WordsManager(getApplicationContext()).getAllWords()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_word, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                startActivity(new Intent(this, AddSingleWordActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRecyclerView.setAdapter(new WordsAdapter(new WordsManager(getApplicationContext()).getAllWords()));
    }
}
