package com.nvisio.project.playin.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.nvisio.project.playin.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    CallbackManager callbackmanager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
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
    }
}
