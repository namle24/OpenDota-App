package vn.edu.usth.opendota.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String getLobbyTypeNameById(int id) {
        String name = "";
        switch (id){
            case 1:
                name="practice";
                break;
            case 2:
                name="tournament";
                break;
            case 3:
                name="tutorial";
                break;
            case 4:
                name="coop_bots";
                break;
            case 5:
                name="ranked_team_mm";
                break;
            case 6:
                name="ranked_solo_mm";
                break;
            case 7:
                name="ranked";
                break;
            case 8:
                name="1v1_mid";
                break;
            case 9:
                name="battle_cup";
                break;
            case 10:
                name="local_bots";
                break;
            case 11:
                name="spectator";
                break;
            case 12:
                name="event";
                break;
            case 13:
                name="gauntlet";
                break;
            case 14:
                name="new_player";
                break; 
            case 15:
                name="featured";
                break;
            default :
                name="normal";
                break;
        }
        return name;

    }
    public static String getGameModeNameById(int id) {
        String name = "";
        switch (id) {
            case 1:
                name = "all_pick";
                break;
            case 2:
                name = "captains_mode";
                break;
            case 3:
                name = "random_draft";
                break;
            case 4:
                name = "single_draft";
                break;
            case 5:
                name = "all_random";
                break;
            case 6:
                name = "intro";
                break;
            case 7:
                name = "diretide";
                break;
            case 8:
                name = "reverse_captains_mode";
                break;
            case 9:
                name = "greeviling";
                break;
            case 10:
                name = "tutorial";
                break;
            case 11:
                name = "mid_only";
                break;
            case 12:
                name = "least_played";
                break;
            case 13:
                name = "limited_heroes";
                break;
            case 14:
                name = "compendium_matchmaking";
                break;
            case 15:
                name = "custom";
                break;
            case 16:
                name = "captains_draft";
                break;
            case 17:
                name = "balanced_draft";
                break;
            case 18:
                name = "ability_draft";
                break;
            case 19:
                name = "event";
                break;
            case 20:
                name = "all_random_death_match";
                break;
            case 21:
                name = "1v1_mid";
                break;
            case 22:
                name = "all_draft";
                break;
            case 23:
                name = "turbo";
                break;
            case 24:
                name = "mutation";
                break;
            case 25:
                name = "coaches_challenge";
                break;
            default:
                name = "Unknown";
                break;

        }

        return name;
    }

    public static String getDateByTimeStamp(long timeStamp) {
        try{
            Date date = new Date(timeStamp*1000);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(date);
        }catch (Exception e){
            return "unknown";
        }
    }

    public static String getDurationStr(int duration) {
        return "" + duration / 60 + ":" + duration % 60;
    }
}
