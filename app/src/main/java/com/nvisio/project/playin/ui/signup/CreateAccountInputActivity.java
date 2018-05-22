package com.nvisio.project.playin.ui.signup;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nvisio.project.playin.R;
import com.nvisio.project.playin.utils.SharedPrefsHelperClass;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccountInputActivity extends AppCompatActivity {

    //personal details
    @BindView(R.id.personalDetailsCon)RelativeLayout personalLayout;
    @BindView(R.id.nameInput)EditText name;
    @BindView(R.id.emailSignup)EditText email;
    @BindView(R.id.passSignup)EditText password;
    //player details
    @BindView(R.id.playerDetailsCon)RelativeLayout playerLayout;
    @BindView(R.id.basketball)RelativeLayout basketballView;
    @BindView(R.id.football)RelativeLayout footballView;
    @BindView(R.id.soccer)RelativeLayout soccerView;
    @BindView(R.id.beginnerLevel)TextView beginnerView;
    @BindView(R.id.intermediateLevel)TextView intermediateView;
    @BindView(R.id.goodLevel)TextView goodView;
    @BindView(R.id.competitiveLevel)TextView competitiveView;
    @BindView(R.id.maleGender)TextView maleView;
    @BindView(R.id.femaleGender)TextView femaleView;


    //Flags
    private String previousSelectedSport ="none";
    private String currentSelectedSport;
    private String previousSelectedLevel ="none";
    private String currentSelectedLevel;
    private String previousSelectedGender ="none";
    private String currentSelectedGender;
    private String currentLayout="personal";
    //SharedPreference Helper
    private SharedPrefsHelperClass sharedPrefsHelperClass;

    //some constant values;
    private String PERSONAL="personal";
    private String PLAYER="player";
    private String BUTTON_LEFT="left";
    private String BUTTON_RIGHT="right";
    private String BUTTON_MIDDLE="middle";
    private String NONE="none";

    private String BASKETBALL="basketball";
    private String FOOTBALL="football";
    private String SOCCER="soccer";

    private String BEGINNER="beginner";
    private String INTERMEDIATE="intermediate";
    private String GOOD="good";
    private String COMPETITIVE="competitive";

    private String MALE="male";
    private String FEMALE="female";

    private String SPORT="sport";
    private String LEVEL="level";
    private String GENDER="gender";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
                    Window window = this.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary) );
                }
        setContentView(R.layout.create_account_input_activity);
        ButterKnife.bind(this);
        activityInit();
    }

    private void activityInit(){
        sharedPrefsHelperClass=new SharedPrefsHelperClass(this);
    }

    //main
    public void BackToCreateAccountStartActivity(View view) {
        onBackPressed();
    }

    //personal details
    public void Continue(View view) {
        ChangeLayout();
    }

    //Player Details
    //previousSelectedSport
    public void BasketBallPressed(View view) {
        if (previousSelectedSport.equals(NONE)){
            SelectedBackground(basketballView,BUTTON_LEFT);
            currentSelectedSport=BASKETBALL;
            previousSelectedSport=currentSelectedSport;
        }
        else{
            SelectedBackground(basketballView,BUTTON_LEFT);
            currentSelectedSport=BASKETBALL;
            FindButtonToUnSelect(SPORT);

        }
    }

    public void FootballPressed(View view) {
        if (previousSelectedSport.equals(NONE)){
            SelectedBackground(footballView,BUTTON_MIDDLE);
            currentSelectedSport=FOOTBALL;
            previousSelectedSport=currentSelectedSport;
        }
        else{
            SelectedBackground(footballView,BUTTON_MIDDLE);
            currentSelectedSport=FOOTBALL;
            FindButtonToUnSelect(SPORT);

        }
    }

    public void SoccerPressed(View view) {
        if (previousSelectedSport.equals(NONE)){
            SelectedBackground(soccerView,BUTTON_RIGHT);
            currentSelectedSport=SOCCER;
            previousSelectedSport=currentSelectedSport;
        }
        else{
            SelectedBackground(soccerView,BUTTON_RIGHT);
            currentSelectedSport=SOCCER;
            FindButtonToUnSelect(SPORT);

        }
    }

    //previousSelectedLevel
    public void BeginnerPressed(View view) {
        if (previousSelectedLevel.equals(NONE)){
            SelectedBackground(beginnerView,BUTTON_LEFT);
            currentSelectedLevel=BEGINNER;
            previousSelectedLevel=currentSelectedLevel;
        }
        else{
            SelectedBackground(beginnerView,BUTTON_LEFT);
            currentSelectedLevel=BEGINNER;
            FindButtonToUnSelect(LEVEL);
        }
    }

    public void IntermediatePressed(View view) {
        if (previousSelectedLevel.equals(NONE)){
            SelectedBackground(intermediateView,BUTTON_RIGHT);
            currentSelectedLevel=INTERMEDIATE;
            previousSelectedLevel=currentSelectedLevel;
        }
        else{
            SelectedBackground(intermediateView,BUTTON_RIGHT);
            currentSelectedLevel=INTERMEDIATE;
            FindButtonToUnSelect(LEVEL);
        }
    }

    public void GoodPressed(View view) {
        if (previousSelectedLevel.equals(NONE)){
            SelectedBackground(goodView,BUTTON_LEFT);
            currentSelectedLevel=GOOD;
            previousSelectedLevel=currentSelectedLevel;
        }
        else{
            SelectedBackground(goodView,BUTTON_LEFT);
            currentSelectedLevel=GOOD;
            FindButtonToUnSelect(LEVEL);
        }
    }

    public void CompetitivePressed(View view) {
        if (previousSelectedLevel.equals(NONE)){
            SelectedBackground(competitiveView,BUTTON_RIGHT);
            currentSelectedLevel=COMPETITIVE;
            previousSelectedLevel=currentSelectedLevel;
        }
        else{
            SelectedBackground(competitiveView,BUTTON_RIGHT);
            currentSelectedLevel=COMPETITIVE;
            FindButtonToUnSelect(LEVEL);
        }
    }

    //previousSelectedGender
    public void MalePressed(View view) {
        if (previousSelectedGender.equals(NONE)){
            SelectedBackground(maleView,BUTTON_LEFT);
            currentSelectedGender=MALE;
            previousSelectedGender=currentSelectedGender;
        }
        else{
            SelectedBackground(maleView,BUTTON_LEFT);
            currentSelectedGender=MALE;
            FindButtonToUnSelect(GENDER);
        }
    }

    public void FemalePressed(View view) {
        if (previousSelectedGender.equals(NONE)){
            SelectedBackground(femaleView,BUTTON_RIGHT);
            currentSelectedGender=FEMALE;
            previousSelectedGender=currentSelectedGender;
        }
        else{
            SelectedBackground(femaleView,BUTTON_RIGHT);
            currentSelectedGender=FEMALE;
            FindButtonToUnSelect(GENDER);
        }
    }

    public void CreateAccount(View view) {
        Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
    }

    private void FindButtonToUnSelect(String sectionName){
        switch (sectionName){
            case "sport":
                Log.d("sch>>","current: "+currentSelectedSport+" pre: "+previousSelectedSport);
               if (previousSelectedSport.equals(BASKETBALL)){
                   UnSelectBackground(basketballView,BUTTON_LEFT);
                   previousSelectedSport=currentSelectedSport;
               }
               else if (previousSelectedSport.equals(FOOTBALL)){
                   UnSelectBackground(footballView,BUTTON_MIDDLE);
                   previousSelectedSport=currentSelectedSport;
               }
               else{
                   UnSelectBackground(soccerView,BUTTON_RIGHT);
                   previousSelectedSport=currentSelectedSport;
               }
                break;
            case "level":
                if (previousSelectedLevel.equals(BEGINNER)){
                    UnSelectBackground(beginnerView,BUTTON_LEFT);
                    previousSelectedLevel=currentSelectedLevel;
                }
                else if(previousSelectedLevel.equals(INTERMEDIATE)){
                    UnSelectBackground(intermediateView,BUTTON_RIGHT);
                    previousSelectedLevel=currentSelectedLevel;
                }

                else if (previousSelectedLevel.equals(GOOD)){
                    UnSelectBackground(goodView,BUTTON_LEFT);
                    previousSelectedLevel=currentSelectedLevel;
                }
                else{
                    UnSelectBackground(competitiveView,BUTTON_RIGHT);
                    previousSelectedLevel=currentSelectedLevel;
                }
                break;
                default:
                    if (previousSelectedGender.equals(MALE)){
                        UnSelectBackground(maleView,BUTTON_LEFT);
                        previousSelectedGender=currentSelectedGender;
                    }
                    else{
                        UnSelectBackground(femaleView,BUTTON_RIGHT);
                        previousSelectedGender=currentSelectedGender;
                    }
                    break;
        }
    }

    private void SelectedBackground(View view,String buttonPosition){
        switch (buttonPosition){
            case "left":
                view.setBackground(getResources().getDrawable(R.drawable.selected_button_right_have_straight_line));
                break;
            case "right":
                view.setBackground(getResources().getDrawable(R.drawable.selected_button_left_have_straight_line));
                break;

                default:
                    view.setBackground(getResources().getDrawable(R.drawable.selected_middle_button_with_no_radius));
                    break;
        }

    }

    private void UnSelectBackground(View view, String buttonPosition){
        switch (buttonPosition){
            case "left":
                view.setBackground(getResources().getDrawable(R.drawable.unselected_button_right_have_straight_line));
                break;
            case "right":
                view.setBackground(getResources().getDrawable(R.drawable.unselected_button_left_have_straight_line));
                break;

            default:
                view.setBackground(getResources().getDrawable(R.drawable.unselected_middle_button_with_no_radius));
                break;
        }
    }

    private void ChangeLayout(){
        if (currentLayout.equals(PERSONAL)){
            currentLayout=PLAYER;
            playerLayout.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.SlideOutLeft).duration(500).playOn(personalLayout);
            YoYo.with(Techniques.SlideInRight).duration(500).playOn(playerLayout);
        }
        else{
            currentLayout=PERSONAL;
            personalLayout.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.SlideOutLeft).duration(500).playOn(playerLayout);
            YoYo.with(Techniques.SlideInRight).duration(500).playOn(personalLayout);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent =new Intent(CreateAccountInputActivity.this,CreateAccountMainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(R.anim.left_to_right_enter,R.anim.left_to_right_exit);
    }
}
