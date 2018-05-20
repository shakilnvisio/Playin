package com.nvisio.project.playin.editGame;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.nvisio.project.playin.R;
import com.nvisio.project.playin.adapter.ChangeOwnershipAdapter;
import com.nvisio.project.playin.demo.GameDetailsPlayerInfoDEMO;
import com.nvisio.project.playin.models.PlayerInfo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChangeOwnershipActivity extends AppCompatActivity implements ChangeOwnershipAdapter.SetChangeOwnerSelected {

    @BindView(R.id.coRecyclerview)RecyclerView changeOwnerRecycler;
    @BindView(R.id.changeOwnershipButton)TextView ownershipButton;
    private ChangeOwnershipAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
                    Window window = this.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary) );
                }
        setContentView(R.layout.change_ownership_layout);
        ButterKnife.bind(this);
        RecyclerViewInit();
        keyHashes();
    }

    private void keyHashes(){
        Log.d("KeyHash>>","start");
        try {
            Log.d("KeyHash>>","inside try");
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.nvisio.project.playin",
                    PackageManager.GET_SIGNATURES);
            Log.d("KeyHash>>","before for");
            for (Signature signature : info.signatures) {
                Log.d("KeyHash>>","inside for");
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash>>", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("KeyHash>>","error first: "+e);

        } catch (NoSuchAlgorithmException e) {
            Log.d("KeyHash>>","error 2nd: "+e);
        }
    }
    private void RecyclerViewInit(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        changeOwnerRecycler.setLayoutManager(linearLayoutManager);
        demoData();
    }
    private void demoData(){
        GameDetailsPlayerInfoDEMO demo=new GameDetailsPlayerInfoDEMO();
        demo.GameDetailsPlayerInfoDemoINSERT();
        adapter=new ChangeOwnershipAdapter(this,demo.getDataModels());
        changeOwnerRecycler.setAdapter(adapter);
        adapter.setOnClicked(this);

    }
    public void CloseClicked(View view) {
    }

    public void ChangeOwnership(View view) {
    }

    @Override
    public void setOwnerChangeListerner(int p,boolean show) {
      if (show){
          ownershipButton.setVisibility(View.VISIBLE);
      }
      else{
          ownershipButton.setVisibility(View.INVISIBLE);
      }
    }
}
