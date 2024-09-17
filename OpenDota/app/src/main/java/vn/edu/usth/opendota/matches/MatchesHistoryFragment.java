package vn.edu.usth.opendota.matches;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapter.MatchesAdapter;
import vn.edu.usth.opendota.player_info.fragment_match_details;
import vn.edu.usth.opendota.retrofit.Client;

public class MatchesHistoryFragment extends Fragment {
    private static final String TAG = "MatchesHistoryFragment";
    private final MatchesAdapter matchesAdapter = new MatchesAdapter();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.match_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        androidx.recyclerview.widget.RecyclerView recyclerView = view.findViewById(R.id.recyclerview_match_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(matchesAdapter);

        matchesAdapter.setOnClickListener((position, match) -> {
            Intent intent = new Intent(getContext(), fragment_match_details.class);
            startActivity(intent);
        });

        loadMockData();
    }

    private void loadMockData() {
        Client client = Client.getInstance(getContext());
        List<Matches> mockMatches = client.getMockMatches();
        matchesAdapter.submit(mockMatches);
    }


    public static List<Matches> generates() {
        List<Matches> results = new ArrayList<>();

        results.add(new Matches("Ranks",10, 2, 15, "12/09/2024", "50:00", R.drawable.slardar_full, true));
        results.add(new Matches("All Draft Normal",5, 8, 20, "12/09/2024", "50:00", R.drawable.queenofpain_full, false));
        results.add(new Matches("All Draft Normal", 12, 4, 8, "12/09/2024", "50:00", R.drawable.slardar_full, true));
        results.add(new Matches("All Draft Normal",7, 10, 25, "12/09/2024", "50:00", R.drawable.huskar_full, false));
        results.add(new Matches("All Draft Normal",14, 3, 17, "12/09/2024", "50:00", R.drawable.aether_lens_lg, true));

        return results;
    }
}
