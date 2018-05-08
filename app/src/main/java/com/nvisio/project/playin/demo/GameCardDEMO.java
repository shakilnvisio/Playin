package com.nvisio.project.playin.demo;

import android.util.Log;

import com.nvisio.project.playin.models.GameCardDataModel;

import java.util.ArrayList;
import java.util.List;

public class GameCardDEMO {

    private List<GameCardDataModel> dataModels;
    public GameCardDEMO() {
        dataModels=new ArrayList<>();
    }

    public void addData(GameCardDataModel model){
        dataModels.add(model);
    }

    public List<GameCardDataModel> getDataModels() {
        return dataModels;
    }

    public void GameCardDemoDataInsert(){
        for (int i = 0; i <10 ; i++) {
            if (i==5){
                GameCardDataModel model=new GameCardDataModel();
                model.setName("Shakil Ahmed");
                model.setImageLink("https://www.ienglishstatus.com/wp-content/uploads/2018/04/Anonymous-Whatsapp-profile-picture.jpg");
                model.setSportType("Footbal");
                model.setTotalPlayer(10);
                model.setPlayerIn(5);
                model.setTime("17:30 pm");
                model.setVenue("1h game @ Abahani Field");
                model.setJoined(true);
                model.setOrganizar(false);
                dataModels.add(model);
            }
            else if(i==3){
                GameCardDataModel model=new GameCardDataModel();
                model.setName("Shakil Ahmed");
                model.setImageLink("https://www.ienglishstatus.com/wp-content/uploads/2018/04/Anonymous-Whatsapp-profile-picture.jpg");
                model.setSportType("Footbal");
                model.setTotalPlayer(10);
                model.setPlayerIn(5);
                model.setTime("17:30 pm");
                model.setVenue("1h game @ Abahani Field");
                model.setJoined(true);
                model.setOrganizar(true);
                dataModels.add(model);

            }
            else{
                GameCardDataModel model=new GameCardDataModel();
                model.setName("Shakil Ahmed");
                model.setImageLink("https://www.ienglishstatus.com/wp-content/uploads/2018/04/Anonymous-Whatsapp-profile-picture.jpg");
                model.setSportType("Footbal");
                model.setTotalPlayer(10);
                model.setPlayerIn(5);
                model.setTime("17:30 pm");
                model.setVenue("1h game @ Abahani Field");
                model.setJoined(false);
                model.setOrganizar(false);
                dataModels.add(model);

            }

        }
        Log.d("ss>>","insert size: "+dataModels.size());
    }
}
