package vn.edu.usth.opendota.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.opendota.R;

public class HomeActivity extends AppCompatActivity {

    private static final String STEAM_LOGIN_URL = "https://steamcommunity.com/openid/login";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home); // Set the layout for this activity

        Button btnSteamLogin = findViewById(R.id.btnSteamLogin);
        btnSteamLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSteamLogin();
            }
        });
    }

    private void performSteamLogin() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(STEAM_LOGIN_URL));
        startActivity(intent);
    }
}
