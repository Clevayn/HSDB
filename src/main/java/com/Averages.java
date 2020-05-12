package com;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Averages {
    protected int[][] wildAverages = new int[13][2];
    protected int[][] standardAverages = new int[13][2];

    Averages() throws IOException, URISyntaxException {

        Filter filter = new Filter().collectible().allMinions();
        List<Card> wild = filter.getCardList();
        List<Card> standard = filter.standard().getCardList();

        int wildSize = wild.size();
        int atkWild = wild.stream().mapToInt(Card::getAttack).sum();
        int healthWild = wild.stream().mapToInt(Card::getHealth).sum();

        int zeroWildSize = (int) wild.stream().filter(Check::costZero).count();
        int atkWildCostZero = wild.stream().filter(Check::costZero).mapToInt(Card::getAttack).sum();
        int healthWildCostZero = wild.stream().filter(Check::costZero).mapToInt(Card::getHealth).sum();

        int oneWildSize = (int) wild.stream().filter(Check::costOne).count();
        int atkWildCostOne = wild.stream().filter(Check::costOne).mapToInt(Card::getAttack).sum();
        int healthWildCostOne = wild.stream().filter(Check::costOne).mapToInt(Card::getHealth).sum();

        int twoWildSize = (int) wild.stream().filter(Check::costTwo).count();
        int atkWildCostTwo = wild.stream().filter(Check::costTwo).mapToInt(Card::getAttack).sum();
        int healthWildCostTwo = wild.stream().filter(Check::costTwo).mapToInt(Card::getHealth).sum();

        int threeWildSize = (int) wild.stream().filter(Check::costThree).count();
        int atkWildCostThree = wild.stream().filter(Check::costThree).mapToInt(Card::getAttack).sum();
        int healthWildCostThree = wild.stream().filter(Check::costThree).mapToInt(Card::getHealth).sum();

        int fourWildSize = (int) wild.stream().filter(Check::costFour).count();
        int atkWildCostFour = wild.stream().filter(Check::costFour).mapToInt(Card::getAttack).sum();
        int healthWildCostFour = wild.stream().filter(Check::costFour).mapToInt(Card::getHealth).sum();

        int fiveWildSize = (int) wild.stream().filter(Check::costFive).count();
        int atkWildCostFive = wild.stream().filter(Check::costFive).mapToInt(Card::getAttack).sum();
        int healthWildCostFive = wild.stream().filter(Check::costFive).mapToInt(Card::getHealth).sum();

        int sixWildSize = (int) wild.stream().filter(Check::costSix).count();
        int atkWildCostSix = wild.stream().filter(Check::costSix).mapToInt(Card::getAttack).sum();
        int healthWildCostSix = wild.stream().filter(Check::costSix).mapToInt(Card::getHealth).sum();

        int sevenWildSize = (int) wild.stream().filter(Check::costSeven).count();
        int atkWildCostSeven = wild.stream().filter(Check::costSeven).mapToInt(Card::getAttack).sum();
        int healthWildCostSeven = wild.stream().filter(Check::costSeven).mapToInt(Card::getHealth).sum();

        int eightWildSize = (int) wild.stream().filter(Check::costEight).count();
        int atkWildCostEight = wild.stream().filter(Check::costEight).mapToInt(Card::getAttack).sum();
        int healthWildCostEight = wild.stream().filter(Check::costEight).mapToInt(Card::getHealth).sum();

        int nineWildSize = (int) wild.stream().filter(Check::costNine).count();
        int atkWildCostNine = wild.stream().filter(Check::costNine).mapToInt(Card::getAttack).sum();
        int healthWildCostNine = wild.stream().filter(Check::costNine).mapToInt(Card::getHealth).sum();

        int tenWildSize = (int) wild.stream().filter(Check::costTen).count();
        int atkWildCostTen = wild.stream().filter(Check::costTen).mapToInt(Card::getAttack).sum();
        int healthWildCostTen = wild.stream().filter(Check::costTen).mapToInt(Card::getHealth).sum();

        int aboveTenWildSize = (int) wild.stream().filter(Check::costGreaterThenTen).count();
        int atkWildCostAboveTen = wild.stream().filter(Check::costGreaterThenTen).mapToInt(Card::getAttack).sum();
        int healthWildCostAboveTen = wild.stream().filter(Check::costGreaterThenTen).mapToInt(Card::getHealth).sum();

        int standardSize = standard.size();
        int atkStandard = standard.stream().mapToInt(Card::getAttack).sum();
        int healthStandard = standard.stream().mapToInt(Card::getHealth).sum();

        int zeroStandardSize = (int) standard.stream().filter(Check::costZero).count();
        int atkStandardCostZero = standard.stream().filter(Check::costZero).mapToInt(Card::getAttack).sum();
        int healthStandardCostZero = standard.stream().filter(Check::costZero).mapToInt(Card::getHealth).sum();

        int oneStandardSize = (int) standard.stream().filter(Check::costOne).count();
        int atkStandardCostOne = standard.stream().filter(Check::costOne).mapToInt(Card::getAttack).sum();
        int healthStandardCostOne = standard.stream().filter(Check::costOne).mapToInt(Card::getHealth).sum();

        int twoStandardSize = (int) standard.stream().filter(Check::costTwo).count();
        int atkStandardCostTwo = standard.stream().filter(Check::costTwo).mapToInt(Card::getAttack).sum();
        int healthStandardCostTwo = standard.stream().filter(Check::costTwo).mapToInt(Card::getHealth).sum();

        int threeStandardSize = (int) standard.stream().filter(Check::costThree).count();
        int atkStandardCostThree = standard.stream().filter(Check::costThree).mapToInt(Card::getAttack).sum();
        int healthStandardCostThree = standard.stream().filter(Check::costThree).mapToInt(Card::getHealth).sum();

        int fourStandardSize = (int) standard.stream().filter(Check::costFour).count();
        int atkStandardCostFour = standard.stream().filter(Check::costFour).mapToInt(Card::getAttack).sum();
        int healthStandardCostFour = standard.stream().filter(Check::costFour).mapToInt(Card::getHealth).sum();

        int fiveStandardSize = (int) standard.stream().filter(Check::costFive).count();
        int atkStandardCostFive = standard.stream().filter(Check::costFive).mapToInt(Card::getAttack).sum();
        int healthStandardCostFive = standard.stream().filter(Check::costFive).mapToInt(Card::getHealth).sum();

        int sixStandardSize = (int) standard.stream().filter(Check::costSix).count();
        int atkStandardCostSix = standard.stream().filter(Check::costSix).mapToInt(Card::getAttack).sum();
        int healthStandardCostSix = standard.stream().filter(Check::costSix).mapToInt(Card::getHealth).sum();

        int sevenStandardSize = (int) standard.stream().filter(Check::costSeven).count();
        int atkStandardCostSeven = standard.stream().filter(Check::costSeven).mapToInt(Card::getAttack).sum();
        int healthStandardCostSeven = standard.stream().filter(Check::costSeven).mapToInt(Card::getHealth).sum();

        int eightStandardSize = (int) standard.stream().filter(Check::costEight).count();
        int atkStandardCostEight = standard.stream().filter(Check::costEight).mapToInt(Card::getAttack).sum();
        int healthStandardCostEight = standard.stream().filter(Check::costEight).mapToInt(Card::getHealth).sum();

        int nineStandardSize = (int) standard.stream().filter(Check::costNine).count();
        int atkStandardCostNine = standard.stream().filter(Check::costNine).mapToInt(Card::getAttack).sum();
        int healthStandardCostNine = standard.stream().filter(Check::costNine).mapToInt(Card::getHealth).sum();

        int tenStandardSize = (int) standard.stream().filter(Check::costTen).count();
        int atkStandardCostTen = standard.stream().filter(Check::costTen).mapToInt(Card::getAttack).sum();
        int healthStandardCostTen = standard.stream().filter(Check::costTen).mapToInt(Card::getHealth).sum();

        int aboveTenStandardSize = (int) standard.stream().filter(Check::costGreaterThenTen).count();
        int atkStandardCostAboveTen = standard.stream().filter(Check::costGreaterThenTen).mapToInt(Card::getAttack).sum();
        int healthStandardCostAboveTen = standard.stream().filter(Check::costGreaterThenTen).mapToInt(Card::getHealth).sum();

        this.wildAverages[0][0] = atkWildCostZero / zeroWildSize;
        this.wildAverages[0][1] = healthWildCostZero / zeroWildSize;

        this.wildAverages[1][0] = atkWildCostOne / oneWildSize;
        this.wildAverages[1][1] = healthWildCostOne / oneWildSize;

        this.wildAverages[2][0] = atkWildCostTwo / twoWildSize;
        this.wildAverages[2][1] = healthWildCostTwo / twoWildSize;

        this.wildAverages[3][0] = atkWildCostThree / threeWildSize;
        this.wildAverages[3][1] = healthWildCostThree / threeWildSize;

        this.wildAverages[4][0] = atkWildCostFour / fourWildSize;
        this.wildAverages[4][1] = healthWildCostFour / fourWildSize;

        this.wildAverages[5][0] = atkWildCostFive / fiveWildSize;
        this.wildAverages[5][1] = healthWildCostFive / fiveWildSize;

        this.wildAverages[6][0] = atkWildCostSix / sixWildSize;
        this.wildAverages[6][1] = healthWildCostSix / sixWildSize;

        this.wildAverages[7][0] = atkWildCostSeven / sevenWildSize;
        this.wildAverages[7][1] = healthWildCostSeven / sevenWildSize;

        this.wildAverages[8][0] = atkWildCostEight / eightWildSize;
        this.wildAverages[8][1] = healthWildCostEight / eightWildSize;

        this.wildAverages[9][0] = atkWildCostNine / nineWildSize;
        this.wildAverages[9][1] = healthWildCostNine / nineWildSize;

        this.wildAverages[10][0] = atkWildCostTen / tenWildSize;
        this.wildAverages[10][1] = healthWildCostTen / tenWildSize;

        this.wildAverages[11][0] = atkWildCostAboveTen / aboveTenWildSize;
        this.wildAverages[11][1] = healthWildCostAboveTen / aboveTenWildSize;

        this.wildAverages[12][0] = atkWild / wildSize;
        this.wildAverages[12][1] = healthWild / wildSize;

        this.standardAverages[0][0] = atkStandardCostZero / zeroStandardSize;
        this.standardAverages[0][1] = healthStandardCostZero / zeroStandardSize;

        this.standardAverages[1][0] = atkStandardCostOne / oneStandardSize;
        this.standardAverages[1][1] = healthStandardCostOne / oneStandardSize;

        this.standardAverages[2][0] = atkStandardCostTwo / twoStandardSize;
        this.standardAverages[2][1] = healthStandardCostTwo / twoStandardSize;

        this.standardAverages[3][0] = atkStandardCostThree / threeStandardSize;
        this.standardAverages[3][1] = healthStandardCostThree / threeStandardSize;

        this.standardAverages[4][0] = atkStandardCostFour / fourStandardSize;
        this.standardAverages[4][1] = healthStandardCostFour / fourStandardSize;

        this.standardAverages[5][0] = atkStandardCostFive / fiveStandardSize;
        this.standardAverages[5][1] = healthStandardCostFive / fiveStandardSize;

        this.standardAverages[6][0] = atkStandardCostSix / sixStandardSize;
        this.standardAverages[6][1] = healthStandardCostSix / sixStandardSize;

        this.standardAverages[7][0] = atkStandardCostSeven / sevenStandardSize;
        this.standardAverages[7][1] = healthStandardCostSeven / sevenStandardSize;

        this.standardAverages[8][0] = atkStandardCostEight / eightStandardSize;
        this.standardAverages[8][1] = healthStandardCostEight / eightStandardSize;

        this.standardAverages[9][0] = atkStandardCostNine / nineStandardSize;
        this.standardAverages[9][1] = healthStandardCostNine / nineStandardSize;

        this.standardAverages[10][0] = atkStandardCostTen / tenStandardSize;
        this.standardAverages[10][1] = healthStandardCostTen / tenStandardSize;

        this.standardAverages[11][0] = atkStandardCostAboveTen / Math.max(1, aboveTenStandardSize);
        this.standardAverages[11][1] = healthStandardCostAboveTen / Math.max(1, aboveTenStandardSize);

        this.standardAverages[12][0] = atkStandard / standardSize;
        this.standardAverages[12][1] = healthStandard / standardSize;
    }
}

