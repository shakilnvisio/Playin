package com.nvisio.project.playin.utils;

public class GameCardUtils {
    public GameCardUtils() {
    }

    public String playerNeededInStr(int total,int playerIn){
        int playerNeeded=total-playerIn;
        return playerNeeded+" needed";
    }

    public String playerStatusInStr(int total,int playerIn){
        return playerIn+"/"+total;
    }
}
