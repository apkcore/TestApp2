package com.apkcore.testapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_TEXT = 1;
    public static final int TYPE_IMAGE = 2;

    private Context mContext;
    private List<String> datas;

    public RvAdapter(Context mcontext, List<String> datas) {
        this.mContext = mcontext;
        this.datas = datas;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 != 0) {
            return 1;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0) {
            return new MyViewHolder(parent);
        }
        return new ImgViewHolder(parent);
//        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        holder.itemView.setLayoutParams(layoutParams);
        switch (getItemViewType(position)) {
            case 0:
                ((MyViewHolder) holder).bind(datas.get(position));
                break;
            case 1:

                break;
            default:
                break;
        }
//        holder.bind(datas.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClickListener(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
            tv = (TextView) itemView.findViewById(R.id.tv);
        }

        public void bind(String s) {
            tv.setText(s);
        }
    }

    class ImgViewHolder extends RecyclerView.ViewHolder {

//        ImageView img;

        public ImgViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false));
//            img = (ImageView) itemView.findViewById(R.id.img);
        }

//        public void bind(int rId) {
//            img.setImageResource(rId);
//        }
    }

    /**
     * item的点击事件的长按事件接口
     */
    private OnItemClickListener onItemClickListener;

    /**
     * 设置点击事件
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 设置item监听的接口
     */
    public interface OnItemClickListener {
        void onItemClickListener(int position);
    }
}
