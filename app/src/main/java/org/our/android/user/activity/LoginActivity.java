package org.our.android.user.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.our.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangyang on 2016/6/21.
 */
public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.tbTitleMenu)
    Toolbar tbTitleMenu;
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
        setSupportActionBar(tbTitleMenu);
    }
}
