package vn.edu.usth.opendota.utils;

import vn.edu.usth.opendota.R;

public class Db {

    public static String getLobbyTypeNameById(int id) {
        switch (id) {
            case 1:
                return "practice";
            case 2:
                return "tournament";
            case 3:
                return "tutorial";
            case 4:
                return "coop bots";
            case 5:
                return "ranked team mm";
            case 6:
                return "ranked solo mm";
            case 7:
                return "ranked";
            case 8:
                return "1v1 mid";
            case 9:
                return "battle cup";
            case 10:
                return "local bots";
            case 11:
                return "spectator";
            case 12:
                return "event";
            case 13:
                return "gauntlet";
            case 14:
                return "new_player";
            case 15:
                return "featured";
            default:
                return "normal";
        }
    }

    public static String getGameModeNameById(int id) {
        switch (id) {
            case 1:
                return "All pick";
            case 2:
                return "Captains mode";
            case 3:
                return "Random draft";
            case 4:
                return "Single draft";
            case 5:
                return "All random";
            case 6:
                return "Intro";
            case 7:
                return "Diretide";
            case 8:
                return "Reverse captains mode";
            case 9:
                return "Greeviling";
            case 10:
                return "Tutorial";
            case 11:
                return "Mid only";
            case 12:
                return "Least played";
            case 13:
                return "Limited heroes";
            case 14:
                return "Compendium matchmaking";
            case 15:
                return "Custom";
            case 16:
                return "Captains draft";
            case 17:
                return "Balanced draft";
            case 18:
                return "Ability draft";
            case 19:
                return "event";
            case 20:
                return "All random death match";
            case 21:
                return "1v1 mid";
            case 22:
                return "All draft";
            case 23:
                return "Turbo";
            case 24:
                return "Mutation";
            case 25:
                return "Coaches challenge";
            default:
                return "Unknown";
        }
    }

    public static String getHeroNameByID(int id) {
        if (id == 1) return "antimage";
        else if (id == 2) return "axe";
        else if (id == 3) return "bane";
        else if (id == 4) return "bloodseeker";
        else if (id == 5) return "crystal_maiden";
        else if (id == 6) return "drow_ranger";
        else if (id == 7) return "earthshaker";
        else if (id == 8) return "juggernaut";
        else if (id == 9) return "mirana";
        else if (id == 10) return "morphling";
        else if (id == 11) return "nevermore";
        else if (id == 12) return "phantom_lancer";
        else if (id == 13) return "puck";
        else if (id == 14) return "pudge";
        else if (id == 15) return "razor";
        else if (id == 16) return "sand_king";
        else if (id == 17) return "storm_spirit";
        else if (id == 18) return "sven";
        else if (id == 19) return "tiny";
        else if (id == 20) return "vengefulspirit";
        else if (id == 21) return "windrunner";
        else if (id == 22) return "zuus";
        else if (id == 23) return "kunkka";
        else if (id == 25) return "lina";
        else if (id == 26) return "lion";
        else if (id == 27) return "shadow_shaman";
        else if (id == 28) return "slardar";
        else if (id == 29) return "tidehunter";
        else if (id == 30) return "witch_doctor";
        else if (id == 31) return "lich";
        else if (id == 32) return "riki";
        else if (id == 33) return "enigma";
        else if (id == 34) return "tinker";
        else if (id == 35) return "sniper";
        else if (id == 36) return "necrolyte";
        else if (id == 37) return "warlock";
        else if (id == 38) return "beastmaster";
        else if (id == 39) return "queenofpain";
        else if (id == 40) return "venomancer";
        else if (id == 41) return "faceless_void";
        else if (id == 42) return "skeleton_king";
        else if (id == 43) return "death_prophet";
        else if (id == 44) return "phantom_assassin";
        else if (id == 45) return "pugna";
        else if (id == 46) return "templar_assassin";
        else if (id == 47) return "viper";
        else if (id == 48) return "luna";
        else if (id == 49) return "dragon_knight";
        else if (id == 50) return "dazzle";
        else if (id == 51) return "rattletrap";
        else if (id == 52) return "leshrac";
        else if (id == 53) return "furion";
        else if (id == 54) return "life_stealer";
        else if (id == 55) return "dark_seer";
        else if (id == 56) return "clinkz";
        else if (id == 57) return "omniknight";
        else if (id == 58) return "enchantress";
        else if (id == 59) return "huskar";
        else if (id == 60) return "night_stalker";
        else if (id == 61) return "broodmother";
        else if (id == 62) return "bounty_hunter";
        else if (id == 63) return "weaver";
        else if (id == 64) return "jakiro";
        else if (id == 65) return "batrider";
        else if (id == 66) return "chen";
        else if (id == 67) return "spectre";
        else if (id == 68) return "ancient_apparition";
        else if (id == 69) return "doom_bringer";
        else if (id == 70) return "ursa";
        else if (id == 71) return "spirit_breaker";
        else if (id == 72) return "gyrocopter";
        else if (id == 73) return "alchemist";
        else if (id == 74) return "invoker";
        else if (id == 75) return "silencer";
        else if (id == 76) return "obsidian_destroyer";
        else if (id == 77) return "lycan";
        else if (id == 78) return "brewmaster";
        else if (id == 79) return "shadow_demon";
        else if (id == 80) return "lone_druid";
        else if (id == 81) return "chaos_knight";
        else if (id == 82) return "meepo";
        else if (id == 83) return "treant";
        else if (id == 84) return "ogre_magi";
        else if (id == 85) return "undying";
        else if (id == 86) return "rubick";
        else if (id == 87) return "disruptor";
        else if (id == 88) return "nyx_assassin";
        else if (id == 89) return "naga_siren";
        else if (id == 90) return "keeper_of_the_light";
        else if (id == 91) return "wisp";
        else if (id == 92) return "visage";
        else if (id == 93) return "slark";
        else if (id == 94) return "medusa";
        else if (id == 95) return "troll_warlord";
        else if (id == 96) return "centaur";
        else if (id == 97) return "magnataur";
        else if (id == 98) return "shredder";
        else if (id == 99) return "bristleback";
        else if (id == 100) return "tusk";
        else if (id == 101) return "skywrath_mage";
        else if (id == 102) return "abaddon";
        else if (id == 103) return "elder_titan";
        else if (id == 104) return "legion_commander";
        else if (id == 105) return "techies";
        else if (id == 106) return "ember_spirit";
        else if (id == 107) return "earth_spirit";
        else if (id == 108) return "abyssal_underlord";
        else if (id == 109) return "terrorblade";
        else if (id == 110) return "phoenix";
        else if (id == 111) return "oracle";
        else if (id == 112) return "winter_wyvern";
        else if (id == 113) return "arc_warden";
        else if (id == 114) return "monkey_king";
        else if (id == 119) return "dark_willow";
        else if (id == 120) return "pangolier";
        else if (id == 121) return "grimstroke";
        else if (id == 123) return "hoodwink";
        else if (id == 126) return "void_spirit";
        else if (id == 128) return "snapfire";
        else if (id == 129) return "mars";
        else if (id == 131) return "ringmaster";
        else if (id == 135) return "dawnbreaker";
        else if (id == 136) return "marci";
        else if (id == 137) return "primal_beast";
        else if (id == 138) return "muerta";
        else return "Unknown Hero";
    }

    public static String getLocalizedNameByID(int id) {
        if (id == 1) return "Anti-Mage";
        else if (id == 2) return "Axe";
        else if (id == 3) return "Bane";
        else if (id == 4) return "Bloodseeker";
        else if (id == 5) return "Crystal Maiden";
        else if (id == 6) return "Drow Ranger";
        else if (id == 7) return "Earthshaker";
        else if (id == 8) return "Juggernaut";
        else if (id == 9) return "Mirana";
        else if (id == 10) return "Morphling";
        else if (id == 11) return "Shadow Fiend";
        else if (id == 12) return "Phantom Lancer";
        else if (id == 13) return "Puck";
        else if (id == 14) return "Pudge";
        else if (id == 15) return "Razor";
        else if (id == 16) return "Sand King";
        else if (id == 17) return "Storm Spirit";
        else if (id == 18) return "Sven";
        else if (id == 19) return "Tiny";
        else if (id == 20) return "Vengeful Spirit";
        else if (id == 21) return "Windranger";
        else if (id == 22) return "Zeus";
        else if (id == 23) return "Kunkka";
        else if (id == 25) return "Lina";
        else if (id == 26) return "Lion";
        else if (id == 27) return "Shadow Shaman";
        else if (id == 28) return "Slardar";
        else if (id == 29) return "Tidehunter";
        else if (id == 30) return "Witch Doctor";
        else if (id == 31) return "Lich";
        else if (id == 32) return "Riki";
        else if (id == 33) return "Enigma";
        else if (id == 34) return "Tinker";
        else if (id == 35) return "Sniper";
        else if (id == 36) return "Necrophos";
        else if (id == 37) return "Warlock";
        else if (id == 38) return "Beastmaster";
        else if (id == 39) return "Queen of Pain";
        else if (id == 40) return "Venomancer";
        else if (id == 41) return "Faceless Void";
        else if (id == 42) return "Wraith King";
        else if (id == 43) return "Death Prophet";
        else if (id == 44) return "Phantom Assassin";
        else if (id == 45) return "Pugna";
        else if (id == 46) return "Templar Assassin";
        else if (id == 47) return "Viper";
        else if (id == 48) return "Luna";
        else if (id == 49) return "Dragon Knight";
        else if (id == 50) return "Dazzle";
        else if (id == 51) return "Clockwerk";
        else if (id == 52) return "Leshrac";
        else if (id == 53) return "Nature's Prophet";
        else if (id == 54) return "Lifestealer";
        else if (id == 55) return "Dark Seer";
        else if (id == 56) return "Clinkz";
        else if (id == 57) return "Omniknight";
        else if (id == 58) return "Enchantress";
        else if (id == 59) return "Huskar";
        else if (id == 60) return "Night Stalker";
        else if (id == 61) return "Broodmother";
        else if (id == 62) return "Bounty Hunter";
        else if (id == 63) return "Weaver";
        else if (id == 64) return "Jakiro";
        else if (id == 65) return "Batrider";
        else if (id == 66) return "Chen";
        else if (id == 67) return "Spectre";
        else if (id == 68) return "Ancient Apparition";
        else if (id == 69) return "Doom";
        else if (id == 70) return "Ursa";
        else if (id == 71) return "Spirit Breaker";
        else if (id == 72) return "Gyrocopter";
        else if (id == 73) return "Alchemist";
        else if (id == 74) return "Invoker";
        else if (id == 75) return "Silencer";
        else if (id == 76) return "Outworld Destroyer";
        else if (id == 77) return "Lycan";
        else if (id == 78) return "Brewmaster";
        else if (id == 79) return "Shadow Demon";
        else if (id == 80) return "Lone Druid";
        else if (id == 81) return "Chaos Knight";
        else if (id == 82) return "Meepo";
        else if (id == 83) return "Treant Protector";
        else if (id == 84) return "Ogre Magi";
        else if (id == 85) return "Undying";
        else if (id == 86) return "Rubick";
        else if (id == 87) return "Disruptor";
        else if (id == 88) return "Nyx Assassin";
        else if (id == 89) return "Naga Siren";
        else if (id == 90) return "Keeper of the Light";
        else if (id == 91) return "Io";
        else if (id == 92) return "Visage";
        else if (id == 93) return "Slark";
        else if (id == 94) return "Medusa";
        else if (id == 95) return "Troll Warlord";
        else if (id == 96) return "Centaur Warrunner";
        else if (id == 97) return "Magnus";
        else if (id == 98) return "Timbersaw";
        else if (id == 99) return "Bristleback";
        else if (id == 100) return "Tusk";
        else if (id == 101) return "Skywrath Mage";
        else if (id == 102) return "Abaddon";
        else if (id == 103) return "Elder Titan";
        else if (id == 104) return "Legion Commander";
        else if (id == 105) return "Techies";
        else if (id == 106) return "Ember Spirit";
        else if (id == 107) return "Earth Spirit";
        else if (id == 108) return "Underlord";
        else if (id == 109) return "Terrorblade";
        else if (id == 110) return "Phoenix";
        else if (id == 111) return "Oracle";
        else if (id == 112) return "Winter Wyvern";
        else if (id == 113) return "Arc Warden";
        else if (id == 114) return "Monkey King";
        else if (id == 119) return "Dark Willow";
        else if (id == 120) return "Pangolier";
        else if (id == 121) return "Grimstroke";
        else if (id == 123) return "Hoodwink";
        else if (id == 126) return "Void Spirit";
        else if (id == 128) return "Snapfire";
        else if (id == 129) return "Mars";
        else if (id == 131) return "Ringmaster";
        else if (id == 135) return "Dawnbreaker";
        else if (id == 136) return "Marci";
        else if (id == 137) return "Primal Beast";
        else if (id == 138) return "Muerta";
        else return "Unknown Hero";
    }

    public static int getRankDrawableId(int rankTier) {
        if (rankTier >= 11 && rankTier <= 15) {
            return R.drawable.rank_icon_1;
        } else if (rankTier >= 21 && rankTier <= 25) {
            return R.drawable.rank_icon_2;
        } else if (rankTier >= 31 && rankTier <= 35) {
            return R.drawable.rank_icon_3;
        } else if (rankTier >= 41 && rankTier <= 45) {
            return R.drawable.rank_icon_4;
        } else if (rankTier >= 51 && rankTier <= 55) {
            return R.drawable.rank_icon_5;
        } else if (rankTier >= 61 && rankTier <= 65) {
            return R.drawable.rank_icon_6;
        } else if (rankTier >= 71 && rankTier <= 75) {
            return R.drawable.rank_icon_7;
        } else if (rankTier == 80) {
            return R.drawable.rank_icon_8;
        } else {
            return R.drawable.rank_icon_0;
        }
    }
}