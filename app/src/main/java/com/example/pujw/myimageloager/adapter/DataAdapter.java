package com.example.pujw.myimageloager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.pujw.myimageloager.R;

import java.util.List;

import myImageloader.MyImageloader;

/**
 * Created by PUJW on 2017/10/30.
 * 不干什么就是为了刷刷git
 */

public class DataAdapter extends
        RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    private List<String> mList;
    private Context context;

    private MyImageloader imageloader;
    public DataAdapter(Context mContext,List<String> list){
        mList=list;
        context=mContext;

        imageloader=new MyImageloader();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        imageloader.displayImage(mList.get(position),holder.image);
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);



            image=itemView.findViewById(R.id.image);
        }
    }
}
