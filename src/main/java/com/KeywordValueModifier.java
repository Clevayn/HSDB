package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class KeywordValueModifier {
    List<ScoredCard> list = new Filter().collectible().allMinions().getCardList();
    LinkedHashMap<String, Double> modifierValues = new LinkedHashMap<>();

    double allMinions = list.size();

    double enhancedMod;
    double enhanced;
    double triggerMod;
    double trigger;

    double passiveMod;
    double passive;
    double activeMod;
    double active;

    double permanentMod;
    double permanent;
    double temporaryMod;
    double temporary;


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


    public KeywordValueModifier() throws IOException {

        this.passive = (double) list
                .stream()
                .filter(Check::isPassive)
                .count();
        this.active = (int) list
                .stream()
                .filter(Check::isActive)
                .count();
        this.permanent = (int) list
                .stream()
                .filter(Check::isPerm)
                .count();
        this.temporary = (int) list
                .stream()
                .filter(Check::isTemp)
                .count();
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

        this.enhancedMod = 1 + (1 - this.enhanced / allMinions);
        this.triggerMod = 1 + (1 - this.trigger / allMinions);

        this.passiveMod = 1 + (1 - this.passive / allMinions) ;
        this.activeMod = 1 + (1 - this.active / allMinions);

        this.permanentMod = 1 + (1 - this.permanent / allMinions);
        this.temporaryMod = 1 + (1 - this.temporary / allMinions);

        this.controlMod = 1 + (1 - this.control / allMinions);
        this.dblEdgeMod = 1 + (1 - this.dblEdge / allMinions);
        this.bonusMod = 1 + (1 - this.bonus / allMinions);
        this.drawMod = 1 + (1 - this.draw / allMinions);
        this.repeatMod = 1 + (1 - this.repeat / allMinions);

        modifierValues.put("Enhanced", this.enhancedMod);
        modifierValues.put("Enhanced Count", this.enhanced);
        modifierValues.put("Spell Trigger", this.triggerMod);
        modifierValues.put("Spell Trigger Count", this.trigger);
        modifierValues.put("Passive", this.passiveMod);
        modifierValues.put("Passive Count", this.passive);
        modifierValues.put("Active", this.activeMod);
        modifierValues.put("Active Count", this.active);
        modifierValues.put("Permanent", this.permanentMod);
        modifierValues.put("Permanent Count", this.permanent);
        modifierValues.put("Temporary", this.temporaryMod);
        modifierValues.put("Temporary Count", this.temporary);
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




        new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\KeywordValueModifier.json"), modifierValues);

    }





}
