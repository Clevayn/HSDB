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
        //properNamesCleaner();

        italicCleaner();

        keywordCleaner();

        numCleaner();



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

    void properNamesCleaner() throws IOException {
        for (JsonNode string: mapper.readTree(ProperNames)
             ) {
            if (!string.asText().toLowerCase().equals("polymorph: ???"))
            this.input = this.input.replaceAll("\\b" + string.asText().toLowerCase() + "\\b", "").toLowerCase();
        }
    }

    public void italicCleaner(){
        if (this.input.contains("<i>")) this.input = this.input.replaceAll(input.substring(input.indexOf("<i>"), input.indexOf("</i>") + 4), "");
    }

    public void classCleaner(){
        String [] classNames = {"Druid", "Hunter", "Mage", "Paladin", "Priest", "Rogue", "Shaman", "Warlock",
                "Warrior", "Demon Hunter"};
        for (String s: classNames
        ) {
            input = input.replaceAll("\\b" +s+ "\\b", "");
        }
    }

    public void phraseCleaner(){
        String [] phrases = {"Illidari",
                "Charrrrrge", "Side Quest", "Reward", "'Azari the Devourer'", "Sealed Un'Goro Pack", "Jade Idols",
                "Dinosaur Forms", "ly", "Stars' Fury", "king Krush", "'deal damage'", "Pogo Hopper", "Razorpetals",
                "Pterrordaxes", };
        for (String s: phrases
        ) {
            this.input = this.input.replaceAll("mana crystals", "mana");
            this.input = this.input.replaceAll(s, "");
        }
    }

    public void tokenCleaner(){
        String [] tokens = {"[Ss]quirrels", "[Tt]reant[s]", "[Ff]elwings", "[Bb]ees", "[Ll]oti's", "[Dd]ryads",
                "[Rr]aptors", "[Ss]aplings",
                "[Cc]at", "[Bb]ear", "[Rr]ats", "[Ll]ynxes", "[Ww]olves", "[Hh]yenas", "[Ww]ebspinners", "[Ll]ocusts",
                "[Gg]oblin [Bb]ombs",
                "[Ss]andwasps", "[Mm]icrocopters", "True Silver Champion", "[Mm]ithril [Gg]olems", "[Bb]oom [Bb]ots",
                "Jo-E Bot",
        "[Ss]piders", "[Ww]isps"};
        for (String s: tokens
        ) {
            input = input.replaceAll("\\b"+s+"\\b", "");
        }
    }

    public void minionTypeCleaner(){
        String [] minionType = {"Murloc", "Demon", "Mech", "Elemental", "Beast", "Totem", "Pirate", "Dragon"};
        for (String s: minionType
        ) {
            input = input.replaceAll("\\b"+s+"\\b", "");
        }
    }

    public void numCleaner(){

        input = input.replaceAll("\\b\\d\\d\\b", "");
        input = input.replaceAll("\\b\\d\\b", "");

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

    public void punCleaner(){
        input = input.replaceAll("[\\x21-\\x2F\\x3A-\\x3F]+" , " ");

    }

    public void keywordCleaner() {
        LinkedList<String> keywords = new LinkedList<>();
        keywords.add("<b>Taunt</b>");
        keywords.add("<b>Spell Power</b>");
        keywords.add("<b>Divine Shield</b>");
        keywords.add("<b>Charge</b>");
        keywords.add("<b>Secret:</b>");
        keywords.add("<b>Stealth</b>");
        keywords.add("<b>Battlecry:</b>");
        keywords.add("<b>Freeze</b>");
        keywords.add("<b>Windfury</b>");
        keywords.add("<b>Deathrattle:</b>");
        keywords.add("<b>Combo:</b>");
        keywords.add("<b>Overload:</b>");
        keywords.add("<b>Silence</b>");
        keywords.add("<b>Counter:</b>");
        keywords.add("<b>Immune</b>");
        keywords.add("<b>Inspire:</b>");
        keywords.add("<b>Discover:</b>");
        keywords.add("<b>Quest:</b>");
        keywords.add("<b>Poisonous</b>");
        keywords.add("<b>Adapt</b>");
        keywords.add("<b>Lifesteal</b>");
        keywords.add("<b>Recruit:</b>");
        keywords.add("<b>Echo:</b>");
        keywords.add("<b>Rush</b>");
        keywords.add("<b>Overkill:</b>");
        keywords.add("<b>Magnetic</b>");
        keywords.add("<b>Lackey</b>");
        keywords.add("<b>Twinspell</b>");
        keywords.add("<b>Mega-Windfury</b>");
        keywords.add("<b>Reborn</b>");
        keywords.add("<b>Invoke</b>");
        keywords.add("<b>Outcast[:]</b>");
        keywords.add("<b>Passive Hero Power</b>");
        keywords.add("<b>Rush</b>");
        keywords.add("<b>Hero Power</b>");
        keywords.add("<b>Start of Combat:</b>");
        keywords.add("<b>Lifesteal</b>");
        keywords.add("<b>Immune</b>");
        keywords.add("<b>Discover</b>");
        keywords.add("<b>Lifesteal</b>");
        keywords.add("<b>Dormant</b>");
        keywords.add("<b>Sidequest:</b>");
        keywords.add("<b>Reward</b>");
        keywords.addLast("<b>Choose One-</b>");


        for (String s: keywords
        ) {
            input = input.replaceAll(s, "");
        }
    }

    public void blankSpaceCleaner(){
        input = input.replaceAll("&nbsp", " ");
        input = input.replaceAll( "\\s+", " ");

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
