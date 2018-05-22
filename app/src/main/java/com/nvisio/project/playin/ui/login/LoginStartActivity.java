package com.nvisio.project.playin.ui.login;

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

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.nvisio.project.playin.R;
import com.nvisio.project.playin.ui.signup.CreateAccountMainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginStartActivity extends AppCompatActivity {

    CallbackManager callbackmanager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
                    Window window = this.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary) );
                }
        setContentView(R.layout.login_main_activity);
    }

    public void FacebookLogin(View view) {
        Fblogin();
    }

    private void Fblogin()
    {
        callbackmanager = CallbackManager.Factory.create();

        // Set permissions
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email","user_photos","public_profile"));

        LoginManager.getInstance().registerCallback(callbackmanager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        System.out.println("Success");
                        GraphRequest.newMeRequest(
                                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject json, GraphResponse response) {
                                        if (response.getError() != null) {
                                            // handle error
                                            Log.d("result>>","Error");
                                        } else {
                                            Log.d("result>>",""+loginResult.getAccessToken().getUserId());
                                            AccessToken token=loginResult.getAccessToken();
                                            String id=token.getUserId();
                                            GraphRequest request = GraphRequest.newGraphPathRequest(
                                                    token,
                                                    "/1826417590755572/friends",
                                                    new GraphRequest.Callback() {
                                                        @Override
                                                        public void onCompleted(GraphResponse response) {
                                                            // Insert your code here
                                                            Log.d("result>>",""+response);
                                                        }
                                                    });

                                            request.executeAsync();
                                            try {

                                                String jsonresult = String.valueOf(json);
                                                Log.d("result>>","JSON Result"+jsonresult);
                                                String str_email = json.getString("email");
                                                String str_id = json.getString("id");
                                                String str_firstname = json.getString("first_name");
                                                String str_lastname = json.getString("last_name");

                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }

                                }).executeAsync();

                    }

                    @Override
                    public void onCancel() {
                        Log.d("cancel>>","On cancel");
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Log.d("onError>>",error.toString());
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackmanager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void LoginWithEmail(View view) {
        Intent intent=new Intent(LoginStartActivity.this, LoginInputActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(R.anim.right_to_left_enter,R.anim.right_to_left_exit);
    }

    public void GoToCreateAccount(View view) {
        Intent intent=new Intent(LoginStartActivity.this, CreateAccountMainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(R.anim.right_to_left_enter,R.anim.right_to_left_exit);
    }
}
