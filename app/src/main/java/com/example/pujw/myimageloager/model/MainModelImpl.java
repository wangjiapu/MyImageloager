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
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509461091078&di=e2646cce1b097a495c49ff6b1930d51d&imgtype=0&src=http%3A%2F%2Fwww.pp3.cn%2Fuploads%2F201510%2F2015100507.jpg");
        }
        return list;
    }

    @Override
    public void putData(List<String> list) {

    }
}
