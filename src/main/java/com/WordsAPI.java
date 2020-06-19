package com;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Objects;

public class WordsAPI {

    File file = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\WordsAPItest.json");
    OkHttpClient client = new OkHttpClient();
    JsonFactory factory = new JsonFactory();
    JsonNode jsonNode;
    ObjectMapper mapper = new ObjectMapper();
    LinkedHashMap<String, String> output = new LinkedHashMap<>();
    LinkedList<JsonNode> test = new LinkedList<>();
    WordsAPI(String word) throws IOException {
        Request request = new Request.Builder()
                .url("https://wordsapiv1.p.rapidapi.com/words/" + word)
                .get()
                .addHeader("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "ec1db166bcmsh540ca03947f952bp193027jsn34448bfac482")
                .build();

        Response response = client.newCall(request).execute();
        JsonParser parser = factory.createParser(Objects.requireNonNull(response.body()).bytes());
        this.jsonNode = mapper.readTree(parser);

        System.out.println(this.jsonNode.findValue("word").textValue());
        try {
            this.jsonNode.findValue("results").elements().forEachRemaining(node -> System.out.println(node.asText()));
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    public LinkedHashMap<String, String> getOutput() {
        return output;
    }
}
