package com.example.tennistracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tennistracker.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    ListView matchsList;
    private FragmentFirstBinding binding;
    private MatchsAdapter matchsAdapter;
    private static final Match[] matchs = {
        new Match(0, "Roland Garros", 48.84581858596526, 2.253548000789472),
        new Match(1, "Wimbledon", 51.435517926388215, -0.2140563891347529)
    };

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        matchsList = (ListView) getView().findViewById(R.id.matchsListView);

        matchsAdapter = new MatchsAdapter(getView().getContext(), R.layout.list_view_matchs, matchs);
        matchsList.setAdapter(matchsAdapter);
        matchsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Match match = (Match)matchsList.getAdapter().getItem(position);
                Intent intent = new Intent(getActivity(), ViewMatch.class);
                intent.putExtra("id", match.id);
                intent.putExtra("latitude", match.latitude);
                intent.putExtra("longitude", match.longitude);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}