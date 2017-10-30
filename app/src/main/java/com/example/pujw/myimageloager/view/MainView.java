package com.example.pujw.myimageloager.view;

import java.util.List;

/**
 * Created by PUJW on 2017/10/30.
 */

public interface MainView {
    public void show(List<String> list);
    public void showLoading();
    public void hideLoading();
}
