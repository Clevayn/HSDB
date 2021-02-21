package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StandardRatios {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode averages = mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\Averages.json"));
    double healthCost;
    double atkCost;
    double atk = averages.get("Standard").get("All").get(0).asInt();
    double health = averages.get("Standard").get("All").get(1).asInt();

    public StandardRatios() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode cardFile = mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\StandardCardList.json"));
        List<Card> tempList = new LinkedList<>();
        List<Card> cardList = new LinkedList<>();
        for (JsonNode node : cardFile) cardList.add(new Card(node));
        String cost;

        for (Card card : cardList
        ) {
            if (Check.isMinion(card)){
                switch (card.getManaCost()){
                    case 0:
                        cost = "0";
                        break;
                    case 1:
                        cost = "1";
                        break;
                    case 2:
                        cost = "2";
                        break;
                    case 3:
                        cost = "3";
                        break;
                    case 4:
                        cost = "4";
                        break;
                    case 5:
                        cost = "5";
                        break;
                    case 6:
                        cost = "6";
                        break;
                    case 7:
                        cost = "7";
                        break;
                    case 8:
                        cost = "8";
                        break;
                    case 9:
                        cost = "9";
                        break;
                    case 10:
                        cost = "10";
                        break;
                    default:
                        cost = ">10";
                        break;

                }

                atkCost = averages.get("Standard").get(cost).get(0).asInt();
                healthCost = averages.get("Standard").get(cost).get(1).asInt();


                card.setDamageScoreStandard(((card.getAttack() / health) * (card.getAttack() / healthCost)));
                card.setSurvivalScoreStandard(((card.getHealth() / atk) * (card.getHealth() / atkCost)));
                card.setPowerScoreStandard(card.getDamageScoreStandard() + card.getSurvivalScoreStandard());

                card.setControl();
                card.setBonus();
                card.setSpellTrigger();
                card.setDraw();
                card.setEnhanced();
                card.setRepeat();

                tempList.add(card);

            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\HSDeckBuilder\\src\\main\\resources\\StandardCardList.json"), tempList);

        }

    }
}
