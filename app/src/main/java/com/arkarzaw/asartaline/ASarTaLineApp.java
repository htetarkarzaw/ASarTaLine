package com.arkarzaw.asartaline;

import android.app.Application;

import com.arkarzaw.asartaline.datas.models.WarDeeModel;

public class ASarTaLineApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        WarDeeModel.initAppModel(getApplicationContext());
    }
}
