package vn.edu.usth.opendota.ui.my_profile.heroes;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.HeroesAdapters;
import vn.edu.usth.opendota.adapters.MatchesAdapter;
import vn.edu.usth.opendota.adapters.MyProfileAdapters;
import vn.edu.usth.opendota.models.Heroes;
import vn.edu.usth.opendota.models.PlayerObj;
import vn.edu.usth.opendota.models.ProPlayerObj;
import vn.edu.usth.opendota.models.RecentMatchesObj;
import vn.edu.usth.opendota.retrofit.ApiClient;
import vn.edu.usth.opendota.retrofit.IAPINetwork;

public class HeroesFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<RecentMatchesObj> listRecentMatches;

    public HeroesFragment(ArrayList<RecentMatchesObj> listRecentMatches){
        this.listRecentMatches=listRecentMatches;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_matches, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.rm_recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        HeroesAdapters HeroesAdapters = new HeroesAdapters(getContext(), listRecentMatches);
        recyclerView.setAdapter(HeroesAdapters);
        HeroesAdapters.notifyDataSetChanged();

    }
}
