package com.nvisio.project.playin.demo;

import com.nvisio.project.playin.models.GameDetailsPlayerInfo;

import java.util.ArrayList;
import java.util.List;

public class GameDetailsPlayerInfoDEMO {
    private List<GameDetailsPlayerInfo> dataModels;
    public GameDetailsPlayerInfoDEMO() {
        dataModels=new ArrayList<>();
    }

    public void addData(GameDetailsPlayerInfo model){
        dataModels.add(model);
    }

    public List<GameDetailsPlayerInfo> getDataModels() {
        return dataModels;
    }
    public void GameDetailsPlayerInfoDemoINSERT(){
        for (int i = 0; i <10 ; i++) {
            if (i==5){
                GameDetailsPlayerInfo model=new GameDetailsPlayerInfo();
                model.setPlayerName("Shakil Ahmed");
                model.setImageURL("https://www.ienglishstatus.com/wp-content/uploads/2018/04/Anonymous-Whatsapp-profile-picture.jpg");
                model.setPlayerLevel("Beginner");
                model.setPlayerCity("Dhaka");
                model.setPlayerId("pla01");
                model.setOrganizer(true);
                dataModels.add(model);
            }
            else if(i==3){
                GameDetailsPlayerInfo model=new GameDetailsPlayerInfo();
                model.setPlayerName("Shohel Rana");
                model.setImageURL("https://www.ienglishstatus.com/wp-content/uploads/2018/04/Anonymous-Whatsapp-profile-picture.jpg");
                model.setPlayerLevel("Beginner");
                model.setPlayerCity("Dhaka");
                model.setPlayerId("pla01");
                model.setOrganizer(false);
                dataModels.add(model);

            }
            else{
                GameDetailsPlayerInfo model=new GameDetailsPlayerInfo();
                model.setPlayerName("Rakin Rahman");
                model.setImageURL("https://www.ienglishstatus.com/wp-content/uploads/2018/04/Anonymous-Whatsapp-profile-picture.jpg");
                model.setPlayerLevel("Beginner");
                model.setPlayerCity("Dhaka");
                model.setPlayerId("pla01");
                model.setOrganizer(false);
                dataModels.add(model);

            }
        }
    }
}
