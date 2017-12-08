package com.example.tal.exercise3.model;

import java.util.ArrayList;

/**
 * Created by tal on 11/15/17.
 */
public class Friend {
    private String mName, mFunFact;

    public Friend(String mName, String mFunFact) {
        this.mName = mName;
        this.mFunFact = mFunFact;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getFunFact() {
        return mFunFact;
    }

    public void setFunFact(String mFunFact) {
        this.mFunFact = mFunFact;
    }

    public static ArrayList<Friend> generateFriendList() {
        ArrayList<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Yonatan V. Levin", "Loves StarWars"));
        friends.add(new Friend("Yossi Segev", "I learned music and thought I'm going to be a DJ"));
        friends.add(new Friend("Refael Ozeri", "I love code"));
        friends.add(new Friend("Idan Felix", "I'm a salsa instructor"));
        friends.add(new Friend("Erez Hod", "sometimes I staple cardboards designed like Push Notifications to my forehead so I can feel how they feel"));
        friends.add(new Friend("Hadar Shkolnik", "I'm ambidextrous, and I write really weird - with my right hand, but with a left hand position"));
        friends.add(new Friend("Gil Goldzweig", "I never remember what side is left or right until I compare it to my hands"));
        friends.add(new Friend("Eti Negev", "I'm really bummed I cannot come to the course this year..."));
        friends.add(new Friend("Britt Barak", "I didn't comment on the post because I'm too cool for school"));
        return friends;
    }
}