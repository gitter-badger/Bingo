package com.sun.bingo;

import android.app.Application;

import com.sun.bingo.constant.ConstantParameters;

import cn.bmob.v3.Bmob;

/**
 * Created by sunfusheng on 15/7/18.
 */
public class BingoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Bmob.initialize(this, ConstantParameters.BMOB_APP_ID);
    }
}
