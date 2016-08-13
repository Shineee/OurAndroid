package org.our.android.user.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import org.our.android.R;
import org.our.android.databinding.LayoutLoginBinding;
import org.our.android.main.base.BaseActivity;
import org.our.android.user.model.User;
import org.our.android.user.presenter.PresenterLogin;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录界面
 * Created by wangyang on 2016/6/21.
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.tbTopMenu)
    Toolbar tbTopMenu;
    @BindView(R.id.tilUserName)
    TextInputLayout tilUserName;
    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;
    private PresenterLogin mPresenterLogin;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.layout_login);
        ButterKnife.bind(this);
        initView();
        mPresenterLogin = new PresenterLogin(binding);
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

    @OnClick(R.id.btnLogin)
    public void btnLogin() {
        String userName = tilUserName.getEditText().getText().toString();
        String password = tilPassword.getEditText().getText().toString();
        if (TextUtils.isEmpty(userName)) {
            tilUserName.setError(getString(R.string.loginUserNameEmptyErrorText));
            tilPassword.setErrorEnabled(false);
        } else if (TextUtils.isEmpty(password)) {
            tilUserName.setErrorEnabled(false);
            tilPassword.setError(getString(R.string.loginPasswordEmptyErrorText));
        } else {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("username", userName);
            hashMap.put("password", password);
            mPresenterLogin.login(hashMap);
        }
        mPresenterLogin.product();
    }
}
