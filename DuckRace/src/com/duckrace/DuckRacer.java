package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer {
    private final int id;
    private String name;
    private final List<Reward> rewards = new ArrayList<>();


    // constructors
    public DuckRacer(int id, String name) {
        this.id = id;
        setName(name);


    }

    // "action" or "business" methods
    public void win(Reward reward) {
        rewards.add(reward);
    }
//    public void addDuckRacer(){
//        if () {
//
//        }
//



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // a derived property, we can "calculate" the number of wins from the "reward" Collection.
    public int getWins(){
        return rewards.size();
    }
    // NOTE: We are returning a direct reference to our list <Reward>
    // This could have undesired effects: the client can add/remove/ clear the List
//    public List<Reward> getRewards() {
//        return rewards;
//    }


    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    @Override
    public String toString(){
        return String.format("%s: ID= %s, Name= %s, Wins= %s, Rewards= %s", getClass().getSimpleName(),
                getName(), getId(), getWins(), getRewards());
    }

}