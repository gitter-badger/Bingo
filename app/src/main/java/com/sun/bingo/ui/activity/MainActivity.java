package com.sun.bingo.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.sun.bingo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initToolBar(toolbar, false, R.string.app_name);
    }


}
