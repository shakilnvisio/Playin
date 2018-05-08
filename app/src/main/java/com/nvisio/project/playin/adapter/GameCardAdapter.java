package com.nvisio.project.playin.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nvisio.project.playin.R;
import com.nvisio.project.playin.models.GameCardDataModel;
import com.nvisio.project.playin.utils.GameCardUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameCardAdapter extends RecyclerView.Adapter<GameCardAdapter.RecyclerViewHolders> {
    private final Context context;
    private List<GameCardDataModel> Items;
    private GameCardSelected gameCardSelected;
    private GameCardUtils gameCardUtils;

    public interface GameCardSelected {
        void GameCardClicked(int p);
    }

    public void setOnClicked(final GameCardSelected gameCardSelected) {
        this.gameCardSelected = gameCardSelected;

    }

    public GameCardAdapter(Context context, List<GameCardDataModel> items) {
        this.Items = items;
        this.context = context;
        gameCardUtils=new GameCardUtils();
    }

    public GameCardDataModel getItem(int position) {
        return Items.get(position);
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_card_single, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        GameCardDataModel itemDeals = Items.get(position);
        holder.managerName.setText(itemDeals.getName());
        Glide.with(context).load(itemDeals.getImageLink()).into(holder.managerImage);
        holder.playerCount.setText(gameCardUtils.playerStatusInStr(itemDeals.getTotalPlayer(),itemDeals.getPlayerIn()));
        holder.playerNeeded.setText(gameCardUtils.playerNeededInStr(itemDeals.getTotalPlayer(),itemDeals.getPlayerIn()));
        holder.gameTime.setText(itemDeals.getTime());
        holder.venue.setText(itemDeals.getVenue());

        if (itemDeals.isOrganizar()){
           
        }


    }

    @Override
    public int getItemCount() {
        return Items.size();
    }


    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.managerName)TextView managerName;
        @BindView(R.id.slot_one)TextView slotOne;
        @BindView(R.id.slot_two)TextView slotTwo;
        @BindView(R.id.slot_three)TextView slotThree;
        @BindView(R.id.playerCount)TextView playerCount;
        @BindView(R.id.playerNeeded)TextView playerNeeded;
        @BindView(R.id.GameTime)TextView gameTime;
        @BindView(R.id.venue)TextView venue;
        @BindView(R.id.managerImage)ImageView managerImage;
        @BindView(R.id.gameIcon)ImageView gameIcon;
        @BindView(R.id.leftBar)View leftBar;
        @BindView(R.id.gameCardContainer)CardView container;
        public RecyclerViewHolders(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            //itemView.setOnClickedListener(this);
            container.setOnClickListener(this);

            //
        }

        @Override
        public void onClick(View view) {
            gameCardSelected.GameCardClicked(getAdapterPosition());
        }
    }
}
