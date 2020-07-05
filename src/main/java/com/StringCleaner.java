package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class StringCleaner {
    Filter cardPool = new Filter();
    public List<ScoredCard> cards = cardPool.getCardList();
    File WordList = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\WordList.json");
    File ProperNames = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\ProperNames.json");
    ObjectMapper mapper = new ObjectMapper();
    String input;
    StringCleaner(String input) throws IOException {
        this.input = input;
        properNamesCleaner();

        italicCleaner();

        numCleaner();

        keywordCleaner();

        punCleaner();

        phraseCleaner();

        classCleaner();

        tokenCleaner();

        minionTypeCleaner();

        blankSpaceCleaner();





    }

    public StringCleaner characterRemover(){
        char [] characters = {'-', '/', '+', '(', ')', '?'};

        for (char x : characters
        ) {
            this.input = this.input.replace(x, ' ');
            this.input = this.input.replaceAll("&nbsp", " ");
        }
        return this;
    }

    StringCleaner properNamesCleaner() throws IOException {
        for (JsonNode string: mapper.readTree(ProperNames)
             ) {
            if (!string.asText().toLowerCase().equals("polymorph: ???"))
            this.input = this.input.replaceAll("\\b" + string.asText().toLowerCase() + "\\b", "").toLowerCase();
        }
        return this;
    }

    public StringCleaner italicCleaner(){
        if (this.input.contains("<i>")) this.input = this.input.replaceAll(input.substring(input.indexOf("<i>"), input.indexOf("</i>") + 4), "");
        return this;
    }

    public StringCleaner classCleaner(){
        String [] classNames = {"druid", "hunter", "mage", "paladin", "priest", "rogue", "shaman", "warlock",
                "warrior", "demon hunter"};
        for (String s: classNames
        ) {
            input = input.replaceAll("\\b" +s+ "\\b", "");
        }
        return this;
    }

    public StringCleaner phraseCleaner(){
        String [] phrases = {"passive hero power", "hero power", "hero powers", "start of combat", "illidari",
                "charrrrrge", "side quest", "reward", "'azari the devourer'", "sealed un'goro pack", "jade idols",
                "dinosaur forms", "ly", "stars' fury", "king krush", "'deal damage'", "pogo hopper", "razorpetals",
                "pterrordaxes", };
        for (String s: phrases
        ) {
            this.input = this.input.replaceAll("mana crystals", "mana");
            this.input = this.input.replaceAll(s, "");
        }
        return this;
    }

    public StringCleaner tokenCleaner(){
        String [] tokens = {"squirrels", "treants", "felwings", "bees", "loti's", "dryads", "raptors", "saplings",
                "cat", "bear", "rats", "lynxes", "wolves", "hyenas", "webspinners", "locusts", "goblin bombs",
                "sandwasps", "microcopters", "true silver champion", "mithril golems", "boom bots", "jo-e bot",
        "spiders", "wisps"};
        for (String s: tokens
        ) {
            input = input.replaceAll("\\b"+s+"\\b", "");
        }
        return this;
    }

    public StringCleaner minionTypeCleaner(){
        String [] minionType = {"murloc", "demon", "mech", "elemental", "beast", "totem", "pirate", "dragon"};
        for (String s: minionType
        ) {
            input = input.replaceAll("\\b"+s+"\\b", "");
        }
        return this;
    }

    public StringCleaner numCleaner(){

        input = input.replaceAll("\\b\\d\\d\\b", "");
        input = input.replaceAll("\\b\\d\\b", "");

        /*String [] numbersArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8","9", "10", "11", "12", "13","14", "15",
                "16", "20", "21", "22", "23", "25", "59", "66", "32", "55", "52", "24", "42", "53",
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        for (String s: numbersArr
        ) {
            input = input.replaceAll("\\b" + s + "\\b", "");
        }*/
        return this;
    }

    public StringCleaner numReplace(){
        input = input.replaceAll("\\b\\d\\d\\b", "x");
        input = input.replaceAll("\\b\\d\\b", "x");
        /*String [] numbersArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8","9", "10", "11", "12", "13","14", "15", "20",
                "one", "two", "three", "four", "five", "seven"};
        for (String y: numbersArr
        ) {
            input = input.replaceAll("\\b\\d\\d\\b", "x");
            input = input.replaceAll("\\b\\d\\b", "x");
        }*/
        return this;
    }

    public StringCleaner punCleaner(){
        input = input.replaceAll("[[:punct:]]+", "");
        input = input.replaceAll("[\\x21-\\x2F]+", "");
        /*String [] punctuationArr = { "+", "<b>", "</b>", "+", "/", "\"", ".", ",", ":", ";", "(", ")", "-", "\\", "?", "!", "''"};

        for (String s: punctuationArr
        ) {
            input = input.replace(s, "  ");
        }*/
        return this;
    }

    public StringCleaner keywordCleaner() {
        LinkedList<String> keywords = new LinkedList<>();
        keywords.add("<b>taunt</b>");
        keywords.add("<b>spell power</b>");
        keywords.add("<b>divine shield</b>");
        keywords.add("<b>charge</b>");
        keywords.add("<b>secret</b>");
        keywords.add("<b>stealth</b>");
        keywords.add("<b>battlecry</b>");
        keywords.add("<b>freeze</b>");
        keywords.add("<b>windfury</b>");
        keywords.add("<b>deathrattle</b>");
        keywords.add("<b>combo</b>");
        keywords.add("<b>overload</b>");
        keywords.add("<b>silence</b>");
        keywords.add("<b>counter</b>");
        keywords.add("<b>immune</b>");
        keywords.add("<b>inspire</b>");
        keywords.add("<b>discover</b>");
        keywords.add("<b>quest</b>");
        keywords.add("<b>poisonous</b>");
        keywords.add("<b>adapt</b>");
        keywords.add("<b>lifesteal</b>");
        keywords.add("<b>recruit</b>");
        keywords.add("<b>echo</b>");
        keywords.add("<b>rush</b>");
        keywords.add("<b>overkill</b>");
        keywords.add("<b>magnetic</b>");
        keywords.add("<b>lackey</b>");
        keywords.add("<b>twinspell</b>");
        keywords.add("<b>mega-windfury</b>");
        keywords.add("<b>reborn</b>");
        keywords.add("<b>invoke</b>");
        keywords.add("<b>outcast</b>");

        for (String s: keywords
        ) {
            input = input.replaceAll(s, "");
        }
        return this;
    }

    public StringCleaner blankSpaceCleaner(){
        input = input.replaceAll("&nbsp", " ");
        input = input.replaceAll( "\\s+", " ");
        return this;

    }

    public String getStringLower(){
        return input.toLowerCase();
    }

    public void properNameList() throws IOException {
        LinkedList<String> properNames = new LinkedList<>();
        for (ScoredCard card: cards
        ) {
            properNames.add(card.getName().toLowerCase());
        }
        properNames.add(String.valueOf(properNames.size()));
        mapper.writerWithDefaultPrettyPrinter().writeValue(ProperNames, properNames);
    }

    public String getString() {
        return input;
    }
}
