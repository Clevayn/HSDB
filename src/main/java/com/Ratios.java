package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

class Ratios extends Averages{
    //private final Averages averages = new Averages();
    private final List<Card> cardList = new LinkedList<>();
    double standardHealthCost;
    double standardAtkCost;
    double wildHealthCost;
    double wildAtkCost;
    double wildHealth = wildAverages[12][1];
    double wildAtk = wildAverages[12][0];
    double standardHealth = standardAverages[12][1];
    double standardAtk = standardAverages[12][0];
    private final double [][] ratios = new double [4][2];
    private final double [][] scores = new double [3][2];
    private double minionScoreWild;
    private double minionScoreStandard;



    Ratios(Card card) throws IOException {
        super();
        card.setStandard(Check.isStandard(card));
        switch (card.getManaCost()){
                case 0:
                    wildAtkCost = wildAverages[0][0];
                    wildHealthCost = wildAverages[0][1];
                    standardAtkCost = standardAverages[0][0];
                    standardHealthCost = standardAverages[0][1];
                    break;
                case 1:
                    wildAtkCost = wildAverages[1][0];
                    wildHealthCost = wildAverages[1][1];
                    standardAtkCost = standardAverages[1][0];
                    standardHealthCost = standardAverages[1][1];
                    break;
                case 2:
                    wildAtkCost = wildAverages[2][0];
                    wildHealthCost = wildAverages[2][1];
                    standardAtkCost = standardAverages[2][0];
                    standardHealthCost = standardAverages[2][1];
                    break;
                case 3:
                    wildAtkCost = wildAverages[3][0];
                    wildHealthCost = wildAverages[3][1];
                    standardAtkCost = standardAverages[3][0];
                    standardHealthCost = standardAverages[3][1];
                    break;
                case 4:
                    wildAtkCost = wildAverages[4][0];
                    wildHealthCost = wildAverages[4][1];
                    standardAtkCost = standardAverages[4][0];
                    standardHealthCost = standardAverages[4][1];
                    break;
                case 5:
                    wildAtkCost = wildAverages[5][0];
                    wildHealthCost = wildAverages[5][1];
                    standardAtkCost = standardAverages[5][0];
                    standardHealthCost = standardAverages[5][1];
                    break;
                case 6:
                    wildAtkCost = wildAverages[6][0];
                    wildHealthCost = wildAverages[6][1];
                    standardAtkCost = standardAverages[6][0];
                    standardHealthCost = standardAverages[6][1];
                    break;
                case 7:
                    wildAtkCost = wildAverages[7][0];
                    wildHealthCost = wildAverages[7][1];
                    standardAtkCost = standardAverages[7][0];
                    standardHealthCost = standardAverages[7][1];
                    break;
                case 8:
                    wildAtkCost = wildAverages[8][0];
                    wildHealthCost = wildAverages[8][1];
                    standardAtkCost = standardAverages[8][0];
                    standardHealthCost = standardAverages[8][1];
                    break;
                case 9:
                    wildAtkCost = wildAverages[9][0];
                    wildHealthCost = wildAverages[9][1];
                    standardAtkCost = standardAverages[9][0];
                    standardHealthCost = standardAverages[9][1];
                    break;
                case 10:
                    wildAtkCost = wildAverages[10][0];
                    wildHealthCost = wildAverages[10][1];
                    standardAtkCost = standardAverages[10][0];
                    standardHealthCost = standardAverages[10][1];
                    break;
                default:
                    wildAtkCost = wildAverages[11][0];
                    wildHealthCost = wildAverages[11][1];
                    standardAtkCost = standardAverages[11][0];
                    standardHealthCost = standardAverages[11][1];
                    break;
            }

        ratios[0][0] = card.getAttack() / wildHealth;
        ratios[0][1] = card.getHealth() / wildAtk;

        ratios[1][0] = card.getAttack() / wildHealthCost;
        ratios[1][1] = card.getHealth() / wildAtkCost;

        ratios[2][0] = card.getAttack() / standardHealth;
        ratios[2][1] = card.getHealth() / standardAtk;

        ratios[3][0] = card.getAttack() / standardHealthCost;
        ratios[3][1] = card.getHealth() / standardAtkCost;

        scores[0][0] = ((card.getAttack() / wildHealth) * (card.getAttack() / wildHealthCost));
        scores[1][0] = ((card.getAttack() / standardHealth) * (card.getAttack() / standardHealthCost));

        scores[0][1] = ((card.getHealth() / wildAtk) * (card.getHealth() / wildAtkCost));
        scores[1][1] = ((card.getHealth() / standardAtk) * (card.getHealth() / standardAtkCost));

        minionScoreWild = (((card.getAttack() / wildHealth) *
                (card.getAttack() / wildHealthCost)) +
                ((card.getHealth() / wildAtk) * (card.getHealth() / wildAtkCost))) / 2;

        minionScoreStandard = Math.log10(((card.getAttack() / standardHealth) *
                (card.getAttack() / standardHealthCost)) +
                ((card.getHealth() / standardAtk) * (card.getHealth() / standardAtkCost)));

        System.out.println(card.getName());
        System.out.println("Mana Cost:             " + card.getManaCost());
        System.out.println("Attack - Health:       " + card.getAttack() + " / " + card.getHealth());
        System.out.println("Standard:              " + standardAtk + " / " + standardHealth);
        System.out.println("Cost:                  " + standardAtkCost + " / " + standardHealthCost);
        System.out.println("atkScore:              " + (card.getAttack() / standardHealth) * (card.getAttack() / standardHealthCost));
        System.out.println("healthScore:           " + (card.getHealth() / standardAtk) * (card.getHealth() / standardAtkCost));
        System.out.println("Minion Score Standard: " + minionScoreStandard);
        System.out.println();
        System.out.println();


    }

    Ratios() throws IOException {
        super();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\BasicDB.json"));




        for (JsonNode node : jsonNode) cardList.add(new Card(node, true));

        for (Card card : cardList
        ) {
            if (Check.isMinion(card)){
                card.setStandard(Check.isStandard(card));

                switch (card.getManaCost()) {
                    case 0:
                        wildAtkCost = wildAverages[0][0];
                        wildHealthCost = wildAverages[0][1];
                        standardAtkCost = standardAverages[0][0];
                        standardHealthCost = standardAverages[0][1];
                        break;
                    case 1:
                        wildAtkCost = wildAverages[1][0];
                        wildHealthCost = wildAverages[1][1];
                        standardAtkCost = standardAverages[1][0];
                        standardHealthCost = standardAverages[1][1];
                        break;
                    case 2:
                        wildAtkCost = wildAverages[2][0];
                        wildHealthCost = wildAverages[2][1];
                        standardAtkCost = standardAverages[2][0];
                        standardHealthCost = standardAverages[2][1];
                        break;
                    case 3:
                        wildAtkCost = wildAverages[3][0];
                        wildHealthCost = wildAverages[3][1];
                        standardAtkCost = standardAverages[3][0];
                        standardHealthCost = standardAverages[3][1];
                        break;
                    case 4:
                        wildAtkCost = wildAverages[4][0];
                        wildHealthCost = wildAverages[4][1];
                        standardAtkCost = standardAverages[4][0];
                        standardHealthCost = standardAverages[4][1];
                        break;
                    case 5:
                        wildAtkCost = wildAverages[5][0];
                        wildHealthCost = wildAverages[5][1];
                        standardAtkCost = standardAverages[5][0];
                        standardHealthCost = standardAverages[5][1];
                        break;
                    case 6:
                        wildAtkCost = wildAverages[6][0];
                        wildHealthCost = wildAverages[6][1];
                        standardAtkCost = standardAverages[6][0];
                        standardHealthCost = standardAverages[6][1];
                        break;
                    case 7:
                        wildAtkCost = wildAverages[7][0];
                        wildHealthCost = wildAverages[7][1];
                        standardAtkCost = standardAverages[7][0];
                        standardHealthCost = standardAverages[7][1];
                        break;
                    case 8:
                        wildAtkCost = wildAverages[8][0];
                        wildHealthCost = wildAverages[8][1];
                        standardAtkCost = standardAverages[8][0];
                        standardHealthCost = standardAverages[8][1];
                        break;
                    case 9:
                        wildAtkCost = wildAverages[9][0];
                        wildHealthCost = wildAverages[9][1];
                        standardAtkCost = standardAverages[9][0];
                        standardHealthCost = standardAverages[9][1];
                        break;
                    case 10:
                        wildAtkCost = wildAverages[10][0];
                        wildHealthCost = wildAverages[10][1];
                        standardAtkCost = standardAverages[10][0];
                        standardHealthCost = standardAverages[10][1];
                        break;
                    default:
                        wildAtkCost = wildAverages[11][0];
                        wildHealthCost = wildAverages[11][1];
                        standardAtkCost = standardAverages[11][0];
                        standardHealthCost = standardAverages[11][1];
                        break;
                }

                ratios[0][0] = card.getAttack() / wildHealth;
                ratios[0][1] = card.getHealth() / wildAtk;

                ratios[1][0] = card.getAttack() / wildHealthCost;
                ratios[1][1] = card.getHealth() / wildAtkCost;

                ratios[2][0] = card.getAttack() / standardHealth;
                ratios[2][1] = card.getHealth() / standardAtk;

                ratios[3][0] = card.getAttack() / standardHealthCost;
                ratios[3][1] = card.getHealth() / standardAtkCost;

                scores[0][0] = ((card.getAttack() / wildHealth) * (card.getAttack() / wildHealthCost));
                scores[1][0] = ((card.getAttack() / standardHealth) * (card.getAttack() / standardHealthCost));

                scores[0][1] = ((card.getHealth() / wildAtk) * (card.getHealth() / wildAtkCost));
                scores[1][1] = ((card.getHealth() / standardAtk) * (card.getHealth() / standardAtkCost));

                minionScoreWild = (((card.getAttack() / wildHealth) * (card.getAttack() / wildHealthCost))
                        + ((card.getHealth() / wildAtk) * (card.getHealth() / wildAtkCost))) / 2;

                minionScoreStandard = ((card.getAttack() / standardHealth) * (card.getAttack() / standardHealthCost)) *
                        ((card.getHealth() / standardAtk) * (card.getHealth() / standardAtkCost));

                System.out.println("Name:                  " + card.getName());
                System.out.println("Mana Cost:             " + card.getManaCost());
                System.out.println("Attack - Health:       " + card.getAttack() + " / " + card.getHealth());
                System.out.println("atkScore:              " + (card.getAttack() / standardHealth) * (card.getAttack() / standardHealthCost));
                System.out.println("healthScore:           " + (card.getHealth() / standardAtk) * (card.getHealth() / standardAtkCost));


                System.out.println();
                System.out.println();
            }


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

