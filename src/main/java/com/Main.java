package com;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        AtomicReference<String> s = new AtomicReference<>("");
        AtomicReference<Integer> n = new AtomicReference<>(0);




        /*new Filter()
                .collectible()
                .minions()
                .getCardList()
                .forEach(scoredCard -> {
                    try {
                        s.set(new Text.Cleaner(scoredCard.getText().toLowerCase())
                                .actionPhraseReplace()
                                .statsCleaner()
                                .blankSpaceCleaner()
                                .boldCleaner()
                                .italicCleaner()
                                .properNamesCleaner()
                                .specialPhraseCleaner()
                                .gameTermCleaner()
                                .minionTypeCleaner()
                                .punCleaner()
                                .wordNumCleaner()
                                .numReplace()
                                .tokenCleaner()
                                .classCleaner()
                                .actionReplace()
                                .effectReplace()
                                .conditionReplace()
                                .specifierReplace()
                                .targetReplace()
                                .statesReplace()
                                .randomCleaner()
                                .blankSpaceCleaner()
                                .getStringLower().trim());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (!s.get().equals("")) {
                        System.out.println(n.get() + "   :    " + s.get());
                        System.out.println(scoredCard.getText() +"\n");
                        n.getAndSet(n.get() + 1 );
                    }

                });*/



    }









}