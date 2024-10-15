package vn.edu.usth.opendota.ui.my_profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.MyProfileAdapters;
import vn.edu.usth.opendota.models.Profile;
import vn.edu.usth.opendota.retrofit.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyProfileFragment extends Fragment {
    private static final String TAG = "MyProfileFragment";
    private long accountId; // Lưu account ID

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            accountId = getArguments().getLong("account_id");
            loadProfileData(accountId);
        }

        ViewPager pager = view.findViewById(R.id.profile_viewpager);
        MyProfileAdapters adapter = new MyProfileAdapters(getChildFragmentManager());
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.profile_tab);
        tabLayout.setupWithViewPager(pager);
    }

    private void loadProfileData(long accountId) {
        ApiClient.getInstance().getAPIService().getProfileById(accountId).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(@NonNull Call<Profile> call, @NonNull Response<Profile> response) {
                if (response.isSuccessful()) {
                    Profile profile = response.body();
                } else {
                    Log.e(TAG, "Error code: " + response.code() + " Error Message: " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Profile> call, @NonNull Throwable t) {
                Log.e(TAG, "Failure: " + t.getMessage());
            }
        });
    }
}
