package com.example.bcmb.personalvocab.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bcmb.personalvocab.R;
import com.example.bcmb.personalvocab.db.WordsManager;
import com.example.bcmb.personalvocab.model.Word;
import com.example.bcmb.personalvocab.translator.TranslationModuleAsyncTask;

public class AddSingleWordActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_single_word);
        Button addWord = (Button) findViewById(R.id.add_it);
        Button getTranslation = (Button) findViewById(R.id.get_translation);
        final EditText mWord = (EditText) findViewById(R.id.original_word);
        final EditText mTranslation = (EditText) findViewById(R.id.translation_word);
        addWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WordsManager manager = new WordsManager(getApplicationContext());
                manager.addWord(mWord.getText().toString(), mTranslation.getText().toString());
            }
        });
        getTranslation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word(mWord.getText().toString());
                TranslationModuleAsyncTask translator = new TranslationModuleAsyncTask(AddSingleWordActivity.this, word, mTranslation);
                translator.execute();
            }
        });
    }
}
