package vn.edu.usth.opendota.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import vn.edu.usth.opendota.MainActivity;

public class SteamLoginActivity extends AppCompatActivity {

    private static final String STEAM_API_KEY = "F432BA35A74128DBCFCE655825F33FD9";
    private static final String STEAM_LOGIN_URL = "https://steamcommunity.com/login/home/?goto=";
    private static final String REDIRECT_URI = "http://yourapp.com/redirect"; // Thay đổi nếu cần
    private String steamId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        setContentView(webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // Kiểm tra xem URL có chứa thông tin đăng nhập thành công hay không
                if (url.startsWith(REDIRECT_URI)) {
                    handleLoginResponse(url);
                    return true; // Ngăn WebView mở URL này
                }
                return false; // Để WebView xử lý URL khác
            }
        });

        // Bắt đầu quá trình đăng nhập
        String loginUrl = STEAM_LOGIN_URL + "?openid.mode=checkid_setup&openid.ns=http://specs.openid.net/auth/2.0&openid.claimed_id=http://specs.openid.net/auth/2.0/identifier_select&openid.identity=http://specs.openid.net/auth/2.0/identifier_select";
        webView.loadUrl(loginUrl);
    }

    private void handleLoginResponse(String url) {
        Uri uri = Uri.parse(url);
        String claimedId = uri.getQueryParameter("openid.claimed_id");

        if (claimedId != null) {
            String[] steamIdParts = claimedId.split("/");
            steamId = steamIdParts[steamIdParts.length - 1];

            fetchUserProfile(steamId);
        } else {
            Toast.makeText(this, "Lỗi: Không tìm thấy ID Steam", Toast.LENGTH_SHORT).show();
        }
    }

    private void fetchUserProfile(String steamId) {
        String url = "https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?F432BA35A74128DBCFCE655825F33FD9=" + STEAM_API_KEY + "&755509=" + steamId;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonData = response.body().string();
                SteamUserResponse steamUserResponse = new Gson().fromJson(jsonData, SteamUserResponse.class);
                SteamUser steamUser = steamUserResponse.getResponse().getPlayers()[0];

                SharedPreferences sharedPreferences = getSharedPreferences("SteamPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("steamId", steamUser.getSteamId());
                editor.putString("avatarUrl", steamUser.getAvatar());
                editor.apply();

                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Lỗi lấy thông tin người dùng", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SteamUserResponse {
        @SerializedName("response")
        private Response response;

        public Response getResponse() {
            return response;
        }

        private static class Response {
            @SerializedName("players")
            private SteamUser[] players;

            public SteamUser[] getPlayers() {
                return players;
            }
        }
    }

    private static class SteamUser {
        @SerializedName("steamid")
        private String steamId;

        @SerializedName("avatar")
        private String avatar;

        public String getSteamId() {
            return steamId;
        }

        public String getAvatar() {
            return avatar;
        }
    }
}
