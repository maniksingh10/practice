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
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class  NumbersActivity extends AppCompatActivity {

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


        // Create a list of words
        final ArrayList<ObjectL> words = new ArrayList<ObjectL>();
        words.add(new ObjectL("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new ObjectL("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new ObjectL("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new ObjectL("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new ObjectL("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new ObjectL("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new ObjectL("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new ObjectL("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new ObjectL("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new ObjectL("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));


        NameAdapter set = new NameAdapter(this, words,R.color.category_numbers, R.color.cate_family);

        GridView listView = (GridView) findViewById(R.id.numlist);

        listView.setAdapter(set );


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ObjectL a =  words.get(position);

                releaseMediaPlayer();
                mMediaPlayer= MediaPlayer.create(NumbersActivity.this,a.getmAudio() );
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


