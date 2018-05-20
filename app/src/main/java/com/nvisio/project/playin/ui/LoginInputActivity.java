package com.nvisio.project.playin.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nvisio.project.playin.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginInputActivity extends AppCompatActivity {

    @BindView(R.id.loginCredentialContainer)RelativeLayout inputLayout;
    @BindView(R.id.loginResetCon) RelativeLayout resetLayout;
    @BindView(R.id.loginNewPassCon) RelativeLayout newPassLayout;

    @BindView(R.id.emailInput)EditText email;
    @BindView(R.id.passwordInput)EditText password;
    @BindView(R.id.emailInputReset)EditText resetEmail;
    @BindView(R.id.newPassInput) EditText newPassword;
    @BindView(R.id.confirmPasswordInput)EditText confirmPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
                    Window window = this.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary) );
                }
        setContentView(R.layout.login_input_activity);
        ButterKnife.bind(this);
    }

    public void BackToLoginStartActivity(View view) {
        GoBackToLoginStart();
    }

    public void Login(View view) {
    }

    public void MakeResetLayoutVisible(View view) {
        resetLayout.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.SlideOutLeft).duration(500).playOn(inputLayout);
        YoYo.with(Techniques.SlideInRight).duration(500).playOn(resetLayout);
    }

    public void ResetSubmit(View view) {
    }

    public void UpdatePassword(View view) {
    }

    private void GoBackToLoginStart(){
        Intent intent =new Intent(LoginInputActivity.this,LoginStartActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(R.anim.left_to_right_enter,R.anim.left_to_right_exit);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        GoBackToLoginStart();
    }
}
