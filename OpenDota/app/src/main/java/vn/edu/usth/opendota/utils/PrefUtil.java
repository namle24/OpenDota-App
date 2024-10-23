package vn.edu.usth.opendota.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import vn.edu.usth.opendota.models.ProPlayerProfile;


public class PrefUtil {

    private static final String KEY_FAVORITES = "favorite_players";

    public static void addToFavorites(Context context, ProPlayerProfile player) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(KEY_FAVORITES, "[]");
        Type type = new TypeToken<List<ProPlayerProfile>>() {}.getType();
        List<ProPlayerProfile> favorites = new Gson().fromJson(json, type);

        if (!favorites.contains(player)) {
            favorites.add(player);
        }

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_FAVORITES, new Gson().toJson(favorites));
        editor.apply();
    }


    public static void removeFavorite(Context context, ProPlayerProfile player) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(KEY_FAVORITES, "[]");
        Type type = new TypeToken<List<ProPlayerProfile>>() {}.getType();
        List<ProPlayerProfile> favorites = new Gson().fromJson(json, type);

        favorites.remove(player);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_FAVORITES, new Gson().toJson(favorites));
        editor.apply();
    }

    // Check if a player is in the favorites list
    public static boolean isFavorite(Context context, String accountId) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(KEY_FAVORITES, "[]");
        Type type = new TypeToken<List<ProPlayerProfile>>() {}.getType();
        List<ProPlayerProfile> favorites = new Gson().fromJson(json, type);

        for (ProPlayerProfile player : favorites) {
            if (player.getAccountID() == accountId) {
                return true;
            }
        }
        return false;
    }

    public static List<ProPlayerProfile> getListFavorite(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(KEY_FAVORITES, "[]");
        Type type = new TypeToken<List<ProPlayerProfile>>() {}.getType();
        return new Gson().fromJson(json, type);
    }
}