package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.naming.LinkLoopException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Averages {
    protected int[][] wildAverages = new int[13][2];
    protected int[][] standardAverages = new int[13][2];

    Averages() throws IOException {

        Filter filter = new Filter().collectible().allMinions();
        List<ScoredCard> wildList = filter.getCardList();
        List<ScoredCard> standardList = filter.standard().getCardList();

        int wildSize = wildList.size();
        int atkWild = wildList.stream().mapToInt(ScoredCard::getAttack).sum();
        int healthWild = wildList.stream().mapToInt(ScoredCard::getHealth).sum();

        int zeroWildSize = (int) wildList.stream().filter(Check::costZero).count();
        int atkWildCostZero = wildList.stream().filter(Check::costZero).mapToInt(ScoredCard::getAttack).sum();
        int healthWildCostZero = wildList.stream().filter(Check::costZero).mapToInt(ScoredCard::getHealth).sum();

        int oneWildSize = (int) wildList.stream().filter(Check::costOne).count();
        int atkWildCostOne = wildList.stream().filter(Check::costOne).mapToInt(ScoredCard::getAttack).sum();
        int healthWildCostOne = wildList.stream().filter(Check::costOne).mapToInt(ScoredCard::getHealth).sum();

        int twoWildSize = (int) wildList.stream().filter(Check::costTwo).count();
        int atkWildCostTwo = wildList.stream().filter(Check::costTwo).mapToInt(ScoredCard::getAttack).sum();
        int healthWildCostTwo = wildList.stream().filter(Check::costTwo).mapToInt(ScoredCard::getHealth).sum();

        int threeWildSize = (int) wildList.stream().filter(Check::costThree).count();
        int atkWildCostThree = wildList.stream().filter(Check::costThree).mapToInt(ScoredCard::getAttack).sum();
        int healthWildCostThree = wildList.stream().filter(Check::costThree).mapToInt(ScoredCard::getHealth).sum();

        int fourWildSize = (int) wildList.stream().filter(Check::costFour).count();
        int atkWildCostFour = wildList.stream().filter(Check::costFour).mapToInt(ScoredCard::getAttack).sum();
        int healthWildCostFour = wildList.stream().filter(Check::costFour).mapToInt(ScoredCard::getHealth).sum();

        int fiveWildSize = (int) wildList.stream().filter(Check::costFive).count();
        int atkWildCostFive = wildList.stream().filter(Check::costFive).mapToInt(ScoredCard::getAttack).sum();
        int healthWildCostFive = wildList.stream().filter(Check::costFive).mapToInt(ScoredCard::getHealth).sum();

        int sixWildSize = (int) wildList.stream().filter(Check::costSix).count();
        int atkWildCostSix = wildList.stream().filter(Check::costSix).mapToInt(ScoredCard::getAttack).sum();
        int healthWildCostSix = wildList.stream().filter(Check::costSix).mapToInt(ScoredCard::getHealth).sum();

        int sevenWildSize = (int) wildList.stream().filter(Check::costSeven).count();
        int atkWildCostSeven = wildList.stream().filter(Check::costSeven).mapToInt(ScoredCard::getAttack).sum();
        int healthWildCostSeven = wildList.stream().filter(Check::costSeven).mapToInt(ScoredCard::getHealth).sum();

        int eightWildSize = (int) wildList.stream().filter(Check::costEight).count();
        int atkWildCostEight = wildList.stream().filter(Check::costEight).mapToInt(ScoredCard::getAttack).sum();
        int healthWildCostEight = wildList.stream().filter(Check::costEight).mapToInt(ScoredCard::getHealth).sum();

        int nineWildSize = (int) wildList.stream().filter(Check::costNine).count();
        int atkWildCostNine = wildList.stream().filter(Check::costNine).mapToInt(ScoredCard::getAttack).sum();
        int healthWildCostNine = wildList.stream().filter(Check::costNine).mapToInt(ScoredCard::getHealth).sum();

        int tenWildSize = (int) wildList.stream().filter(Check::costTen).count();
        int atkWildCostTen = wildList.stream().filter(Check::costTen).mapToInt(ScoredCard::getAttack).sum();
        int healthWildCostTen = wildList.stream().filter(Check::costTen).mapToInt(ScoredCard::getHealth).sum();

        int aboveTenWildSize = (int) wildList.stream().filter(Check::costGreaterThenTen).count();
        int atkWildCostAboveTen = wildList.stream().filter(Check::costGreaterThenTen).mapToInt(ScoredCard::getAttack).sum();
        int healthWildCostAboveTen = wildList.stream().filter(Check::costGreaterThenTen).mapToInt(ScoredCard::getHealth).sum();

        int standardSize = standardList.size();
        int atkStandard = standardList.stream().mapToInt(ScoredCard::getAttack).sum();
        int healthStandard = standardList.stream().mapToInt(ScoredCard::getHealth).sum();

        int zeroStandardSize = (int) standardList.stream().filter(Check::costZero).count();
        int atkStandardCostZero = standardList.stream().filter(Check::costZero).mapToInt(ScoredCard::getAttack).sum();
        int healthStandardCostZero = standardList.stream().filter(Check::costZero).mapToInt(ScoredCard::getHealth).sum();

        int oneStandardSize = (int) standardList.stream().filter(Check::costOne).count();
        int atkStandardCostOne = standardList.stream().filter(Check::costOne).mapToInt(ScoredCard::getAttack).sum();
        int healthStandardCostOne = standardList.stream().filter(Check::costOne).mapToInt(ScoredCard::getHealth).sum();

        int twoStandardSize = (int) standardList.stream().filter(Check::costTwo).count();
        int atkStandardCostTwo = standardList.stream().filter(Check::costTwo).mapToInt(ScoredCard::getAttack).sum();
        int healthStandardCostTwo = standardList.stream().filter(Check::costTwo).mapToInt(ScoredCard::getHealth).sum();

        int threeStandardSize = (int) standardList.stream().filter(Check::costThree).count();
        int atkStandardCostThree = standardList.stream().filter(Check::costThree).mapToInt(ScoredCard::getAttack).sum();
        int healthStandardCostThree = standardList.stream().filter(Check::costThree).mapToInt(ScoredCard::getHealth).sum();

        int fourStandardSize = (int) standardList.stream().filter(Check::costFour).count();
        int atkStandardCostFour = standardList.stream().filter(Check::costFour).mapToInt(ScoredCard::getAttack).sum();
        int healthStandardCostFour = standardList.stream().filter(Check::costFour).mapToInt(ScoredCard::getHealth).sum();

        int fiveStandardSize = (int) standardList.stream().filter(Check::costFive).count();
        int atkStandardCostFive = standardList.stream().filter(Check::costFive).mapToInt(ScoredCard::getAttack).sum();
        int healthStandardCostFive = standardList.stream().filter(Check::costFive).mapToInt(ScoredCard::getHealth).sum();

        int sixStandardSize = (int) standardList.stream().filter(Check::costSix).count();
        int atkStandardCostSix = standardList.stream().filter(Check::costSix).mapToInt(ScoredCard::getAttack).sum();
        int healthStandardCostSix = standardList.stream().filter(Check::costSix).mapToInt(ScoredCard::getHealth).sum();

        int sevenStandardSize = (int) standardList.stream().filter(Check::costSeven).count();
        int atkStandardCostSeven = standardList.stream().filter(Check::costSeven).mapToInt(ScoredCard::getAttack).sum();
        int healthStandardCostSeven = standardList.stream().filter(Check::costSeven).mapToInt(ScoredCard::getHealth).sum();

        int eightStandardSize = (int) standardList.stream().filter(Check::costEight).count();
        int atkStandardCostEight = standardList.stream().filter(Check::costEight).mapToInt(ScoredCard::getAttack).sum();
        int healthStandardCostEight = standardList.stream().filter(Check::costEight).mapToInt(ScoredCard::getHealth).sum();

        int nineStandardSize = (int) standardList.stream().filter(Check::costNine).count();
        int atkStandardCostNine = standardList.stream().filter(Check::costNine).mapToInt(ScoredCard::getAttack).sum();
        int healthStandardCostNine = standardList.stream().filter(Check::costNine).mapToInt(ScoredCard::getHealth).sum();

        int tenStandardSize = (int) standardList.stream().filter(Check::costTen).count();
        int atkStandardCostTen = standardList.stream().filter(Check::costTen).mapToInt(ScoredCard::getAttack).sum();
        int healthStandardCostTen = standardList.stream().filter(Check::costTen).mapToInt(ScoredCard::getHealth).sum();

        int aboveTenStandardSize = (int) standardList.stream().filter(Check::costGreaterThenTen).count();
        int atkStandardCostAboveTen = standardList.stream().filter(Check::costGreaterThenTen).mapToInt(ScoredCard::getAttack).sum();
        int healthStandardCostAboveTen = standardList.stream().filter(Check::costGreaterThenTen).mapToInt(ScoredCard::getHealth).sum();

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


        LinkedHashMap<String, int[]> standard = new LinkedHashMap<>();
        standard.put("0", this.standardAverages[0]);
        standard.put("1", this.standardAverages[1]);
        standard.put("2", this.standardAverages[2]);
        standard.put("3", this.standardAverages[3]);
        standard.put("4", this.standardAverages[4]);
        standard.put("5", this.standardAverages[5]);
        standard.put("6", this.standardAverages[6]);
        standard.put("7", this.standardAverages[7]);
        standard.put("8", this.standardAverages[8]);
        standard.put("9", this.standardAverages[9]);
        standard.put("10", this.standardAverages[10]);
        standard.put(">10", this.standardAverages[11]);
        standard.put("All", this.standardAverages[12]);


        LinkedHashMap<String, int[]> wild = new LinkedHashMap<>();
        wild.put("0", this.wildAverages[0]);
        wild.put("1", this.wildAverages[1]);
        wild.put("2", this.wildAverages[2]);
        wild.put("3", this.wildAverages[3]);
        wild.put("4", this.wildAverages[4]);
        wild.put("5", this.wildAverages[5]);
        wild.put("6", this.wildAverages[6]);
        wild.put("7", this.wildAverages[7]);
        wild.put("8", this.wildAverages[8]);
        wild.put("9", this.wildAverages[9]);
        wild.put("10", this.wildAverages[10]);
        wild.put(">10", this.wildAverages[11]);
        wild.put("All", this.wildAverages[12]);

        LinkedHashMap<String, LinkedHashMap<String, int[]>> averages = new LinkedHashMap<>();
        averages.put("Wild", wild);
        averages.put("Standard", standard);

        new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\Averages.json"), averages);
    }
}

