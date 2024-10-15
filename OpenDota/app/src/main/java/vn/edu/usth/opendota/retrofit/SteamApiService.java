package vn.edu.usth.opendota.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SteamApiService {
    @GET("ISteamUser/GetPlayerSummaries/v0002/")
    Call<SteamUserResponse> getPlayerSummaries(@Query("key") String apiKey, @Query("steamids") String steamId);
}
