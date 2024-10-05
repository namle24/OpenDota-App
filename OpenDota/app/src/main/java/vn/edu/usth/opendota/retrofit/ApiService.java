package vn.edu.usth.opendota.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vn.edu.usth.opendota.models.Matches;

public interface ApiService {

    @GET("players/{id}/recentMatches")
    Call<List<Matches>> getMatches(@Path("id") String id);

}

