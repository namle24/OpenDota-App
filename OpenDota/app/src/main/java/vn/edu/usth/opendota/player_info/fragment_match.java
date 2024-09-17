package vn.edu.usth.opendota.player_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.matches.Matches;
import vn.edu.usth.opendota.adapter.MatchesAdapter;
import vn.edu.usth.opendota.retrofit.Client;

public class fragment_match extends Fragment {
    private static final String TAG = "SearchFragment";
    private final MatchesAdapter matchesAdapter = new MatchesAdapter();


    public static fragment_match newInstance() {
        fragment_match frag_layout2 = new fragment_match();
        return frag_layout2;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_match, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        androidx.recyclerview.widget.RecyclerView recyclerView = view.findViewById(R.id.recyclerview_match_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(matchesAdapter);

        loadMockData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void loadMockData() {
        Client client = Client.getInstance(getContext());
        List<Matches> mockMatches = client.getMockMatches();
        matchesAdapter.submit(mockMatches);
    }
}
