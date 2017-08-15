package com.example.admin.mygreendaotest.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by admin on 2017/8/14.
 */

public class MyApplication extends Application {

    public static Context app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = getApplicationContext();
    }

}
