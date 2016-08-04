package org.our.android;

import android.app.Application;

import org.our.android.utils.L;

/**
 * 应用后台主体，初始化必须的应用工具
 * Created by Administrator on 2016/7/24.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Log系统初始化
        L.init();
    }
}
