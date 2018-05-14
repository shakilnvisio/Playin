package com.nvisio.project.playin.gamedetails;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.nvisio.project.playin.R;
import com.nvisio.project.playin.adapter.GameDetailsPlayerInfoAdapter;
import com.nvisio.project.playin.demo.GameDetailsPlayerInfoDEMO;
import com.nvisio.project.playin.models.GameDetailsPlayerInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameDetailsPlayerNumberActivity extends AppCompatActivity implements GameDetailsPlayerInfoAdapter.PlayerSelected {

    @BindView(R.id.playerInfoRecycler)RecyclerView playerInfoRecycler;
    private List<GameDetailsPlayerInfo>ListData;
    private GameDetailsPlayerInfoAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
                    Window window = this.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary) );
                }
        setContentView(R.layout.game_details_player_number);
        ButterKnife.bind(this);
        RecyclerViewInit();
    }

    private void RecyclerViewInit(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        playerInfoRecycler.setLayoutManager(linearLayoutManager);
        ListData=new ArrayList<>();
        demoData();
    }

    private void demoData(){
        GameDetailsPlayerInfoDEMO demo=new GameDetailsPlayerInfoDEMO();
        demo.GameDetailsPlayerInfoDemoINSERT();
        List<GameDetailsPlayerInfo> data=demo.getDataModels();
        for (int i = 0; i <data.size() ; i++) {
            ListData.add(data.get(i));
        }
        adapter=new GameDetailsPlayerInfoAdapter(this,ListData);
        playerInfoRecycler.setAdapter(adapter);
        adapter.setOnClicked(this::PlayerSelectedInterface);

    }

    public void BackButtonClicked(View view) {
        Intent intent =new Intent(GameDetailsPlayerNumberActivity.this,GameDetailsAcivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(R.anim.left_to_right_enter,R.anim.left_to_right_exit);
    }

    @Override
    public void PlayerSelectedInterface(int p) {
        Toast.makeText(this, ""+p, Toast.LENGTH_SHORT).show();
    }
}
