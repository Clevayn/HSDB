package com;

import com.fasterxml.jackson.databind.JsonNode;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ScoredCard {
    private final MathContext m = new MathContext(3);
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
    private  int [] keywordIds;

    private boolean standard;

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


    ScoredCard(){}

    ScoredCard(Card card, Ratios ratios) {
        this.id = card.getId();
        this.collectible = card.getCollectible();
        this.slug = card.getSlug();
        this.classId = card.getClassId();
        this.multiClassIds = card.getMultiClassIds();
        this.minionTypeId = card.getMinionTypeId();
        this.cardTypeId = card.getCardTypeId();
        this.cardSetId = card.getCardSetId();
        this.rarityId = card.getRarityId();
        this.artistName = card.getArtistName();
        this.health = card.getHealth();
        this.attack = card.getAttack();
        this.manaCost = card.getManaCost();
        this.minionScoreWild = ratios.getMinionScoreWild();
        this.minionScoreStandard = ratios.getMinionScoreStandard();
        this.durability = card.getDurability();
        this.name = card.getName();
        this.text = card.getText();
        this.image = card.getImage();
        this.imageGold = card.getImageGold();
        this.flavorText = card.getFlavorText();
        this.cropImage = card.getCropImage();
        this.parentId = card.getParentId();
        this.childIds = card.getChildIds();
        this.keywordIds = card.getKeywordIds();
        this.standard = card.isStandard();

        this.damageRatioWild = ratios.getRatios()[0][0];
        this.survivalRatioWild = ratios.getRatios()[0][1];

        this.damageRatioWildCost = ratios.getRatios()[1][0];
        this.survivalRatioWildCost = ratios.getRatios()[1][1];

        this.damageScoreWild = ratios.getScores()[0][0];
        this.survivalScoreWild = ratios.getScores()[0][1];

        this.damageRatioStandard = ratios.getRatios()[2][0];
        this.survivalRatioStandard = ratios.getRatios()[2][1];

        this.damageRatioStandardCost = ratios.getRatios()[3][0];
        this.survivalRatioStandardCost = ratios.getRatios()[3][1];

        this.damageScoreStandard = ratios.getScores()[1][0];
        this.survivalScoreStandard = ratios.getScores()[1][1];

    }

    ScoredCard(JsonNode node){
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
    public static int[] arrayGetter(JsonNode node){
        ArrayList<Integer> hold = new ArrayList<>();
        node.elements().forEachRemaining(j -> hold.add(j.asInt()));
        int[] out = new int[hold.size()];
        for (int i = 0; i < hold.size(); i++) out[i] = hold.get(i);
        return out;


    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCollectible(int collectible) {
        this.collectible = collectible;
    }

    public int getCollectible() {
        return collectible;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSlug() {
        return slug;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    public void setMultiClassIds(int[] multiClassIds) {
        this.multiClassIds = multiClassIds;
    }

    public int[] getMultiClassIds() {
        return multiClassIds;
    }

    public void setMinionTypeId(int minionTypeId) {
        this.minionTypeId = minionTypeId;
    }

    public int getMinionTypeId() {
        return minionTypeId;
    }

    public void setCardTypeId(int cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public int getCardTypeId() {
        return cardTypeId;
    }

    public void setCardSetId(int cardSetId) {
        this.cardSetId = cardSetId;
    }

    public int getCardSetId() {
        return cardSetId;
    }

    public void setRarityId(int rarityId) {
        this.rarityId = rarityId;
    }

    public int getRarityId() {
        return rarityId;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImageGold(String imageGold) {
        this.imageGold = imageGold;
    }

    public String getImageGold() {
        return imageGold;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setCropImage(String cropImage) {
        this.cropImage = cropImage;
    }

    public String getCropImage() {
        return cropImage;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setChildIds(int[] childIds) {
        this.childIds = childIds;
    }

    public int[] getChildIds() {
        return childIds;
    }

    public void setKeywordIds(int[] keywordIds) {
        this.keywordIds = keywordIds;
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

    public boolean getStandard(){return this.standard;}

}
