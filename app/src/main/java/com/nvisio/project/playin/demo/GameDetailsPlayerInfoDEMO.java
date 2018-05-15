package com.nvisio.project.playin.demo;

import com.nvisio.project.playin.models.PlayerInfo;

import java.util.ArrayList;
import java.util.List;

public class GameDetailsPlayerInfoDEMO {
    private List<PlayerInfo> dataModels;
    public GameDetailsPlayerInfoDEMO() {
        dataModels=new ArrayList<>();
    }

    public void addData(PlayerInfo model){
        dataModels.add(model);
    }

    public List<PlayerInfo> getDataModels() {
        return dataModels;
    }
    public void GameDetailsPlayerInfoDemoINSERT(){
        for (int i = 0; i <10 ; i++) {
            if (i==5){
                PlayerInfo model=new PlayerInfo();
                model.setPlayerName("Shakil Ahmed");
                model.setImageURL("https://www.ienglishstatus.com/wp-content/uploads/2018/04/Anonymous-Whatsapp-profile-picture.jpg");
                model.setPlayerLevel("Beginner");
                model.setPlayerCity("Dhaka");
                model.setPlayerId("pla"+i);
                model.setOrganizer(true);
                dataModels.add(model);
            }
            else if(i==3){
                PlayerInfo model=new PlayerInfo();
                model.setPlayerName("Shohel Rana");
                model.setImageURL("https://www.ienglishstatus.com/wp-content/uploads/2018/04/Anonymous-Whatsapp-profile-picture.jpg");
                model.setPlayerLevel("Beginner");
                model.setPlayerCity("Dhaka");
                model.setPlayerId("pla"+i);
                model.setOrganizer(false);
                dataModels.add(model);

            }
            else{
                PlayerInfo model=new PlayerInfo();
                model.setPlayerName("Rakin Rahman");
                model.setImageURL("https://www.ienglishstatus.com/wp-content/uploads/2018/04/Anonymous-Whatsapp-profile-picture.jpg");
                model.setPlayerLevel("Beginner");
                model.setPlayerCity("Dhaka");
                model.setPlayerId("pla"+i);
                model.setOrganizer(false);
                dataModels.add(model);

            }
        }
    }
}
