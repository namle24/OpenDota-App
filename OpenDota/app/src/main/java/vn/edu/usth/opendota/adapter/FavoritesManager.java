package vn.edu.usth.opendota.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

public class FavoritesManager {
    private static final String PREFS_NAME = "favorites";
    private static final String FAVORITES_KEY = "favorite_users";

    private SharedPreferences sharedPreferences;

    public FavoritesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void addFavorite(String name, String id) {
        Set<String> favorites = sharedPreferences.getStringSet(FAVORITES_KEY, new HashSet<>());
        favorites.add(name + " - " + id);
        sharedPreferences.edit().putStringSet(FAVORITES_KEY, favorites).apply();
    }

    public Set<String> getFavorites() {
        return sharedPreferences.getStringSet(FAVORITES_KEY, new HashSet<>());
    }
}
