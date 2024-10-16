package vn.edu.usth.opendota.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiClient INSTANCE = null;
    private static Retrofit retrofit;

    private ApiClient() {
    }

    public static ApiClient getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApiClient();

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(0, TimeUnit.SECONDS)
                    .writeTimeout(0, TimeUnit.SECONDS)
                    .connectTimeout(0, TimeUnit.SECONDS).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.opendota.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return INSTANCE;
    }

    public ApiService getAPIService() {
        return retrofit.create(ApiService.class);
    }
}
