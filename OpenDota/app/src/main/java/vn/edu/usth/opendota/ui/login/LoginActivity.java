package vn.edu.usth.opendota.ui.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import vn.edu.usth.opendota.R;

public class LoginActivity extends AppCompatActivity {

    private static final String REDIRECT_URI = "myapp://steam-login-opendota";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // Đảm bảo layout chính cho LoginActivity

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())  // R.id.fragment_container là ID cho FrameLayout nơi bạn muốn hiển thị Fragment
                    .commit();
        }
    }

    // Phương thức này sẽ được gọi từ HomeFragment
    public void initiateSteamLogin() {
        Log.d("SteamLogin", "Chuẩn bị khởi chạy Intent đăng nhập Steam");
        String openidUrl = "https://steamcommunity.com/openid/login" +
                "?openid.ns=http://specs.openid.net/auth/2.0" +
                "&openid.mode=checkid_setup" +
                "&openid.return_to=" + REDIRECT_URI +
                "&openid.realm=" + REDIRECT_URI +
                "&openid.identity=http://specs.openid.net/auth/2.0/identifier_select" +
                "&openid.claimed_id=http://specs.openid.net/auth/2.0/identifier_select";

        Log.d("SteamLogin", "URL: " + openidUrl);

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(openidUrl));
        if (browserIntent.resolveActivity(getPackageManager()) != null) {
            Log.d("SteamLogin", "Đã tạo Intent để mở trình duyệt: " + openidUrl);
            startActivity(browserIntent);
        } else {
            Log.e("SteamLogin", "Không có trình duyệt nào có thể xử lý Intent");
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri uri = intent.getData();
        if (uri != null && uri.toString().startsWith(REDIRECT_URI)) {
            handleSteamLoginResponse(uri);
        }
    }

    private void handleSteamLoginResponse(Uri uri) {
        String steamId = extractSteamId(uri);
        if (steamId != null) {
            getSteamUserDetails(steamId);
        } else {
            Toast.makeText(this, "Lỗi xác thực Steam", Toast.LENGTH_SHORT).show();
        }
    }

    private String extractSteamId(Uri uri) {
        String steamId = null;
        String query = uri.getQuery();
        if (query != null && query.contains("openid.claimed_id")) {
            steamId = query.split("openid.claimed_id=")[1];
            steamId = steamId.substring(steamId.lastIndexOf("/") + 1);
        }
        return steamId;
    }

    @SuppressLint("StaticFieldLeak")
    private void getSteamUserDetails(String steamId) {
        String apiUrl = "https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=F432BA35A74128DBCFCE655825F33FD9&steamids=755509" + steamId;

        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(apiUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder content = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }

                    in.close();
                    connection.disconnect();
                    return content.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String result) {
                if (result != null) {
                    Toast.makeText(LoginActivity.this, "Thông tin người dùng: " + result, Toast.LENGTH_SHORT).show();
                    saveSteamId(steamId);
                } else {
                    Toast.makeText(LoginActivity.this, "Lỗi khi lấy thông tin người dùng", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }

    private void saveSteamId(String steamId) {
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("steamId", steamId);
        editor.apply();
    }
}
