
package vn.edu.usth.opendota.retrofit;

import java.util.List;

public class SteamUserResponse {
    private Response response;

    public Response getResponse() {
        return response;
    }

    public class Response {
        private List<SteamUser> players;

        public List<SteamUser> getPlayers() {
            return players;
        }
    }

    public class SteamUser {
        private String steamName;
        private String avatar;

        public String getSteamName() {
            return steamName;
        }

        public String getAvatar() {
            return avatar;
        }
    }
}
