package com.example.pujw.myimageloager.presenter;

import com.example.pujw.myimageloager.model.MainModel;
import com.example.pujw.myimageloager.model.MainModelImpl;
import com.example.pujw.myimageloager.view.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by PUJW on 2017/10/30.
 */

public class MainPersenter {
    private MainModel model=new MainModelImpl();
    private MainView view;
    private List<String> list;
    public MainPersenter(MainView mainView){
        view=mainView;
    }

    public void fetchData(){
        view.showLoading();
        view.show(model.getData());
        Timer timer=new Timer();

        view.hideLoading();
    }
}
