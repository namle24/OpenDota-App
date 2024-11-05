package vn.edu.usth.opendota.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.ui.login.LoginActivity;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        CardView btnSteamLogin = view.findViewById(R.id.btnSteamLogin);
        btnSteamLogin.setOnClickListener(v -> {
            Log.d("SteamLogin", "Nút Steam Login đã được bấm");
            if (getActivity() instanceof LoginActivity) {
                ((LoginActivity) getActivity()).initiateSteamLogin();
            }
        });

        return view;
    }
}