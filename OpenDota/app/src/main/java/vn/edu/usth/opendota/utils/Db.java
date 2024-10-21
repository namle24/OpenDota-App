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
        String[] heroNames = {
                "Unknown Hero", // 0
                "antimage", // 1
                "axe", // 2
                "bane", // 3
                "bloodseeker", // 4
                "crystal_maiden", // 5
                "drow_ranger", // 6
                "earthshaker", // 7
                "juggernaut", // 8
                "mirana", // 9
                "morphling", // 10
                "nevermore", // 11
                "phantom_lancer", // 12
                "puck", // 13
                "pudge", // 14
                "razor", // 15
                "sand_king", // 16
                "storm_spirit", // 17
                "sven", // 18
                "tiny", // 19
                "vengefulspirit", // 20
                "windrunner", // 21
                "zuus", // 22
                "kunkka", // 23
                "", // 24
                "lina", // 25
                "lion", // 26
                "shadow_shaman", // 27
                "slardar", // 28
                "tidehunter", // 29
                "witch_doctor", // 30
                "lich", // 31
                "riki", // 32
                "enigma", // 33
                "tinker", // 34
                "sniper", // 35
                "necrolyte", // 36
                "warlock", // 37
                "beastmaster", // 38
                "queenofpain", // 39
                "venomancer", // 40
                "faceless_void", // 41
                "skeleton_king", // 42
                "death_prophet", // 43
                "phantom_assassin", // 44
                "pugna", // 45
                "templar_assassin", // 46
                "viper", // 47
                "luna", // 48
                "dragon_knight", // 49
                "dazzle", // 50
                "rattletrap", // 51
                "leshrac", // 52
                "furion", // 53
                "life_stealer", // 54
                "dark_seer", // 55
                "clinkz", // 56
                "omniknight", // 57
                "enchantress", // 58
                "huskar", // 59
                "night_stalker", // 60
                "broodmother", // 61
                "bounty_hunter", // 62
                "weaver", // 63
                "jakiro", // 64
                "batrider", // 65
                "chen", // 66
                "spectre", // 67
                "ancient_apparition", // 68
                "doom_bringer", // 69
                "ursa", // 70
                "spirit_breaker", // 71
                "gyrocopter", // 72
                "alchemist", // 73
                "invoker", // 74
                "silencer", // 75
                "obsidian_destroyer", // 76
                "lycan", // 77
                "brewmaster", // 78
                "shadow_demon", // 79
                "lone_druid", // 80
                "chaos_knight", // 81
                "meepo", // 82
                "treant", // 83
                "ogre_magi", // 84
                "undying", // 85
                "rubick", // 86
                "disruptor", // 87
                "nyx_assassin", // 88
                "naga_siren", // 89
                "keeper_of_the_light", // 90
                "wisp", // 91
                "visage", // 92
                "slark", // 93
                "medusa", // 94
                "troll_warlord", // 95
                "centaur", // 96
                "magnataur", // 97
                "shredder", // 98
                "bristleback", // 99
                "tusk", // 100
                "skywrath_mage", // 101
                "abaddon", // 102
                "elder_titan", // 103
                "legion_commander", // 104
                "techies", // 105
                "ember_spirit", // 106
                "earth_spirit", // 107
                "abyssal_underlord", // 108
                "terrorblade", // 109
                "phoenix", // 110
                "oracle", // 111
                "winter_wyvern", // 112
                "arc_warden", // 113
                "monkey_king", // 114
                "", // 115
                "dark_willow", // 119
                "pangolier", // 120
                "grimstroke", // 121
                "", // 122
                "hoodwink", // 123
                "", // 124
                "", // 125
                "void_spirit", // 126
                "snapfire", // 128
                "mars", // 129
                "", // 130
                "ringmaster", // 131
                "", // 132
                "", // 133
                "", // 134
                "dawnbreaker", // 135
                "marci", // 136
                "primal_beast", // 137
                "muerta" // 138
        };

        if (id < 0 || id >= heroNames.length) {
            return heroNames[0];
        }
        return heroNames[id];
    }

    public static String getLocalizedNameByID(int id) {
        String[] localizedHeroNames = {
                "Unknown Hero", // 0
                "Anti-Mage", // 1
                "Axe", // 2
                "Bane", // 3
                "Bloodseeker", // 4
                "Crystal Maiden", // 5
                "Drow Ranger", // 6
                "Earthshaker", // 7
                "Juggernaut", // 8
                "Mirana", // 9
                "Morphling", // 10
                "Shadow Fiend", // 11
                "Phantom Lancer", // 12
                "Puck", // 13
                "Pudge", // 14
                "Razor", // 15
                "Sand King", // 16
                "Storm Spirit", // 17
                "Sven", // 18
                "Tiny", // 19
                "Vengeful Spirit", // 20
                "Windranger", // 21
                "Zeus", // 22
                "Kunkka", // 23
                "", // 24
                "Lina", // 25
                "Lion", // 26
                "Shadow Shaman", // 27
                "Slardar", // 28
                "Tidehunter", // 29
                "Witch Doctor", // 30
                "Lich", // 31
                "Riki", // 32
                "Enigma", // 33
                "Tinker", // 34
                "Sniper", // 35
                "Necrophos", // 36
                "Warlock", // 37
                "Beastmaster", // 38
                "Queen of Pain", // 39
                "Venomancer", // 40
                "Faceless Void", // 41
                "Wraith King", // 42
                "Death Prophet", // 43
                "Phantom Assassin", // 44
                "Pugna", // 45
                "Templar Assassin", // 46
                "Viper", // 47
                "Luna", // 48
                "Dragon Knight", // 49
                "Dazzle", // 50
                "Clockwerk", // 51
                "Leshrac", // 52
                "Nature's Prophet", // 53
                "Lifestealer", // 54
                "Dark Seer", // 55
                "Clinkz", // 56
                "Omniknight", // 57
                "Enchantress", // 58
                "Huskar", // 59
                "Night Stalker", // 60
                "Broodmother", // 61
                "Bounty Hunter", // 62
                "Weaver", // 63
                "Jakiro", // 64
                "Batrider", // 65
                "Chen", // 66
                "Spectre", // 67
                "Ancient Apparition", // 68
                "Doom Bringer", // 69
                "Ursa", // 70
                "Spirit Breaker", // 71
                "Gyrocopter", // 72
                "Alchemist", // 73
                "Invoker", // 74
                "Silencer", // 75
                "Obsidian Destroyer", // 76
                "Lycan", // 77
                "Brewmaster", // 78
                "Shadow Demon", // 79
                "Lone Druid", // 80
                "Chaos Knight", // 81
                "Meepo", // 82
                "Treant Protector", // 83
                "Ogre Magi", // 84
                "Undying", // 85
                "Rubick", // 86
                "Disruptor", // 87
                "Nyx Assassin", // 88
                "Naga Siren", // 89
                "Keeper of the Light", // 90
                "Wisp", // 91
                "Visage", // 92
                "Slark", // 93
                "Medusa", // 94
                "Troll Warlord", // 95
                "Centaur Warrunner", // 96
                "Magnus", // 97
                "Timbersaw", // 98
                "Bristleback", // 99
                "Tusk", // 100
                "Skywrath Mage", // 101
                "Abaddon", // 102
                "Elder Titan", // 103
                "Legion Commander", // 104
                "Techies", // 105
                "Ember Spirit", // 106
                "Earth Spirit", // 107
                "Abyssal Underlord", // 108
                "Terrorblade", // 109
                "Phoenix", // 110
                "Oracle", // 111
                "Winter Wyvern", // 112
                "Arc Warden", // 113
                "Monkey King", // 114
                "", // 115
                "Dark Willow", // 119
                "Pangolier", // 120
                "Grimstroke", // 121
                "", // 122
                "Hoodwink", // 123
                "", // 124
                "", // 125
                "Void Spirit", // 126
                "Snapfire", // 128
                "Mars", // 129
                "", // 130
                "Ringmaster", // 131
                "", // 132
                "", // 133
                "", // 134
                "Dawnbreaker", // 135
                "Marci", // 136
                "Primal Beast", // 137
                "Muerta" // 138
        };

        if (id < 0 || id >= localizedHeroNames.length) {
            return localizedHeroNames[0];
        }
        return localizedHeroNames[id];
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
