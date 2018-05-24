package com.nvisio.project.playin.ui.creategame;

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
import android.widget.RelativeLayout;
import android.widget.TextView;

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
import com.nvisio.project.playin.adapter.CreateLocationAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateLocationActivity extends AppCompatActivity implements OnMapReadyCallback,CreateLocationAdapter.RecyclerItemClicked{

    @BindView(R.id.mapButton)TextView mapButton;
    @BindView(R.id.mapContainer)RelativeLayout mapLayout;

    @BindView(R.id.listButton)TextView listButton;
    @BindView(R.id.locationRecycler)RecyclerView listLayoutRecycler;

    @BindView(R.id.addressContainer)RelativeLayout addressLayout;
    @BindView(R.id.localAddress)TextView localAddress;
    @BindView(R.id.streetAddress)TextView streetAddress;

    @BindView(R.id.locationNameInputContainer)RelativeLayout customLocalAddressLayout;
    @BindView(R.id.locationName)EditText custonLocationName;
    @BindView(R.id.localAddressBelowEdittext)TextView customStreetAddress;

    @BindView(R.id.creatLocation)TextView createLocation;


    private SupportMapFragment mapFragment;
    private GoogleMap mMap;

    private CreateLocationAdapter adapter;

    private String TYPE_MAP="map";
    private String TYPE_LIST="list";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
                    Window window = this.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary) );
                }
        setContentView(R.layout.create_location_main_layout);
        ButterKnife.bind(this);
        MapInitialise();
    }


    private void MapInitialise(){
        new Thread(() -> {
            try {
                mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
                mapFragment.getMapAsync(this);
            }
            catch (Exception ignored){
            }
        }).start();
    }

    private void recyclerviewInit(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listLayoutRecycler.setLayoutManager(linearLayoutManager);
        //GetData
        DataBindToRecyclerView();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        MapStyleOptions styleOptions=MapStyleOptions.loadRawResourceStyle(CreateLocationActivity.this,R.raw.document);
        mMap.setMapStyle(styleOptions);
        MarkerOptions markerOptions=new MarkerOptions();
        markerOptions.position(new LatLng(44.968046,-94.420307));
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(44.968046  ,-94.420307)));
    }


    public void MapClicked(View view) {
        ChangeLayout(TYPE_MAP);
    }

    public void ListClicked(View view) {
        ChangeLayout(TYPE_LIST);
    }

    private void ChangeLayout(String type){
        if (type.equals(TYPE_MAP)){
            ShowMapLayout();
        }
        else{
            ShowListLayout();
        }
    }

    private void ShowMapLayout(){
        YoYo.with(Techniques.SlideOutRight).duration(500).playOn(listLayoutRecycler);
        YoYo.with(Techniques.SlideInLeft).duration(500).playOn(mapLayout);
    }
    private void ShowListLayout(){
        YoYo.with(Techniques.SlideOutLeft).duration(500).playOn(mapLayout);
        YoYo.with(Techniques.SlideInRight).duration(500).playOn(listLayoutRecycler);
        recyclerviewInit();
    }

    private void DataBindToRecyclerView(){
        /*adapter=new CreateLocationAdapter(this,demo.getDataModels());
        listLayoutRecycler.setAdapter(adapter);
        adapter.setOnClicked(this);*/
    }

    public void PreviousActivity(View view) {
    }

    public void LocationSave(View view) {
    }

    public void CreatLocation(View view) {
    }


    @Override
    public void LocationItemClicked(int p) {

    }
}
