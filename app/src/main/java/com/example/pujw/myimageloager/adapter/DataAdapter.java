package com.example.pujw.myimageloager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pujw.myimageloager.R;

import java.util.List;

/**
 * Created by PUJW on 2017/10/30.
 */

public class DataAdapter extends
        RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    private List<String> mList;
    private Context context;
    public DataAdapter(Context mContext,List<String> list){
        mList=list;
        context=mContext;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.image.setImageDrawable(context.getResources()
                .getDrawable(R.mipmap.ic_launcher));
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
