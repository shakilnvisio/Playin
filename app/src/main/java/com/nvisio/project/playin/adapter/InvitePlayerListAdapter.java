package com.nvisio.project.playin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.ivbaranov.mli.MaterialLetterIcon;
import com.nvisio.project.playin.R;
import com.nvisio.project.playin.models.PhoneContactModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InvitePlayerListAdapter extends RecyclerView.Adapter<InvitePlayerListAdapter.RecyclerViewHolders> {
    private final Context context;
    private List<PhoneContactModel> Items;
    private PhoneContactNumberListener phoneContactNumberListener;

    public interface PhoneContactNumberListener {
        void PhoneNumberSelected(String number);
    }

    public void setOnClicked(final PhoneContactNumberListener phoneContactNumberListener) {
        this.phoneContactNumberListener = phoneContactNumberListener;

    }

    public InvitePlayerListAdapter(Context context, List<PhoneContactModel> items) {
        this.Items = items;
        this.context = context;
    }

    public PhoneContactModel getItem(int position) {
        return Items.get(position);
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.invitation_list_single_layout, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        PhoneContactModel itemDeals = Items.get(position);
        String player=itemDeals.getName();
        //image
        player=player.trim();
        String[] playerSeparate=player.split(" ");
        String imageLetter=playerSeparate[0].substring(0,1)+playerSeparate[1].substring(0,1);
        holder.playerImage.setLetter(imageLetter);
        //name
        holder.name.setText(player);
        //number
        holder.phoneNumber.setText(itemDeals.getNumber());

    }

    @Override
    public int getItemCount() {
        return Items.size();
    }


    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
        //get the view's references
        //private Textview textView
        @BindView(R.id.smsPlayerImage)MaterialLetterIcon playerImage;
        @BindView(R.id.smsPlayerName)TextView name;
        @BindView(R.id.smsPlayerPhoneNumber)TextView phoneNumber;
        @BindView(R.id.smsAdd)ImageView add;
        @BindView(R.id.smsPlayerSelectionButton)RelativeLayout selectionLayout;
        @BindView(R.id.smsBackground)RelativeLayout background;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            selectionLayout.setOnClickListener(this);
            add.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos=getAdapterPosition();
            String number=Items.get(pos).getNumber();
            phoneContactNumberListener.PhoneNumberSelected(number);
        }
    }
}
