package com.nvisio.project.playin.gamedetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.nvisio.project.playin.R;
import com.nvisio.project.playin.dialog.DialogMenuEditGameBottom;
import com.nvisio.project.playin.dialog.DialogMenuInvitePlayerBottom;

public class GameDetailsAcivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_details_activity);
    }

    public void ViewClicked(View view) {
        Intent intent=new Intent(GameDetailsAcivity.this, GameDetailsPlayerNumberActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(R.anim.right_to_left_enter,R.anim.right_to_left_exit);
    }

    public void CloseClicked(View view) {
    }

    public void Edit(View view) {
        DialogMenuEditGameBottom dialogMenuEditGameBottom =new DialogMenuEditGameBottom(GameDetailsAcivity.this);
        dialogMenuEditGameBottom.setCustomDialogListener(new DialogMenuEditGameBottom.OnCustomDialogMenuListener() {
            @Override
            public void onEditGamePressed() {
                Toast.makeText(GameDetailsAcivity.this, "Edit", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChangeOwnershipPressed() {
                Toast.makeText(GameDetailsAcivity.this, "Change", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelPressed() {
                Toast.makeText(GameDetailsAcivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }
}
