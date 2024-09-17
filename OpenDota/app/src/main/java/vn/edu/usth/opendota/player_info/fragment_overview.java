package vn.edu.usth.opendota.player_info;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapter.MatchesAdapter;
import vn.edu.usth.opendota.matches.Matches;
import vn.edu.usth.opendota.models.MatchDetailActivityManage;
import vn.edu.usth.opendota.retrofit.Client;


public class fragment_overview extends Fragment {
    private MatchesAdapter matchesAdapter;
    public static fragment_overview newInstance() {
        fragment_overview frag_layout1 = new fragment_overview();
        return frag_layout1;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        androidx.recyclerview.widget.RecyclerView recyclerView = view.findViewById(R.id.recyclerview_match_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        matchesAdapter = new MatchesAdapter();
        recyclerView.setAdapter(matchesAdapter);

        loadMockData();

        matchesAdapter.setOnClickListener((position, match) -> {
            Intent intent = new Intent(getActivity(), MatchDetailActivityManage.class);
            intent.putExtra("MATCH_DETAILS", match);
            startActivity(intent);
        });
    }


    private void loadMockData() {
        Client client = Client.getInstance(getContext());
        List<Matches> mockMatches = client.getMockMatches();
        matchesAdapter.submit(mockMatches);
    }
}
