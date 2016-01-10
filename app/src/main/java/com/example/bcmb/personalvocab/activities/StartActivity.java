package com.example.bcmb.personalvocab.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bcmb.personalvocab.R;

public class StartActivity extends AppCompatActivity {
    private Button mAddWords;
    private Button mTrackProgress;
    private Button mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mAddWords = (Button) findViewById(R.id.add_new_words);
        mAddWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, AddSingleWordActivity.class));
            }
        });
        mTrackProgress = (Button) findViewById(R.id.track_progress);
        mTrackProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, TrackProgressActivity.class));
            }
        });

        mSettings = (Button) findViewById(R.id.settings);
        mSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
            }
        });
    }
}
