package com.nvisio.project.playin.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.nvisio.project.playin.R;
import com.nvisio.project.playin.models.PersonalDetailsModels;

public class SharedPrefsHelperClass {
    private Context context;
    private SharedPreferences sharedPreferences;

    public SharedPrefsHelperClass(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(context.getString(R.string.sharedPreferenceName),Context.MODE_PRIVATE);
    }

    //Create Account Personal Details
    public void savePersonalDetails(PersonalDetailsModels data){
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(data);
        prefsEditor.putString(context.getString(R.string.sp_personal_details), json);
        prefsEditor.apply();
    }

    public PersonalDetailsModels getPersonalDetails(String key){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(context.getString(R.string.sp_personal_details), "");
        return gson.fromJson(json, PersonalDetailsModels.class);
    }

}
