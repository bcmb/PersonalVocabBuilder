package com.example.bcmb.personalvocab.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bcmb.personalvocab.model.Word;

import java.util.ArrayList;
import java.util.List;

import static com.example.bcmb.personalvocab.db.VocabDBSchema.NewWordsTable;

public class WordsManager {
    private SQLiteDatabase mDatabase;
    private String[] mAllColumns = { NewWordsTable.Cols.ORIGINAL_WORD,
            NewWordsTable.Cols.TRANSLATION };

    public WordsManager (Context c) {
        mDatabase = new WordsDBHelper(c).getWritableDatabase();
    }

    public boolean addWord(String origWord, String translation) {
        ContentValues values = new ContentValues();
        values.put(NewWordsTable.Cols.ORIGINAL_WORD, origWord);
        values.put(NewWordsTable.Cols.TRANSLATION, translation);

        return mDatabase.insert(NewWordsTable.NAME, null, values) == -1;
    }

    public List<Word> getAllWords() {
        ArrayList<Word> words = new ArrayList<Word>();
        Cursor cursor = mDatabase.query(NewWordsTable.NAME,
                mAllColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Word word = cursorToWord(cursor);
            words.add(word);
            cursor.moveToNext();
        }
        cursor.close();

        return words;
    }

    private Word cursorToWord(Cursor cursor) {
        Word word = new Word();
        word.setWord(cursor.getString(cursor.getColumnIndex(NewWordsTable.Cols.ORIGINAL_WORD)));
        word.setTranslation(cursor.getString(cursor.getColumnIndex(NewWordsTable.Cols.TRANSLATION)));

        return word;
    }
}
