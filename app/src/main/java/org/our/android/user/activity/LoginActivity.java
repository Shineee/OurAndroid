package org.our.android.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.our.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录界面
 * Created by wangyang on 2016/6/21.
 */
public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.tbTopMenu)
    Toolbar tbTopMenu;
    @BindView(R.id.tilUserName)
    TextInputLayout tilUserName;
    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(tbTopMenu);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbTopMenu.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @OnClick(R.id.btnRegister)
    public void btnRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
