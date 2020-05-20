package com;

import java.util.List;

public class Check {

    static boolean isDruid(Card card){
        return card.getClassId() == 2;
    }

    static boolean isHunter(Card card){
        return card.getClassId() == 3;
    }

    static boolean isMage(Card card){
        return card.getClassId() == 4;
    }

    static boolean isPaladin(Card card){
        return card.getClassId() == 5;
    }

    static boolean isPriest(Card card){
        return card.getClassId() == 6;
    }

    static boolean isRogue(Card card){
        return card.getClassId() == 7;
    }

    static boolean isShaman(Card card){
        return card.getClassId() == 8;
    }

    static boolean isWarlock(Card card){
        return card.getClassId() == 9;
    }

    static boolean isWarrior(Card card){
        return card.getClassId() == 10;
    }

    static boolean isDemonHunter(Card card){
        return card.getClassId() == 14;
    }

    static boolean isNeutral(Card card){
        return card.getClassId() == 12;
    }

    static boolean isControl(Card card){
        for (int i: card.getKeywordIds()
             ) {
            if (i == 1 || i == 4 || i == 5 || i == 6 || i == 10 || i == 14 ||
                    i == 15 || i == 16 || i == 17 || i == 21 || i == 31 || i == 32 ||
                    i == 34 || i == 53) return true;
        }
        return false;
    }

    static boolean isSpellTrigger(Card card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 5 || i == 8 || i == 12 || i == 13  || i == 14 || i == 16 || i == 20 || i == 21 || i == 31 || i == 34 ||
            i == 39 || i == 52 || i == 61 || i == 71 || i == 76 || i == 78 || i == 79 || i == 86)
                return true;
        }
        return false;
    }

    static boolean isEnhanced(Card card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 10 || i == 11 ||
                    i == 15 || i == 17 || i == 32 || i == 38 || i == 53 || i == 66 || i == 77)
                return true;
        }
        return false;
    }

    static boolean isBonus(Card card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 2 || i == 38 || i == 61 || i == 86)
                return true;
        }
        return false;
    }

    static boolean isDraw(Card card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 21 || i == 71)
                return true;
        }
        return false;
    }

    static boolean isRepeat(Card card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 52 || i == 76 || i == 78)
                return true;
        }
        return false;
    }

    static boolean isPassive(Card card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 1 || i == 2 || i == 3 || i == 5 || i == 6 || i == 12 || i == 14 || i == 16 || i == 17 ||
            i == 31 || i == 76 || i == 79 || i == 78)
                return true;
        }
        return false;
    }

    static boolean isActive(Card card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 4 || i == 8 || i == 10 || i == 11 || i == 13 || i == 15 || i == 20 || i == 21 ||
                    i == 32 || i == 34 || i == 38 || i == 39 || i == 52 || i == 53 || i == 61 || i == 66 ||
                    i == 71 || i == 77 || i == 86)
                return true;
        }
        return false;
    }

    static boolean isPerm(Card card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 1 || i == 2 || i == 10 || i == 11 || i == 17 || i == 20 || i == 31 ||
                    i == 32 || i == 38 || i == 61 || i == 66 || i == 77)
                return true;
        }
        return false;
    }

    static boolean isTemp(Card card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 3 || i == 4 || i == 5 || i == 6 || i == 8 || i == 12 || i == 13 ||
                    i == 14 || i == 15 || i == 16 || i == 21 || i == 34 || i == 39 || i == 52 ||
            i == 53 || i == 71 || i == 76 || i == 78 || i == 86)
                return true;
        }
        return false;
    }

    static boolean isDblEdge(Card card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 14 || i == 66 || i == 86)
                return true;
        }
        return false;
    }


    static boolean isTempInt(int kw){

        return kw == 3 || kw == 78 || kw == 34 || kw == 6 ||
                kw == 66 || kw == 10 || kw == 4 || kw == 53;
    }

    static boolean isPermInt(int kw){
        return kw == 32 || kw == 17 || kw == 11 || kw == 77 ||
                kw == 2 || kw == 38 || kw == 15 || kw == 16 ||
                kw == 1;
    }

    static boolean isBonusInt(int kw){
        return kw == 39 || kw == 52 || kw == 76 || kw == 71 ||
                kw == 14 ;
    }

    static boolean isEnhancedInt(int kw){
        return kw == 32 || kw == 3 || kw == 17 || kw == 78 || kw == 11
                || kw == 77 || kw == 2 || kw == 6 || kw == 38 ||
                kw == 34 || kw == 66;
    }

    static boolean isControlInt(int kw){
        return kw == 10 || kw == 5 || kw == 15 || kw == 16 || kw == 14 || kw == 4 ||
                kw == 53 || kw == 1 || kw == 21 || kw == 39 || kw == 52 ||
                kw == 71;
    }

    static boolean isRepeatInt(int kw){
        return kw == 52 || kw == 76;
    }

    static boolean isDrawInt(int kw){
        return kw == 21 || kw == 39 || kw == 71 ;
    }

    static boolean isPassiveInt(int kw){
        return kw == 12 || kw == 8 || kw == 13 || kw == 31;
    }

    static boolean isActiveInt(int kw){
        return kw == 61 || kw == 20 || kw == 5;
    }

    static boolean isSpellTriggerInt(int kw){
        return kw == 12 || kw == 8 || kw == 61 || kw == 20 || kw == 13;
    }

    static boolean isTaunt(Card card){
        for (int i: card.getKeywordIds()) if (i == 1) return true;
        return false;
    }

    static boolean isSpellPower(Card card){
        for (int i: card.getKeywordIds()) if (i == 2) return true;
        return false;
    }

    static boolean isDivineShield(Card card){
        for (int i: card.getKeywordIds()) if (i == 3) return true;
        return false;
    }

    static boolean isCharge(Card card){
        for (int i: card.getKeywordIds()) if (i == 4) return true;
        return false;
    }

    static boolean isSecret(Card card){
        for (int i: card.getKeywordIds()) if (i == 5) return true;
        return false;
    }

    static boolean isStealth(Card card){
        for (int i: card.getKeywordIds()) if (i == 6) return true;
        return false;
    }

    static boolean isBattleCry(Card card){
        for (int i: card.getKeywordIds()) if (i == 8) return true;
        return false;
    }

    static boolean isFreeze(Card card){
        for (int i: card.getKeywordIds()) if (i == 10) return true;
        return false;

    }

    static boolean isWindFury(Card card){
        for (int i: card.getKeywordIds()) if (i == 11) return true;
        return false;
    }

    static boolean isDeathRattle(Card card){
        for (int i: card.getKeywordIds()) if (i == 12) return true;
        return false;
    }

    static boolean isCombo(Card card){
        for (int i: card.getKeywordIds()) if (i == 13) return true;
        return false;
    }

    static boolean isOverload(Card card){
        for (int i: card.getKeywordIds()) if (i == 14) return true;
        return false;
    }

    static boolean isSilence(Card card){
        for (int i: card.getKeywordIds()) if (i == 15) return true;
        return false;
    }

    static boolean isCounter(Card card){
        for (int i: card.getKeywordIds()) if (i == 16) return true;
        return false;
    }

    static boolean isImmune(Card card){
        for (int i: card.getKeywordIds()) if (i == 17) return true;
        return false;
    }

    static boolean isInspire(Card card){
        for (int i: card.getKeywordIds()) if (i == 20) return true;
        return false;
    }

    static boolean isDiscover(Card card){
        for (int i: card.getKeywordIds()) if (i == 21) return true;
        return false;
    }

    static boolean isQuest(Card card){
        for (int i: card.getKeywordIds()) if (i == 31) return true;
        return false;
    }

    static boolean isPoisonous(Card card){
        for (int i: card.getKeywordIds()) if (i == 32) return true;
        return false;
    }

    static boolean isAdapt(Card card){
        for (int i: card.getKeywordIds()) if (i == 34) return true;
        return false;
    }

    static boolean isLifeSteal(Card card){
        for (int i: card.getKeywordIds()) if (i == 38) return true;
        return false;
    }

    static boolean isRecruit(Card card){
        for (int i: card.getKeywordIds()) if (i == 39) return true;
        return false;
    }

    static boolean isEcho(Card card){
        for (int i: card.getKeywordIds()) if (i == 52) return true;
        return false;
    }

    static boolean isRush(Card card){
        for (int i: card.getKeywordIds()) if (i == 53) return true;
        return false;
    }

    static boolean isOverkill(Card card){
        for (int i: card.getKeywordIds()) if (i == 61) return true;
        return false;
    }

    static boolean isMagnetic(Card card){
        for (int i: card.getKeywordIds()) if (i == 66) return true;
        return false;
    }

    static boolean isLackey(Card card){
        for (int i: card.getKeywordIds()) if (i == 71) return true;
        return false;
    }

    static boolean isTwinSpell(Card card){
        for (int i: card.getKeywordIds()) if (i == 76) return true;
        return false;
    }

    static boolean isMegaWindFury(Card card){
        for (int i: card.getKeywordIds()) if (i == 77) return true;
        return false;
    }

    static boolean isReborn(Card card){
        for (int i: card.getKeywordIds()) if (i == 78) return true;
        return false;
    }

    static boolean isInvoke(Card card){
        for (int i: card.getKeywordIds()) if (i == 79) return true;
        return false;
    }

    static boolean isOutcast(Card card){
        for (int i: card.getKeywordIds()) if (i == 86) return true;
        return false;
    }

    static boolean isHeroPower(Card card){
        return card.getCardTypeId() == 10;
    }

    static boolean isHero(Card card){
        return card.getCardTypeId() == 3;
    }

    static boolean isWeapon(Card card){
        return card.getCardTypeId() == 7;
    }

    static boolean isSpell(Card card){
        return card.getCardTypeId() == 5;
    }

    static boolean isMinion(Card card){
        return card.getCardTypeId() == 4;
    }

    static boolean isCollectible(Card card){
        return card.getCollectible() == 1;
    }

    static boolean isNotCollectible(Card card){
        return card.getCollectible() == -1;
    }

    static boolean isStandard(Card card){
        return card.getCardSetId() >= 1130 || card.getCardSetId() == 2 || card.getCardSetId() == 3;
    }

    static boolean noRarity(Card card){
        return card.getRarityId() == -1;
    }

    static boolean isFree(Card card){
        return card.getRarityId() == 2;
    }

    static boolean isCommon(Card card){
        return card.getRarityId() == 1;
    }

    static boolean isRare(Card card){
        return card.getRarityId() == 3;
    }

    static boolean isEpic(Card card){
        return card.getRarityId() == 4;
    }

    static boolean isLegendary(Card card){
        return card.getRarityId() ==5;
    }

    static boolean isBasic(Card card){
        return card.getMinionTypeId() == -1;
    }

    static boolean isMurloc(Card card){
        return card.getMinionTypeId() == 14;
    }

    static boolean isDemon(Card card){
        return card.getMinionTypeId() == 15;
    }

    static boolean isMech(Card card){
        return card.getMinionTypeId() == 17;
    }

    static boolean isElemental(Card card){
        return card.getMinionTypeId() ==18;
    }

    static boolean isBeast(Card card){
        return card.getMinionTypeId() == 20;
    }

    static boolean isTotem(Card card){
        return card.getMinionTypeId() == 21;
    }

    static boolean isPirate(Card card){
        return card.getMinionTypeId() == 23;
    }

    static boolean isDragon(Card card){
        return card.getMinionTypeId() == 24;
    }

    static boolean costZero(Card card){
        return card.getManaCost() == 0;
    }

    static boolean costOne(Card card){
        return card.getManaCost() == 1;
    }

    static boolean costTwo(Card card){
        return card.getManaCost() == 2;
    }

    static boolean costThree(Card card){
        return card.getManaCost() == 3;
    }

    static boolean costFour(Card card){
        return card.getManaCost() == 4;
    }

    static boolean costFive(Card card){
        return card.getManaCost() == 5;
    }

    static boolean costSix(Card card){
        return card.getManaCost() == 6;
    }

    static boolean costSeven(Card card){
        return card.getManaCost() == 7;
    }

    static boolean costEight(Card card){
        return card.getManaCost() == 8;
    }

    static boolean costNine(Card card){
        return card.getManaCost() == 9;
    }

    static boolean costTen(Card card){
        return card.getManaCost() == 10;
    }

    static boolean costGreaterThenTen(Card card){
        return card.getManaCost() > 10;
    }

    static boolean costEqual(Card card1, int cost){
        return card1.getManaCost() == cost;
    }

    static boolean isDruid(ScoredCard card){
        return card.getClassId() == 2;
    }

    static boolean isHunter(ScoredCard card){
        return card.getClassId() == 3;
    }

    static boolean isMage(ScoredCard card){
        return card.getClassId() == 4;
    }

    static boolean isPaladin(ScoredCard card){
        return card.getClassId() == 5;
    }

    static boolean isPriest(ScoredCard card){
        return card.getClassId() == 6;
    }

    static boolean isRogue(ScoredCard card){
        return card.getClassId() == 7;
    }

    static boolean isShaman(ScoredCard card){
        return card.getClassId() == 8;
    }

    static boolean isWarlock(ScoredCard card){
        return card.getClassId() == 9;
    }

    static boolean isWarrior(ScoredCard card){
        return card.getClassId() == 10;
    }

    static boolean isDemonHunter(ScoredCard card){
        return card.getClassId() == 14;
    }

    static boolean isNeutral(ScoredCard card){
        return card.getClassId() == 12;
    }

    public static boolean isDblEdge(ScoredCard card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 14 || i == 66 || i == 86)
                return true;
        }
        return false;
    }

    static boolean isControl(ScoredCard card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 1 || i == 4 || i == 5 || i == 6 || i == 10 || i == 14 ||
                    i == 15 || i == 16 || i == 17 || i == 21 || i == 31 || i == 32 ||
                    i == 34 || i == 53) return true;
        }
        return false;
    }

    static boolean isSpellTrigger(ScoredCard card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 5 || i == 8 || i == 12 || i == 13  || i == 14 || i == 16 || i == 20 || i == 21 || i == 31 || i == 34 ||
                    i == 39 || i == 52 || i == 61 || i == 71 || i == 76 || i == 78 || i == 79 || i == 86)
                return true;
        }
        return false;
    }

    static boolean isPassive(ScoredCard card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 1 || i == 2 || i == 3 || i == 5 || i == 6 || i == 12 || i == 14 || i == 16 || i == 17 ||
                    i == 31 || i == 76 || i == 79 || i == 78)
                return true;
        }
        return false;
    }

    static boolean isActive(ScoredCard card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 4 || i == 8 || i == 10 || i == 11 || i == 13 || i == 15 || i == 20 || i == 21 ||
                    i == 32 || i == 34 || i == 38 || i == 39 || i == 52 || i == 53 || i == 61 || i == 66 ||
                    i == 71 || i == 77 || i == 86)
                return true;
        }
        return false;
    }

    static boolean isEnhanced(ScoredCard card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 10 || i == 11 ||
                    i == 15 || i == 17 || i == 32 || i == 38 || i == 53 || i == 66 || i == 77)
                return true;
        }
        return false;
    }

    static boolean isPerm(ScoredCard card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 1 || i == 2 || i == 10 || i == 11 || i == 17 || i == 20 || i == 31 ||
                    i == 32 || i == 38 || i == 61 || i == 66 || i == 77)
                return true;
        }
        return false;
    }

    static boolean isTemp(ScoredCard card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 3 || i == 4 || i == 5 || i == 6 || i == 8 || i == 12 || i == 13 ||
                    i == 14 || i == 15 || i == 16 || i == 21 || i == 34 || i == 39 || i == 52 ||
                    i == 53 || i == 71 || i == 76 || i == 78 || i == 86)
                return true;
        }
        return false;
    }

    static boolean isBonus(ScoredCard card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 2 || i == 38 || i == 61 || i == 86)
                return true;
        }
        return false;
    }

    static boolean isDraw(ScoredCard card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 21 || i == 71)
                return true;
        }
        return false;
    }

    static boolean isRepeat(ScoredCard card){
        for (int i: card.getKeywordIds()
        ) {
            if (i == 52 || i == 76 || i == 78)
                return true;
        }
        return false;
    }

    static boolean isTaunt(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 1) return true;
        return false;
    }

    static boolean isSpellPower(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 2) return true;
        return false;
    }

    static boolean isDivineShield(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 3) return true;
        return false;
    }

    static boolean isCharge(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 4) return true;
        return false;
    }

    static boolean isSecret(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 5) return true;
        return false;
    }

    static boolean isStealth(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 6) return true;
        return false;
    }

    static boolean isBattleCry(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 8) return true;
        return false;
    }

    static boolean isFreeze(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 10) return true;
        return false;

    }

    static boolean isWindFury(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 11) return true;
        return false;
    }

    static boolean isDeathRattle(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 12) return true;
        return false;
    }

    static boolean isCombo(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 13) return true;
        return false;
    }

    static boolean isOverload(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 14) return true;
        return false;
    }

    static boolean isSilence(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 15) return true;
        return false;
    }

    static boolean isCounter(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 16) return true;
        return false;
    }

    static boolean isImmune(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 17) return true;
        return false;
    }

    static boolean isInspire(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 20) return true;
        return false;
    }

    static boolean isDiscover(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 21) return true;
        return false;
    }

    static boolean isQuest(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 31) return true;
        return false;
    }

    static boolean isPoisonous(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 32) return true;
        return false;
    }

    static boolean isAdapt(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 34) return true;
        return false;
    }

    static boolean isLifeSteal(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 38) return true;
        return false;
    }

    static boolean isRecruit(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 39) return true;
        return false;
    }

    static boolean isEcho(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 52) return true;
        return false;
    }

    static boolean isRush(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 53) return true;
        return false;
    }

    static boolean isOverkill(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 61) return true;
        return false;
    }

    static boolean isMagnetic(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 66) return true;
        return false;
    }

    static boolean isLackey(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 71) return true;
        return false;
    }

    static boolean isTwinSpell(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 76) return true;
        return false;
    }

    static boolean isMegaWindFury(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 77) return true;
        return false;
    }

    static boolean isReborn(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 78) return true;
        return false;
    }

    static boolean isInvoke(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 79) return true;
        return false;
    }

    static boolean isOutcast(ScoredCard card){
        for (int i: card.getKeywordIds()) if (i == 86) return true;
        return false;
    }




    static boolean isHeroPower(ScoredCard card){
        return card.getCardTypeId() == 10;
    }

    static boolean isHero(ScoredCard card){
        return card.getCardTypeId() == 3;
    }

    static boolean isWeapon(ScoredCard card){
        return card.getCardTypeId() == 7;
    }

    static boolean isSpell(ScoredCard card){
        return card.getCardTypeId() == 5;
    }

    static boolean isMinion(ScoredCard card){
        return card.getCardTypeId() == 4;
    }

    static boolean isCollectible(ScoredCard card){
        return card.getCollectible() == 1;
    }

    static boolean isNotCollectible(ScoredCard card){
        return card.getCollectible() == -1;
    }

    static boolean isStandard(ScoredCard card){
        return card.getCardSetId() >= 1130 || card.getCardSetId() == 2 || card.getCardSetId() == 3;
    }

    static boolean noRarity(ScoredCard card){
        return card.getRarityId() == -1;
    }

    static boolean isFree(ScoredCard card){
        return card.getRarityId() == 2;
    }

    static boolean isCommon(ScoredCard card){
        return card.getRarityId() == 1;
    }

    static boolean isRare(ScoredCard card){
        return card.getRarityId() == 3;
    }

    static boolean isEpic(ScoredCard card){
        return card.getRarityId() == 4;
    }

    static boolean isLegendary(ScoredCard card){
        return card.getRarityId() ==5;
    }

    static boolean isBasic(ScoredCard card){
        return card.getMinionTypeId() == -1;
    }

    static boolean isMurloc(ScoredCard card){
        return card.getMinionTypeId() == 14;
    }

    static boolean isDemon(ScoredCard card){
        return card.getMinionTypeId() == 15;
    }

    static boolean isMech(ScoredCard card){
        return card.getMinionTypeId() == 17;
    }

    static boolean isElemental(ScoredCard card){
        return card.getMinionTypeId() ==18;
    }

    static boolean isBeast(ScoredCard card){
        return card.getMinionTypeId() == 20;
    }

    static boolean isTotem(ScoredCard card){
        return card.getMinionTypeId() == 21;
    }

    static boolean isPirate(ScoredCard card){
        return card.getMinionTypeId() == 23;
    }

    static boolean isDragon(ScoredCard card){
        return card.getMinionTypeId() == 24;
    }

    static boolean costZero(ScoredCard card){
        return card.getManaCost() == 0;
    }

    static boolean costOne(ScoredCard card){
        return card.getManaCost() == 1;
    }

    static boolean costTwo(ScoredCard card){
        return card.getManaCost() == 2;
    }

    static boolean costThree(ScoredCard card){
        return card.getManaCost() == 3;
    }

    static boolean costFour(ScoredCard card){
        return card.getManaCost() == 4;
    }

    static boolean costFive(ScoredCard card){
        return card.getManaCost() == 5;
    }

    static boolean costSix(ScoredCard card){
        return card.getManaCost() == 6;
    }

    static boolean costSeven(ScoredCard card){
        return card.getManaCost() == 7;
    }

    static boolean costEight(ScoredCard card){
        return card.getManaCost() == 8;
    }

    static boolean costNine(ScoredCard card){
        return card.getManaCost() == 9;
    }

    static boolean costTen(ScoredCard card){
        return card.getManaCost() == 10;
    }

    static boolean costGreaterThenTen(ScoredCard card){
        return card.getManaCost() > 10;
    }

    static boolean costEqual(ScoredCard card1, int cost){
        return card1.getManaCost() == cost;
    }

}
