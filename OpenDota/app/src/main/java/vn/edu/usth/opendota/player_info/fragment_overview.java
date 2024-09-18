package vn.edu.usth.opendota.player_info;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
    private static final String TAG = "FragmentOverview";
    private MatchesAdapter matchesAdapter;

    public static fragment_overview newInstance() {
        return new fragment_overview();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        Log.d(TAG, "Layout inflated successfully.");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_match_history);

        if (recyclerView == null) {
            Log.e(TAG, "RecyclerView is null! Check your layout file.");
            return;
        }

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
        if (mockMatches != null) {
            matchesAdapter.submit(mockMatches);
        } else {
            Log.e(TAG, "Mock matches are null!");
        }
    }
}
