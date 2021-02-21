package com;


import com.fasterxml.jackson.databind.JsonNode;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class Card {
    private final MathContext m = new MathContext(4);
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

    private boolean standard;

    private double powerScoreWild;
    private double powerScoreStandard;

    private double damageScoreWild;
    private double survivalScoreWild;

    private double damageScoreStandard;
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
        this.powerScoreWild =node.at("/powerScoreWild").asDouble();
        this.powerScoreStandard = node.at("/powerScoreStandard").asDouble();
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
        this.damageScoreWild = node.at("/damageScoreWild").asDouble();
        this.survivalScoreWild = node.at("/survivalScoreWild").asDouble();
        this.damageScoreStandard = node.at("/damageScoreStandard").asDouble();
        this.survivalScoreStandard = node.at("/survivalScoreStandard").asDouble();
        this.control = node.at("/control").asBoolean();
        this.controlCount  = node.at("/controlCount").asInt();
        this.spellTrigger = node.at("/spellTrigger").asBoolean();
        this.spellTriggerCount = node.at("/spellTriggerCount").asInt();
        this.enhanced = node.at("/enhanced").asBoolean();
        this.enhancedCount= node.at("/enhancedCount").asInt();
        this.bonus = node.at("/bonus").asBoolean();
        this.bonusCount = node.at("/bonusCount").asInt();
        this.draw = node.at("/draw").asBoolean();
        this.drawCount = node.at("/drawCount").asInt();
        this.repeat = node.at("/repeat").asBoolean();
        this.repeatCount = node.at("/repeatCount").asInt();

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

    public void setPowerScoreWild(double powerScoreWild) {
        this.powerScoreWild = powerScoreWild;
    }
    public double getPowerScoreWild() {
        try {
            return Double.parseDouble(new BigDecimal(powerScoreWild).round(m).toString());
        } catch (Exception e){
            return 0;
        }
    }

    public void setPowerScoreStandard(double powerScoreStandard) {
        this.powerScoreStandard = powerScoreStandard;
    }
    public double getPowerScoreStandard() {
        try {
            return Double.parseDouble(new BigDecimal(powerScoreStandard).round(m).toString());
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

}
