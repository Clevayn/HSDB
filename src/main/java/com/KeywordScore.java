package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

public class KeywordScore {
    private final ObjectMapper mapper = new ObjectMapper();
    private final JsonNode keywordValue =
            mapper.readTree(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\KeywordValue.json"));
    private final JsonNode modifiers =
            mapper.readTree(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\KeywordValueModifier.json"));
    int [] kwId = {1, 2, 3, 4, 5, 6, 8, 10, 11, 12, 13, 14, 15, 17, 20, 21, 31, 32, 34, 38, 39, 52, 53, 61, 66, 71,
            77, 78, 79, 86};
    int [] classId = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14};



    public KeywordScore() throws IOException {
        LinkedHashMap<String, LinkedHashMap<String, Double>> byClass = new LinkedHashMap<>();
        for (int classId: classId
             ) {
            LinkedHashMap<String, Double> byKeyword = new LinkedHashMap<>();
            for (int kw : kwId
            ) {
                double score = mainValue(classId, kw);
               if (score != -1) {
                   score = score *
                           (1 + ((primaryModifier(kw) *
                                   secondModifier(kw) *
                                   thirdModifier(kw) *
                                   fourthModifier(kw))));

                   if (Check.isDblEdgeInt(kw)) score = score * .85;
                   byKeyword.put(ValueTranslator.keywordName(kw), score);
               }

            }
            byClass.put(ValueTranslator.classNames(classId), byKeyword);
        }
        new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\KeywordScore.json"), byClass);
    }

    double mainValue(int classId, int kw){
        if (keywordValue
                .findValue(ValueTranslator.classNames(classId))
                .hasNonNull(ValueTranslator.keywordName(kw)))
            return keywordValue
                .findValue(ValueTranslator.classNames(classId))
                .findValue(ValueTranslator.keywordName(kw)).asDouble();
        else return -1;
    }

    double primaryModifier(int kw){
        if (Check.isEnhancedInt(kw)) return modifiers.findValue("Enhanced").asDouble();
        else if (Check.isSpellTriggerInt(kw)) return modifiers.findValue("Spell Trigger").asDouble();
        else return 1;
    }

    double secondModifier(int kw){
        if (Check.isPassiveInt(kw)) return modifiers.findValue("Passive").asDouble();
        else if (Check.isTempInt(kw)) return modifiers.findValue("Temporary").asDouble();
        else return 1;

    }

    double thirdModifier(int kw){
        if (Check.isActiveInt(kw)) return modifiers.findValue("Active").asDouble();
        else if (Check.isPassiveInt(kw)) return modifiers.findValue("Passive").asDouble();
        else return 1;
    }

    double fourthModifier(int kw){
        if (Check.isControlInt(kw)) return modifiers.findValue("Control").asDouble();
        else if (Check.isBonusInt(kw)) return modifiers.findValue("Bonus").asDouble();
        else if (Check.isDrawInt(kw)) return modifiers.findValue("Draw").asDouble();
        else if (Check.isRepeatInt(kw)) return modifiers.findValue("Repeat").asDouble();
        else return 1;
    }

}
