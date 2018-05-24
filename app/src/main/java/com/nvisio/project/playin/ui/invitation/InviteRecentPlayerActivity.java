package com.nvisio.project.playin.ui.invitation;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nvisio.project.playin.R;
import com.nvisio.project.playin.adapter.InvitePlayerListAdapter;
import com.nvisio.project.playin.demo.PhoneNumberDemo;

import butterknife.BindView;

public class InviteRecentPlayerActivity extends AppCompatActivity implements InvitePlayerListAdapter.PhoneContactNumberListener{

    @BindView(R.id.recentSearchCon)LinearLayout searchLayout;
    @BindView(R.id.recentDefault)RelativeLayout defaultToolbarLayout;
    @BindView(R.id.recentSearchContactEdit)EditText searchPlayer;
    @BindView(R.id.recentRecycler)RecyclerView recyclerView;
    @BindView(R.id.invitePlayerRecent)TextView invitePlayerButton;

    private InvitePlayerListAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
                    Window window = this.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary) );
                }
        setContentView(R.layout.invitation_recent_player_activity);
        recyclerviewInit();
    }
    private void recyclerviewInit(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        demoData();
    }

    private void demoData() {
        PhoneNumberDemo demo=new PhoneNumberDemo();
        demo.GameCardDemoDataInsert();

        adapter=new InvitePlayerListAdapter(this,demo.getDataModels());
        adapter.setOnClicked(this);
        recyclerView.setAdapter(adapter);

    }
    public void RemoveAllString(View view) {
    }

    public void CancelSearchPanel(View view) {
    }

    public void Previous(View view) {
    }

    public void Search(View view) {
    }

    public void InvitePlayer(View view) {
    }

    @Override
    public void PhoneNumberSelected(String number) {

    }
}
