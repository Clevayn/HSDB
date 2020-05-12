package com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PrettyJson {
    private ObjectMapper mapper = new ObjectMapper();



    PrettyJson(List<Card> list) throws IOException {
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list));
        mapper.writerWithDefaultPrettyPrinter().writeValue(
                new File("C:\\Users\\genes\\Desktop\\HSjson files\\HSDB.txt")
                , list);
    }
}
