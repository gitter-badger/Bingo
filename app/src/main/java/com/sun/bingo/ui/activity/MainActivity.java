package com.sun.bingo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sun.bingo.R;
import com.sun.bingo.adapter.FragmentAdapter;
import com.sun.bingo.control.NavigateManager;
import com.sun.bingo.ui.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tab_layout)
    TabLayout tabLayout;
    @InjectView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;
    @InjectView(R.id.floating_action_button)
    FloatingActionButton floatingActionButton;
    @InjectView(R.id.main_coordinator_layout)
    CoordinatorLayout mainCoordinatorLayout;
    @InjectView(R.id.main_navigation_layout)
    NavigationView mainNavigationLayout;
    @InjectView(R.id.main_drawer_layout)
    DrawerLayout mainDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initView();
        initListener();
    }

    private void initView() {
        initToolBar(toolbar, false, R.string.app_name);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mainDrawerLayout, toolbar, 0, 0);
        drawerToggle.syncState();
        initTabLayout();
        initFloatingActionButton();
    }

    private void initListener() {

    }

    private void initTabLayout() {
        List<String> titles = new ArrayList<>();
        titles.add("Tab 1");
        titles.add("Tab 2");
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListFragment());
        fragments.add(new ListFragment());
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);
    }

    private void initFloatingActionButton() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigateManager.gotoEditNewBingoActivity(MainActivity.this);
//                Snackbar.make(view, "Snackbar comes out", Snackbar.LENGTH_LONG)
//                        .setAction("Action", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Toast.makeText(
//                                        MainActivity.this,
//                                        "Toast comes out",
//                                        Toast.LENGTH_SHORT).show();
//                            }
//                        }).show();
//                new MaterialDialog.Builder(MainActivity.this)
//                        .title("标题")
//                        .content("消息")
//                        .positiveText("确定")
//                        .negativeText("取消")
//                        .show();
            }
        });
    }

}
