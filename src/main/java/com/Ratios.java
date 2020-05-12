package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

class Ratios{
    //private final Averages averages = new Averages();
    //private final List<ScoredCard> cardList = new LinkedList<>();

    private final double [][] ratios = new double [4][2];
    private final double [][] scores = new double [3][2];
    private final double minionScoreWild;
    private final double minionScoreStandard;

    Ratios(Card card, Averages averages) {

        card.setStandard(Check.isStandard(card));
        double standardHealthCost;
        double standardAtkCost;
        double wildHealthCost;
        double wildAtkCost;
        switch (card.getManaCost()){
                case 0:
                    wildAtkCost = averages.wildAverages[0][0];
                    wildHealthCost = averages.wildAverages[0][1];
                    standardAtkCost = averages.standardAverages[0][0];
                    standardHealthCost = averages.standardAverages[0][1];
                    break;
                case 1:
                    wildAtkCost = averages.wildAverages[1][0];
                    wildHealthCost = averages.wildAverages[1][1];
                    standardAtkCost = averages.standardAverages[1][0];
                    standardHealthCost = averages.standardAverages[1][1];
                    break;
                case 2:
                    wildAtkCost = averages.wildAverages[2][0];
                    wildHealthCost = averages.wildAverages[2][1];
                    standardAtkCost = averages.standardAverages[2][0];
                    standardHealthCost = averages.standardAverages[2][1];
                    break;
                case 3:
                    wildAtkCost = averages.wildAverages[3][0];
                    wildHealthCost = averages.wildAverages[3][1];
                    standardAtkCost = averages.standardAverages[3][0];
                    standardHealthCost = averages.standardAverages[3][1];
                    break;
                case 4:
                    wildAtkCost = averages.wildAverages[4][0];
                    wildHealthCost = averages.wildAverages[4][1];
                    standardAtkCost = averages.standardAverages[4][0];
                    standardHealthCost = averages.standardAverages[4][1];
                    break;
                case 5:
                    wildAtkCost = averages.wildAverages[5][0];
                    wildHealthCost = averages.wildAverages[5][1];
                    standardAtkCost = averages.standardAverages[5][0];
                    standardHealthCost = averages.standardAverages[5][1];
                    break;
                case 6:
                    wildAtkCost = averages.wildAverages[6][0];
                    wildHealthCost = averages.wildAverages[6][1];
                    standardAtkCost = averages.standardAverages[6][0];
                    standardHealthCost = averages.standardAverages[6][1];
                    break;
                case 7:
                    wildAtkCost = averages.wildAverages[7][0];
                    wildHealthCost = averages.wildAverages[7][1];
                    standardAtkCost = averages.standardAverages[7][0];
                    standardHealthCost = averages.standardAverages[7][1];
                    break;
                case 8:
                    wildAtkCost = averages.wildAverages[8][0];
                    wildHealthCost = averages.wildAverages[8][1];
                    standardAtkCost = averages.standardAverages[8][0];
                    standardHealthCost = averages.standardAverages[8][1];
                    break;
                case 9:
                    wildAtkCost = averages.wildAverages[9][0];
                    wildHealthCost = averages.wildAverages[9][1];
                    standardAtkCost = averages.standardAverages[9][0];
                    standardHealthCost = averages.standardAverages[9][1];
                    break;
                case 10:
                    wildAtkCost = averages.wildAverages[10][0];
                    wildHealthCost = averages.wildAverages[10][1];
                    standardAtkCost = averages.standardAverages[10][0];
                    standardHealthCost = averages.standardAverages[10][1];
                    break;
                default:
                    wildAtkCost = averages.wildAverages[11][0];
                    wildHealthCost = averages.wildAverages[11][1];
                    standardAtkCost = averages.standardAverages[11][0];
                    standardHealthCost = averages.standardAverages[11][1];
                    break;
            }

        double wildHealth = averages.wildAverages[12][1];
        double wildAtk = averages.wildAverages[12][0];
        double standardHealth = averages.standardAverages[12][1];
        double standardAtk = averages.standardAverages[12][0];

        ratios[0][0] = card.getAttack() / wildHealth;
        ratios[0][1] = card.getHealth() / wildAtk;

        ratios[1][0] = card.getAttack() / wildHealthCost;
        ratios[1][1] = card.getHealth() / wildAtkCost;

        ratios[2][0] = card.getAttack() / standardHealth;
        ratios[2][1] = card.getHealth() / standardAtk;

        ratios[3][0] = card.getAttack() / standardHealthCost;
        ratios[3][1] = card.getHealth() / standardAtkCost;

        scores[0][0] = ((card.getAttack() / wildHealth) * (card.getAttack() / wildHealthCost)); // attackScoreWild
        scores[1][0] = ((card.getAttack() / standardHealth) * (card.getAttack() / standardHealthCost));

        scores[0][1] = ((card.getHealth() / wildAtk) * (card.getHealth() / wildAtkCost)); // survivalScoreWild
        scores[1][1] = ((card.getHealth() / standardAtk) * (card.getHealth() / standardAtkCost));

        minionScoreWild = (((card.getAttack() / wildHealth) * (card.getAttack() / wildHealthCost))
                + ((card.getHealth() / wildAtk) * (card.getHealth() / wildAtkCost))) / 2;

        minionScoreStandard = (((card.getAttack() / standardHealth) * (card.getAttack() / standardHealthCost))
                + ((card.getHealth() / standardAtk) * (card.getHealth() / standardAtkCost))) / 2;


    }

 /*   Ratios() throws IOException, URISyntaxException {

        Database db = new Database();
        for (Card card : db.getCardDB()
        ) {


            switch (scoredCard.getManaCost()){
                case 0:
                    wildAtkCost = averages.wildAverages[0][0];
                    wildHealthCost = averages.wildAverages[0][1];
                    standardAtkCost = averages.standardAverages[0][0];
                    standardHealthCost = averages.standardAverages[0][1];
                    break;
                case 1:
                    wildAtkCost = averages.wildAverages[1][0];
                    wildHealthCost = averages.wildAverages[1][1];
                    standardAtkCost = averages.standardAverages[1][0];
                    standardHealthCost = averages.standardAverages[1][1];
                    break;
                case 2:
                    wildAtkCost = averages.wildAverages[2][0];
                    wildHealthCost = averages.wildAverages[2][1];
                    standardAtkCost = averages.standardAverages[2][0];
                    standardHealthCost = averages.standardAverages[2][1];
                    break;
                case 3:
                    wildAtkCost = averages.wildAverages[3][0];
                    wildHealthCost = averages.wildAverages[3][1];
                    standardAtkCost = averages.standardAverages[3][0];
                    standardHealthCost = averages.standardAverages[3][1];
                    break;
                case 4:
                    wildAtkCost = averages.wildAverages[4][0];
                    wildHealthCost = averages.wildAverages[4][1];
                    standardAtkCost = averages.standardAverages[4][0];
                    standardHealthCost = averages.standardAverages[4][1];
                    break;
                case 5:
                    wildAtkCost = averages.wildAverages[5][0];
                    wildHealthCost = averages.wildAverages[5][1];
                    standardAtkCost = averages.standardAverages[5][0];
                    standardHealthCost = averages.standardAverages[5][1];
                    break;
                case 6:
                    wildAtkCost = averages.wildAverages[6][0];
                    wildHealthCost = averages.wildAverages[6][1];
                    standardAtkCost = averages.standardAverages[6][0];
                    standardHealthCost = averages.standardAverages[6][1];
                    break;
                case 7:
                    wildAtkCost = averages.wildAverages[7][0];
                    wildHealthCost = averages.wildAverages[7][1];
                    standardAtkCost = averages.standardAverages[7][0];
                    standardHealthCost = averages.standardAverages[7][1];
                    break;
                case 8:
                    wildAtkCost = averages.wildAverages[8][0];
                    wildHealthCost = averages.wildAverages[8][1];
                    standardAtkCost = averages.standardAverages[8][0];
                    standardHealthCost = averages.standardAverages[8][1];
                    break;
                case 9:
                    wildAtkCost = averages.wildAverages[9][0];
                    wildHealthCost = averages.wildAverages[9][1];
                    standardAtkCost = averages.standardAverages[9][0];
                    standardHealthCost = averages.standardAverages[9][1];
                    break;
                case 10:
                    wildAtkCost = averages.wildAverages[10][0];
                    wildHealthCost = averages.wildAverages[10][1];
                    standardAtkCost = averages.standardAverages[10][0];
                    standardHealthCost = averages.standardAverages[10][1];
                    break;
                default:
                    wildAtkCost = averages.wildAverages[11][0];
                    wildHealthCost = averages.wildAverages[11][1];
                    standardAtkCost = averages.standardAverages[11][0];
                    standardHealthCost = averages.standardAverages[11][1];
                    break;
            }

            scoredCard.setDamageRatioWild((scoredCard.getAttack() / wildHealth));
            scoredCard.setSurvivalRatioWild((scoredCard.getHealth() / wildAtk));

            scoredCard.setDamageRatioCostWild((scoredCard.getAttack() / wildHealthCost));
            scoredCard.setSurvivalRatioCostWild((scoredCard.getHealth() / wildAtkCost));

            scoredCard.setDamageRatioStandard(scoredCard.getAttack() / standardHealth);
            scoredCard.setSurvivalRatioStandard((scoredCard.getHealth() / standardAtk));

            scoredCard.setDamageRatioStandardCost((scoredCard.getAttack() / standardHealthCost));
            scoredCard.setSurvivalRatioCostWild((scoredCard.getHealth() / standardAtkCost));

            scoredCard.setDamageScoreWild(scoredCard.getDamageRatioWild() * scoredCard.getDamageRatioWildCost());
            scoredCard.setSurvivalScoreWild(scoredCard.getSurvivalRatioWild() * scoredCard.getDamageRatioWildCost());

            scoredCard.setDamageScoreStandard(scoredCard.getDamageRatioStandard() * scoredCard.getDamageRatioStandardCost());
            scoredCard.setSurvivalScoreStandard(scoredCard.getSurvivalRatioStandard() * scoredCard.getSurvivalRatioStandardCost());

            scoredCard.setMinionScoreWild((scoredCard.getDamageScoreWild() + scoredCard.getSurvivalScoreWild()) / 2);
            scoredCard.setMinionScoreStandard((scoredCard.getDamageScoreStandard() + scoredCard.getSurvivalScoreStandard()) / 2);


            cardList.add(scoredCard);

        }
        File file = new File("C:\\Users\\genes\\Desktop\\HSjson files\\forFilter.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, cardList);
        File txtFile = new File("C:\\Users\\genes\\Desktop\\HSjson files\\forFilter.txt");
        mapper.writeValue(txtFile, cardList);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cardList));

    }*/


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

    /*public List<ScoredCard> getCardList() {
        return cardList;
    }*/
}

