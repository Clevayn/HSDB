package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        /*JsonNode modifier = mapper.readTree(
                new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\KeywordScore.json"));
        List<ScoredCard> list = new Filter().allMinions().getCardList();

        //new KeywordValue();
        new KeywordValueModifier();
        new KeywordScore();

        list.forEach(scoredCard -> {
            if (scoredCard.getKeywordIds().length > 0){
                if (modifier.findValue(ValueTranslator
                        .classNames(scoredCard.getClassId()))
                        .hasNonNull(ValueTranslator.keywordName(scoredCard.getKeywordIds()[0]))) {
                    System.out.println(scoredCard.getName());
                    System.out.println(scoredCard.getMinionScoreWild() *
                            modifier.findValue(ValueTranslator.classNames(scoredCard.getClassId()))
                                    .findValue(ValueTranslator.keywordName(scoredCard.getKeywordIds()[0]))
                                    .asDouble());
                }
            }
        });
    }*/

        //new Text().wordList();

        LinkedHashMap<String, String> definitions = new LinkedHashMap<>();
        JsonNode words = new ObjectMapper().readTree(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\WordList.json"));


        for (JsonNode node: words
             ) {
            String s = node.asText();
            System.out.println(new WordsAPI(s).getOutput());
        }








    }
}