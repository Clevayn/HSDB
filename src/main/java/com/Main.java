package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        new Filter()
                .collectible()
                .minions()
                .getCardList()
                .forEach(scoredCard -> System.out.println(new Text().sentenceStructure(scoredCard.getText()) + "\n"));

    }









}