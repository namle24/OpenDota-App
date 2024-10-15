package vn.edu.usth.opendota.profile.matches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.RecentMatchesObj;


public class MatchesFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<RecentMatchesObj> listRecentMatches;

    public MatchesFragment(ArrayList<RecentMatchesObj> listRecentMatches){
        this.listRecentMatches=listRecentMatches;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_matches_history, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.matches_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        MatchesAdapter MatchesAdapter = new MatchesAdapter(getContext(), listRecentMatches);
        recyclerView.setAdapter(MatchesAdapter);
        MatchesAdapter.notifyDataSetChanged();

    }
}

