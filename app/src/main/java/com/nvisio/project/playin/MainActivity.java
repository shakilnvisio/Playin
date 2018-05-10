package com.nvisio.project.playin;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nvisio.project.playin.lobbymap.LobbyMapActivity;
import com.sensorberg.permissionbitte.BitteBitte;
import com.sensorberg.permissionbitte.PermissionBitte;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

public class MainActivity extends AppCompatActivity{

    Button button;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.but);
        button.setVisibility(View.VISIBLE);
        cardView=findViewById(R.id.card);
        YoYo.with(Techniques.FadeIn).duration(5000).playOn(button);
        cardView.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.FadeIn).duration(15000).playOn(cardView);
    }

    public void NextActivity(View view) {
        startActivity(new Intent(MainActivity.this, LobbyMapActivity.class));
        finish();
    }
}
