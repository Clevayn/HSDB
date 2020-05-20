package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class KeywordScore {
    private final List<ScoredCard> minionList = new Filter().allMinions().collectible().getCardList();
    private final ObjectMapper mapper = new ObjectMapper();
    private final JsonNode keywordValue = mapper.readTree(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\KeywordValue.json"));
    private final JsonNode valueModifier = mapper.readTree(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\KeywordValueModifier.json"));



    public KeywordScore() throws IOException {
        System.out.println(allValue(1));
    }

    double allValue (int kw){

       return this.keywordValue.findValue("NoClass")
               .findValue(ValueTranslator.keywordName(kw)).asDouble();
    }

    double classValue(int classId, int kw){

        return keywordValue.findValue(ValueTranslator.classNames(classId)).findValue(ValueTranslator.keywordName(kw)).asDouble();

    }

    double mainModifier(){

        return 0.0;
    }
}
