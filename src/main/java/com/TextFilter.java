package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextFilter {
    File map = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\CountedWordList.json");
    File mapKeys = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\keyList.json");
    File occurrence = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\occurrence.json");
    File alphabetical = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\alphabetical.json");
    File numerical = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\numerical.json");
    private final ObjectMapper mapper = new ObjectMapper();


    JsonNode valueMap = mapper.readTree(map);






    TextFilter() throws IOException {
        LinkedHashMap<String, Long> all = new LinkedHashMap<>();
        LinkedHashMap<String, Long> one = new LinkedHashMap<>();
        LinkedHashMap<String, Long> two = new LinkedHashMap<>();
        LinkedHashMap<String, Long> three = new LinkedHashMap<>();
        LinkedHashMap<String, Long> four = new LinkedHashMap<>();
        LinkedHashMap<String, Long> five = new LinkedHashMap<>();
        LinkedHashMap<String, Long> six = new LinkedHashMap<>();
        LinkedHashMap<String, Long> seven = new LinkedHashMap<>();
        LinkedHashMap<String, Long> eight = new LinkedHashMap<>();
        LinkedHashMap<String, Long> nine = new LinkedHashMap<>();
        LinkedHashMap<String, Long> tenTwenty = new LinkedHashMap<>();
        LinkedHashMap<String, Long> twentyThirty = new LinkedHashMap<>();
        LinkedHashMap<String, Long> thirtyForty = new LinkedHashMap<>();
        LinkedHashMap<String, Long> fortyFifty = new LinkedHashMap<>();
        LinkedHashMap<String, Long> fiftySixty = new LinkedHashMap<>();
        LinkedHashMap<String, Long> sixtySeventy = new LinkedHashMap<>();
        LinkedHashMap<String, Long> seventyEighty = new LinkedHashMap<>();
        LinkedHashMap<String, Long> eightyNinety = new LinkedHashMap<>();
        LinkedHashMap<String, Long> ninetyHundred = new LinkedHashMap<>();
        LinkedHashMap<String, Long> hundredTwo = new LinkedHashMap<>();
        LinkedHashMap<String, Long> twoHundredThree = new LinkedHashMap<>();
        LinkedHashMap<String, Long> threeHundredFour = new LinkedHashMap<>();
        LinkedHashMap<String, Long> fourHundredAbove = new LinkedHashMap<>();

        LinkedList<String> a = new LinkedList<>();
        LinkedList<String> b = new LinkedList<>();
        LinkedList<String> c = new LinkedList<>();
        LinkedList<String> d = new LinkedList<>();
        LinkedList<String> e = new LinkedList<>();
        LinkedList<String> f = new LinkedList<>();
        LinkedList<String> g = new LinkedList<>();
        LinkedList<String> h = new LinkedList<>();
        LinkedList<String> i = new LinkedList<>();
        LinkedList<String> j = new LinkedList<>();
        LinkedList<String> k = new LinkedList<>();
        LinkedList<String> l = new LinkedList<>();
        LinkedList<String> m = new LinkedList<>();
        LinkedList<String> n = new LinkedList<>();
        LinkedList<String> o = new LinkedList<>();
        LinkedList<String> p = new LinkedList<>();
        LinkedList<String> q = new LinkedList<>();
        LinkedList<String> r = new LinkedList<>();
        LinkedList<String> s = new LinkedList<>();
        LinkedList<String> t = new LinkedList<>();
        LinkedList<String> u = new LinkedList<>();
        LinkedList<String> v = new LinkedList<>();
        LinkedList<String> w = new LinkedList<>();
        LinkedList<String> x = new LinkedList<>();
        LinkedList<String> y = new LinkedList<>();
        LinkedList<String> z = new LinkedList<>();

        LinkedList<String> ones = new LinkedList<>();
        LinkedList<String> twos = new LinkedList<>();
        LinkedList<String> threes = new LinkedList<>();
        LinkedList<String> fours = new LinkedList<>();
        LinkedList<String> fives = new LinkedList<>();
        LinkedList<String> sixes = new LinkedList<>();
        LinkedList<String> sevens = new LinkedList<>();
        LinkedList<String> eights = new LinkedList<>();
        LinkedList<String> nines = new LinkedList<>();

        LinkedList<String> tenTwenties = new LinkedList<>();
        LinkedList<String> twentyThirties = new LinkedList<>();
        LinkedList<String> thirtyForties = new LinkedList<>();
        LinkedList<String> fortyFifties = new LinkedList<>();
        LinkedList<String> fiftySixties = new LinkedList<>();
        LinkedList<String> sixtySeventies = new LinkedList<>();
        LinkedList<String> seventyEighties = new LinkedList<>();
        LinkedList<String> eightieNinties = new LinkedList<>();
        LinkedList<String> ninetyHundreds = new LinkedList<>();
        LinkedList<String> hundredTwos = new LinkedList<>();
        LinkedList<String> twoThrees = new LinkedList<>();
        LinkedList<String> threeFours = new LinkedList<>();
        LinkedList<String> fourAbove = new LinkedList<>();



        for (Iterator<String> it = valueMap.fieldNames(); it.hasNext(); ) {
            String string = it.next();
            long value = valueMap.get(string).asLong();
            all.put(string, value);
            if (value == 1) {
                ones.add(string);
                one.put(string, value);
            }
            if (value == 2) {
                twos.add(string);
                two.put(string, value);
            }
            if (value == 3) {
                threes.add(string);
                three.put(string, value);
            }
            if (value == 4) {
                fours.add(string);
                four.put(string, value);
            }
            if (value == 5) {
                fives.add(string);
                five.put(string, value);
            }
            if (value == 6) {
                sixes.add(string);
                six.put(string, value);
            }
            if (value == 7) {
                sevens.add(string);
                seven.put(string, value);
            }
            if (value == 8) {
                eights.add(string);
                eight.put(string, value);
            }
            if (value == 9) {
                nines.add(string);
                nine.put(string, value);
            }
            if (value >= 10 && value < 20) {
                tenTwenties.add(string);
                tenTwenty.put(string, value);
            }
            if (value >= 20 && value < 30) {
                twentyThirties.add(string);
                twentyThirty.put(string, value);
            }
            if (value >= 30 && value < 40) {
                thirtyForties.add(string);
                thirtyForty.put(string, value);
            }
            if (value >= 40 && value < 50) {
                fortyFifties.add(string);
                fortyFifty.put(string, value);
            }
            if (value >= 50 && value < 60) {
                fiftySixties.add(string);
                fiftySixty.put(string, value);
            }
            if (value >= 60 && value < 70) {
                sixtySeventies.add(string);
                sixtySeventy.put(string, value);
            }
            if (value >= 70 && value < 80) {
                seventyEighties.add(string);
                seventyEighty.put(string, value);
            }
            if (value >= 80 && value < 90) {
                eightieNinties.add(string);
                eightyNinety.put(string, value);
            }
            if (value >= 90 && value < 100) {
                ninetyHundreds.add(string);
                ninetyHundred.put(string, value);
            }
            if (value >= 100 && value < 200) {
                hundredTwos.add(string);
                hundredTwo.put(string, value);
            }
            if (value >= 200 && value < 300) {
                twoThrees.add(string);
                twoHundredThree.put(string, value);
            }
            if (value >= 300 && value < 400) {
                threeFours.add(string);
                threeHundredFour.put(string, value);
            }
            if (value >= 400) {
                fourAbove.add(string);
                fourHundredAbove.put(string, value);
            }

            if (string.toLowerCase().startsWith("a") && !a.contains(string)) a.add(string);
            if (string.toLowerCase().startsWith("b") && !b.contains(string)) b.add(string);
            if (string.toLowerCase().startsWith("c") && !c.contains(string)) c.add(string);
            if (string.toLowerCase().startsWith("d") && !d.contains(string)) d.add(string);
            if (string.toLowerCase().startsWith("e") && !e.contains(string)) e.add(string);
            if (string.toLowerCase().startsWith("f") && !f.contains(string)) f.add(string);
            if (string.toLowerCase().startsWith("g") && !g.contains(string)) g.add(string);
            if (string.toLowerCase().startsWith("h") && !h.contains(string)) h.add(string);
            if (string.toLowerCase().startsWith("i") && !i.contains(string)) i.add(string);
            if (string.toLowerCase().startsWith("j") && !j.contains(string)) j.add(string);
            if (string.toLowerCase().startsWith("k") && !k.contains(string)) k.add(string);
            if (string.toLowerCase().startsWith("l") && !l.contains(string)) l.add(string);
            if (string.toLowerCase().startsWith("m") && !m.contains(string)) m.add(string);
            if (string.toLowerCase().startsWith("n") && !n.contains(string)) n.add(string);
            if (string.toLowerCase().startsWith("o") && !o.contains(string)) o.add(string);
            if (string.toLowerCase().startsWith("p") && !p.contains(string)) p.add(string);
            if (string.toLowerCase().startsWith("q") && !q.contains(string)) q.add(string);
            if (string.toLowerCase().startsWith("r") && !r.contains(string)) r.add(string);
            if (string.toLowerCase().startsWith("s") && !s.contains(string)) s.add(string);
            if (string.toLowerCase().startsWith("t") && !t.contains(string)) t.add(string);
            if (string.toLowerCase().startsWith("u") && !u.contains(string)) u.add(string);
            if (string.toLowerCase().startsWith("v") && !v.contains(string)) v.add(string);
            if (string.toLowerCase().startsWith("w") && !w.contains(string)) w.add(string);
            if (string.toLowerCase().startsWith("x") && !x.contains(string)) x.add(string);
            if (string.toLowerCase().startsWith("y") && !y.contains(string)) y.add(string);
            if (string.toLowerCase().startsWith("z") && !z.contains(string)) z.add(string);

        }

        LinkedHashMap<String, LinkedList<String>> numerical = new LinkedHashMap<>();
        numerical.put("1", ones);
        numerical.put("2", twos);
        numerical.put("3", threes);
        numerical.put("4", fours);
        numerical.put("5", fives);
        numerical.put("6", sixes);
        numerical.put("7", sevens);
        numerical.put("8", eights);
        numerical.put("9", nines);
        numerical.put("10-19", tenTwenties);
        numerical.put("20-29", twentyThirties);
        numerical.put("30-39", thirtyForties);
        numerical.put("40-49", fortyFifties);
        numerical.put("50-59", fiftySixties);
        numerical.put("60-69", sixtySeventies);
        numerical.put("70-79", seventyEighties);
        numerical.put("80-89", eightieNinties);
        numerical.put("90-99", ninetyHundreds);
        numerical.put("100-199", hundredTwos);
        numerical.put("200-299", twoThrees);
        numerical.put("300-399", threeFours);
        numerical.put("400 & Above", fourAbove);


        LinkedHashMap<String, LinkedList<String>> alphabetical = new LinkedHashMap<>();
        alphabetical.put("A", a);
        alphabetical.put("B", b);
        alphabetical.put("C", c);
        alphabetical.put("D", d);
        alphabetical.put("E", e);
        alphabetical.put("F", f);
        alphabetical.put("G", g);
        alphabetical.put("H", h);
        alphabetical.put("I", i);
        alphabetical.put("J", j);
        alphabetical.put("K", k);
        alphabetical.put("L", l);
        alphabetical.put("M", m);
        alphabetical.put("N", n);
        alphabetical.put("O", o);
        alphabetical.put("P", p);
        alphabetical.put("Q", q);
        alphabetical.put("R", r);
        alphabetical.put("S", s);
        alphabetical.put("T", t);
        alphabetical.put("U", u);
        alphabetical.put("V", v);
        alphabetical.put("W", w);
        alphabetical.put("X", x);
        alphabetical.put("Y", y);
        alphabetical.put("Z", z);

        LinkedHashMap<String, LinkedHashMap<String, Long>> occurance = new LinkedHashMap<>();
        occurance.put("All", all);
        occurance.put("One", one);
        occurance.put("Two", two);
        occurance.put("Three", three);
        occurance.put("Four", four);
        occurance.put("Five", five);
        occurance.put("Six", six);
        occurance.put("Seven", seven);
        occurance.put("Eight", eight);
        occurance.put("Nine", nine);
        occurance.put("Ten to Twenty", tenTwenty);
        occurance.put("Twenty to Thirty", twentyThirty);
        occurance.put("Thirty to Forty", thirtyForty);
        occurance.put("Forty to Fifty", fortyFifty);
        occurance.put("Fifty to Sixty", fiftySixty);
        occurance.put("Sixty to Seventy", sixtySeventy);
        occurance.put("Seventy to Eighty", seventyEighty);
        occurance.put("Eighty to Ninety", eightyNinety);
        occurance.put("Ninety to One Hundred", ninetyHundred);
        occurance.put("One Hundred to Two Hundred", hundredTwo);
        occurance.put("Two Hundred to Three Hundred", twoHundredThree);
        occurance.put("Three Hundred to Four Hundred", threeHundredFour);
        occurance.put("Four Hundred and Above", fourHundredAbove);






        mapper.writerWithDefaultPrettyPrinter().writeValue(this.alphabetical, alphabetical);
        mapper.writerWithDefaultPrettyPrinter().writeValue(this.occurrence, occurance);
        mapper.writerWithDefaultPrettyPrinter().writeValue(this.numerical, numerical);

    }




    public static class WordCounter extends TextFilter {
        private final File WordList = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\WordList.json");
        private final ObjectMapper mapper = new ObjectMapper();



        WordCounter() throws IOException {


            List<String> list = listBuilder();
            Map<String, Long> map = mapBuilder();

            mapper.writerWithDefaultPrettyPrinter().writeValue(WordList, list);
            mapper.writerWithDefaultPrettyPrinter().writeValue(mapKeys, new LinkedList<>(map.keySet()));
            mapper.writerWithDefaultPrettyPrinter().writeValue(this.map, map);
        }

        Map<String, Long> mapBuilder() throws IOException {
            List<String> list = new LinkedList<>();
            for (JsonNode node: mapper.readTree(WordList)) list.add(node.asText());
            return list.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        }

        List<String> listBuilder() throws IOException {
            List<String> out = new LinkedList<>();
            for (ScoredCard scoredCard : new Filter().getCardList()) {
                if (!"".equals(scoredCard.getText())) {
                    out.addAll(Arrays.asList(new StringCleaner(scoredCard.getText())
                            .boldCleaner()
                            .italicCleaner()
                            .punCleaner()
                            .numCleaner()
                            .blankSpaceCleaner()
                            .getString()
                            .strip()
                            .split(" ")));
                }
            }

            return out;
        }


        public static class StringCleaner {
            private final ObjectMapper mapper = new ObjectMapper();
            private String input;

            StringCleaner(String input) {
                this.input = input;
            }

            public StringCleaner properNamesCleaner() throws IOException {
                for (JsonNode string: mapper.readTree(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\ProperNames.json"))
                     ) {

                    this.input = this.input.replaceAll("\\b[\\s]" + string.asText() + "\\b", "");
                }
                return this;
            }

            public StringCleaner italicCleaner(){
                if (this.input.contains("<i>")) this.input = this.input.replaceAll("<i>|</i>", "");
                return this;
            }

            public StringCleaner boldCleaner(){
                if (this.input.contains("<b>")) this.input = this.input.replaceAll("<b>|</b>", "");
                return this;
            }

            public StringCleaner classCleaner(){
                Pattern pattern;

                String [] classNames = {"[Dd]ruid", "[Hh]unter", "[Mm]age", "[Pp]aladin", "[Pp]riest", "[Rr]ogue",
                        "[Ss]haman", "[Ww]arlock",
                        "[Ww]arrior", "[Dd]emon [Hh]unter"};
                for (String s: classNames
                ) {
                    this.input = this.input.replaceAll("\\b" + Pattern.compile(s) + "\\b", "");
                }
                return this;
            }

            public StringCleaner gameTerms(){
                List<String> list = Arrays.asList("[Mm]inion[s|\\s]", "[Hh]ero [Pp]owers", "[Dd]ormant", "[Ss]pell[s|\\s]",
                        "[Hh]ero[es|\\s]", "[Hh]ero", "[Mm]ana [Cc]rystal[s|\\s]", "Auto Attack", "[Ii]llidari", "Galakrond",
                        "[Aa]rmor", "[Ff]rozen", "[Mm]ana", "[Cc]oin", "[Dd]urability", "[Ww]eapon", "[Ss]pell");
                for (String s: list
                ) {
                    this.input = this.input.replaceAll("\\b" + Pattern.compile(s) + "\\b", "");
                }
                return this;
            }

            public StringCleaner pronouns(){
                List<String> firstPersonSub = Arrays.asList("\\b[Ii]\\b", "\\b[Ww]e\\b");
                List<String> firstPersonObj = Arrays.asList("\\b[Mm]e\\b", "\\b[Uu]s\\b");
                List<String> secondPerson = Collections.singletonList("\\b[Yy]ou[\\sre]\\b");
                List<String> thirdPersonSub = Arrays.asList("\\b[Hh]e\\b", "\\b[Ss]he\\b", "\\b[Ii]t[\\ss]\\b", "\\b[Tt]hey\\b");
                List<String> thirdPersonObj = Arrays.asList("\\b[Hh]im\\b", "\\b[Hh]er\\b", "\\b[Ii]t[\\ss]\\b", "\\b[Tt]hem\\b");
                List<List<String>> list = new LinkedList<>();
                list.add(firstPersonSub);
                list.add(firstPersonObj);
                list.add(secondPerson);
                list.add(thirdPersonSub);
                list.add(thirdPersonObj);

                list.forEach(l -> l.forEach(l1 -> this.input = this.input.replaceAll(l1, "")));

                return this;
            }

            public StringCleaner articlesCleaner(){
                List<String> indefArt = Arrays.asList("\\b[Aa]\\b", "\\b[Tt]he\\b", "\\b[Tt]his\\b", "\\b[Tt]o\\b", "\\b[Aa]t\\b",
                        "");
                indefArt.forEach(s -> this.input = this.input.replaceAll(s, ""));
                return this;
            }

            public StringCleaner phraseCleaner(){
                List<String> phrases = Arrays.asList("Illidari", "Charrrrrge", "Side Quest", "Reward", "'Azari the Devourer'",
                        "Sealed Un'Goro Pack", "Jade Idols", "Dinosaur Forms", "Stars' Fury", "King Krush",
                        "'deal damage'", "&nbsp", "nbsp");
                for (String s: phrases
                ) {
                    this.input = this.input.replaceAll("mana crystals", "mana");
                    this.input = this.input.replaceAll(s, "");
                }
                return this;
            }

            public StringCleaner tokenCleaner(){
                String [] tokens = {"[Ss]quirrel[s|\\s]", "[Ss]pirit [Ww]olves", "[Tt]reant[s|\\s]", "[Ff]elwing[s|\\s]", "[Bb]ee[s|\\s]", "[Ll]oti's",
                        "[Dd]ryad[s|\\s]", "[Rr]aptors[s|\\s]", "[Ss]apling[s|\\s]", "[Bb]ruiser[s|\\s]", "[Gg]aurdian[s|\\s]",
                        "[Cc]at[s|\\s]", "[Bb]ear[s|\\s]", "[Rr]at[s|\\s]", "[Ll]ynx[s|\\s]", "[Ww]olves[s|\\s]", "[Hh]yena[s|\\s]",
                        "[Ww]ebspinner[s|\\s]", "[Ll]ocust[s|\\s]", "[Gg]oblin [Bb]omb[s|\\s]","[Ss]carab[s|\\s]", "[Ss]aytr[s|\\s]",
                        "[Ss]andwasp[s|\\s]", "[Mm]icrocopters[s|\\s]", "True Silver Champion", "[Mm]ithril [Gg]olem[s|\\s]",
                        "[Bb]oom [Bb]ot[s|\\s]", "Jo-E Bot[s|\\s]", "[Ss]pider[s|\\s]", "[Ww]isp[s|\\s]", "[Pp]terrordaxe[s|\\s]",
                        "[Pp]ogo [Hh]opper[s|\\s]", "[Rr]azorpetal[s|\\s]", "[Dd]irehorn", "[Bb]oar", "[Mm]uckling[s|\\s]", "[Pp]lates", "[Mm]echs"};
                for (String s: tokens
                ) {
                    this.input = this.input.replaceAll(String.valueOf(Pattern.compile(s)), "");
                }
                return this;
            }

            public StringCleaner wordNumCleaner(){
                List<String> wordNum = Arrays.asList("[Oo]ne", "[Tt]wo", "[Tt]hree", "[Ff]our", "[Ff]ive", "[Ss]ix", "[Ss]even",
                        "[Ee]ight", "[Nn]ine", "[Tt]en");
                for (String s: wordNum
                ) {
                    this.input = this.input.replaceAll("\\b"+Pattern.compile(s)+"\\b", "");
                }
                return this;
            }

            public StringCleaner minionTypeCleaner(){
                String [] minionType = {"[Mm]urloc[s|\\s]", "[Dd]emon", "[Mm]ech", "[Ee]lemental", "[Bb]east",
                        "[Tt]otem", "[Pp]irate", "[Dd]ragon[s|\\s]", "[Dd]ragon"};
                for (String s: minionType
                ) {
                    this.input = this.input.replaceAll("\\b"+Pattern.compile(s)+"\\b", "");
                }
                return this;
            }

            public StringCleaner numCleaner(){

                this.input = this.input.replaceAll("\\b\\d\\d\\d\\b", "   ");
                this.input = this.input.replaceAll("\\b\\d\\d\\b", "   ");
                this.input = this.input.replaceAll("\\b\\d\\b", "   ");
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
                this.input = this.input.replaceAll("'", "");
                this.input = this.input.replaceAll("[\\x21-\\x2F\\x3A-\\x3F]" , "   ");
                return this;
            }

            public StringCleaner keywordCleaner() {
                LinkedList<String> keywords = new LinkedList<>();
                keywords.add("Taunt");
                keywords.add("Spell Power");
                keywords.add("Spell Damage");
                keywords.add("Divine Shield");
                keywords.add("Charge");
                keywords.add("Secret");
                keywords.add("Stealth");
                keywords.add("Battlecry");
                keywords.add("Freeze");
                keywords.add("Windfury");
                keywords.add("Deathrattle");
                keywords.add("Combo");
                keywords.add("Overload");
                keywords.add("Silence");
                keywords.add("Counter");
                keywords.add("Immune");
                keywords.add("Inspire");
                keywords.add("Discover");
                keywords.add("Quest");
                keywords.add("Poisonous");
                keywords.add("Adapt");
                keywords.add("Lifesteal");
                keywords.add("Recruit");
                keywords.add("Echo");
                keywords.add("Rush");
                keywords.add("Overkill");
                keywords.add("Magnetic");
                keywords.add("Lackey");
                keywords.add("Twinspell");
                keywords.add("Mega Windfury");
                keywords.add("Reborn");
                keywords.add("Invoke");
                keywords.add("Outcast");
                keywords.add("Passive Hero Power");
                keywords.add("Rush");
                keywords.add("Hero Power");
                keywords.add("Start of Combat");
                keywords.add("Lifesteal");
                keywords.add("Immune");
                keywords.add("Discover");
                keywords.add("Lifesteal");
                keywords.add("Dormant");
                keywords.add("Sidequest");
                keywords.add("Reward");
                keywords.add("Choose One");
                keywords.add("Hero Power");

                for (String s: keywords
                ) {
                    input = input.replaceAll(s, "");
                }
                return this;

            }

            public StringCleaner blankSpaceCleaner(){
                this.input = this.input.replaceAll( "nbsp", "");
                this.input = this.input.replaceAll( "\\s+", " ");
                return this;
            }

            public String getStringLower(){
                return input.toLowerCase();
            }

            public static void properNameList() throws IOException {
                List<ScoredCard> cards = new Filter().getCardList();
                ObjectMapper mapper = new ObjectMapper();
                File ProperNames = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\ProperNames.json");
                LinkedList<String> properNames = new LinkedList<>();
                for (ScoredCard card: cards
                ) {
                    properNames.add(card.getName());
                }
                properNames.add(String.valueOf(properNames.size()));
                mapper.writerWithDefaultPrettyPrinter().writeValue(ProperNames, properNames);
            }

            public String getString() {
                return input;
            }
        }
    }
}
