package vn.edu.usth.opendota.utils;

public class Db {

    public static String getHeroNameByID(int id) {
        switch (id) {
            case 1:
                return "antimage";
            case 2:
                return "axe";
            case 3:
                return "bane";
            case 4:
                return "bloodseeker";
            case 5:
                return "crystal_maiden";
            case 6:
                return "drow_ranger";
            case 7:
                return "earthshaker";
            case 8:
                return "juggernaut";
            case 9:
                return "mirana";
            case 10:
                return "morphling";
            case 11:
                return "nevermore";
            case 12:
                return "phantom_lancer";
            case 13:
                return "puck";
            case 14:
                return "pudge";
            case 15:
                return "razor";
            case 16:
                return "sand_king";
            case 17:
                return "storm_spirit";
            case 18:
                return "sven";
            case 19:
                return "tiny";
            case 20:
                return "vengefulspirit";
            case 21:
                return "windrunner";
            case 22:
                return "zuus";
            case 23:
                return "kunkka";
            case 25:
                return "lina";
            case 26:
                return "lion";
            case 27:
                return "shadow_shaman";
            case 28:
                return "slardar";
            case 29:
                return "tidehunter";
            case 30:
                return "witch_doctor";
            case 32:
                return "riki";
            case 33:
                return "enigma";
            case 34:
                return "tinker";
            case 35:
                return "sniper";
            case 36:
                return "necrolyte";
            case 37:
                return "warlock";
            case 38:
                return "beastmaster";
            case 39:
                return "queenofpain";
            case 40:
                return "venomancer";
            case 41:
                return "faceless_void";
            case 42:
                return "skeleton_king";
            case 43:
                return "death_prophet";
            case 44:
                return "phantom_assassin";
            case 45:
                return "pugna";
            case 46:
                return "templar_assassin";
            case 47:
                return "viper";
            case 48:
                return "luna";
            case 49:
                return "dragon_knight";
            case 50:
                return "dazzle";
            case 51:
                return "rattletrap";
            case 52:
                return "leshrac";
            case 53:
                return "furion";
            case 54:
                return "life_stealer";
            case 55:
                return "dark_seer";
            case 56:
                return "clinkz";
            case 57:
                return "omniknight";
            case 58:
                return "enchantress";
            case 59:
                return "huskar";
            case 60:
                return "night_stalker";
            case 61:
                return "broodmother";
            case 62:
                return "bounty_hunter";
            case 63:
                return "weaver";
            case 64:
                return "jakiro";
            case 65:
                return "batrider";
            case 66:
                return "chen";
            case 67:
                return "spectre";
            case 68:
                return "ancient_apparition";
            case 69:
                return "ursa";
            case 70:
                return "spirit_breaker";
            case 71:
                return "gyrocopter";
            case 72:
                return "alchemist";
            case 73:
                return "invoker";
            case 74:
                return "silencer";
            case 75:
                return "obsidian_destroyer";
            case 76:
                return "lycan";
            case 77:
                return "brewmaster";
            case 78:
                return "shadow_demon";
            case 79:
                return "lone_druid";
            case 80:
                return "chaos_knight";
            case 81:
                return "meepo";
            case 82:
                return "treant";
            case 83:
                return "ogre_magi";
            case 84:
                return "undying";
            case 85:
                return "rubick";
            case 86:
                return "disruptor";
            case 87:
                return "nyx_assassin";
            case 88:
                return "naga_siren";
            case 89:
                return "keeper_of_the_light";
            case 90:
                return "wisp";
            case 91:
                return "visage";
            case 92:
                return "slark";
            case 93:
                return "medusa";
            case 94:
                return "troll_warlord";
            case 95:
                return "centaur";
            case 96:
                return "magnataur";
            case 97:
                return "shredder";
            case 98:
                return "bristleback";
            case 99:
                return "tusk";
            case 100:
                return "skywrath_mage";
            case 101:
                return "abaddon";
            case 102:
                return "elder_titan";
            case 103:
                return "legion_commander";
            case 104:
                return "ember_spirit";
            case 106:
                return "earth_spirit";
            case 107:
                return "abyssal_underlord";
            case 108:
                return "terrorblade";
            case 109:
                return "phoenix";
            case 110:
                return "techies";
            case 111:
                return "oracle";
            case 112:
                return "winter_wyvern";
            case 113:
                return "npc_dota_hero_arc_warden";
            case 114:
                return "monkey_king";
            case 119:
                return "dark_willow";
            case 120:
                return "pangolier";
            case 121:
                return "grimstroke";
            case 123:
                return "hoodwink";
            case 126:
                return "void_spirit";
            case 128:
                return "snapfire";
            case 129:
                return "mars";
            case 135:
                return "dawnbreaker";
            case 136:
                return "marci";
            case 137:
                return "primal_beast";
            case 138:
                return "muerta";
            default:
                return "Unknown Hero";
        }
    }

    public static String getLocalizedNameByID(int id) {
        switch (id) {
            case 1:
                return "Anti-Mage";
            case 2:
                return "Axe";
            case 3:
                return "Bane";
            case 4:
                return "Bloodseeker";
            case 5:
                return "Crystal Maiden";
            case 6:
                return "Drow Ranger";
            case 7:
                return "Earthshaker";
            case 8:
                return "Juggernaut";
            case 9:
                return "Mirana";
            case 10:
                return "Morphling";
            case 11:
                return "Shadow Fiend";
            case 12:
                return "Phantom Lancer";
            case 13:
                return "Puck";
            case 14:
                return "Pudge";
            case 15:
                return "Razor";
            case 16:
                return "Sand King";
            case 17:
                return "Storm Spirit";
            case 18:
                return "Sven";
            case 19:
                return "Tiny";
            case 20:
                return "Vengeful Spirit";
            case 21:
                return "Windranger";
            case 22:
                return "Zeus";
            case 23:
                return "Kunkka";
            case 25:
                return "Lina";
            case 26:
                return "Lion";
            case 27:
                return "Shadow Shaman";
            case 28:
                return "Slardar";
            case 29:
                return "Tidehunter";
            case 30:
                return "Witch Doctor";
            case 32:
                return "Riki";
            case 33:
                return "Enigma";
            case 34:
                return "Tinker";
            case 35:
                return "Sniper";
            case 36:
                return "Necrophos";
            case 37:
                return "Warlock";
            case 38:
                return "Beastmaster";
            case 39:
                return "Queen of Pain";
            case 40:
                return "Venomancer";
            case 41:
                return "Faceless Void";
            case 42:
                return "Wraith King";
            case 43:
                return "Death Prophet";
            case 44:
                return "Phantom Assassin";
            case 45:
                return "Pugna";
            case 46:
                return "Templar Assassin";
            case 47:
                return "Viper";
            case 48:
                return "Luna";
            case 49:
                return "Dragon Knight";
            case 50:
                return "Dazzle";
            case 51:
                return "Clockwerk";
            case 52:
                return "Leshrac";
            case 53:
                return "Nature's Prophet";
            case 54:
                return "Lifestealer";
            case 55:
                return "Dark Seer";
            case 56:
                return "Clinkz";
            case 57:
                return "Omniknight";
            case 58:
                return "Enchantress";
            case 59:
                return "Huskar";
            case 60:
                return "Night Stalker";
            case 61:
                return "Broodmother";
            case 62:
                return "Bounty Hunter";
            case 63:
                return "Weaver";
            case 64:
                return "Jakiro";
            case 65:
                return "Batrider";
            case 66:
                return "Chen";
            case 67:
                return "Spectre";
            case 68:
                return "Ancient Apparition";
            case 69:
                return "Ursa";
            case 70:
                return "Spirit Breaker";
            case 71:
                return "Gyrocopter";
            case 72:
                return "Alchemist";
            case 73:
                return "Invoker";
            case 74:
                return "Silencer";
            case 75:
                return "Outworld Destroyer";
            case 76:
                return "Lycan";
            case 77:
                return "Brewmaster";
            case 78:
                return "Shadow Demon";
            case 79:
                return "Lone Druid";
            case 80:
                return "Chaos Knight";
            case 81:
                return "Meepo";
            case 82:
                return "Treant Protector";
            case 83:
                return "Ogre Magi";
            case 84:
                return "Undying";
            case 85:
                return "Rubick";
            case 86:
                return "Disruptor";
            case 87:
                return "Nyx Assassin";
            case 88:
                return "Naga Siren";
            case 89:
                return "Keeper of the Light";
            case 90:
                return "Io";
            case 91:
                return "Visage";
            case 92:
                return "Slark";
            case 93:
                return "Medusa";
            case 94:
                return "Troll Warlord";
            case 95:
                return "Centaur Warrunner";
            case 96:
                return "Magnus";
            case 97:
                return "Timbersaw";
            case 98:
                return "Bristleback";
            case 99:
                return "Tusk";
            case 100:
                return "Skywrath Mage";
            case 101:
                return "Abaddon";
            case 102:
                return "Elder Titan";
            case 103:
                return "Legion Commander";
            case 104:
                return "Ember Spirit";
            case 106:
                return "Earth Spirit";
            case 107:
                return "Underlord";
            case 108:
                return "Terrorblade";
            case 109:
                return "Phoenix";
            case 110:
                return "Techies";
            case 111:
                return "Oracle";
            case 112:
                return "Winter Wyvern";
            case 113:
                return "Arc Warden";
            case 114:
                return "Monkey King";
            case 119:
                return "Dark Willow";
            case 120:
                return "Pangolier";
            case 121:
                return "Grimstroke";
            case 123:
                return "Hoodwink";
            case 126:
                return "Void Spirit";
            case 128:
                return "Snapfire";
            case 129:
                return "Mars";
            case 135:
                return "Dawnbreaker";
            case 136:
                return "Marci";
            case 137:
                return "Primal Beast";
            case 138:
                return "Muerta";
            default:
                return "Unknown Hero";
        }
    }


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

}