package org.our.android.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.our.android.R;
import org.our.android.main.base.BaseActivity;
import org.our.android.user.ui.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主界面
 * Created by Administrator on 2016/7/24.
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.tbTopMenu)
    Toolbar tbTopMenu;
    @BindView(R.id.dlLeftMenu)
    DrawerLayout dlLeftMenu;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    @BindView(R.id.lvLeftMenu)
    ListView lvLeftMenu;
    private String[] mLeftMenuArray = {"首页"};
    private ArrayAdapter mArrayAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        ButterKnife.bind(this);
        initView();
        showLoadingDialog();
    }

    private void initView() {
        setSupportActionBar(tbTopMenu);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, dlLeftMenu, tbTopMenu, 0, 0) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mActionBarDrawerToggle.syncState();
        dlLeftMenu.addDrawerListener(mActionBarDrawerToggle);
        //设置菜单列表
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mLeftMenuArray);
        lvLeftMenu.setAdapter(mArrayAdapter);
    }

    @OnClick(R.id.imgAvatar)
    public void imgAvatar() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
