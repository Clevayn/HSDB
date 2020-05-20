package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class KeywordValue {
    int [] kwId = {1, 2, 3, 4, 5, 6, 8, 10, 11, 12, 13, 14, 15, 16, 17, 20, 21, 31, 32, 34, 38, 39, 52, 53, 61, 66, 71,
            76, 77, 78, 79, 86};
    int [] classId = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14};

    KeywordValue() throws IOException {
        LinkedHashMap<String, LinkedHashMap<String, Double>> byClass = new LinkedHashMap<>();
        for (int id: classId
             ) {
            LinkedHashMap<String, Double> byKeyword = new LinkedHashMap<>();
            for (int kw: kwId
                 ) {
                if (kw(kw, id) != 0) byKeyword.put(ValueTranslator.keywordName(kw), 1 +(1 - (kw(kw, id) / id(id).size())));
            }
            byClass.put(ValueTranslator.classNames(id), byKeyword);
        }
        new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\KeywordValue.json"), byClass);
    }

    List<ScoredCard> id(int id) throws IOException {
        List<ScoredCard> out;
        if (id == 2) out = new Filter().druid().minions().collectible().getCardList();
        else if (id == 3) out = new Filter().hunter().minions().collectible().getCardList();
        else if (id == 4) out = new Filter().mage().minions().collectible().getCardList();
        else if (id == 5) out = new Filter().paladin().minions().collectible().getCardList();
        else if (id == 6) out = new Filter().priest().minions().collectible().getCardList();
        else if (id == 7) out = new Filter().rogue().minions().collectible().getCardList();
        else if (id == 8) out = new Filter().shaman().minions().collectible().getCardList();
        else if (id == 9) out = new Filter().warlock().minions().collectible().getCardList();
        else if (id == 10) out = new Filter().warrior().minions().collectible().getCardList();
        else if (id == 14) out = new Filter().demonHunter().minions().collectible().getCardList();
        else if (id == 12) out = new Filter().neutral().minions().collectible().getCardList();
        else out = new Filter().allMinions().collectible().getCardList();

        return out;
    }

    double kw(int kw, int id) throws IOException {
        double kwCount = 0;
        if (kw == 1) kwCount = (int) id(id).stream().filter(Check::isTaunt).count();
        else if (kw == 2) kwCount = (int) id(id).stream().filter(Check::isSpellPower).count();
        else if (kw == 3) kwCount = (int) id(id).stream().filter(Check::isDivineShield).count();
        else if (kw == 4) kwCount = (int) id(id).stream().filter(Check::isCharge).count();
        else if (kw == 5) kwCount = (int) id(id).stream().filter(Check::isSecret).count();
        else if (kw == 6) kwCount = (int) id(id).stream().filter(Check::isStealth).count();
        else if (kw == 8) kwCount = (int) id(id).stream().filter(Check::isBattleCry).count();
        else if (kw == 10) kwCount = (int) id(id).stream().filter(Check::isFreeze).count();
        else if (kw == 11) kwCount = (int) id(id).stream().filter(Check::isWindFury).count();
        else if (kw == 12) kwCount = (int) id(id).stream().filter(Check::isDeathRattle).count();
        else if (kw == 13) kwCount = (int) id(id).stream().filter(Check::isCombo).count();
        else if (kw == 14) kwCount = (int) id(id).stream().filter(Check::isOverload).count();
        else if (kw == 15) kwCount = (int) id(id).stream().filter(Check::isSilence).count();
        else if (kw == 16) kwCount = (int) id(id).stream().filter(Check::isCounter).count();
        else if (kw == 17) kwCount = (int) id(id).stream().filter(Check::isImmune).count();
        else if (kw == 20) kwCount = (int) id(id).stream().filter(Check::isInspire).count();
        else if (kw == 21) kwCount = (int) id(id).stream().filter(Check::isDiscover).count();
        else if (kw == 31) kwCount = (int) id(id).stream().filter(Check::isQuest).count();
        else if (kw == 32) kwCount = (int) id(id).stream().filter(Check::isPoisonous).count();
        else if (kw == 34) kwCount = (int) id(id).stream().filter(Check::isAdapt).count();
        else if (kw == 38) kwCount = (int) id(id).stream().filter(Check::isLifeSteal).count();
        else if (kw == 39) kwCount = (int) id(id).stream().filter(Check::isRecruit).count();
        else if (kw == 52) kwCount = (int) id(id).stream().filter(Check::isEcho).count();
        else if (kw == 53) kwCount = (int) id(id).stream().filter(Check::isRush).count();
        else if (kw == 61) kwCount = (int) id(id).stream().filter(Check::isOverkill).count();
        else if (kw == 66) kwCount = (int) id(id).stream().filter(Check::isMagnetic).count();
        else if (kw == 71) kwCount = (int) id(id).stream().filter(Check::isLackey).count();
        else if (kw == 76) kwCount = (int) id(id).stream().filter(Check::isTwinSpell).count();
        else if (kw == 77) kwCount = (int) id(id).stream().filter(Check::isMegaWindFury).count();
        else if (kw == 78) kwCount = (int) id(id).stream().filter(Check::isReborn).count();
        else if (kw == 79) kwCount = (int) id(id).stream().filter(Check::isInvoke).count();
        else if (kw == 86) kwCount = (int) id(id).stream().filter(Check::isOutcast).count();
        return kwCount;
    }




}
