package com.example.bcmb.personalvocab.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.bcmb.personalvocab.db.VocabDBSchema.*;

public class WordsDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "vocabulary.db";

    public WordsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NewWordsTable.NAME + " (" +
                        " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        NewWordsTable.Cols.ORIGINAL_WORD + " TEXT, " +
                        NewWordsTable.Cols.TRANSLATION + " TEXT" +
                        ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + NewWordsTable.NAME + ");");
        onCreate(db);
    }
}
