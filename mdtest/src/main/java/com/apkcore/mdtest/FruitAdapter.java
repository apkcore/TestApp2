package com.apkcore.mdtest;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private Context mContext;
    private List<Friut> mFriuts;

    public FruitAdapter(List<Friut> friuts) {
        mFriuts = friuts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext = parent.getContext();
        }

        View view = LayoutInflater .from(mContext).inflate(R.layout.fruit_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Friut friut = mFriuts.get(position);
        holder.tv.setText(friut.getName());
        Glide.with(mContext).load(friut.getImagId()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mFriuts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView img;
        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            img = (ImageView) itemView.findViewById(R.id.img);
            tv = (TextView) itemView.findViewById(R.id.tvv);
        }
    }
}
