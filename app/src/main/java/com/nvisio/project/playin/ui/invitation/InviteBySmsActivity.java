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
import android.widget.Toast;

import com.nvisio.project.playin.R;
import com.nvisio.project.playin.adapter.PhoneContactAdapter;
import com.nvisio.project.playin.demo.PhoneNumberDemo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InviteBySmsActivity extends AppCompatActivity implements PhoneContactAdapter.PhoneContactNumberListener {

    @BindView(R.id.smsRecyclerview)RecyclerView recyclerView;

    private PhoneContactAdapter adapter;
    private List<String>selectedPhoneNumber;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
                    Window window = this.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary) );
                }
        setContentView(R.layout.contact_list_sms_layout);
        ButterKnife.bind(this);
        selectedPhoneNumber=new ArrayList<>();
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

        adapter=new PhoneContactAdapter(this,demo.getDataModels());
        adapter.setOnClicked(this);
        recyclerView.setAdapter(adapter);

    }


    public void InvitePlayer(View view) {
    }

    public void Previous(View view) {
    }

    public void Search(View view) {
    }

    @Override
    public void PhoneNumberSelected(String number) {
        Toast.makeText(this, ""+number, Toast.LENGTH_SHORT).show();
        if (selectedPhoneNumber.size()>0){
            for (int i = 0; i <selectedPhoneNumber.size() ; i++) {
                if (selectedPhoneNumber.get(i).equals(number)){

                }
                else{

                }
            }
        }

    }
}
