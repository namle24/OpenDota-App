package vn.edu.usth.opendota.retrofit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.usth.opendota.models.PlayerObj;
import vn.edu.usth.opendota.models.PlayerWinLoss;
import vn.edu.usth.opendota.models.ProPlayerObj;
import vn.edu.usth.opendota.models.RecentMatchesObj;

public class APIClient {
    private static ApiService mApiBuilder;

    private static ApiService getAPIBuilder() {
        if (mApiBuilder == null) {
            // show in logcat
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.addInterceptor(chain -> {
                        Request request = chain.request();
                        HttpUrl httpUrl = request.url().newBuilder().build();
                        request = request.newBuilder().url(httpUrl).build();
                        return chain.proceed(request);
                    })
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.opendota.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(builder.build())
                    .build();
            mApiBuilder = retrofit.create(ApiService.class);
        }
        return mApiBuilder;
    }

    public static Call<List<ProPlayerObj>> getProPlayer(){
        return getAPIBuilder().proPlayers();
    }
    public static Call<List<RecentMatchesObj>> getRecentMatch(int account_id){
        return getAPIBuilder().recentMatcheObj(account_id);
    }
    public static Call<PlayerObj> getPlayerData(int account_id){
        return getAPIBuilder().playerData(account_id);
    }

    public static Call<PlayerWinLoss> getPlayerWinLoss(int account_id){
        return getAPIBuilder().playerWinLoss(account_id);
    }
}
