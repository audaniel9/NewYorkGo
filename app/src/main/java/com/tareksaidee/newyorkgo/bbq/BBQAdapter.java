package com.tareksaidee.newyorkgo.bbq;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.BBQ;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;

/**
 * Created by tarek on 4/28/2018.
 */

public class BBQAdapter extends RecyclerView.Adapter<BBQAdapter.BBQViewHolder> implements View.OnClickListener{

    ArrayList<BBQ> bbqs;
    private Context mContext;

    BBQAdapter(@NonNull Context context, ArrayList<BBQ> bbqs) {
        mContext = context;
        this.bbqs = bbqs;

    }

    @Override
    public BBQAdapter.BBQViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bbq_card, parent, false);
        view.setOnClickListener(this);
        return new BBQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BBQAdapter.BBQViewHolder holder, int position) {
        BBQ bbq = bbqs.get(position);
        holder.location.setText(bbq.getLocation());
        holder.name.setText(bbq.getName());
    }

    @Override
    public int getItemCount() {
        return bbqs.size();
    }

    void clear() {
        bbqs.clear();
    }

    class BBQViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView location;

        BBQViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, ShowAddressActivity.class);
        intent.putExtra("address", ((TextView) view.findViewById(R.id.location)).getText().toString());
        mContext.startActivity(intent);
    }


}
