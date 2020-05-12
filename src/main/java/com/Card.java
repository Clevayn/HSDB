package com;


import com.fasterxml.jackson.databind.JsonNode;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Card {
    private final MathContext m = new MathContext(20);
    private int id;
    private int collectible;
    private String slug;
    private int classId;
    private int [] multiClassIds;
    private int minionTypeId;
    private int cardTypeId;
    private int cardSetId;
    private int rarityId;
    private String artistName;

    private double minionScoreWild;
    private double minionScoreStandard;

    private int health;
    private int attack;
    private int manaCost;
    private int durability;
    private String name;
    private String text;
    private String image;
    private String imageGold;
    private String flavorText;
    private String cropImage;
    private int parentId;
    private int [] childIds;
    private int [] keywordIds;

    private boolean standard = false;

    private double damageRatioWild;
    private double damageRatioWildCost;
    private double damageScoreWild;

    private double survivalRatioWild;
    private double survivalRatioWildCost;
    private double survivalScoreWild;

    private double damageRatioStandard;
    private double damageRatioStandardCost;
    private double damageScoreStandard;

    private double survivalRatioStandard;
    private double survivalRatioStandardCost;
    private double survivalScoreStandard;

    private boolean control;
    private int controlCount;

    private boolean spellTrigger;
    private int spellTriggerCount;

    private boolean enhanced;
    private int enhancedCount;

    private boolean bonus;
    private int bonusCount;

    private boolean draw;
    private int drawCount;

    private boolean repeat;
    private int repeatCount;

    private boolean passive;
    private int passiveCount;

    private boolean active;
    private int activeCount;

    private boolean permanent;
    private int permCount;

    private boolean temporary;
    private int tempCount;

    Card(JsonNode node) {
        this.id = node.at("/id").asInt();
        this.collectible = node.at("/collectible").asInt();
        this.slug = node.at("/slug").asText();
        this.classId = node.at("/classId").asInt();
        this.multiClassIds = arrayGetter(node.at("/multiClassIds"));
        this.minionTypeId = node.at("/minionTypeId").asInt();
        this.cardTypeId = node.at("/cardTypeId").asInt();
        this.cardSetId = node.at("/cardSetId").asInt();
        this.rarityId = node.at("/rarity").asInt();
        this.artistName = node.at("/artistName").asText();
        this.health = node.at("/health").asInt();
        this.attack = node.at("/attack").asInt();
        this.manaCost = node.at("/manaCost").asInt();
        this.minionScoreWild =node.at("/minionScoreWild").asDouble();
        this.minionScoreStandard = node.at("/minionScoreStandard").asDouble();
        this.durability = node.at("/durability").asInt();
        this.name = node.at("/name").asText();
        this.text = node.at("/text").asText();
        this.image = node.at("/image").asText();
        this.imageGold = node.at("/imageGold").asText();
        this.flavorText = node.at("/flavorText").asText();
        this.cropImage = node.at("/cropImage").asText();
        this.parentId = node.at("/parentId").asInt();
        this.childIds = arrayGetter(node.at("/childIds"));
        this.keywordIds = arrayGetter(node.at("/keywordIds"));
        this.standard = node.at("/standard").asBoolean();
        this.damageRatioWild = node.at("/damageRatioWild").asDouble();
        this.damageRatioWildCost = node.at("/damageRatioWildCost").asDouble();
        this.damageScoreWild = node.at("/damageScoreWild").asDouble();
        this.survivalRatioWild = node.at("/survivalRatioWild").asDouble();
        this.survivalRatioWildCost = node.at("/survivalRatioWildCost").asDouble();
        this.survivalScoreWild = node.at("/survivalScoreWild").asDouble();
        this.damageRatioStandard = node.at("/damageRatioStandard").asDouble();
        this.damageRatioStandardCost = node.at("/damageRatioStandardCost").asDouble();
        this.damageScoreStandard = node.at("/damageScoreStandard").asDouble();
        this.survivalRatioStandard = node.at("/survivalRatioStandard").asDouble();
        this.survivalRatioStandardCost = node.at("/survivalRatioStandardCost").asDouble();
        this.survivalScoreStandard = node.at("/survivalScoreStandard").asDouble();
    }


    Card(JsonNode node, boolean fromURL){
        this.id = node.at("/id").asInt();
        this.collectible = node.at("/collectible").asInt();
        this.slug = node.at("/slug").asText();
        this.classId = node.at("/classId").asInt();
        this.multiClassIds = arrayGetter(node.at("/multiClassIds"));
        this.minionTypeId = node.at("/minionTypeId").asInt();
        this.cardTypeId = node.at("/cardTypeId").asInt();
        this.cardSetId = node.at("/cardSetId").asInt();
        this.rarityId = node.at("/rarity").asInt();
        this.artistName = node.at("/artistName").asText();
        this.health = node.at("/health").asInt();
        this.attack = node.at("/attack").asInt();
        this.manaCost = node.at("/manaCost").asInt();
        this.durability = node.at("/durability").asInt();
        if (fromURL)this.name = node.at("/name/en_US").asText();
        else this.name = node.at("/name").asText();
        if (fromURL)this.text = node.at("/text/en_US").asText();
        else this.text = node.at("/text").asText();
        if (fromURL)this.image = node.at("/image/en_US").asText();
        else this.image = node.at("/image").asText();
        if (fromURL)this.imageGold = node.at("/imageGold/en_US").asText();
        else this.imageGold = node.at("/imageGold").asText();
        if (fromURL)this.flavorText = node.at("/flavorText/en_US").asText();
        else this.flavorText = node.at("/flavorText").asText();
        if (fromURL)this.cropImage = node.at("/cropImage/en_US").asText();
        else this.cropImage = node.at("/cropImage").asText();
        this.parentId = node.at("/parentId").asInt();
        this.childIds = arrayGetter(node.at("/childIds"));
        this.keywordIds = arrayGetter(node.at("/keywordIds"));

        setControl();
        setSpellTrigger();
        setPassive();
        setActive();
        setEnhanced();
        setPermanent();
        setTemporary();
        setBonus();
        setDraw();
        setRepeat();



    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }

    public boolean isStandard() {
        return standard;
    }

    public static int[] arrayGetter(JsonNode node){
        ArrayList<Integer> hold = new ArrayList<>();
        node.elements().forEachRemaining(j -> hold.add(j.asInt()));
        int[] out = new int[hold.size()];
        for (int i = 0; i < hold.size(); i++) out[i] = hold.get(i);
        return out;


    }

    public int getId() {
        return id;
    }

    public int getCollectible() {
        return collectible;
    }

    public String getSlug() {
        return slug;
    }

    public int getClassId() {
        return classId;
    }

    public int[] getMultiClassIds() {
        return multiClassIds;
    }

    public int getMinionTypeId() {
        return minionTypeId;
    }

    public int getCardTypeId() {
        return cardTypeId;
    }

    public int getCardSetId() {
        return cardSetId;
    }

    public int getRarityId() {
        return rarityId;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getDurability() {
        return durability;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }

    public String getImageGold() {
        return imageGold;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public String getCropImage() {
        return cropImage;
    }

    public int getParentId() {
        return parentId;
    }

    public int[] getChildIds() {
        return childIds;
    }

    public int[] getKeywordIds() {
        return keywordIds;
    }

    public void setDamageRatioWild(double damageRatio) {
        this.damageRatioWild = damageRatio;
    }
    public double getDamageRatioWild() {
        try {
            return  Double.parseDouble(new BigDecimal(damageRatioWild).round(m).toString());
        } catch (Exception e){
            return 0;
        }

    }

    public void setDamageRatioCostWild(double costAttackScore) {
        this.damageRatioWildCost = costAttackScore;
    }
    public double getDamageRatioWildCost() {
        try{
            return Double.parseDouble(new BigDecimal(damageRatioWildCost).round(new MathContext(1, RoundingMode.HALF_UP)).toString());
        } catch (Exception e){
            return 0;
        }

    }

    public void setDamageRatioStandard(double damageRatioStandard) {
        this.damageRatioStandard = damageRatioStandard;
    }
    public double getDamageRatioStandard() {
        try {
            return Double.parseDouble(new BigDecimal(damageRatioStandard).round(m).toString());
        } catch (Exception e){
            return 0;
        }

    }

    public void setDamageRatioStandardCost(double damageRatioStandardCost) {
        this.damageRatioStandardCost = damageRatioStandardCost;
    }
    public double getDamageRatioStandardCost() {
        try {
            return Double.parseDouble(new BigDecimal(damageRatioStandardCost).round(m).toString());
        } catch (Exception e){
            return 0;
        }

    }

    public void setSurvivalRatioWild(double survivalRatio) {
        this.survivalRatioWild = survivalRatio;
    }
    public double getSurvivalRatioWild() {
        try {
            return Double.parseDouble(new BigDecimal(survivalRatioWild).round(m).toString());
        } catch (Exception e){
            return 0;
        }

    }

    public void setSurvivalRatioCostWild(double costHealthScore) {
        this.survivalRatioWildCost = costHealthScore;
    }
    public double getSurvivalRatioWildCost() {
        try{
            return Double.parseDouble(new BigDecimal(survivalRatioWildCost).round(m).toString());
        }
        catch (Exception e) {
            return 0;
        }

    }

    public void setSurvivalRatioStandard(double survivalRatioStandard) {
        this.survivalRatioStandard = survivalRatioStandard;
    }
    public double getSurvivalRatioStandard() {
        try {
            return Double.parseDouble(new BigDecimal(survivalRatioStandard).round(m).toString());
        } catch (Exception e){
            return 0;
        }

    }

    public void setSurvivalRatioStandardCost(double survivalRatioStandardCost) {
        this.survivalRatioStandardCost = survivalRatioStandardCost;
    }
    public double getSurvivalRatioStandardCost() {
        try {
            return Double.parseDouble(new BigDecimal(survivalRatioStandardCost).round(m).toString());
        } catch (Exception e){
            return 0;
        }

    }



    public void setDamageScoreWild(double damageScoreWild) {
        this.damageScoreWild = damageScoreWild;
    }
    public double getDamageScoreWild() {
        try {
            return Double.parseDouble(new BigDecimal(damageScoreWild).round(m).toString());
        } catch (Exception e){
            return 0;
        }
    }

    public void setSurvivalScoreWild(double survivalScoreWild) {
        this.survivalScoreWild = survivalScoreWild;
    }
    public double getSurvivalScoreWild() {
        try {
            return Double.parseDouble(new BigDecimal(survivalScoreWild).round(m).toString());
        } catch (Exception e){
            return 0;
        }
    }

    public void setDamageScoreStandard(double damageScoreStandard) {
        this.damageScoreStandard = damageScoreStandard;
    }
    public double getDamageScoreStandard() {
        try {
            return Double.parseDouble(new BigDecimal(damageScoreStandard).round(m).toString());
        } catch (Exception e){
            return 0;
        }
    }

    public void setSurvivalScoreStandard(double survivalScoreStandard) {
        this.survivalScoreStandard = survivalScoreStandard;
    }
    public double getSurvivalScoreStandard() {
        try {
            return Double.parseDouble(new BigDecimal(survivalScoreStandard).round(m).toString());
        } catch (Exception e){
            return 0;
        }
    }

    public void setMinionScoreWild(double minionScoreWild) {
        this.minionScoreWild = minionScoreWild;
    }

    public double getMinionScoreWild() {
        try {
            return Double.parseDouble(new BigDecimal(minionScoreWild).round(m).toString());
        } catch (Exception e){
            return 0;
        }
    }

    public void setMinionScoreStandard(double minionScoreStandard) {
        this.minionScoreStandard = minionScoreStandard;
    }

    public double getMinionScoreStandard() {
        try {
            return Double.parseDouble(new BigDecimal(minionScoreStandard).round(m).toString());
        } catch (Exception e){
            return 0;
        }
    }

    public void setControl() {
        int x = 0;
        for (int i: getKeywordIds()) if (Check.isControlInt(i)) x++;
        this.controlCount = x;
        this.control = this.controlCount > 0;
    }
    public boolean getControl(){
        return this.control;
    }
    public int getControlCount() {
        return controlCount;
    }

    public void setSpellTrigger() {
        for (int i: getKeywordIds()) if (Check.isSpellTriggerInt(i)) this.spellTriggerCount++;
        this.spellTrigger = this.spellTriggerCount > 0;
    }
    public boolean getSpellTrigger() {
        return this.spellTrigger;
    }
    public int getSpellTriggerCount() {
        return spellTriggerCount;
    }

    public void setEnhanced() {
        for (int i: getKeywordIds()) if (Check.isEnhancedInt(i)) this.enhancedCount++;
        this.enhanced = this.enhancedCount > 0;
    }
    public boolean getEnhanced() {
        return enhanced;
    }
    public int getEnhancedCount() {
        return enhancedCount;
    }

    public void setBonus() {
        for (int i: getKeywordIds()) if (Check.isBonusInt(i)) this.bonusCount++;
        this.bonus = this.bonusCount > 0;
    }
    public boolean getBonus(){
        return this.bonus;
    }
    public int getBonusCount() {
        return bonusCount;
    }

    public void setDraw() {
        for (int i: getKeywordIds()) if (Check.isDrawInt(i)) this.drawCount++;
        this.draw = this.drawCount > 0;
    }
    public boolean getDraw(){
        return this.draw;
    }
    public int getDrawCount() {
        return drawCount;
    }

    public void setRepeat() {
        for (int i: getKeywordIds()) if (Check.isRepeatInt(i)) this.repeatCount++;
        this.repeat = this.repeatCount > 0;
    }
    public boolean getRepeat(){
        return this.repeat;
    }
    public int getRepeatCount() {
        return repeatCount;
    }

    public void setPassive() {
        for (int i: getKeywordIds()) if (Check.isPassiveInt(i)) this.passiveCount++;
        this.passive = this.passiveCount > 0;
    }
    public boolean getPassive(){
        return this.passive;
    }
    public int getPassiveCount() {
        return passiveCount;
    }

    public void setActive() {
        for (int i: getKeywordIds()) if (Check.isActiveInt(i)) this.activeCount++;
        this.active = this.activeCount > 0;
    }
    public boolean getActive(){
        return this.active;
    }
    public int getActiveCount() {
        return activeCount;
    }

    public void setPermanent() {
        for (int i: getKeywordIds()) if (Check.isPermInt(i)) this.permCount++;
        this.permanent = this.permCount > 0;
    }
    public boolean getPermanent(){
        return this.permanent;
    }
    public int getPermCount() {
        return permCount;
    }

    public void setTemporary() {
        for (int i: getKeywordIds()) if (Check.isTempInt(i)) this.tempCount++;
        this.temporary = this.tempCount > 0;
    }
    public boolean getTemporary(){
        return this.temporary;
    }
    public int getTempCount() {
        return tempCount;
    }





}
