package com.example.tennistracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tennistracker.databinding.FragmentSecondBinding;
import com.example.tennistracker.placeholder.Place;

public class SecondFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentSecondBinding binding;
    private View view;
    private Spinner spinner;
    private Spinner spinner_player2;
    private PlayersAdapter playersAdapter;
    private PlayersAdapter playersAdapter2;
    private Handler handler;
    private static final Player[] players = {
        new Player("104925","Novak","Djokovic","R","19870522","SRB","188","Q5812"),
        new Player("106421","Daniil","Medvedev","R","19960211","RUS","198","Q21622022")
    };

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        view = inflater.inflate(R.layout.fragment_second, container, false);

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        handler = new Handler();

        // Maybe try to launch the Task here ?

        playersAdapter = new PlayersAdapter(view.getContext(), android.R.layout.simple_spinner_item, players);
        playersAdapter2 = new PlayersAdapter(view.getContext(), android.R.layout.simple_spinner_item, players);
        spinner = (Spinner)view.findViewById(R.id.spinner_player1);
        spinner_player2 = (Spinner)view.findViewById(R.id.spinner_player2);
        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(playersAdapter);
        spinner_player2.setAdapter(playersAdapter2);
        // https://stackoverflow.com/questions/1625249/android-how-to-bind-spinner-to-custom-object-list

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}