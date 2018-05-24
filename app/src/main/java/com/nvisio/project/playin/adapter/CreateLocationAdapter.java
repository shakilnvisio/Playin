package com.nvisio.project.playin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nvisio.project.playin.R;
import com.nvisio.project.playin.models.LocationModel;

import java.util.List;

import butterknife.BindView;

public class CreateLocationAdapter extends RecyclerView.Adapter<CreateLocationAdapter.RecyclerViewHolders> {
    private final Context context;
    private List<LocationModel> Items;
    private RecyclerItemClicked recyclerItemClicked;

    public interface RecyclerItemClicked {
        void LocationItemClicked(int p);
    }

    public void setOnClicked(final RecyclerItemClicked recyclerItemClicked) {
        this.recyclerItemClicked = recyclerItemClicked;

    }

    public CreateLocationAdapter(Context context, List<LocationModel> items) {
        this.Items = items;
        this.context = context;
    }

    public LocationModel getItem(int position) {
        return Items.get(position);
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_list_single_layout, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        LocationModel itemDeals = Items.get(position);
        holder.localName.setText(itemDeals.getLocalAddress());
        holder.streetName.setText(itemDeals.getStreetAddress());
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }


    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
        //get the view's references
        //private Textview textView
        @BindView(R.id.singleItemContainer)RelativeLayout mainLayout;
        @BindView(R.id.localNameRec)TextView localName;
        @BindView(R.id.streetAddressRec)TextView streetName;
        public RecyclerViewHolders(View itemView) {
            super(itemView);
            mainLayout.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            recyclerItemClicked.LocationItemClicked(getAdapterPosition());
        }
    }
}
