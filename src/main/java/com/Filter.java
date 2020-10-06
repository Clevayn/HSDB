package com;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private List<ScoredCard> cardList = new LinkedList<>();

    Filter() throws IOException {
        for (JsonNode node: new ObjectMapper().readTree(new File("C:\\Projects\\JavaKotlinSandbox\\src\\main\\resources\\DataBase.json"))
        ) {
            cardList.add(new ScoredCard(node));
        }

    }

    public Filter zeroCost(){
        this.cardList = this.cardList.stream().filter(Check::costZero).collect(Collectors.toList());
        return this;
    }

    public Filter oneCost(){
        this.cardList = this.cardList.stream().filter(Check::costOne).collect(Collectors.toList());
        return this;
    }

    public Filter twoCost(){
        this.cardList = this.cardList.stream().filter(Check::costTwo).collect(Collectors.toList());
        return this;
    }

    public Filter threeCost(){
        this.cardList = this.cardList.stream().filter(Check::costThree).collect(Collectors.toList());
        return this;
    }

    public Filter fourCost(){
        this.cardList = this.cardList.stream().filter(Check::costFour).collect(Collectors.toList());
        return this;
    }

    public Filter fiveCost(){
        this.cardList = this.cardList.stream().filter(Check::costFive).collect(Collectors.toList());
        return this;
    }

    public Filter sixCost(){
        this.cardList = this.cardList.stream().filter(Check::costSix).collect(Collectors.toList());
        return this;
    }

    public Filter sevenCost(){
        this.cardList = this.cardList.stream().filter(Check::costSeven).collect(Collectors.toList());
        return this;
    }

    public Filter eightCost(){
        this.cardList = this.cardList.stream().filter(Check::costEight).collect(Collectors.toList());
        return this;
    }

    public Filter nineCost(){
        this.cardList = this.cardList.stream().filter(Check::costNine).collect(Collectors.toList());
        return this;
    }

    public Filter tenCost(){
        this.cardList = this.cardList.stream().filter(Check::costTen).collect(Collectors.toList());
        return this;
    }

    public Filter aboveTenCost(){
        this.cardList = this.cardList.stream().filter(Check::costGreaterThenTen).collect(Collectors.toList());
        return this;
    }

    public Filter allHero() {
        this.cardList = this.cardList.stream().filter(Check::isHero).collect(Collectors.toList());
        return this;
    }

    public Filter allWeapons() {
        this.cardList = this.cardList.stream().filter(Check::isWeapon).collect(Collectors.toList());
        return this;
    }

    public Filter allSpells() {
        this.cardList = this.cardList.stream().filter(Check::isSpell).collect(Collectors.toList());
        return this;
    }

    public Filter allMinions() {
        this.cardList = this.cardList.stream().filter(Check::isMinion).collect(Collectors.toList());
        return this;
    }

    public Filter druid(){
        this.cardList = this.cardList.stream().filter(Check::isDruid).collect(Collectors.toList());
        return this;
    }

    public Filter hunter(){
        this.cardList = this.cardList.stream().filter(Check::isHunter).collect(Collectors.toList());
        return this;
    }

    public Filter mage(){
        this.cardList = this.cardList.stream().filter(Check::isMage).collect(Collectors.toList());
        return this;
    }

    public Filter paladin(){
        this.cardList = this.cardList.stream().filter(Check::isPaladin).collect(Collectors.toList());
        return this;
    }

    public Filter priest(){
        this.cardList = this.cardList.stream().filter(Check::isPriest).collect(Collectors.toList());
        return this;
    }

    public Filter rogue(){
        this.cardList = this.cardList.stream().filter(Check::isRogue).collect(Collectors.toList());
        return this;
    }

    public Filter shaman(){
        this.cardList = this.cardList.stream().filter(Check::isShaman).collect(Collectors.toList());
        return this;
    }

    public Filter warlock(){
        this.cardList = this.cardList.stream().filter(Check::isWarlock).collect(Collectors.toList());
        return this;
    }

    public Filter warrior(){
        this.cardList = this.cardList.stream().filter(Check::isWarrior).collect(Collectors.toList());
        return this;
    }

    public Filter demonHunter(){
        this.cardList = this.cardList.stream().filter(Check::isDemonHunter).collect(Collectors.toList());
        return this;
    }

    public Filter neutral(){
        this.cardList = this.cardList.stream().filter(Check::isNeutral).collect(Collectors.toList());
        return this;
    }

    public Filter getHeroPower() {
        this.cardList = this.cardList.stream().filter(Check::isHeroPower).collect(Collectors.toList());
        return this;
    }

    public Filter standard() {
        this.cardList =
                this.cardList
                .stream()
                .filter(Check::isStandard)
                .collect(Collectors.toList());
        return this;
    }

    public Filter collectible() {
        this.cardList = this.cardList
                .stream()
                .filter(Check::isCollectible)
                .collect(Collectors.toList());
        return this;
    }

    public Filter nonCollectible(){
        this.cardList = this.cardList.stream()
                .filter(Check::isNotCollectible)
                .collect(Collectors.toList());
        return this;
    }

    public Filter minions() {
        this.cardList = this.cardList.stream()
                .filter(Check::isMinion)
                .collect(Collectors.toList());
        return this;
    }

    public Filter spells() {
        this.cardList =
                this.cardList
                        .stream()
                        .filter(Check::isSpell)
                        .collect(Collectors.toList());
        return this;
    }

    public Filter basic() {
        this.cardList = this.cardList.stream().filter(Check::isBasic).collect(Collectors.toList());
        return this;
    }

    public Filter murloc() {
        this.cardList = this.cardList.stream().filter(Check::isMurloc).collect(Collectors.toList());
        return this;
    }

    public Filter demon() {
        this.cardList = this.cardList.stream().filter(Check::isDemon).collect(Collectors.toList());
        return this;
    }

    public Filter mech() {
        this.cardList = this.cardList
                .stream()
                .filter(Check::isMech)
                .collect(Collectors.toList());
        return this;
    }

    public Filter elemental() {
        this.cardList =
                this.cardList
                        .stream()
                        .filter(Check::isElemental)
                        .collect(Collectors.toList());
        return this;
    }

    public Filter beast() {
        this.cardList = this.cardList.stream().filter(Check::isBeast).collect(Collectors.toList());
        return this;
    }

    public Filter totem() {
        this.cardList = this.cardList.stream().filter(Check::isTotem).collect(Collectors.toList());
        return this;
    }

    public Filter pirate() {
        this.cardList = this.cardList.stream().filter(Check::isPirate).collect(Collectors.toList());
        return this;
    }

    public Filter dragon() {
        this.cardList = this.cardList.stream().filter(Check::isDragon).collect(Collectors.toList());
        return this;
    }

    public Filter costEqual(int cost){
        this.cardList = this.cardList
                .stream()
                .filter(card -> card.getManaCost() == cost)
                .collect(Collectors.toList());
        return this;
    }

    public Filter costAndGreater(int cost){
        this.cardList =
                this.cardList
                        .stream()
                        .filter(card -> card.getManaCost() >= cost)
                        .collect(Collectors.toList());
        return this;
    }

    public Filter costAndLesser(int cost){
        this.cardList =
                this.cardList
                        .stream()
                        .filter(card -> card.getManaCost() <= cost)
                        .collect(Collectors.toList());
        return this;
    }

    public Filter noRarity(){
        this.cardList = this.cardList.stream().filter(Check::noRarity).collect(Collectors.toList());
        return this;
    }

    public Filter free(){
        this.cardList = this.cardList.stream().filter(Check::isFree).collect(Collectors.toList());
        return this;
    }

    public Filter common(){
        this.cardList = this.cardList.stream().filter(Check::isCommon).collect(Collectors.toList());
        return this;
    }

    public Filter rare(){
        this.cardList = this.cardList.stream().filter(Check::isRare).collect(Collectors.toList());
        return this;
    }

    public Filter epic(){
        this.cardList = this.cardList.stream().filter(Check::isEpic).collect(Collectors.toList());
        return this;
    }

    public Filter legendary(){
        this.cardList = this.cardList.stream().filter(Check::isLegendary).collect(Collectors.toList());
        return this;
    }

    public Filter taunt(){
        this.cardList = this.cardList.stream().filter(Check::isTaunt).collect(Collectors.toList());
        return this;
    }

    public Filter spellPower(){
        this.cardList = this.cardList.stream().filter(Check::isSpellPower).collect(Collectors.toList());
        return this;
    }

    public Filter divineShield(){
        this.cardList = this.cardList.stream().filter(Check::isDivineShield).collect(Collectors.toList());
        return this;
    }

    public Filter charge(){
        this.cardList = this.cardList.stream().filter(Check::isCharge).collect(Collectors.toList());
        return this;
    }

    public Filter secret(){
        this.cardList = this.cardList.stream().filter(Check::isSecret).collect(Collectors.toList());
        return this;
    }

    public Filter stealth(){
        this.cardList = this.cardList.stream().filter(Check:: isStealth).collect(Collectors.toList());
        return this;
    }

    public Filter battlecry(){
        this.cardList = this.cardList.stream().filter(Check::isBattleCry).collect(Collectors.toList());
        return this;
    }

    public Filter Freeze(){
        this.cardList = this.cardList.stream().filter(Check::isFreeze).collect(Collectors.toList());
        return this;
    }

    public Filter windfury(){
        this.cardList = this.cardList.stream().filter(Check::isWindFury).collect(Collectors.toList());
        return this;
    }

    public Filter deathrattle(){
        this.cardList = this.cardList.stream().filter(Check::isDeathRattle).collect(Collectors.toList());
        return this;
    }

    public Filter combo(){
        this.cardList = this.cardList.stream().filter(Check::isCombo).collect(Collectors.toList());
        return this;
    }

    public Filter overload(){
        this.cardList = this.cardList.stream().filter(Check::isOverload).collect(Collectors.toList());
        return this;
    }

    public Filter silence(){
        this.cardList = this.cardList.stream().filter(Check::isSilence).collect(Collectors.toList());
        return this;
    }

    public Filter counter(){
        this.cardList = this.cardList.stream().filter(Check::isCounter).collect(Collectors.toList());
        return this;
    }

    public Filter immune(){
        this.cardList = this.cardList.stream().filter(Check::isImmune).collect(Collectors.toList());
        return this;
    }

    public Filter inspire(){
        this.cardList = this.cardList.stream().filter(Check::isInspire).collect(Collectors.toList());
        return this;
    }

    public Filter discover(){
        this.cardList = this.cardList.stream().filter(Check::isDiscover).collect(Collectors.toList());
        return this;
    }

    public Filter quest(){
        this.cardList = this.cardList.stream().filter(Check::isQuest).collect(Collectors.toList());
        return this;
    }

    public Filter poisonous(){
        this.cardList = this.cardList.stream().filter(Check::isPoisonous).collect(Collectors.toList());
        return this;
    }

    public Filter adapt(){
        this.cardList = this.cardList.stream().filter(Check::isAdapt).collect(Collectors.toList());
        return this;
    }

    public Filter lifesteal(){
        this.cardList = this.cardList.stream().filter(Check::isLifeSteal).collect(Collectors.toList());
        return this;
    }

    public Filter recruit(){
        this.cardList = this.cardList.stream().filter(Check::isRecruit).collect(Collectors.toList());
        return this;
    }

    public Filter echo(){
        this.cardList = this.cardList.stream().filter(Check::isEcho).collect(Collectors.toList());
        return this;
    }

    public Filter rush(){
        this.cardList = this.cardList.stream().filter(Check::isRush).collect(Collectors.toList());
        return this;
    }

    public Filter overkill(){
        this.cardList = this.cardList.stream().filter(Check::isOverkill).collect(Collectors.toList());
        return this;
    }

    public Filter magnetic(){
        this.cardList = this.cardList.stream().filter(Check::isMagnetic).collect(Collectors.toList());
        return this;
    }

    public Filter lackey(){
        this.cardList = this.cardList.stream().filter(Check::isLackey).collect(Collectors.toList());
        return this;
    }

    public Filter twinspell(){
        this.cardList = this.cardList.stream().filter(Check::isTwinSpell).collect(Collectors.toList());
        return this;
    }

    public Filter megaWindfury(){
        this.cardList = this.cardList.stream().filter(Check::isMegaWindFury).collect(Collectors.toList());
        return this;
    }

    public Filter reborn(){
        this.cardList = this.cardList.stream().filter(Check::isReborn).collect(Collectors.toList());
        return this;
    }

    public Filter invoke(){
        this.cardList = this.cardList.stream().filter(Check::isInvoke).collect(Collectors.toList());
        return this;
    }

    public Filter outcast(){
        this.cardList = this.cardList.stream().filter(Check::isOutcast).collect(Collectors.toList());
        return this;
    }

    public Filter control(){
        this.cardList = this.cardList.stream().filter(Check::isControl).collect(Collectors.toList());
        return this;
    }

    public Filter spellTrigger(){
        this.cardList = this.cardList.stream().filter(Check::isSpellTrigger).collect(Collectors.toList());
        return this;
    }

    public Filter buff(){
        this.cardList = this.cardList.stream().filter(Check::isEnhanced).collect(Collectors.toList());
        return this;
    }

    public Filter deckAugment(){
        this.cardList =
                this.cardList
                        .stream()
                        .filter(Check::isBonus)
                        .collect(Collectors.toList());
        return this;
    }

    public Filter active(){
        this.cardList =
                this.cardList
                        .stream()
                        .filter(Check::isActive)
                        .collect(Collectors.toList());
        return this;
    }

    public Filter passive(){
        this.cardList =
                this.cardList
                        .stream()
                        .filter(Check::isPassive)
                        .collect(Collectors.toList());
        return this;
    }

    public Filter perm(){
        this.cardList =
                this.cardList
                        .stream()
                        .filter(Check::isPerm)
                        .collect(Collectors.toList());
        return this;
    }

    public Filter temp(){
        this.cardList =
                this.cardList
                        .stream()
                        .filter(Check::isTemp)
                        .collect(Collectors.toList());
        return this;
    }

    public Filter draw(){
        this.cardList =
                this.cardList
                        .stream()
                        .filter(Check::isDraw)
                        .collect(Collectors.toList());
        return this;
    }

    public Filter repeat(){
        this.cardList =
                this.cardList
                        .stream()
                        .filter(Check::isRepeat)
                        .collect(Collectors.toList());
        return this;
    }

    public List<ScoredCard> getCardList() {
        return cardList;
    }
}
