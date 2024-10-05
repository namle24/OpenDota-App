package vn.edu.usth.opendota.retrofit;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MatchesClient {
    private static MatchesClient INSTANCE = null;

    private static Retrofit retrofit;

    private MatchesClient() {
    }

    public static MatchesClient getInstance(Context context) {
        if (MatchesClient.INSTANCE == null) {
            MatchesClient.INSTANCE = new MatchesClient();

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS).build();

            MatchesClient.retrofit = new Retrofit.Builder().baseUrl("https://api.opendota.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return MatchesClient.INSTANCE;
    }

    public ApiService getAPIService() {
        return retrofit.create(ApiService.class);
    }
}
