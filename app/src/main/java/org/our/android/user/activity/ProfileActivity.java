package org.our.android.user.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.our.android.R;
import org.our.android.databinding.LayoutProfileBinding;
import org.our.android.main.base.BaseActivity;
import org.our.android.user.model.User;
import org.our.android.user.presenter.PresenterProfile;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人信息界面
 * Created by wangyang on 2016/6/21.
 */
public class ProfileActivity extends BaseActivity {
    @BindView(R.id.tbTopMenu)
    Toolbar tbTopMenu;
    @BindView(R.id.tilUserName)
    TextInputLayout tilUserName;
    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;
    private PresenterProfile mPresenterProfile;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.layout_profile);
        ButterKnife.bind(this);
        initView();
        mPresenterProfile = new PresenterProfile(binding);
        mUser = new User();
        binding.setUser(mUser);
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
