package com.example.bcmb.personalvocab.model;

public class Word {
    private String mWord;
    private String mTranslation;

    public Word () {
    }

    public Word (String word) {
        mWord = word;
    }

    public String getWord() {
        return mWord;
    }

    public void setWord(String word) {
        this.mWord = word;
    }

    public String getTranslation() {
        return mTranslation;
    }

    public void setTranslation(String translation) {
        this.mTranslation = translation;
    }
}
