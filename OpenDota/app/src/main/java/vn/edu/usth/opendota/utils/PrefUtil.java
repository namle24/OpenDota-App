package vn.edu.usth.opendota.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import vn.edu.usth.opendota.models.ProPlayerObj;


public class PrefUtil {

    private static final String KEY_FAVORITES = "favorite_players";

    public static void addToFavorites(Context context, ProPlayerObj player) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(KEY_FAVORITES, "[]");
        Type type = new TypeToken<List<ProPlayerObj>>() {}.getType();
        List<ProPlayerObj> favorites = new Gson().fromJson(json, type);

        if (!favorites.contains(player)) {
            favorites.add(player);
        }

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_FAVORITES, new Gson().toJson(favorites));
        editor.apply();
    }


    public static void removeFavorite(Context context, ProPlayerObj player) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(KEY_FAVORITES, "[]");
        Type type = new TypeToken<List<ProPlayerObj>>() {}.getType();
        List<ProPlayerObj> favorites = new Gson().fromJson(json, type);

        favorites.remove(player);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_FAVORITES, new Gson().toJson(favorites));
        editor.apply();
    }

    // Check if a player is in the favorites list
    public static boolean isFavorite(Context context, int accountId) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(KEY_FAVORITES, "[]");
        Type type = new TypeToken<List<ProPlayerObj>>() {}.getType();
        List<ProPlayerObj> favorites = new Gson().fromJson(json, type);

        for (ProPlayerObj player : favorites) {
            if (player.getAccountId() == accountId) {
                return true;
            }
        }
        return false;
    }

    public static List<ProPlayerObj> getListFavorite(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(KEY_FAVORITES, "[]");
        Type type = new TypeToken<List<ProPlayerObj>>() {}.getType();
        return new Gson().fromJson(json, type);
    }
}
