package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class KeywordValueModifier {
    List<Card> list = new Filter().collectible().allMinions().getCardList();
    LinkedHashMap<String, Double> modifierValues = new LinkedHashMap<>();

    double allMinions = list.size();

    List<Integer> kw = List.of(1, 2, 3, 4, 5, 6, 8, 10, 11, 12, 13, 14, 15, 16, 17, 20, 21,
            31, 32, 34, 38, 39, 52, 53, 61, 66, 71, 76, 77, 78, 79, 86);
    List<Double> value = List.of(2.0, 2.0, 1.5, 1.0, 1.5, 1.5, 1.0, 1.5, 1.5, 1.5, 1.0, 1.5,
            1.0, 1.5, 2.0, 1.5, 1.0, 2.0, 1.5, 1.0, 1.5, 1.0, 1.0, 1.0, 1.5, 1.5,
            1.0, 1.5, 1.5, 1.5, 2.0, 1.0);
    double enhancedMod;
    double enhanced;
    double triggerMod;
    double trigger;
    double controlMod;
    double control;
    double dblEdgeMod;
    double dblEdge;
    double bonusMod;
    double bonus;
    double drawMod;
    double draw;
    double repeatMod;
    double repeat;

    double taunt; //1
    double spellPower; //2
    double divineShield; //3
    double charge; //4
    double secret; //5
    double stealth; //6
    double battlecry; //8
    double freeze; //10
    double windfury; //11
    double deathrattle; //12
    double combo; //13
    double overload; //14
    double silence; //15
    double counter; //16
    double immune; //17
    double inspire; //20
    double discover; //21
    double quest; //31
    double poisonous; //32
    double adapt; //34
    double lifesteal; //38
    double recruit; //39
    double echo; //52
    double rush; //53
    double overkill; //61
    double magnetic; //66
    double lackey; //71
    double twinspell; //76
    double megaWindfury; //77
    double reborn; //78
    double invoke; //79
    double outcast; //86
    public KeywordValueModifier() throws IOException {
        new KeywordValue();

        this.trigger = (int) list
                .stream()
                .filter(Check::isSpellTrigger)
                .count();
        this.enhanced = (int) list
                .stream()
                .filter(Check::isEnhanced)
                .count();
        this.control = (int) list
                .stream()
                .filter(Check::isControl)
                .count();
        this.dblEdge = (int) list
                .stream()
                .filter(Check::isDblEdge)
                .count();
        this.bonus = (int) list
                .stream()
                .filter(Check::isBonus)
                .count();
        this.draw = (int) list
                .stream()
                .filter(Check::isDraw)
                .count();
        this.repeat = (int) list
                .stream()
                .filter(Check::isRepeat)
                .count();

        this.enhancedMod = 1 + ( 1 - (this.enhanced / allMinions));
        this.triggerMod = 1 + (1 - (this.trigger / allMinions));
        this.controlMod = 1 + (1 - (this.control / allMinions));
        this.dblEdgeMod = 1 + (1 - (this.dblEdge / allMinions));
        this.bonusMod = 1 + (1 - (this.bonus / allMinions));
        this.drawMod = 1 + (1 - (this.draw / allMinions));
        this.repeatMod = 1 + (1 - (this.repeat / allMinions));

        double temp;
        for (int i: kw
             ) {
            temp = value.get(kw.indexOf(i));
            if (Check.isEnhancedInt(i)) temp = temp * this.enhancedMod;
            if (Check.isSpellTriggerInt(i)) temp = temp * this.triggerMod;
            if (Check.isControlInt(i)) temp = temp * this.controlMod;
            if (Check.isDblEdgeInt(i)) temp = (temp*.5);
            if (Check.isBonusInt(i)) temp = temp * this.bonusMod;
            if (Check.isDrawInt(i)) temp = temp * this.drawMod;
            if (Check.isRepeatInt(i)) temp = temp * this.repeatMod;

            modifierValues.put(ValueTranslator.keywordName(i), temp);

        }


        modifierValues.put("Enhanced", this.enhancedMod);
        modifierValues.put("Enhanced Count", this.enhanced);
        modifierValues.put("Spell Trigger", this.triggerMod);
        modifierValues.put("Spell Trigger Count", this.trigger);
        modifierValues.put("Control", this.controlMod);
        modifierValues.put("Control Count", this.control);
        modifierValues.put("DblEdge", this.dblEdgeMod);
        modifierValues.put("DblEdge Count", this.dblEdge);
        modifierValues.put("Bonus", this.bonusMod);
        modifierValues.put("Bonus Count", this.bonus);
        modifierValues.put("Draw", this.drawMod);
        modifierValues.put("Draw Count", this.draw);
        modifierValues.put("Repeat", this.repeatMod);
        modifierValues.put("Repeat Count", this.repeat);
        modifierValues.put("Minions Count", this.allMinions);




        new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new File("C:\\HSDeckBuilder\\src\\main\\resources\\KeywordModifier.json"), modifierValues);

    }





}
