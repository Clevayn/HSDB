package com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Text {
    List<String> condition = Arrays.asList( "have no", "after", "if", "else", "until", "whenever", "whomever", "while", "can't", "may");
    List<String> states = Arrays.asList("in", "holding", "damaged", "dead", "attacked", "undamaged", "targeted",
             "control", "equal", "summoned", "destroyed", "equipped", "isn't", "drawn", "empty");
    List<String> attribute = Arrays.asList("cost","Health", "Attack", "Armor", "mana", "Mana Crystal");
    List<String> effects = Arrays.asList("resummon", "becomes", "dies", "draws", "damages", "damage", "kills", "casts",
            "casts", "equips", "attacks", "loses");
    List<String> specifier = Arrays.asList("other", "to", "from", "for", "you've", "your", "you're", "you", "random", "randomly", "all", "this", "each",
            "adjacent", "friendly", "enemy", "enemies", "enemy", "characters", "character", "an", "a", "they", "left",
            "right", "opponent", "opponents", "another", "it", "and", "any", "top", "lowest", "highest", "they", "them",
            "those", "these");
    List<String> target = Arrays.asList("deck","minion", "minions", "card", "cards", "hand", "weapon", "hero", "heroes",
            "battlefield");
    List<String> action = Arrays.asList("add", "replace", "draw", "equip", "deal", "cast", "summon", "give", "attack", "destroy", "copy",
            "change", "trigger", "shuffle", "transform", "return", "choose", "put", "create", "gain", "remove", "set");

    List<String> specialPhrase = Arrays.asList("at the end of your", "can't be targeted by spells of hero powers",
            "after this attacks and kills a minion", "deal x damage", "that died this game", "of the same cost",
            "split among all enemies", "has no duplicates");

    List<String> gameTerm = Arrays.asList("[Mm]ana [Cc]rystal", "mana", "turn", "turns", "armor", "health", "Attack",
            "cost", "spell", "weapon", "durability", "costs");



    public String sentenceStructure(String s){
        AtomicReference<String> out = new AtomicReference<>(s.toLowerCase());
        //System.out.println(s);

        out.set(out.get().replaceAll("[\\d|\\d\\d]`", "x"));
        /*specialPhrase.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "phrase")));
        gameTerm.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "gameTerm")));
        condition.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "condition")));
        states.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "state")));
        attribute.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "attribute")));
        effects.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "effect")));
        specifier.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "specifier")));
        target.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "target")));
        action.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "action")));*/

        specialPhrase.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "")));
        gameTerm.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "")));
        condition.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "")));
        states.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "")));
        attribute.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "")));
        effects.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "")));
        specifier.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "")));
        target.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "")));
        action.forEach(s1 -> out.set(out.get().replaceAll("\\b"+ s1 + "\\b", "")));




        return String.valueOf(out.get());
    }


    public List<String> compoundSpecifier(){
        List<String> list = new LinkedList<>();


        return list;

    }







}
