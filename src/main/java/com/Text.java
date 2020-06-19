package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Text {

    Filter cardPool = new Filter();
    public List<ScoredCard> cards = cardPool.getCardList();
    LinkedList<String> singleWord = new LinkedList<>();
    LinkedList<String> allWords = new LinkedList<>();
    ObjectMapper mapper = new ObjectMapper();
    File WordList = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\WordList.json");
    File ProperNames = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\ProperNames.json");
    File Keywords = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\KeywordList.json");
    public Text() throws IOException {}


    public void wordList() throws IOException {
        int x = 0;
        LinkedHashMap<Integer, String> wordList = new LinkedHashMap<>();
        for (ScoredCard card: cards
        ) {
            String text = new StringCleaner(card.getText().toLowerCase()).getStringLower().trim();
            if (!text.equals(""))System.out.println(text);
            List<String> words = Arrays.asList(text.split(" "));

            words.forEach(s -> {
                if (!s.equals("")) allWords.add(s);
                if (!singleWord.contains(s) && !s.equals("")) singleWord.add(s);

            });

            x++;
            if (!text.equals(""))System.out.println(x);
        }

        wordList.put(allWords.size(), "Total Words");
        wordList.put(singleWord.size(), "Individual Word Count");

        for (String s: singleWord
        ) {
            wordList.put((int)allWords.stream().filter(s::equals).count(), s);
        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(WordList, wordList);
    }

    public void keywordList() throws IOException {

        LinkedHashMap<Integer, String> keywords = new LinkedHashMap<>();
        keywords.put(1, "Taunt");
        keywords.put(2, "Spell Power");
        keywords.put(3, "Divine Shield");
        keywords.put(4, "Charge");
        keywords.put(5, "Secret");
        keywords.put(6, "Stealth");
        keywords.put(8, "Battlecry");
        keywords.put(10, "Freeze");
        keywords.put(11, "Windfury");
        keywords.put(12, "Deathrattle");
        keywords.put(13, "Combo");
        keywords.put(14, "Overload");
        keywords.put(15, "Silence");
        keywords.put(16, "Counter");
        keywords.put(17, "Immune");
        keywords.put(20, "Inspire");
        keywords.put(21, "Discover");
        keywords.put(31, "Quest");
        keywords.put(32, "Poisonous");
        keywords.put(34, "Adapt");
        keywords.put(38, "Lifesteal");
        keywords.put(39, "Recruit");
        keywords.put(52, "Echo");
        keywords.put(53, "Rush");
        keywords.put(61, "Overkill");
        keywords.put(66, "Magnetic");
        keywords.put(71, "Lackey");
        keywords.put(76, "Twinspell");
        keywords.put(77, "Mega-Windfury");
        keywords.put(78, "Reborn");
        keywords.put(79, "Invoke");
        keywords.put(86, "Outcast");

        mapper.writerWithDefaultPrettyPrinter().writeValue(Keywords, keywords);



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

    public static class StringCleaner extends Text {
        private String input;

        StringCleaner(String input) throws IOException {
            super();
            this.input = input;

            keywordCleaner();

            punCleaner();

            properNamesCleaner();

            phraseCleaner();

            classCleaner();

            italicCleaner();

            tokenCleaner();

            minionTypeCleaner();

            numCleaner();

            blankSpaceCleaner();





        }

        public void characterRemover(){
            char [] characters = {'-', '/', '+', '(', ')', '?'};

            for (char x : characters
            ) {
                input = input.replace(x, ' ');
                input = input.replaceAll("&nbsp", " ");
            }
        }

        void properNamesCleaner() throws IOException {
            for (JsonNode string: mapper.readTree(ProperNames)
                 ) {
                if (!string.asText().toLowerCase().equals("polymorph: ???"))
                input = input.replaceAll("\\b" + string.asText().toLowerCase() + "\\b", "").toLowerCase();
            }
        }

        public String getStringLower(){
            return input.toLowerCase();
        }

        public String getString() {
            return input;
        }

        public void italicCleaner(){
            if (input.contains("<i>")) input = input.replaceAll(input.substring(input.indexOf("<i>"), input.indexOf("</i>")), "");
        }

        public void classCleaner(){
            String [] classNames = {"druid", "hunter", "mage", "paladin", "priest", "rogue", "shaman", "warlock",
                    "warrior", "demon hunter"};
            for (String s: classNames
            ) {
                input = input.replaceAll("\\b" +s+ "\\b", "");
            }
        }

        public void phraseCleaner(){
            String [] phrases = {"passive hero power", "hero power", "hero powers", "start of combat", "illidari",
                    "charrrrrge", "side quest", "reward", "''", "'azari the devourer'", "sealed un'goro pack", "jade idols",
                    "dinosaur forms", "ly", "stars' fury", "king krush", "'deal damage'", "pogo hopper", "razorpetals",
                    "pterrordaxes", };
            for (String s: phrases
            ) {
                input = input.replaceAll("mana crystals", "mana");
                input = input.replaceAll(s, "");
            }

        }

        public void tokenCleaner(){
            String [] tokens = {"squirrels", "treants", "felwings", "bees", "loti's", "dryads", "raptors", "saplings",
                    "cat", "bear", "rats", "lynxes", "wolves", "hyenas", "webspinners", "locusts", "goblin bombs",
                    "sandwasps", "microcopters", "true silver champion", "mithril golems", "boom bots", "jo-e bot",
            "spiders", "wisps"};
            for (String s: tokens
            ) {
                input = input.replaceAll("\\b"+s+"\\b", "");
            }
        }

        public void minionTypeCleaner(){
            String [] minionType = {"murloc", "demon", "mech", "elemental", "beast", "totem", "pirate", "dragon"};
            for (String s: minionType
            ) {
                input = input.replaceAll("\\b"+s+"\\b", "");
            }
        }

        public void numCleaner(){

            String [] numbersArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8","9", "10", "11", "12", "13","14", "15",
                    "16", "20", "21", "22", "23", "25", "59", "66", "32", "55", "52", "24", "42", "53",
                    "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

            for (String s: numbersArr
            ) {
                input = input.replaceAll("\\b" + s + "\\b", "");
            }
        }

        public void numReplace(){

            String [] numbersArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8","9", "10", "11", "12", "13","14", "15", "20",
                    "one", "two", "three", "four", "five", "seven"};

            for (String y: numbersArr
            ) {
                input = input.replaceAll("\\b" + y + "\\b", "x");
            }
        }

        public void punCleaner(){

            String [] punctuationArr = { "+", "<b>", "</b>", "<i>", "</i>","+", "/", "\"", ".", ",", ":", ";", "(", ")", "-", "\\", "?", "!", "''"};

            for (String s: punctuationArr
            ) {
                input = input.replace(s, "  ");
            }
        }

        public void keywordCleaner() throws IOException {
            LinkedList<String> keywords = new LinkedList<>();
            keywords.add("<b>taunt</b>");
            keywords.add("spell power");
            keywords.add("divine shield");
            keywords.add("charge");
            keywords.add("secret");
            keywords.add("stealth");
            keywords.add("battlecry");
            keywords.add("freeze");
            keywords.add("windfury");
            keywords.add("deathrattle");
            keywords.add("combo");
            keywords.add("overload");
            keywords.add("silence");
            keywords.add("counter");
            keywords.add("immune");
            keywords.add("inspire");
            keywords.add("discover");
            keywords.add("quest");
            keywords.add("poisonous");
            keywords.add("adapt");
            keywords.add("lifesteal");
            keywords.add("recruit");
            keywords.add("echo");
            keywords.add("rush");
            keywords.add("overkill");
            keywords.add("magnetic");
            keywords.add("lackey");
            keywords.add("twinspell");
            keywords.add("mega-windfury");
            keywords.add("reborn");
            keywords.add("invoke");
            keywords.add("outcast");

            for (String s: keywords
            ) {
                input = input.replaceAll(s, "");
            }
        }

        public void blankSpaceCleaner(){
            input = input.replaceAll("&nbsp", " ");
            input = input.replaceAll( "\\s+", " ");

        }
    }





}
