package com.nvisio.project.playin.demo;

import android.util.Log;

import com.nvisio.project.playin.models.PhoneContactModel;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberDemo {
    private List<PhoneContactModel> dataModels;
    public PhoneNumberDemo() {
        dataModels=new ArrayList<>();
    }

    public void addData(PhoneContactModel model){
        dataModels.add(model);
    }

    public List<PhoneContactModel> getDataModels() {
        return dataModels;
    }

    public void GameCardDemoDataInsert(){
        for (int i = 0; i <10 ; i++) {
            if (i==5){
                PhoneContactModel model=new PhoneContactModel();
                model.setName("Shakil Ahmed");
                model.setNumber("016745253698");
                dataModels.add(model);
            }
            else if(i==3){
                PhoneContactModel model=new PhoneContactModel();
                model.setName("Rakin Ahmed");
                model.setNumber("016745253698");
                dataModels.add(model);

            }
            else{
                PhoneContactModel model=new PhoneContactModel();
                model.setName("Shohel Rana");
                model.setNumber("016745253698");
                dataModels.add(model);

            }

        }
        Log.d("ss>>","insert size: "+dataModels.size());
    }
}
