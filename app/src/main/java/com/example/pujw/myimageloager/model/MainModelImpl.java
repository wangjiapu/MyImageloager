package com.example.pujw.myimageloager.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PUJW on 2017/10/30.
 */

public class MainModelImpl implements MainModel {
    List<String> list;
    @Override
    public List<String> getData() {
        list=new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add("111111111");
        }
        return list;
    }

    @Override
    public void putData(List<String> list) {

    }
}
