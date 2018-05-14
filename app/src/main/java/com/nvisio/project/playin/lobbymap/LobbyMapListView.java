package com.nvisio.project.playin.lobbymap;

import android.content.Intent;
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
import com.nvisio.project.playin.adapter.GameCardAdapter;
import com.nvisio.project.playin.demo.GameCardDEMO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LobbyMapListView extends AppCompatActivity implements GameCardAdapter.GameCardSelected {

    @BindView(R.id.gameCardList)RecyclerView gameRecycler;
    private GameCardAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
        setContentView(R.layout.lobby_map_listview_activity);
        ButterKnife.bind(this);
        recyclerviewInit();

    }
    private void recyclerviewInit(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        gameRecycler.setLayoutManager(linearLayoutManager);
        demoData(true);
    }

    private void demoData(boolean insert){
        if (insert){
            GameCardDEMO demo=new GameCardDEMO();
            Log.d("ss>>","insert");
            demo.GameCardDemoDataInsert();
            Log.d("ss>>","now: "+demo.getDataModels().size());
            adapter=new GameCardAdapter(this,demo.getDataModels());
            gameRecycler.setAdapter(adapter);
            adapter.setOnClicked(this::GameCardClicked);
            //demoData(false);
        }
        else{
            GameCardDEMO demo=new GameCardDEMO();

            Log.d("ss>>",""+demo.getDataModels().size());
            adapter=new GameCardAdapter(this,demo.getDataModels());
            gameRecycler.setAdapter(adapter);
            adapter.setOnClicked(this::GameCardClicked);

        }
    }
    public void MapClicked(View view) {
        Intent intent=new Intent(LobbyMapListView.this,LobbyMapActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(R.anim.left_to_right_enter,R.anim.left_to_right_exit);
    }

    public void ListClicked(View view) {
    }

    public void FilterClicked(View view) {
    }

    public void NavigationClicked(View view) {
    }

    public void CreateGameClicked(View view) {
    }

    @Override
    public void GameCardClicked(int p) {

    }
}
