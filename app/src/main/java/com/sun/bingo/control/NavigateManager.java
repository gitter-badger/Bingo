package com.sun.bingo.control;

import android.app.Activity;
import android.content.Intent;

import com.sun.bingo.ui.activity.EditNewBingoActivity;

public class NavigateManager {

    public static void gotoEditNewBingoActivity(Activity activity) {
        Intent intent = new Intent(activity, EditNewBingoActivity.class);
        activity.startActivity(intent);
    }
}
