package com;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        AtomicReference<String> s = new AtomicReference<>("");
        AtomicReference<Integer> n = new AtomicReference<>(0);


        new Text.Searcher().actionBuilder();
        /*new Filter()
                .collectible()
                .minions()
                .getCardList()
                .forEach(scoredCard -> {
                    try {
                        s.set(new Text.Cleaner(scoredCard.getText().toLowerCase())
                                .blankSpaceCleaner()
                                .italicCleaner()
                                .targeterReplace()
                                .statesReplace()
                                .conditionReplace()
                                .effectReplace()
                                .joinerReplace()
                                .blankSpaceCleaner()
                                .getStringLower().trim());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (!s.get().equals("")) {
                        System.out.println(s.get());
                        System.out.println(scoredCard.getText() +"\n");
                        n.getAndSet(n.get() + 1 );
                    }

                });*/






    }









}