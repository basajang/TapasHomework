package com.tapas.homework;


import android.app.Application;
import android.content.Context;

import com.bumptech.glide.Glide;
/*
 * Created by jiHoon on 2021. 7. 10.
 */

public class BaseApplication extends Application {

    private static volatile Application instance;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        BaseApplication.context = getApplicationContext();
    }

    public static Application getInstance() {
        return instance;
    }


    public static Context getContext() {
        return context;
    }


    // 글라이드에서 with 호출 시 context를 사용할 경우 메모리가 부족할 때 글라이드에서 사용하는 메모리를 clear해준다.
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Glide.get(this).trimMemory(level);
    }
}
