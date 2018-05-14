package com.nvisio.project.playin.lobbymap;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nvisio.project.playin.R;
import com.nvisio.project.playin.adapter.GameCardAdapter;
import com.nvisio.project.playin.demo.GameCardDEMO;

import at.favre.lib.dali.Dali;
import butterknife.BindView;
import butterknife.ButterKnife;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class LobbyMapActivity extends AppCompatActivity implements GameCardAdapter.GameCardSelected {
    private SupportMapFragment mapFragment;
    private GoogleMap mMap;
    private OnMapReadyCallback onMapReadyCallback;
    private GameCardAdapter adapter;
    private Boolean isOpened=false;
    @BindView(R.id.gameCardRecycler)RecyclerView gameCardRecycler;
    @BindView(R.id.blur)RelativeLayout blurry;
    @BindView(R.id.bluredImage)ImageView imageView;
    @BindView(R.id.cardContainer)RelativeLayout cardContainer;
    @BindView(R.id.drawer_layout)DrawerLayout drawerLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
        //setContentView(R.layout.lobby_map_activity);
        setContentView(R.layout.drawer);
        ButterKnife.bind(this);

        recyclerviewInit();
        Dali.create(this).load(R.drawable.mapblur).blurRadius(20).downScale(2).concurrent().reScale().skipCache().into(imageView);
        demoData(true);
        onMapReadyCallback=this::MapReady;
        MapInitialise();
        LobbyMapActivityPermissionsDispatcher.CallMapWithPermissionCheck(LobbyMapActivity.this);
    }

    private void recyclerviewInit(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        gameCardRecycler.setLayoutManager(linearLayoutManager);
    }


    private void demoData(boolean insert){
        if (insert){
            GameCardDEMO demo=new GameCardDEMO();
            Log.d("ss>>","insert");
            demo.GameCardDemoDataInsert();
            Log.d("ss>>","now: "+demo.getDataModels().size());
            adapter=new GameCardAdapter(this,demo.getDataModels());
            gameCardRecycler.setAdapter(adapter);
            //demoData(false);
        }
        else{
            GameCardDEMO demo=new GameCardDEMO();

            Log.d("ss>>",""+demo.getDataModels().size());
            adapter=new GameCardAdapter(this,demo.getDataModels());
            gameCardRecycler.setAdapter(adapter);
            adapter.setOnClicked(this::GameCardClicked);
        }
    }

    private void AddToRecAdapter(){

    }

    @NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION})
    void CallMap(){
      //mapFragment.getMapAsync(onMapReadyCallback);

    }
    private void MapReady(GoogleMap googleMap){
        mMap = googleMap;
        MapStyleOptions styleOptions=MapStyleOptions.loadRawResourceStyle(LobbyMapActivity.this,R.raw.document);
        mMap.setMapStyle(styleOptions);

        MarkerOptions markerOptions=new MarkerOptions();
        markerOptions.position(new LatLng(44.968046,-94.420307));
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(44.968046  ,-94.420307)));
    }
    private void MapInitialise(){
        new Thread(() -> {
            try {
                mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
                callIT();

            }
            catch (Exception ignored){
            }
        }).start();
    }

    private void callIT(){

    }

    public void MapClicked(View view) {
    }

    public void ListClicked(View view) {
        Intent intent=new Intent(LobbyMapActivity.this,LobbyMapListView.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(R.anim.right_to_left_enter,R.anim.right_to_left_exit);
    }

    public void FilterClicked(View view) {
    }

    public void NavigationClicked(View view) {
       drawerLayout.openDrawer(Gravity.LEFT);
    }

    public void ArrowUpClicked(View view) {
        //demoData(false);
        cardContainer.setVisibility(View.VISIBLE);
        //gameCardRecycler.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.SlideInUp).duration(1000).playOn(cardContainer);
        //YoYo.with(Techniques.FadeIn).duration(5000).playOn(imageView);
        //YoYo.with(Techniques.BounceIn).duration(10000).playOn(gameCardRecycler);


    }

    public void ArrowDownClicked(View view) {
        YoYo.with(Techniques.SlideOutDown).duration(1000).playOn(cardContainer);
    }

    @Override
    public void GameCardClicked(int p) {

    }
}
