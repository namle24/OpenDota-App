package vn.edu.usth.opendota.retrofit;

import android.content.Context;

import java.util.List;

import vn.edu.usth.opendota.matches.Matches;
import vn.edu.usth.opendota.models.MatchesConstant;

public class Client {
    private static Client INSTANCE = null;

    private Client() {
    }

    public static Client getInstance(Context context) {
        if (Client.INSTANCE == null) {
            Client.INSTANCE = new Client();
        }
        return Client.INSTANCE;
    }


    public List<Matches> getMockMatches() {
        return MatchesConstant.generates();
    }
}
