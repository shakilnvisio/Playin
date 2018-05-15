package com.nvisio.project.playin.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.github.abdularis.civ.CircleImageView;
import com.nvisio.project.playin.R;
import com.nvisio.project.playin.models.PlayerInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChangeOwnershipAdapter extends RecyclerView.Adapter<ChangeOwnershipAdapter.RecyclerViewHolders> {
    private final Context context;
    private List<PlayerInfo> Items;
    private SetChangeOwnerSelected setChangeOwnerSelected;
    private int selected_item=-1;
    private int last_selected_item=-1;

    public interface SetChangeOwnerSelected {
        void setOwnerChangeListerner(int p,boolean show);
    }

    public void setOnClicked(final SetChangeOwnerSelected setChangeOwnerSelected) {
        this.setChangeOwnerSelected = setChangeOwnerSelected;

    }

    public ChangeOwnershipAdapter(Context context, List<PlayerInfo> items) {
        this.Items = items;
        this.context = context;
    }

    public PlayerInfo getItem(int position) {
        return Items.get(position);
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.change_ownership_single_row, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        PlayerInfo itemDeals = Items.get(position);
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
      /*  if (row==position){
            Log.d("pos>>","selected: "+row+" current: "+position);
            holder.coBackground.setBackground(context.getResources().getDrawable(R.drawable.change_owner_selected_state));
            holder.circleChecked.setBackground(context.getResources().getDrawable(R.drawable.ic_check_circle_button_color_24dp));
        }
        else{
            Log.d("pos>>","Not Selected: "+position);
        }*/



        if (last_selected_item==position){
                holder.circleChecked.setBackground(context.getResources().getDrawable(R.drawable.circle_custom_not_selected));
                holder.coBackground.setBackground(context.getResources().getDrawable(R.drawable.change_owner_selected_state));
            }
            if (selected_item==position){
            holder.circleChecked.setBackground(context.getResources().getDrawable(R.drawable.ic_check_circle_button_color_24dp));
                holder.coBackground.setBackground(context.getResources().getDrawable(R.drawable.change_owner_selected_state));
        }
        else {
            holder.circleChecked.setBackground(context.getResources().getDrawable(R.drawable.circle_custom_not_selected));
                holder.coBackground.setBackgroundColor(ContextCompat.getColor(context,R.color.colorPrimary));
        }
     }

    @Override
    public int getItemCount() {
        return Items.size();
    }


    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.coBackground)RelativeLayout coBackground;
        @BindView(R.id.coPlayerImage)CircleImageView playerImage;
        @BindView(R.id.coPlayerName)TextView playerName;
        @BindView(R.id.coPlayerLevelAndCity)TextView playerLevelAndCity;
        @BindView(R.id.coPlayerSelectionButton)RelativeLayout selectionButton;
        @BindView(R.id.coCircleChecked)ImageView circleChecked;

        RecyclerViewHolders(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            selectionButton.setOnClickListener(this);
            circleChecked.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            if (last_selected_item==-1){
                selected_item=getAdapterPosition();
                notifyItemChanged(selected_item);
                last_selected_item=selected_item;
                setChangeOwnerSelected.setOwnerChangeListerner(getAdapterPosition(),true);
            }
            else{
                if (selected_item==getAdapterPosition()){
                    setChangeOwnerSelected.setOwnerChangeListerner(getAdapterPosition(),false);
                    //un selected
                    last_selected_item=selected_item;
                    notifyItemChanged(last_selected_item);
                    last_selected_item=-1;
                    selected_item=-1;
                }
                else{
                    setChangeOwnerSelected.setOwnerChangeListerner(getAdapterPosition(),true);
                    //selected
                    selected_item=getAdapterPosition();
                    notifyItemChanged(selected_item);
                    notifyItemChanged(last_selected_item);
                    last_selected_item=selected_item;
                }

                /*selected_item=getAdapterPosition();
                    notifyItemChanged(selected_item);
                    notifyItemChanged(last_selected_item);
                    last_selected_item=selected_item;*/

            }

        }
    }

}
