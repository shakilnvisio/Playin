package com.nvisio.project.playin.lobbymap;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nvisio.project.playin.R;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class LobbyMapActivity extends AppCompatActivity {
    private SupportMapFragment mapFragment;
    private GoogleMap mMap;
    private OnMapReadyCallback onMapReadyCallback;
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

        onMapReadyCallback=this::MapReady;
        MapInitialise();
        LobbyMapActivityPermissionsDispatcher.CallMapWithPermissionCheck(LobbyMapActivity.this);
        Log.d("log>>","start");



    }

    @NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION})
    void CallMap(){
      mapFragment.getMapAsync(onMapReadyCallback);
        Log.d("log>>","callmap");

    }
    private void MapReady(GoogleMap googleMap){
        Log.d("log>>","map ready");
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
    }

    public void FilterClicked(View view) {
    }

    public void NavigationClicked(View view) {
    }

    public void ArrowUpClicked(View view) {
    }
}
