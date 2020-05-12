package com;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

public class WriteJsonFile {

    WriteJsonFile(List<ScoredCard> cardList) throws IOException {
        File file = new File("C:\\Users\\genes\\Desktop\\HSjson files\\HSDBScored.json");
        File txtFile = new File("C:\\Users\\genes\\Desktop\\HSjson files\\HSBDScored.txt");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root;
        List<ScoredCard> out = new LinkedList<>();
        String jString;

        for (ScoredCard scoredCard: cardList
             ) {
            jString = mapper.writeValueAsString(scoredCard);
            root = mapper.readTree(jString);
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
            out.add(mapper.readValue(jString, ScoredCard.class));



        }
        for (ScoredCard card: out
             ) {
            System.out.println(card.getMinionScoreStandard());
        }
        mapper.writeValue(file, out);
        mapper.writeValue(txtFile, out);

    }
}
