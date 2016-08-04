package org.our.android.user.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
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
        L.v(TAG, "btnRegister userName=%s", tilUserName.getEditText().getText());
    }
}
