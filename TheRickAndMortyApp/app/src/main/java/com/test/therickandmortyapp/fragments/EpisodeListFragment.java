package com.test.therickandmortyapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.therickandmortyapp.R;
import com.test.therickandmortyapp.data.EpisodeListAsyncTask;
import com.test.therickandmortyapp.data.callbacks.DataCallback;
import com.test.therickandmortyapp.data.models.Episode;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EpisodeListFragment extends Fragment {


    public EpisodeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_episode_list, container, false);

        new EpisodeListAsyncTask().execute(new DataCallback<List<Episode>>() {
            @Override
            public void onDataReady(List<Episode> result) {

            }
        });

        return view;
    }

}
