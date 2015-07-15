package com.sun.bingo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sun.bingo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGAStickinessRefreshViewHolder;


public class MainActivity extends BaseActivity implements BGARefreshLayout.BGARefreshLayoutDelegate {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.text)
    TextView text;
    @InjectView(R.id.refresh_layout)
    BGARefreshLayout refreshLayout;
    @InjectView(R.id.drawer_view)
    RelativeLayout drawerView;
    @InjectView(R.id.drawer)
    DrawerLayout drawer;
    @InjectView(R.id.tab_layout)
    TabLayout tabLayout;
    @InjectView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @InjectView(R.id.tv_version_right)
    LinearLayout tvVersionRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initToolBar(toolbar, false, R.string.app_name);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, 0, 0);
        mDrawerToggle.syncState();
        drawer.setDrawerListener(mDrawerToggle);
        initTabLayout();
        initBGARefreshLayout();
    }

    private void initTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
    }



    private void initBGARefreshLayout() {
        // 为BGARefreshLayout设置代理
        refreshLayout.setDelegate(this);
        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
        BGARefreshViewHolder refreshViewHolder = new BGAStickinessRefreshViewHolder(this, true);
        // 设置下拉刷新和上拉加载更多的风格
        refreshLayout.setRefreshViewHolder(refreshViewHolder);
    }
    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {
    }
    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        return false;
    }
}
