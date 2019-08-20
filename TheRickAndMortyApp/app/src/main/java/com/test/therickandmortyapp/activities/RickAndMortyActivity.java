package com.test.therickandmortyapp.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.therickandmortyapp.R;
import com.test.therickandmortyapp.data.callbacks.DataCallback;
import com.test.therickandmortyapp.fragments.EpisodeListFragment;

public class RickAndMortyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayEpisodeFragment();
    }

    private void displayEpisodeFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_frame, new EpisodeListFragment());
        fragmentTransaction.commit();
    }
}
