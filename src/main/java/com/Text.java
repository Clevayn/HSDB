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

    List<String> condition = Arrays.asList("during", "unless", "has", "have", "after", "if", "else", "until", "whenever", "whomever", "while",
            "can't", "cant", "can", "may", "last", "takes", "when", "every", "already", "non", "than", "no", "take");

    List<String> states = Arrays.asList("in", "holding", "damaged", "dead", "attacked", "undamaged", "targeted",
            "control", "equal", "summoned", "destroyed", "equipped", "isnt", "drawn", "empty", "less", "played", "used",
            "odd", "healed", "unspent", "attacking", "per", "was", "discarded", "spent", "lost", "locked");

    List<String> effects = Arrays.asList("resummons", "resummon", "becomes", "dies", "die", "draws", "damages", "damage", "kills", "casts",
            "casts", "equips", "attacks", "loses", "upgrade", "survives", "explodes", "healing");

    List<String> joiners = Arrays.asList("to", "from", "for", "all", "this", "each",  "at", "that", "they",
            "any", "them", "those", "these", "the", "have", "also", "their", "on", "of", "are", "with","that", "by",
            "at", "than", "no", "in","is(n't|)", "the", "put", "into", "this", "or", "and", "their");

    List<String> specifier = Arrays.asList("(an|)other(s|)", "to", "from", "for", "random(ly|)", "all", "this", "each",
            "adjacent", "friendly", "a(nd|ll|n|)", "end", "they", "left", "right", "at", "that",
            "any", "top", "lowest", "highest", "they", "them", "those", "these", "taken", "the", "have", "next",
            "also", "their", "on", "of", "more", "instead", "chosen", "are", "again", "with", "only",
            "double", "least", "both", "same", "full(y|)", "better", "wrong", "even", "type", "neighbor",
            "dealt", "extra", "exact", "took", "most", "it('s|s|)", "number", "that", "back", "by", "copies",
            "effect(s|)", "starting", "awesome", "invention", "chance", "at", "chord", "can", "does(n't|)", "always",
            "during", "unless", "has", "have", "no", "after", "if", "else", "until", "whenever", "whomever", "while",
            "can't", "cant", "can", "may", "last", "takes", "when", "every", "already", "non", "than", "no", "take",
            "in", "holding", "damaged", "dead", "attack(ed|ing|s)", "undamaged", "targeted",
            "control", "equal", "summoned", "destroyed", "equipped", "is(n't|)", "empty", "less", "played", "used",
            "odd", "(un|)spent", "per", "was", "discarded", "lost", "locked", "resummon(s|)",
            "becomes", "dies", "die", "draw(s|n)", "damages", "damage", "kill(s|)", "cast(s|)",
            "equips", "loses", "upgrade", "survives", "explodes", "heal(ing|ed|)", "deck(s|)",
            "minion(s|)", "card(s|)", "hand", "weapon", "hero(es|)",
            "battlefield", "player(s|)", "target(s|)", "someone", "himself", "owners", "enem(y|ies)", "opponent(s|'s|)",
            "character(s|)", "hero power", "stats", "pack", "coins", "coin", "class", "you(rs|r|'re|'ve|)",
            "friendly", "enemy", "random", "most", "the", "put", "into",
            "this", "each", "on", "any", "both", "more", "adjacent", "or", "and", "next", "also",
            "their", "of", "wrong", "are", "you", "from", "top", "extra", "to", "only");

    /*List<String> specifier = Arrays.asList("other", "to", "from", "for", "yours", "your", "you're", "you've", "you",
            "random", "randomly", "all", "this", "each", "adjacent", "friendly",
            "an", "a", "they", "left", "right", "another", "at", "that",
            "and", "any", "top", "lowest", "highest", "they", "them", "those", "these", "taken", "the", "have", "next",
            "also", "their", "on", "of", "more", "instead", "chosen", "are", "again", "with", "or", "only", "died",
            "double", "at least", "both", "same", "fully", "full" , "better", "wrong", "even", "type", "other", "neighbor",
            "dealt", "extra", "exact", "took", "most", "it", "its", "it's", "number");*/

    List<String> targetCombos = Arrays.asList("you(r|'re|rs|)", "an", "all", "friendly", "enem(ies|y)", "random", "the", "this",
            "on", "any", "both", "another", "other", "next", "adjacent", "their",  "top", "only", "same",
            "a");

    List<String> target = Arrays.asList("deck(s|)", "minion(s|'s|)", "card(s|)", "hand", "weapon", "hero(es|'s|)",
            "battlefield", "player(s|)", "target(s|)", "someone", "himself", "owners", "enem(y|ies)", "opponent(s|)",
            "character(s|)", "squirrel(s|)", "spirit wolves", "treant(s|)", "felwing(s|)", "bee(s|)", "loti's", "dryad(s|)",
            "raptor(s|)", "sapling(s|)", "bruiser(s|)", "gaurdian(s|)", "cat(s|)", "bear(s|)", "rat(s|)", "lynx(s|)", "wolve", "hyena(s|)", "webspinner(s|)",
            "locust(s|)", "goblin bomb(s|)","scarab(s|)", "satyr(s|)", "sandwasp(s|)", "microcopter(s|)", "truesilver champion(s|)", "mithril golem(s|)",
            "boom bot(s|)", "jo-e bot(s|)", "spider(s|)", "wisp(s|)", "pterrordaxe(s|)", "pogo hopper(s|)", "razorpetal(s|)", "direhorn(s|)", "boar(s|)",
            "muckling", "plate", "mech", "grub(s|)", "leper gnome(s|)", "whelp(s|)", "tentacle(s|)", "silver hand recruit(s|)", "runt(s|)",
            "microbot(s|)", "bat(s|)", "hat(s|)", "murloc", "demon(s|)", "mech(s|)", "elemental(s|)", "beast(s|)",
            "totem(s|)", "pirate(s|)", "dragon(s|)", "druid", "hunter", "mage", "paladin", "priest", "rogue",
            "shaman", "warlock", "warrior", "demon hunter", "death knight");

    /*List<String> target = Arrays.asList("deck(s|)", "minion(s|)", "card(s|)", "hand", "weapon", "hero(es|)",
            "battlefield", "player(s|)", "target(s|)", "someone", "himself", "owners", "enem(y|ies)", "opponent(s|)",
            "character(s|)");*/


    List<String> resourceAction = Arrays.asList("refresh", "spend", "discard", "add", "draw", "shuffle", "return",
            "remove", "return");

    List<String> characterAction = Arrays.asList("equip", "summon", "attack", "play", "steal", "destroy",
            "create", "deal", "cast", "choose", "look", "reveal", "restore", "put");

    List<String> modificationAction = Arrays.asList("merge", "change", "transform", "give", "copy", "gain", "set",
            "swap", "reduce", "resurrect", "replace", "hatch","form", "become", "lose", "awaken", "trigger");

    List<String> action = new LinkedList<>();

    List<String> specialPhrase = Arrays.asList("at the start of your turn", "at the end of your", "fill your board with", "fill each player's board with",
            "can't be targeted by spells or hero powers", "after this attacks and kills a minion",
            "deal x damage", "that died this game", "of the same cost", "split among all enemies", "has no duplicates",
            "fill board with", "can't attack", "cant attack", "at the end of turn that died", "set a hero's remaining health to",
            "players only have 15 seconds to take their turns", "side of the battlefield is full",
            "at the end of each turn", "split among", "split between", "for each time", "at the end of each player's turn",
            "power to rock", "fall asleep", "you start the game with one of whizbang's wonderful decks",
            "your end of turn effects trigger twice", "you start the game with one of zayle's evil decks", "hero powers are disabled");

    List<String> gameTerm = Arrays.asList("mana crystal(\\s|s)", "mana", "turn", "turns", "armor", "health", "attack",
            "cost", "spell", "spells", "weapon's", "weapons", "weapon", "durability", "costs", "game", "frozen", "powerful artifact",
            "health", "cost", "armor", "hero power", "stats", "pack", "coins", "coin", "class", "starts dormant", "golden",
            "neutral", "wish", "basic");

    List<String> keywords = Arrays.asList("taunt", "spell power", "spell damage", "divine shield", "charge", "secret", "battlecry", "freeze",
            "windfury", "deathrattle", "combo", "overload", "silence", "counter", "immune", "inspire", "discover",
            "quest", "poisonous", "adapt","lifesteal", "recruit", "echo", "rush", "overkill", "magnetic", "lackey",
            "overkill", "magnetic", "lackey", "twinspell", "mega-windfury", "reborn", "invoke", "outcast",
            "passive hero power", "start of combat", "start of game", "dormant", "sidequest", "reward", "choose one",
            "hero power");

    List<String> targeting = Arrays.asList("your", "a", "an", "all", "friendly", "enemy", "random", "most", "the",
            "this", "each", "on", "any", "both", "more", "other", "adjacent", "or", "and", "another", "next", "also",
            "their", "of", "wrong", "are", "you", "from", "top", "extra", "to", "only");

    List<String> wordPlusTarget = new LinkedList<>();

    List<String> twoWord = new LinkedList<>();

    List<String> threeWord = new LinkedList<>();

    List<String> fourWord = new LinkedList<>();

    List<String> fiveWord = new LinkedList<>();

    List<String> sixWord = new LinkedList<>();

    List<String> sevenWord = new LinkedList<>();

    List<String> eightWord = new LinkedList<>();

    List<String> nineWord = new LinkedList<>();

    List<String> tenWord = new LinkedList<>();

    List<String> elevenWord = new LinkedList<>();

    List<String> twelveWord = new LinkedList<>();

    List<String> thirteenWord = new LinkedList<>();

    List<String> fourteenWord = new LinkedList<>();

    List<String> fifteenWord = new LinkedList<>();

    List<String> sixteenWord = new LinkedList<>();

    List<String> seventeenWord = new LinkedList<>();

    List<String> specifierOneWord = new LinkedList<>();

    List<String> specifierTwoWord = new LinkedList<>();

    List<String> specifierThreeWord = new LinkedList<>();

    List<String> specifierFourWord = new LinkedList<>();

    List<String> specifierFiveWord = new LinkedList<>();

    List<String> specifierSixWord = new LinkedList<>();

    List<String> specifierSevenWord = new LinkedList<>();

    List<String> specifierEightWord = new LinkedList<>();

    List<String> specifierNineWord = new LinkedList<>();

    List<String> specifierTenWord = new LinkedList<>();

    List<String> specifierElevenWord = new LinkedList<>();

    List<String> joinerList = new LinkedList<>();

    List<String> joiner2List = new LinkedList<>();

    List<String> joiner3List = new LinkedList<>();

    List<String> joiner4List = new LinkedList<>();

    List<String> targetList = new LinkedList<>();

    List<String> targetComboList1 = new LinkedList<>();

    List<String> targetComboList2 = new LinkedList<>();

    List<String> targetComboList3 = new LinkedList<>();

    List<String> targetComboList4 = new LinkedList<>();

    List<String> targetComboList5 = new LinkedList<>();

    List<String> mainTarget = new LinkedList<>();

    List<String> targeting1 = new LinkedList<>();

    List<String> targeting2 = new LinkedList<>();

    List<String> targeting3 = new LinkedList<>();



    public Text() throws IOException {

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\Targets.json"))
        ) {
            targetList.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\Targeting 2 Word.json"))
        ) {
            targeting1.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\Targeting 3 Word.json"))
        ) {
            targeting2.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\Targeting 4 Word.json"))
        ) {
            targeting3.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\mainTargetCombos.json"))
        ) {
            mainTarget.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\targetCombos 2 Word.json"))
        ) {
            targetComboList1.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\targetCombos 3 Word.json"))
        ) {
            targetComboList2.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\targetCombos 4 Word.json"))
        ) {
            targetComboList3.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\targetCombos 5 Word.json"))
        ) {
            targetComboList4.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\targetCombos 6 Word.json"))
        ) {
            targetComboList5.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\wordPlusTarget.json"))
             ) {
            wordPlusTarget.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\1 Word.json"))
        ) {
            specifierOneWord.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\2 Word.json"))
        ) {
            specifierTwoWord.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\3 Word.json"))
        ) {
            specifierThreeWord.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\4 Word.json"))
        ) {
            specifierFourWord.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\5 Word.json"))
        ) {
            specifierFiveWord.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\6 Word.json"))
        ) {
            specifierSixWord.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\7 Word.json"))
        ) {
            specifierSevenWord.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\8 Word.json"))
        ) {
            specifierEightWord.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\9 Word.json"))
        ) {
            specifierNineWord.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\10 Word.json"))
        ) {
            specifierTenWord.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\11 Word.json"))
        ) {
            specifierElevenWord.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\Joiner.json"))
        ) {
            joinerList.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\Joiner 2 Word.json"))
        ) {
            joiner2List.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\Joiner 3 Word.json"))
        ) {
            joiner3List.add(node.textValue());
        }

        for (JsonNode node: mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\Joiner 4 Word.json"))
        ) {
            joiner4List.add(node.textValue());
        }
    }


    public static class Cleaner extends Text {

        Cleaner(String input) throws IOException {
            super();
            this.input = input.toLowerCase();
        }

        public Cleaner wordPlusTargetCleaner(){
            wordPlusTarget.forEach(s -> {
                if (this.input.contains(s))this.input = this.input.replaceAll("\\b" + s + "\\b", "Target");
            });
            return this;
        }


        public Cleaner actionCleaner(){
        action.addAll(modificationAction);
        action.addAll(characterAction);
        action.addAll(resourceAction);
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

        public Cleaner targeterCleaner(){
            targeting3.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            targeting2.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            targeting1.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            targetList.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            return this;
        }

        public Cleaner targeterReplace(){
            targeting3.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "target"));
            targeting2.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "target"));
            targeting1.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "target"));
            targetList.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "target"));
            return this;
        }


        public Cleaner specifierCleaner(){
            specifierTenWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            specifierTenWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            specifierNineWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            specifierEightWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            specifierSevenWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            specifierSixWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            specifierFiveWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            specifierFourWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            specifierThreeWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            specifierTwoWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            specifierOneWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            return this;
        }

        public Cleaner joinerCleaner(){
            joiner4List.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            joiner3List.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            joiner2List.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            joinerList.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", " "));
            return this;
        }

        public Cleaner joinerReplace(){
            joiner4List.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "join"));
            joiner3List.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "join"));
            joiner2List.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "join"));
            joinerList.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "join"));
            return this;
        }

        public Cleaner specifierReplace(){
            specifierTenWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "11Words"));
            specifierTenWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "10Words"));
            specifierNineWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "9Words"));
            specifierEightWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "8Words"));
            specifierSevenWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "7Words"));
            specifierSixWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "6Words"));
            specifierFiveWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "5Words"));
            specifierFourWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "4Words"));
            specifierThreeWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "3Words"));
            specifierTwoWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "2Words"));
            specifierOneWord.forEach(s -> this.input = this.input.replaceAll("\\b"+ s + "\\b", "1Word"));
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
            this.input = this.input.replaceAll( "\\s{2,}", " ");
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
        List<String> wordPlusTarget = new LinkedList<>();
        List<ScoredCard> list = new Filter().collectible().getCardList();

        Searcher() throws IOException {}

        public List<String> characterAction(){
            List<String> out = new LinkedList<>();
            for (ScoredCard card: list
                 ) {
                String text = card.getText().toLowerCase().replaceAll("([.,:!]|&nbsp;)", "   ");
                text = text.replaceAll("\\s{2,}", " ");
                for (String s: characterAction
                     ) {
                    Pattern pattern = Pattern.compile("(" + s + ")" + " ([a-z]\\w+)");
                    Matcher matcher = pattern.matcher(text);

                    if (matcher.find()
                            && !matcher.group().equals("")
                            && !out.contains(matcher.group())) {
                        out.add(matcher.group());
                        System.out.println(matcher.group());
                    }
                }
            }
            return out;
        }

        public void actionBuilder(){
            List<String> out = new LinkedList<>();
            for (ScoredCard card: list
                 ) {
                String text =  card.getText().toLowerCase().replaceAll("&nbsp;", " ");
                text = text.replaceAll("[.,;!]", "   ");
                text = text.replaceAll("\\d\\d|\\d", "x");
                for (String s: resourceAction
                     ) {
                    text = text.replaceAll("\\s{2,}", " ");
                    Pattern pattern = Pattern.compile(s + " ([^\\s]+)" + " ([^\\s]+)");
                    Matcher matcher = pattern.matcher(text);

                    if (matcher.find() && !out.contains(matcher.group())){
                        System.out.println(matcher.group());
                        out.add(matcher.group());
                    }
                }
            }

        }


        public void listBuilder(String name, List<String> wordList) throws IOException {
            for (ScoredCard card : list
            ) {
                String text = card.getText().toLowerCase().replaceAll("&nbsp;", " ");
                text = text.replaceAll("[.,;!]", " ");
                text = text.replaceAll("\\s{2,}", " ");
                    for (String s: wordList
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !twoWord.contains(matcher.group())) {
                            twoWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }
            }
            new WriteJsonFile(name).writeStringList(twoWord);

        }

        public void singleListCombos(String name, List<String> wordList) throws IOException {
            for (ScoredCard card: list
                 ) {
                String text = card.getText().toLowerCase().replaceAll("&nbsp;", " ");
                text = text.replaceAll("[.,;!]", " ");
                text = text.replaceAll("\\s{2,}", " ");
                for (String s: wordList
                ) {
                    for (String s1: wordList
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !twoWord.contains(matcher.group())) {
                            twoWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: twoWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !threeWord.contains(matcher.group())) {
                            threeWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: threeWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !fourWord.contains(matcher.group())) {
                            fourWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: fourWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !fiveWord.contains(matcher.group())) {
                            fiveWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: fiveWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !sixWord.contains(matcher.group())) {
                            sixWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: sixWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !sevenWord.contains(matcher.group())) {
                            sevenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: sevenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !eightWord.contains(matcher.group())) {
                            eightWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: eightWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !nineWord.contains(matcher.group())) {
                            nineWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: nineWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !tenWord.contains(matcher.group())) {
                            tenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: tenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !elevenWord.contains(matcher.group())) {
                            elevenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: elevenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !twelveWord.contains(matcher.group())) {
                            twelveWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: twelveWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !thirteenWord.contains(matcher.group())) {
                            thirteenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: thirteenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !fourteenWord.contains(matcher.group())) {
                            fourteenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: fourteenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !fifteenWord.contains(matcher.group())) {
                            fifteenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: fifteenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !sixteenWord.contains(matcher.group())) {
                            sixteenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: sixteenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !seventeenWord.contains(matcher.group())) {
                            seventeenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }
                }
            }


            if (twoWord.size() > 0)new WriteJsonFile(name + " 2 Word").writeStringList(twoWord);

            if (threeWord.size() > 0)new WriteJsonFile(name + " 3 Word").writeStringList(threeWord);

            if (fourWord.size() > 0)new WriteJsonFile(name + " 4 Word").writeStringList(fourWord);

            if (fiveWord.size() > 0)new WriteJsonFile(name + " 5 Word").writeStringList(fiveWord);

            if (sixWord.size() > 0)new WriteJsonFile(name + " 6 Word").writeStringList(sixWord);

            if (sevenWord.size() > 0)new WriteJsonFile(name + " 7 Word").writeStringList(sevenWord);

            if (eightWord.size() > 0)new WriteJsonFile(name + " 8 Word").writeStringList(eightWord);

            if (nineWord.size() > 0)new WriteJsonFile(name + " 9 Word").writeStringList(nineWord);

            if (tenWord.size() > 0)new WriteJsonFile(name + " 10 Word").writeStringList(tenWord);

            if (elevenWord.size() > 0)new WriteJsonFile(name + " 11 Word").writeStringList(elevenWord);

            if (twelveWord.size() > 0)new WriteJsonFile(name + " 12 Word").writeStringList(twelveWord);

            if (thirteenWord.size() > 0)new WriteJsonFile(name + " 13 Word").writeStringList(thirteenWord);

            if (fourteenWord.size() > 0)new WriteJsonFile(name + " 14 Word").writeStringList(fourteenWord);

            if (fifteenWord.size() > 0)new WriteJsonFile(name + " 15 Word").writeStringList(fifteenWord);

            if (sixteenWord.size() > 0)new WriteJsonFile(name + " 16 Word").writeStringList(sixteenWord);

            if (seventeenWord.size() > 0)new WriteJsonFile(name + " 17 Word").writeStringList(seventeenWord);




        }

        public void twoListCombos(String name, List<String> wordList1, List<String> wordList2) throws IOException {
            for (ScoredCard card: list
            ) {
                String text = card.getText().toLowerCase().replaceAll("&nbsp;", " ");
                text = text.replaceAll("[.,;!]", " ");
                text = text.replaceAll("\\s{2,}", " ");


                for (String s: wordList1
                ) {
                    for (String s1: wordList2
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !twoWord.contains(matcher.group())) {
                            twoWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: twoWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !threeWord.contains(matcher.group())) {
                            threeWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: threeWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !fourWord.contains(matcher.group())) {
                            fourWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: fourWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !fiveWord.contains(matcher.group())) {
                            fiveWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: fiveWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !sixWord.contains(matcher.group())) {
                            sixWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: sixWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !sevenWord.contains(matcher.group())) {
                            sevenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: sevenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !eightWord.contains(matcher.group())) {
                            eightWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: eightWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !nineWord.contains(matcher.group())) {
                            nineWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: nineWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !tenWord.contains(matcher.group())) {
                            tenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: tenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !elevenWord.contains(matcher.group())) {
                            elevenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: elevenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !twelveWord.contains(matcher.group())) {
                            twelveWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: twelveWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !thirteenWord.contains(matcher.group())) {
                            thirteenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: thirteenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !fourteenWord.contains(matcher.group())) {
                            fourteenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: fourteenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !fifteenWord.contains(matcher.group())) {
                            fifteenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: fifteenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !sixteenWord.contains(matcher.group())) {
                            sixteenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }

                    for (String s1: sixteenWord
                    ) {
                        Pattern pattern = Pattern.compile("\\b" + s + " " + s1 + "\\b");
                        Matcher matcher = pattern.matcher(text);
                        if (matcher.find() && !seventeenWord.contains(matcher.group())) {
                            seventeenWord.add(matcher.group());
                            System.out.println(matcher.group());
                        }
                    }
                }
            }

            new WriteJsonFile(name).writeStringList(targetList);

            if (twoWord.size() > 0)new WriteJsonFile(name + " 2 Word").writeStringList(twoWord);

            if (threeWord.size() > 0)new WriteJsonFile(name + " 3 Word").writeStringList(threeWord);

            if (fourWord.size() > 0)new WriteJsonFile(name + " 4 Word").writeStringList(fourWord);

            if (fiveWord.size() > 0)new WriteJsonFile(name + " 5 Word").writeStringList(fiveWord);

            if (sixWord.size() > 0)new WriteJsonFile(name + " 6 Word").writeStringList(sixWord);

            if (sevenWord.size() > 0)new WriteJsonFile(name + " 7 Word").writeStringList(sevenWord);

            if (eightWord.size() > 0)new WriteJsonFile(name + " 8 Word").writeStringList(eightWord);

            if (nineWord.size() > 0)new WriteJsonFile(name + " 9 Word").writeStringList(nineWord);

            if (tenWord.size() > 0)new WriteJsonFile(name + " 10 Word").writeStringList(tenWord);

            if (elevenWord.size() > 0)new WriteJsonFile(name + " 11 Word").writeStringList(elevenWord);

            if (twelveWord.size() > 0)new WriteJsonFile(name + " 12 Word").writeStringList(twelveWord);

            if (thirteenWord.size() > 0)new WriteJsonFile(name + " 13 Word").writeStringList(thirteenWord);

            if (fourteenWord.size() > 0)new WriteJsonFile(name + " 14 Word").writeStringList(fourteenWord);

            if (fifteenWord.size() > 0)new WriteJsonFile(name + " 15 Word").writeStringList(fifteenWord);

            if (sixteenWord.size() > 0)new WriteJsonFile(name + " 16 Word").writeStringList(sixteenWord);

            if (seventeenWord.size() > 0)new WriteJsonFile(name + " 17 Word").writeStringList(seventeenWord);




        }

        public void wordPlusTarget() throws IOException {
            for (ScoredCard card: list
            ) {
                String text = card.getText().toLowerCase().replaceAll("[.,;!]", " ");
                text = text.replaceAll("nbsp", "");
                text = text.replaceAll("\\d\\d|\\d", "x");

                for(String com: targetCombos){
                   for (String s: target
                   ) {
                       Pattern pattern = Pattern.compile("(\\b" + com + "\\b) " + "(\\b" + s + "\\b)");
                       Matcher matcher = pattern.matcher(text);
                       if (matcher.find() && !wordPlusTarget.contains(matcher.group(1) + " " + matcher.group(2))) {
                           wordPlusTarget.add(matcher.group(1) + " " + matcher.group(2));
                       }
                   }
               }
            }
            new WriteJsonFile("wordPlusTarget").writeStringList(wordPlusTarget);
        }

        public void contentCounter() throws IOException {
            int characterAction = 0;
            int resourceAction = 0;
            int modificationAction = 0;
            int targetCount = 0;
            int stateCount = 0;
            int effectCount = 0;
            int conditionCount = 0;
            int textLen;
            for (ScoredCard card: list
                 ) {
                String text = new Cleaner(card.getText().toLowerCase())
                        .boldCleaner()
                        .italicCleaner()
                        .blankSpaceCleaner()
                        .punCleaner()
                        .italicCleaner()
                        .blankSpaceCleaner()
                        .getStringLower()
                        .strip();

                textLen = text.split(" ").length;
                for (String s: text.split(" ")
                     ) {
                    if (this.characterAction.contains(s)) characterAction++;
                    if (this.resourceAction.contains(s)) resourceAction++;
                    if (this.modificationAction.contains(s)) modificationAction++;
                    if (target.contains(s)) targetCount++;
                    if (states.contains(s)) stateCount++;
                    if (effects.contains(s)) effectCount++;
                    if (condition.contains(s)) conditionCount++;
                }

                System.out.println(card.getText());
                System.out.println("Character Actions:    " + characterAction);
                System.out.println("Resource Action:      " + resourceAction);
                System.out.println("Mod Action:           " + modificationAction);
                System.out.println("Targets:              " + targetCount);
                System.out.println("States:               " + stateCount);
                System.out.println("Effects:              " + effectCount);
                System.out.println("Conditions:           " + conditionCount);
                System.out.println();
                System.out.println("Word Count:           " + textLen);
                System.out.println("Total:                " + (characterAction + resourceAction + modificationAction +
                        targetCount + stateCount + effectCount + conditionCount));
                System.out.println("------------------------------------------------------------");

                System.out.println();

                characterAction = 0;
                resourceAction = 0;
                modificationAction = 0;
                targetCount = 0;
                stateCount = 0;
                effectCount = 0;
                conditionCount = 0;
            }
        }
    }

    public static class Value extends Text{

        Value() throws IOException {
            super();

        }




    }
}

