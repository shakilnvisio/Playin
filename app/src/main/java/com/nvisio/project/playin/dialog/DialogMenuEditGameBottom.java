package com.nvisio.project.playin.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.nvisio.project.playin.R;

public class DialogMenuEditGameBottom implements View.OnClickListener {
    private Dialog dialog;
    private OnCustomDialogMenuListener listener;
    public DialogMenuEditGameBottom(Context context) {
        dialog=new Dialog(context, R.style.Theme_Dialog);
        //remove title
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //layout
        dialog.setContentView(R.layout.bottom_pop_up_edit_game_details_layout);
        //removing padding of the window
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //pop up from the bottom
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        //setting width and height
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();

        TextView editGame=dialog.findViewById(R.id.EditGameDetails);
        TextView change=dialog.findViewById(R.id.ChangeOwnerShip);
        TextView cancel=dialog.findViewById(R.id.cancelEditBottomPopUp);

        editGame.setOnClickListener(this);
        change.setOnClickListener(this);
        cancel.setOnClickListener(this);

    }

    public void setCustomDialogListener(OnCustomDialogMenuListener listener){
        this.listener=listener;
    }
    public interface  OnCustomDialogMenuListener{
        void onEditGamePressed();
        void onChangeOwnershipPressed();
        void onCancelPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.EditGameDetails:
                listener.onEditGamePressed();
                dialog.dismiss();
                break;
            case R.id.ChangeOwnerShip:
                listener.onChangeOwnershipPressed();
                dialog.dismiss();
                break;
                default:
                    listener.onCancelPressed();
                    dialog.dismiss();
                    break;
        }
    }
}
