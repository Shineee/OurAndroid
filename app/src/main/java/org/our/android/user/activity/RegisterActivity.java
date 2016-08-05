package org.our.android.user.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import org.our.android.R;
import org.our.android.databinding.LayoutRegisterBinding;
import org.our.android.main.base.BaseActivity;
import org.our.android.user.model.User;
import org.our.android.user.presenter.PresenterRegister;
import org.our.android.utils.L;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册界面
 * Created by wangyang on 2016/6/21.
 */
public class RegisterActivity extends BaseActivity {
    private static final String TAG = "RegisterActivity";
    @BindView(R.id.tbTopMenu)
    Toolbar tbTopMenu;
    @BindView(R.id.tilUserName)
    TextInputLayout tilUserName;
    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;
    @BindView(R.id.tilRePassword)
    TextInputLayout tilRePassword;
    private PresenterRegister mPresenterRegister;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutRegisterBinding binding = DataBindingUtil.setContentView(this, R.layout.layout_register);
        ButterKnife.bind(this);
        initView();
        mPresenterRegister = new PresenterRegister(binding);
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
        String userName = tilUserName.getEditText().getText().toString();
        String password = tilPassword.getEditText().getText().toString();
        String rePassword = tilRePassword.getEditText().getText().toString();

        if (TextUtils.isEmpty(userName)) {
            tilUserName.setError(getString(R.string.registerUserNameEmptyErrorText));
            tilPassword.setErrorEnabled(false);
        } else if (TextUtils.isEmpty(password)) {
            tilUserName.setErrorEnabled(false);
            tilPassword.setError(getString(R.string.registerPasswordEmptyErrorText));
        } else if (password.length() < 6) {
            tilUserName.setErrorEnabled(false);
            tilPassword.setError(getString(R.string.registerPasswordLengthErrorText));
        } else if (!password.equals(rePassword)) {
            tilUserName.setErrorEnabled(false);
            tilPassword.setErrorEnabled(false);
            tilRePassword.setError(getString(R.string.registerPasswordConformErrorText));
            L.v(TAG, "btnRegister password=%s rePassword=%s", password, rePassword);
        } else {
            tilRePassword.setErrorEnabled(false);
            mUser.setUserName(userName);
            mUser.setPassword(password);
            mPresenterRegister.register(mUser);
        }
    }
}
