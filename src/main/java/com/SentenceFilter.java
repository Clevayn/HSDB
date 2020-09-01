package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import java.io.IOException;
import java.math.MathContext;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceFilter implements  FilesAndLists{
    Pattern pattern;
    Matcher matcher;

    ObjectMapper mapper = new ObjectMapper();
    JsonNode num = mapper.readTree(numerical);

    List<ScoredCard> list = new Filter().getCardList();



    List<String> allWords = Arrays.asList("destroy", "deal", "give", "gain", "transform", "restore", "summon", "play",  "shuffle", "return",
            "minion", "enemy", "hand", "deck", "battlefield", "opponent", "character",
            "enemies");

    List<String> spellAction = Arrays.asList("destroy", "deal", "give", "gain", "transform", "restore");

    List<String> cardAction = Arrays.asList("summon", "play",  "shuffle", "return");


    List<String> target = Arrays.asList("minion", "enemy", "hand", "deck", "battlefield", "opponent", "character",
            "enemies");

    List<String> death = Arrays.asList("dies", "died", "killed", "kill", "die");



    SentenceFilter() throws IOException {
        List<String> wordOne = new LinkedList<>();
        List<String> wordTwo = new LinkedList<>();
        List<String> wordThree = new LinkedList<>();
        List<String> wordFour = new LinkedList<>();

        for (ScoredCard card: list
            ) {
            String cardText = card.getText();
            for (String word: allWords
                 ) {
                Pattern wordPlusOne = Pattern.compile(word + " (\\w+)");
                Pattern wordPlusTwo = Pattern.compile(word + " (\\w+ \\w+)");
                Pattern wordPlusThree = Pattern.compile(word + " (\\w+ \\w+ \\w+)");
                Pattern wordPlusFour = Pattern.compile(word + " (\\w+ \\w+ \\w+ \\w+)");


                Matcher matcher = wordPlusOne.matcher(cardText);
                Matcher matcher1 = wordPlusTwo.matcher(cardText);
                Matcher matcher2 = wordPlusThree.matcher(cardText);
                Matcher matcher3 = wordPlusFour.matcher(cardText);


                if (matcher.find() && !wordOne.contains(matcher.group(1))) wordOne.add(matcher.group(1));
                if (matcher1.find() && !wordTwo.contains(matcher1.group(1))) wordTwo.add(matcher1.group(1));
                if (matcher2.find() && !wordThree.contains(matcher2.group(1))) wordThree.add(matcher2.group(1));
                if (matcher3.find() && !wordFour.contains(matcher3.group(1))) wordFour.add(matcher3.group(1));
            }



        }

        System.out.println("One Word______________________________________________________________________________");
        wordOne.forEach(System.out::println);
        System.out.println("Two Word:_____________________________________________________________________________");
        wordTwo.forEach(System.out::println);
        System.out.println("Three Word:___________________________________________________________________________");
        wordThree.forEach(System.out::println);
        System.out.println("Four Word:____________________________________________________________________________");







    }
}