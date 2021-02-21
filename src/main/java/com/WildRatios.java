package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class WildRatios {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode averages = mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\Averages.json"));
    double standardHealthCost;
    double standardAtkCost;
    double wildHealthCost;
    double wildAtkCost;
    double wildAtk = averages.get("Wild").get("All").get(0).asInt();
    double wildHealth = averages.get("Wild").get("All").get(1).asInt();
    double standardAtk = averages.get("Standard").get("All").get(0).asInt();
    double standardHealth = averages.get("Standard").get("All").get(1).asInt();
    private final double [][] ratios = new double [4][2];
    private final double [][] scores = new double [3][2];
    private double minionScoreWild;
    private double minionScoreStandard;



    WildRatios(Card card) throws IOException {
        card.setStandard(Check.isStandard(card));
        String cost;
        if (Check.isMinion(card)) {
            switch (card.getManaCost()) {
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

            wildAtkCost = averages.get("Wild").get(cost).get(0).asInt();
            wildHealthCost = averages.get("Wild").get(cost).get(1).asInt();

            card.setDamageScoreWild(((card.getAttack() / wildHealth) * (card.getAttack() / wildHealthCost)));
            card.setSurvivalScoreWild(((card.getHealth() / wildAtk) * (card.getHealth() / wildAtkCost)));



            System.out.println(card.getName());
            System.out.println("Mana Cost:             " + card.getManaCost());
            System.out.println("(A/H):                 " + card.getAttack() + " / " + card.getHealth() + "\n");
            System.out.println("Attack Score:          " + card.getDamageScoreWild());
            System.out.println("Survival Score:          " + card.getSurvivalScoreWild() + "\n");
            System.out.println("Minion Score Wild: " + card.getPowerScoreWild());
            System.out.println();
        }

    }

    WildRatios() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode cardFile = mapper.readTree(new File("C:\\HSDeckBuilder\\src\\main\\resources\\WildCardList.json"));
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

                wildAtkCost = averages.get("Wild").get(cost).get(0).asInt();
                wildHealthCost = averages.get("Wild").get(cost).get(1).asInt();

                card.setDamageScoreWild(((card.getAttack() / wildHealth) * (card.getAttack() / wildHealthCost)));
                card.setSurvivalScoreWild(((card.getHealth() / wildAtk) * (card.getHealth() / wildAtkCost)));
                card.setPowerScoreWild(card.getDamageScoreWild() + card.getSurvivalScoreWild());

                card.setControl();
                card.setBonus();
                card.setSpellTrigger();
                card.setDraw();
                card.setEnhanced();
                card.setRepeat();

                tempList.add(card);

                System.out.println("Name:                  " + card.getName());

                System.out.println("Mana Cost:             " + card.getManaCost());
                System.out.println("(A/H):                 " + card.getAttack() + " / " + card.getHealth() + "\n");

                System.out.println("Standard Power Score:  " + card.getPowerScoreStandard());
                System.out.println("Kewword:               " + Arrays.toString(card.getKeywordIds()));

                System.out.println();
                System.out.println();
                System.out.println();
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\HSDeckBuilder\\src\\main\\resources\\WildCardList.json"), tempList);

        }

    }


    public double getMinionScoreWild() {
        return minionScoreWild;
    }

    public double getMinionScoreStandard() {
        return minionScoreStandard;
    }

    public double[][] getScores() {
        return scores;
    }

    public double[][] getRatios() {
        return ratios;
    }

}

