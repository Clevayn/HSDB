package com;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;

public class WordDictionary {


    private final WordInfo wordInfo;

    WordDictionary(String word) throws IOException {

        Request definition = new Request.Builder()
                .url("https://twinword-word-graph-dictionary.p.rapidapi.com/definition/?entry=" + word)
                .get()
                .addHeader("x-rapidapi-host", "twinword-word-graph-dictionary.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "ec1db166bcmsh540ca03947f952bp193027jsn34448bfac482")
                .build();

        Request reference = new Request.Builder()
                .url("https://twinword-word-graph-dictionary.p.rapidapi.com/reference/?entry=" + word)
                .get()
                .addHeader("x-rapidapi-host", "twinword-word-graph-dictionary.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "ec1db166bcmsh540ca03947f952bp193027jsn34448bfac482")
                .build();

        Request association = new Request.Builder()
                .url("https://twinword-word-graph-dictionary.p.rapidapi.com/association/?entry=" + word)
                .get()
                .addHeader("x-rapidapi-host", "twinword-word-graph-dictionary.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "ec1db166bcmsh540ca03947f952bp193027jsn34448bfac482")
                .build();

        OkHttpClient client = new OkHttpClient();
        Response definitionResponse = client.newCall(definition).execute();
        JsonFactory factory = new JsonFactory();
        JsonParser definitionParser = factory.createParser(Objects.requireNonNull(definitionResponse.body()).bytes());

        Response referenceResponse = client.newCall(reference).execute();
        JsonParser referenceParser = factory.createParser(Objects.requireNonNull(referenceResponse.body()).bytes());

        Response associationResponse = client.newCall(association).execute();
        JsonParser associationParser = factory.createParser(Objects.requireNonNull(associationResponse.body()).bytes());

        ObjectMapper mapper = new ObjectMapper();
        wordInfo = new WordInfo(new Definition(mapper.readTree(definitionParser)),
                new Reference(mapper.readTree(referenceParser)),
                new Association(mapper.readTree(associationParser)));


    }

    public WordInfo getWordInfo() {
        return wordInfo;
    }

    static class WordInfo{
        LinkedHashMap<String, Object> output = new LinkedHashMap<>();

        WordInfo(Definition definition, Reference reference, Association association){

            output.put("Definition", definition.getOutput());
            output.put("Reference", reference.getOutput());
            output.put("Association", association.getWords());


        }

        public LinkedHashMap<String, Object> getOutput() {
            return output;
        }
    }

    public static class Definition {
        LinkedHashMap<String, List<String>> output = new LinkedHashMap<>();

        Definition(JsonNode root) {

            output.put("Noun", Arrays.asList(root.get("meaning")
                    .get("noun")
                    .asText()
                    .replaceAll("\\(nou\\)", "")
                    .strip()
                    .split("$")));
            output.put("Verb", Arrays.asList(root.get("meaning")
                    .get("verb")
                    .asText()
                    .replaceAll("\\(vrb\\)", "")
                    .strip()
                    .split("$")));
            output.put("Adverb", Arrays.asList(root.get("meaning")
                    .get("adverb")
                    .asText()
                    .replaceAll("\\(adv\\)", "")
                    .strip()
                    .split("$")));
            output.put("Adjective", Arrays.asList(root.get("meaning")
                    .get("adjective")
                    .asText()
                    .replaceAll("\\(adj\\)", "")
                    .strip()
                    .split("$")));


        }

        public LinkedHashMap<String, List<String>> getOutput() {
            return output;
        }
    }

    public static class Association {
        List<String> words = new LinkedList<>();

        Association(JsonNode root){

            root.get("assoc_word").forEach(node -> words.add(node.asText()));
            root.get("assoc_word_ex").forEach(node -> {
                if(!words.contains(node.asText()))words.add(node.asText());
            });


        }

        public List<String> getWords() {
            return words;
        }
    }

    public static class Reference {
        LinkedHashMap<String, List<String>> output = new LinkedHashMap<>();

        Reference(JsonNode root){

            output.put("Associations", Arrays.asList(root.get("relation").get("associations").asText().split(",")));
            output.put("Broads Terms", Arrays.asList(root.get("relation").get("broad_terms").asText().split(",")));
            output.put("Derived Terms", Arrays.asList(root.get("relation").get("derived_terms").asText().split(",")));
            output.put("Evocations", Arrays.asList(root.get("relation").get("evocations").asText().split(",")));
            output.put("Narrow Terms", Arrays.asList(root.get("relation").get("narrow_terms").asText().split(",")));
            output.put("Related Terms", Arrays.asList(root.get("relation").get("related_terms").asText().split(",")));
            output.put("Synonyms Terms", Arrays.asList(root.get("relation").get("synonyms").asText().split(",")));
        }

        public LinkedHashMap<String, List<String>> getOutput() {
            return output;
        }
    }
}
