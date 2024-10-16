package vn.edu.usth.opendota.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.edu.usth.opendota.R;

public class HomeFragment extends Fragment {

    private static final String STEAM_LOGIN_URL = "https://steamcommunity.com/openid/login";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnSteamLogin = view.findViewById(R.id.btnSteamLogin);
        btnSteamLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSteamLogin();
            }
        });

        return view;
    }

    private void performSteamLogin() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(STEAM_LOGIN_URL));
        startActivity(intent);
    }
}
