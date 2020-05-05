package com.bw.domeweidudianying416.app;

import android.app.Application;
import android.content.Context;

/**
 * 时间：2020/4/16
 * 作者：徐黎明
 * 类的作用：
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
