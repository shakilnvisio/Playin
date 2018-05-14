package com.nvisio.project.playin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.github.abdularis.civ.CircleImageView;
import com.nvisio.project.playin.R;
import com.nvisio.project.playin.models.GameDetailsPlayerInfo;

import java.util.List;
import java.util.PrimitiveIterator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameDetailsPlayerInfoAdapter extends RecyclerView.Adapter<GameDetailsPlayerInfoAdapter.RecyclerViewHolders> {
    private final Context context;
    private List<GameDetailsPlayerInfo> Items;
    private PlayerSelected playerSelected;

    public interface PlayerSelected {
        void PlayerSelectedInterface(int p);
    }

    public void setOnClicked(final PlayerSelected playerSelected) {
        this.playerSelected = playerSelected;

    }

    public GameDetailsPlayerInfoAdapter(Context context, List<GameDetailsPlayerInfo> items) {
        this.Items = items;
        this.context = context;
    }

    public GameDetailsPlayerInfo getItem(int position) {
        return Items.get(position);
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_details_recycler_single, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        GameDetailsPlayerInfo itemDeals = Items.get(position);
        //Name
        if (itemDeals.isOrganizer()){
            holder.playerName.setText(itemDeals.getPlayerName()+" (Organizer)");
        }
        else{
            holder.playerName.setText(itemDeals.getPlayerName());
        }

        //Image
        RequestOptions options=new RequestOptions().override(50,50).diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(itemDeals.getImageURL()).apply(options).into(holder.playerImage);

        //Level and City
        holder.playerLevelAndCity.setText(itemDeals.getPlayerLevel()+" From "+itemDeals.getPlayerCity());

    }

    @Override
    public int getItemCount() {
        return Items.size();
    }


    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.playerName)TextView playerName;
        @BindView(R.id.playerLevelAndCity)TextView playerLevelAndCity;
        @BindView(R.id.playerImage)CircleImageView playerImage;
        @BindView(R.id.playerProfile)RelativeLayout playerProfile;
        public RecyclerViewHolders(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            playerProfile.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("pos>>",""+getAdapterPosition());
            playerSelected.PlayerSelectedInterface(getAdapterPosition());
        }
    }
}
