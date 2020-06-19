package com;

public class ValueTranslator {

    static String classNames(int input){
        switch (input){
            case 2: return "Druid";
            case 3: return "Hunter";
            case 4: return "Mage";
            case 5: return "Paladin";
            case 6: return "Priest";
            case 7: return "Rogue";
            case 8: return "Shaman";
            case 9: return "Warlock";
            case 10: return "Warrior";
            case 12: return "Neutral";
            case 14: return "Demon Hunter";
            default: return "NoClass";
        }
    }

    static String keywordName(int input){
        switch (input){
            case 1: return "Taunt";
            case 2: return "Spell Power";
            case 3: return "Divine Shield";
            case 4: return "Charge";
            case 5: return "Secret";
            case 6: return "Stealth";
            case 8: return "Battlecry";
            case 10: return "Freeze";
            case 11: return "Windfury";
            case 12: return "Deathratle";
            case 13: return "Combo";
            case 14: return "Overload";
            case 15: return "Silence";
            case 16: return "Counter";
            case 17: return "Immune";
            case 20: return "Inspire";
            case 21: return "Discover";
            case 31: return "Quest";
            case 32: return "Poisonous";
            case 34: return "Adapt";
            case 38: return "Lifesteal";
            case 39: return "Recruit";
            case 52: return "Echo";
            case 53: return "Rush";
            case 61: return "Overkill";
            case 66: return "Magnetic";
            case 71: return "Lackey";
            case 76: return "Twinspell";
            case 77: return "Mega Windfury";
            case 78: return "Reborn";
            case 86: return "Outcast";
            default: return "Invoke";

        }
    }

    static String cardSetName(int input){
        switch (input){
            case 1463: return "Demon Hunter Initiate";
            case 1414: return "Ashes of Outland";
            case 1403: return "Galakronds Awakening";
            case 1347: return "Descent of Dragons";
            case 1158: return "Saviors of Uldum";
            case 1130: return "Rise of Shadows";
            case 1129: return "Ratakhans Rumble";
            case 1127: return "The Boomsday Project";
            case 1125: return "The Witchwood";
            case 1004: return "Kobolds and Catacombs";
            case 1001: return "Knights of the Frozen Throne";
            case 27: return "Journey to Un'Goro";
            case 25: return "Mean Streets of Gadgetzan";
            case 23: return "One Night in Karazhan";
            case 21: return "Whispers of the Old Gods";
            case 20: return "League of Explorers";
            case 15: return "The Grand Tournament";
            case 14: return "Blackrock Mountain";
            case 13: return "Goblins vs Gnomes";
            case 12: return "Curse of Naxxramas";
            case 2: return "Basic";
            case 3: return "Classic";
            case 4: return "Hall of Fame";
            default: return "noSet";
        }
    }

    static String rarityName(int rarity){
        switch (rarity){
            case 0: return "No Rarity";
            case 1: return "Common";
            case 2: return "Free";
            case 3: return "Rare";
            case 4: return "Epic";
            case 5: return "Legendary";
            default: return "All Minions";

        }
    }

    static String minionType(int type){
        switch (type){
            case 0: return "All Minions";
            case 14: return "Murloc";
            case 15: return "Demon";
            case 17: return "Mech";
            case 18: return "Elemental";
            case 20: return "Beast";
            case 21: return "Totem";
            case 23: return "Pirate";
            case 24: return "Dragon";
            default: return "No Subtype";
        }
    }

    static String cardTypeName(int input){
        switch (input){
            case 3: return "Hero";
            case 4: return "Minion";
            case 5: return "Spell";
            case 7: return "Weapon";
            case 10: return "HeroPower";
            default:return "noType";
        }
    }


}
