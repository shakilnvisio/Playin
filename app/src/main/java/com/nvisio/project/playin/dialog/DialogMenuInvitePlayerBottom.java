package com.nvisio.project.playin.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.nvisio.project.playin.R;

public class DialogMenuInvitePlayerBottom implements View.OnClickListener{

    private Dialog dialog;
    private setCustomInviteDialogListener listener;
    public DialogMenuInvitePlayerBottom(Context context,String nameofPlayer) {
        dialog=new Dialog(context, R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_pop_up_invite_player);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();

        TextView playerName=dialog.findViewById(R.id.invitePlayerName);
        playerName.setText(nameofPlayer);

        TextView viewProfile=dialog.findViewById(R.id.dialogViewProfile);
        TextView resend=dialog.findViewById(R.id.dialog_resend);
        TextView cancelInvitation=dialog.findViewById(R.id.dialogCancel);
        TextView cancel=dialog.findViewById(R.id.cancelInvitePopUp);

        viewProfile.setOnClickListener(this);
        resend.setOnClickListener(this);
        cancelInvitation.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    public void setInvitePopUpListener(setCustomInviteDialogListener listener){
        this.listener=listener;
    }

    public interface setCustomInviteDialogListener{
        void onViewProfilePressed();
        void onResendPressed();
        void onCancelInvitationPressed();
        void onCancelPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dialogViewProfile:
                listener.onViewProfilePressed();
                dialog.dismiss();
                break;
            case R.id.dialog_resend:
                listener.onResendPressed();
                dialog.dismiss();
                break;
            case R.id.dialogCancel:
                listener.onCancelInvitationPressed();
                dialog.dismiss();
                break;
                default:
                    listener.onCancelPressed();
                    dialog.dismiss();
                    break;
        }
    }
}
