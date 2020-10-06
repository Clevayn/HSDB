package com;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

public class WriteJsonFile {
    File file;
    ObjectMapper mapper = new ObjectMapper();
    JsonNode root;

    WriteJsonFile(String string) throws IOException {
        this.file = new File("C:\\HSDeckBuilder\\src\\main\\resources\\" + string +".json");
    }


    void writeCardList(List<ScoredCard> cardList) throws IOException {
        List<ScoredCard> out = new LinkedList<>();
        String jString;
        for (ScoredCard scoredCard: cardList
        ) {
            jString = mapper.writeValueAsString(scoredCard);
            root = mapper.readTree(jString);
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
            out.add(mapper.readValue(jString, ScoredCard.class));
        }
        mapper.writeValue(file, out);
    }

    void writeStringList(List<String> list) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, list);
    }

}
