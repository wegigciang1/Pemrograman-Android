package com.example.helloworld;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMovie extends Fragment {

    //buat array list film
    private ArrayList<Film> list;

    public FragmentMovie() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment_movie, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        list.addAll(FilmsData.getListData());

        RecyclerView rvFilm = view.findViewById(R.id.rv_film);
        rvFilm.setHasFixedSize(true);

        FilmCardViewAdapter filmCardViewAdapter = new FilmCardViewAdapter(list);

        rvFilm.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFilm.setAdapter(filmCardViewAdapter);
    }


}