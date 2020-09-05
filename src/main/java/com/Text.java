package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    protected final ObjectMapper mapper = new ObjectMapper();
    protected String input;

    List<String> random = Arrays.asList("is",  "that", "back", "by", "copies", "effects", "effect",
            "starting", "awesome", "invention", "chance", "at", "chord", "can", "doesnt", "always");

    List<String> wordNum = Arrays.asList("one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "third", "twice", "first");

    List<String> minionType = Arrays.asList("murloc", "demon", "mech", "elemental", "beast",
            "totem", "pirate", "dragon", "dragon");

    List<String> tokens = Arrays.asList("squirrel", "spirit wolve", "treant", "felwing", "bee", "loti's", "dryad",
            "raptor", "sapling", "bruiser", "gaurdian", "cat", "bear", "rat", "lynx", "wolves", "hyena", "webspinner",
            "locust", "goblin bomb","scarab", "satyr", "sandwasp", "microcopter", "truesilver champion", "mithril golem",
            "boom bot", "jo-e bot", "spider", "wisp", "pterrordaxe", "pogo hopper", "razorpetal", "direhorn", "boar",
            "muckling", "plate", "mech", "grub", "leper gnome", "whelp", "tentacle", "silver hand recruits", "runt",
            "microbot", "bat", "hat");

    List<String> classNames = Arrays.asList("druid", "hunter", "mage", "paladin", "priest", "rogue",
            "shaman", "warlock", "warrior", "demon hunter", "death knight");

    List<String> condition = Arrays.asList("during", "unless", "has", "have no", "after", "if", "else", "until", "whenever", "whomever", "while",
            "can't", "cant", "can", "may", "last", "takes", "when", "every", "already", "non", "than", "no");

    List<String> states = Arrays.asList("in", "holding", "damaged", "dead", "attacked", "undamaged", "targeted",
            "control", "equal", "summoned", "destroyed", "equipped", "isnt", "drawn", "empty", "less", "played", "used",
            "odd", "healed", "unspent", "attacking", "per", "was", "discarded", "spent", "lost", "locked");

    List<String> effects = Arrays.asList("resummons", "resummon", "becomes", "dies", "die", "draws", "damages", "damage", "kills", "casts",
            "casts", "equips", "attacks", "loses", "upgrade", "survives", "explodes", "healing");

    List<String> specifier = Arrays.asList("other", "to", "from", "for", "you've", "youve", "yours", "your", "you're", "youre",
            "you", "random", "randomly", "all", "this", "each", "adjacent", "friendly", "enemy", "enemies", "enemy",
            "characters", "character", "an", "a", "they", "left", "right", "opponent", "opponents", "another",
            "and", "any", "top", "lowest", "highest", "they", "them", "those", "these", "taken", "the", "have", "next",
            "also", "their", "on", "of", "more", "instead", "chosen", "are", "again", "with", "or", "only", "died",
            "double", "at least", "both", "same", "full", "fully", "better", "wrong", "even", "type", "other", "neighbor", "dealt",
            "extra", "exact", "took", "most", "its", "it's", "it", "number");

    List<String> target = Arrays.asList("decks", "deck","minions", "minion", "cards", "card", "hand", "weapon", "hero", "heroes",
            "battlefield", "player", "players", "targets", "target", "someone", "himself", "owners");

    List<String> action = Arrays.asList("spend", "merge", "reveal", "discard", "add", "replace", "draw", "equip", "deal", "cast",
            "summon", "give", "attack", "destroy", "copy", "change", "trigger", "shuffle", "transform", "return",
            "choose", "put", "create", "gain", "remove", "set", "into", "restore", "swap", "play", "shuffle", "reduce",
            "take", "refresh", "unleash", "resurrect", "hatch", "steal", "form", "become", "lose", "toss", "awaken",
            "look");

    List<String> specialPhrase = Arrays.asList("at the start of your turn", "at the end of your", "fill your board with", "fill each player's board with",
            "can't be targeted by spells or hero powers", "after this attacks and kills a minion",
            "deal x damage", "that died this game", "of the same cost", "split among all enemies", "has no duplicates",
            "fill board with", "can't attack", "cant attack", "at the end of turn that died", "set a hero's remaining health to",
            "players only have 15 seconds to take their turns", "side of the battlefield is full",
            "at the end of each turn", "split among", "split between", "for each time", "at the end of each player's turn",
            "power to rock", "fall asleep", "you start the game with one of whizbang's wonderful decks",
            "your end of turn effects trigger twice", "you start the game with one of zayle's evil decks", "hero powers are disabled");

    List<String> gameTerm = Arrays.asList("mana crystal", "mana crystals", "mana", "turn", "turns", "armor", "health", "attack",
            "cost", "spell", "spells", "weapon's", "weapons", "weapon", "durability", "costs", "game", "frozen", "powerful artifact",
            "health", "cost", "armor", "hero power", "stats", "pack", "coins", "coin", "class", "starts dormant", "golden",
            "neutral", "wish", "basic");

    List<String> keywords = Arrays.asList("taunt", "spell power", "spell damage", "divine shield", "charge", "secret", "battlecry", "freeze",
            "windfury", "deathrattle", "combo", "overload", "silence", "counter", "immune", "inspire", "discover",
            "quest", "poisonous", "adapt","lifesteal", "recruit", "echo", "rush", "overkill", "magnetic", "lackey",
            "overkill", "magnetic", "lackey", "twinspell", "mega-windfury", "reborn", "invoke", "outcast",
            "passive hero power", "start of combat", "start of game", "dormant", "sidequest", "reward", "choose one",
            "hero power");


    public static class Cleaner extends Text {
        Cleaner(String input) {
            this.input = input.toLowerCase();
        }

        public Cleaner actionCleaner(){
            action.forEach(s -> {
                if (this.input.contains(s))this.input = this.input.replaceAll("\\b"+ s + "s" + "\\b", "");
                if (this.input.contains(s))this.input = this.input.replaceAll("\\b"+ s + "\\b", "");
            });
            return this;
        }

        public Cleaner targetCleaner(){
            target.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "s" + "\\b", ""));
            target.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", ""));
            return this;
        }

        public Cleaner specifierCleaner(){
            specifier.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "s" + "\\b", ""));
            specifier.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", ""));
            return this;
        }

        public Cleaner effectCleaner (){
            effects.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", ""));
            return this;
        }

        public Cleaner statesCleaner(){
            states.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", ""));
            return this;
        }

        public Cleaner conditionCleaner(){
            condition.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", ""));
            return this;
        }

        public Cleaner gameTermCleaner(){
            gameTerm.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", ""));
            return this;
        }

        public Cleaner specialPhraseCleaner(){
            specialPhrase.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", ""));
            return this;
        }

        public Cleaner properNamesCleaner() throws IOException {
            for (JsonNode string: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\ProperNames.json"))
            ) {
                if (string.asText().toLowerCase().equals("polymorph: ???")) this.input = this.input.replace("polymorph: ???", " ");
                else{
                    this.input = this.input.replaceAll("\\b" + string.asText().toLowerCase() + "\\b", " ");
                }
            }
            return this;
        }

        public Cleaner actionReplace(){
            action.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "act"));
            return this;
        }

        public Cleaner targetReplace(){
            target.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "tar"));
            return this;
        }

        public Cleaner specifierReplace(){
            specifier.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "spec"));
            return this;
        }

        public Cleaner effectReplace(){
            effects.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "eff"));
            return this;
        }

        public Cleaner statesReplace(){
            states.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "state"));
            return this;
        }

        public Cleaner conditionReplace(){
            condition.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "cond"));
            return this;
        }

        public Cleaner gameTermReplace(){
            gameTerm.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "gT"));
            return this;
        }

        public Cleaner specialPhraseReplace(){
            specialPhrase.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "sP"));
            return this;
        }

        public Cleaner properNamesReplace() throws IOException {
            for (JsonNode string: mapper.readTree(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\ProperNames.json"))
            ) {
                this.input = this.input.replaceAll("\\b" + string.asText().toLowerCase() + "\\b", "cardName");
            }
            return this;
        }

        public Cleaner randomCleaner(){
            random.forEach(s -> this.input = this.input.replaceAll("\\b" + s + "\\b", " "));
            return this;
        }

        public Cleaner classCleaner(){
            classNames.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", ""));
            return this;
        }

        public Cleaner tokenCleaner(){
            tokens.forEach(s -> this.input = this.input.replaceAll("\\b" + s + "s" + "\\b", " "));
            tokens.forEach(s -> this.input = this.input.replaceAll("\\b" + s + "\\b", " "));

            return this;
        }

        public Cleaner wordNumCleaner(){
            wordNum.forEach(s -> this.input = this.input.replaceAll("\\b" + s + "\\b", ""));
            return this;
        }

        public Cleaner minionTypeCleaner(){
            minionType.forEach(s -> this.input = this.input.replaceAll("\\b" + s  + "s" + "\\b", " "));
            minionType.forEach(s -> this.input = this.input.replaceAll("\\b" + s  + "\\b", " "));

            return this;
        }

        public Cleaner numCleaner(){
            this.input = this.input.replaceAll("\\b\\d\\d\\d\\b|\\b\\d\\d\\b|\\b\\d\\b", " ");
            return this;
        }

        public Cleaner numReplace(){
            input = input.replaceAll("\\b\\d\\d\\b|\\b\\d\\b", "x");
            return this;
        }

        public Cleaner punCleaner(){
            this.input = this.input.replaceAll("'", "");
            this.input = this.input.replaceAll("[\\x21-\\x2F\\x3A-\\x3F]" , "   ");
            return this;
        }

        public Cleaner boldCleaner() {
            this.input = this.input.replaceAll("<b>.*</b>", " ");
            return this;
        }

        public Cleaner blankSpaceCleaner(){
            this.input = this.input.replaceAll( "&nbsp;", " ");
            this.input = this.input.replaceAll( "\\s+", " ");
            return this;
        }

        public Cleaner italicCleaner(){
            if (this.input.contains("<i>")) this.input = this.input.replaceAll("<i>.*</i>", "");
            return this;
        }

        public void properNameList() throws IOException {
            List<ScoredCard> cards = new Filter().getCardList();
            ObjectMapper mapper = new ObjectMapper();
            File ProperNames = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\ProperNames.json");
            LinkedList<String> properNames = new LinkedList<>();
            for (ScoredCard card: cards
            ) {
                properNames.add(card.getName());
            }
            mapper.writerWithDefaultPrettyPrinter().writeValue(ProperNames, properNames);
        }

        public String getStringLower(){
            return input.toLowerCase();
        }

        public String getString() {
            return input;
        }


    }

    public static class Searcher extends Text{
        int firstWord = 0;
        int secondWord = 0;
        List<String> twoWord = new LinkedList<>();
        List<String> threeWord = new LinkedList<>();
        List<ScoredCard> list = new Filter().collectible().getCardList();


        Searcher() throws IOException {
            for (ScoredCard card: list
                 ) {
                for (String s: specifier
                     ) {
                    Pattern pattern = Pattern.compile("([\\w]*) " + s + " ([\\w]*) ");
                    Matcher matcher = pattern.matcher(card.getText().toLowerCase());

                    if (matcher.find() && !twoWord.contains(matcher.group(1) + "  " + s + "  " + matcher.group(2))) {
                        twoWord.add(matcher.group(1) + "  " + s + "  " + matcher.group(2));
                        System.out.println(matcher.group(1) + "  " + s + "  " + matcher.group(2));
                    }
                }


            }


        }


        public List<String> getTwoWord() {
            return twoWord;
        }
    }
}
