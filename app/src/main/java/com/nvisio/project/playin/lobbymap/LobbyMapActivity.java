package com.nvisio.project.playin.lobbymap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.nvisio.project.playin.R;

public class LobbyMapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
        setContentView(R.layout.lobby_map_activity);
    }

    public void MapClicked(View view) {
    }

    public void ListClicked(View view) {
    }

    public void FilterClicked(View view) {
    }

    public void NavigationClicked(View view) {
    }

    public void ArrowUpClicked(View view) {
    }
}
