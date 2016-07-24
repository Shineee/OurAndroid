package org.our.android.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import org.our.android.R;
import org.our.android.user.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主界面
 * Created by Administrator on 2016/7/24.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void btnLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
