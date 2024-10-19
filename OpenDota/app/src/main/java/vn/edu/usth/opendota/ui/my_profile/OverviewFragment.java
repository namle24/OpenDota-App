package vn.edu.usth.opendota.ui.my_profile;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.Matches;
import vn.edu.usth.opendota.models.Overview;
import vn.edu.usth.opendota.models.Winlose;
import vn.edu.usth.opendota.retrofit.ApiClient;

public class OverviewFragment extends Fragment {
    private ApiClient client;
    private CircleImageView ow_avar;
    private TextView ow_name, ow_win, ow_lose, ow_winrate, ow_url;
    private LottieAnimationView animationView;

    public OverviewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        ow_avar = view.findViewById(R.id.ow_avar);
        ow_name = view.findViewById(R.id.ow_name);
        ow_win = view.findViewById(R.id.ow_win);
        ow_lose = view.findViewById(R.id.ow_lose);
        ow_winrate = view.findViewById(R.id.ow_winrate);
        ow_url = view.findViewById(R.id.ow_profile_steam);



        return view;
    }

    public static OverviewFragment newInstance() {
        return new OverviewFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        client = ApiClient.getInstance();
        animationView = view.findViewById(R.id.animationView);
        animationView.setVisibility(View.VISIBLE);;

        String id = String.valueOf(1296625);
        fetchOverviewData(id);
    }

    private void fetchOverviewData(String id) {
        Call<Overview> overviewCall = client.getAPIService().getOverview(id);
        Call<Winlose> winloseCall = client.getAPIService().getWinlose(id);

        overviewCall.enqueue(new Callback<Overview>() {
            @Override
            public void onResponse(@NonNull Call<Overview> call, @NonNull Response<Overview> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Overview overview = response.body();

                    winloseCall.enqueue(new Callback<Winlose>() {
                        @Override
                        public void onResponse(@NonNull Call<Winlose> call, @NonNull Response<Winlose> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                Winlose winlose = response.body();
                                overview.setWinlose(winlose);
                                updateUI(overview);
                                animationView.setVisibility(View.GONE);
                            } else {
                                Log.e(TAG, "Error fetching winlose data");
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<Winlose> call, @NonNull Throwable t) {
                            Log.e(TAG, "Failed to fetch winlose: " + t.getMessage());

                        }
                    });

                } else {
                    Log.e(TAG, "Error fetching overview data");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Overview> call, @NonNull Throwable t) {
                Log.e(TAG, "Failed to fetch overview: " + t.getMessage());
                animationView.setVisibility(View.GONE);

            }
        });
    }

    private void updateUI(Overview overview) {
        ow_name.setText(overview.getProfile().getName());
        Picasso.get().load(overview.getProfile().getAvatarmedium()).into(ow_avar);
        ow_url.setText(overview.getProfile().getProfileurl());

        String wins = String.valueOf(overview.getWinlose().getWin());
        String lose = String.valueOf(overview.getWinlose().getLose());
        int total = Integer.parseInt(String.valueOf(overview.getWinlose().getWin() + overview.getWinlose().getLose()));
        String winrate = (total > 0) ? String.format("%.2f%%", (double) overview.getWinlose().getWin() / total * 100) : "N/A";

        ow_win.setText("WINS\n" + wins);
        ow_lose.setText("LOSSES\n" + lose);
        ow_winrate.setText("WINRATE\n" + winrate + "%");
    }
}
