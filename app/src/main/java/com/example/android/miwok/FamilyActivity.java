/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer ;

    private MediaPlayer.OnCompletionListener mComplete = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

       final ArrayList<ObjectL> words = new ArrayList<ObjectL>();
        words.add(new ObjectL("father", "әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new ObjectL("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new ObjectL("son", "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new ObjectL("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new ObjectL("older brother", "taachi", R.drawable.family_older_brother,
                R.raw.family_older_brother));
        words.add(new ObjectL("younger brother", "chalitti", R.drawable.family_younger_brother,
                R.raw.family_younger_brother));
        words.add(new ObjectL("older sister", "teṭe", R.drawable.family_older_sister,
                R.raw.family_older_sister));
        words.add(new ObjectL("younger sister", "kolliti", R.drawable.family_younger_sister,
                R.raw.family_younger_sister));
        words.add(new ObjectL("grandmother ", "ama", R.drawable.family_grandmother,
                R.raw.family_grandmother));
        words.add(new ObjectL("grandfather", "paapa", R.drawable.family_grandfather,
                R.raw.family_grandfather));
        NameAdapter set = new NameAdapter(this, words, R.color.category_family,R.color. cate_colors);

        GridView listView = (GridView) findViewById(R.id.numlist);

        listView.setAdapter(set );

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ObjectL a =  words.get(position);

                releaseMediaPlayer();
                mMediaPlayer= MediaPlayer.create(FamilyActivity.this,a.getmAudio() );
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mComplete);
            }
        });
    }


    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }
        

}

