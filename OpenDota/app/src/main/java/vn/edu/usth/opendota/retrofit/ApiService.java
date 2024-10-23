package vn.edu.usth.opendota.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vn.edu.usth.opendota.models.Heroes;
import vn.edu.usth.opendota.models.Matches;
import vn.edu.usth.opendota.models.Overview;
import vn.edu.usth.opendota.models.ProPlayerProfile;
import vn.edu.usth.opendota.models.Winlose;

public interface ApiService {

    @GET("players/{id}/recentMatches")
    Call<List<Matches>> getMatches(@Path("id") String id);

    @GET("players/{id}/heroes")
    Call<List<Heroes>> getHeroes(@Path("id") String id);

    @GET("proPlayers")
    Call<List<ProPlayerProfile>> getProfile();

    @GET("players/{id}")
    Call<Overview> getOverview(@Path("id") String id);

    @GET("players/{id}/wl")
    Call<Winlose> getWinlose(@Path("id") String id);

}

