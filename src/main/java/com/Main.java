package com;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Filter cardPool = new Filter();
        List<ScoredCard> cards = cardPool.getCardList();

        for (ScoredCard card: cards
             ) {
            System.out.println(new StringCleaner(card.getText()).getString());
        }





    }
}