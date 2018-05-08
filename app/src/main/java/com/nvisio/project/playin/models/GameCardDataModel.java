package com.nvisio.project.playin.models;

public class GameCardDataModel {

    private int id;
    private String name, imageLink,sportType,time,venue;
    private boolean isOrganizar, isJoined;
    private int totalPlayer, playerIn;

    public GameCardDataModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public boolean isOrganizar() {
        return isOrganizar;
    }

    public void setOrganizar(boolean organizar) {
        isOrganizar = organizar;
    }

    public boolean isJoined() {
        return isJoined;
    }

    public void setJoined(boolean joined) {
        isJoined = joined;
    }

    public int getTotalPlayer() {
        return totalPlayer;
    }

    public void setTotalPlayer(int totalPlayer) {
        this.totalPlayer = totalPlayer;
    }

    public int getPlayerIn() {
        return playerIn;
    }

    public void setPlayerIn(int playerIn) {
        this.playerIn = playerIn;
    }
}
