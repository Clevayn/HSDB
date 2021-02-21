package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordListsBuilder {
    File map = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\CountedWordList.json");
    File mapKeys = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\keyList.json");
    File occurrence = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\occurrence.json");
    File alphabetical = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\alphabetical.json");
    File numerical = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\numerical.json");
    private final ObjectMapper mapper = new ObjectMapper();
    JsonNode valueMap = mapper.readTree(map);

    WordListsBuilder() throws IOException {
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



        new WordCounter();


        mapper.writerWithDefaultPrettyPrinter().writeValue(this.alphabetical, alphabetical);
        mapper.writerWithDefaultPrettyPrinter().writeValue(this.occurrence, occurance);
        mapper.writerWithDefaultPrettyPrinter().writeValue(this.numerical, numerical);

    }

    public static class WordCounter extends WordListsBuilder {
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
            for (Card card : new Filter().getCardList()) {
                if (!"".equals(card.getText())) {
                    out.addAll(Arrays.asList(new Text.Cleaner(card.getText())
                            .numCleaner()
                            .getString()
                            .strip()
                            .split(" ")));
                }
            }

            return out;
        }


    }

}
