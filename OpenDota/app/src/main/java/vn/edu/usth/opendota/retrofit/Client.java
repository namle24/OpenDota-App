package vn.edu.usth.opendota.retrofit;

import android.content.Context;

import java.util.List;

import vn.edu.usth.opendota.matches.Matches;

public class Client {
    private static Client INSTANCE = null;

    // Constructor private để ngăn chặn khởi tạo bên ngoài
    private Client() {
    }

    // Singleton pattern để lấy instance của Client
    public static Client getInstance(Context context) {
        if (Client.INSTANCE == null) {
            Client.INSTANCE = new Client();
        }
        return Client.INSTANCE;
    }


    public List<Matches> getMockMatches() {
        return Matches.generates();
    }
}
