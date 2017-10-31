package com.example.pujw.myimageloager;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.pujw.myimageloager.adapter.DataAdapter;
import com.example.pujw.myimageloager.presenter.MainPersenter;
import com.example.pujw.myimageloager.view.A;
import com.example.pujw.myimageloager.view.MainView;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MainView{
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private MainPersenter mPersenter;
    private DataAdapter mAdapter;
    private List<String> mlist=new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mPersenter=new MainPersenter(this);
        mPersenter.fetchData();
        A.context=this;
    }

    private void initView() {
        mProgressBar= (ProgressBar) findViewById(R.id.pb);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mAdapter=new DataAdapter(this,mlist);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void show(List<String> list) {
        mlist.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }
}
