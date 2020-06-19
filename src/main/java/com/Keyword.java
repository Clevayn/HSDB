package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.LinkedHashMap;

public class Keyword {

    protected boolean spellTrigger = false;
    protected boolean enhanced = false;
    protected boolean active = false;
    protected boolean passive = false;
    protected boolean permanent = false;
    protected boolean temporary = false;
    protected boolean control = false;
    protected boolean dblEdge = false;
    protected boolean bonus = false;
    protected boolean draw = false;
    protected boolean repeat = false;

    Keyword(){}

    Keyword taunt(){
        this.enhanced = true;
        this.passive = true;
        this.permanent = true;
        this.control = true;
        return this;
    }

    Keyword spellPower(){
        this.enhanced = true;
        this.passive = true;
        this.permanent = true;
        this.bonus = true;
        return this;
    }

    Keyword divineShield(){
        this.enhanced = true;
        this.passive = true;
        this.temporary = true;
        return this;
    }

    Keyword charge(){
        this.enhanced = true;
        this.active = true;
        this.temporary = true;
        this.control = true;
        return this;
    }

    Keyword secret(){
        this.spellTrigger = true;
        this.passive = true;
        this.temporary = true;
        this.control = true;
        return this;
    }

    Keyword stealth(){
        this.enhanced = true;
        this.passive = true;
        this.temporary = true;
        this.control = true;
        return this;
    }

    Keyword battlecry(){
        this.spellTrigger = true;
        this.active = true;
        this.temporary = true;
        return this;
    }

    Keyword freeze(){
        this.enhanced = true;
        this.active = true;
        this.permanent = true;
        this.control = true;
        return this;
    }

    Keyword windfury(){
        this.enhanced = true;
        this.active = true;
        this.permanent = true;
        return this;
    }

    Keyword deathrattle(){
        this.spellTrigger = true;
        this.passive = true;
        this.temporary = true;
        return this;
    }

    Keyword combo(){
        this.spellTrigger = true;
        this.active = true;
        this.temporary = true;
        return this;
    }

    Keyword overload(){
        this.passive = true;
        this.temporary = true;
        this.control = true;
        this.dblEdge = true;
        return this;
    }

    Keyword silence(){
        this.enhanced = true;
        this.active = true;
        this.temporary = true;
        this.control = true;
        return this;
    }

    Keyword counter(){
        this.spellTrigger = true;
        this.passive = true;
        this.temporary = true;
        this.control = true;
        return this;
    }

    Keyword immune(){
        this.enhanced = true;
        this.passive = true;
        this.permanent = true;
        this.control = true;
        return this;
    }

    Keyword inspire(){
        this.spellTrigger = true;
        this.active = true;
        this.permanent = true;
        return this;
    }

    Keyword discover(){
        this.spellTrigger = true;
        this.active = true;
        this.temporary = true;
        this.draw = true;
        return this;
    }

    Keyword quest(){
        this.spellTrigger = true;
        this.permanent = true;
        this.passive = true;
        this.control = true;
        return this;
    }

    Keyword poisonous(){
        this.enhanced = true;
        this.active = true;
        this.permanent = true;
        this.control = true;
        return this;
    }

    Keyword adapt(){
        this.spellTrigger = true;
        this.active = true;
        this.temporary = true;
        this.control = true;
        return this;
    }

    Keyword lifesteal(){
        this.enhanced = true;
        this.active = true;
        this.permanent = true;
        this.bonus = true;
        return this;
    }

    Keyword recruit(){
        this.spellTrigger = true;
        this.active = true;
        this.temporary = true;
        this.draw = true;
        return this;
    }

    Keyword echo(){
        this.spellTrigger = true;
        this.active = true;
        this.temporary = true;
        this.repeat = true;
        return this;
    }

    Keyword rush(){
        this.enhanced = true;
        this.active = true;
        this.temporary = true;
        this.control = true;
        return this;
    }

    Keyword overkill(){
        this.spellTrigger = true;
        this.active = true;
        this.permanent = true;
        this.bonus = true;
        return this;
    }

    Keyword magnetic(){
        this.enhanced = true;
        this.active = true;
        this.permanent = true;
        this.dblEdge =true;
        return this;
    }

    Keyword lackey(){
        this.spellTrigger = true;
        this.active = true;
        this.temporary = true;
        this.draw = true;
        return this;
    }

    Keyword twinspell(){
        this.spellTrigger = true;
        this.passive = true;
        this.temporary = true;
        this.repeat = true;
        return this;
    }

    Keyword megaWindfury(){
        this.enhanced = true;
        this.active = true;
        this.permanent = true;
        return this;
    }

    Keyword reborn(){
        this.spellTrigger = true;
        this.passive = true;
        this.temporary = true;
        this.repeat = true;
        return this;
    }

    Keyword invoke(){
        this.spellTrigger = true;
        this.passive = true;
        return this;
    }

    Keyword outcast(){
        this.spellTrigger = true;
        this.active = true;
        this.temporary = true;
        this.dblEdge = true;
        this.bonus = true;
        return this;
    }

    void write() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        LinkedHashMap<String, Keyword> kwList = new LinkedHashMap<>();

        kwList.put("Taunt", new Keyword().taunt());
        kwList.put("Spell Power" , new Keyword().spellPower());
        kwList.put("Divine Shield" , new Keyword().divineShield());
        kwList.put("Charge" , new Keyword().charge());
        kwList.put("Secret" , new Keyword().secret());
        kwList.put("Stealth" , new Keyword().stealth());
        kwList.put("Battlecry" , new Keyword().battlecry());
        kwList.put("Freeze" , new Keyword().freeze());
        kwList.put("Windfury" , new Keyword().windfury());
        kwList.put("Deathrattle" , new Keyword().deathrattle());
        kwList.put("Combo" , new Keyword().combo());
        kwList.put("Overload" , new Keyword().overload());
        kwList.put("Silence" , new Keyword().silence());
        kwList.put("Counter" , new Keyword().counter());
        kwList.put("Immune" , new Keyword().immune());
        kwList.put("Inspire" , new Keyword().inspire());
        kwList.put("Discover" , new Keyword().discover());
        kwList.put("Quest" , new Keyword().quest());
        kwList.put("Poisonous" , new Keyword().poisonous());
        kwList.put("Adapt" , new Keyword().adapt());
        kwList.put("Lifesteal" , new Keyword().lifesteal());
        kwList.put("Recruit" , new Keyword().recruit());
        kwList.put("Echo" , new Keyword().echo());
        kwList.put("Rush" , new Keyword().rush());
        kwList.put("Overkill" , new Keyword().overkill());
        kwList.put("Magnetic" , new Keyword().magnetic());
        kwList.put("Lackey" , new Keyword().lackey());
        kwList.put("Twinspell" , new Keyword().twinspell());
        kwList.put("Mega-Windfury" , new Keyword().megaWindfury());
        kwList.put("Reborn" , new Keyword().reborn());
        kwList.put("Invoke" , new Keyword().invoke());
        kwList.put("Outcast" , new Keyword().outcast());


        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\Keywords.json"), kwList);
    }


    public boolean isSpellTrigger() {
        return spellTrigger;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isBonus() {
        return bonus;
    }

    public boolean isControl() {
        return control;
    }

    public boolean isDblEdge() {
        return dblEdge;
    }

    public boolean isDraw() {
        return draw;
    }

    public boolean isEnhanced() {
        return enhanced;
    }

    public boolean isPassive() {
        return passive;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public boolean isTemporary() {
        return temporary;
    }


}
