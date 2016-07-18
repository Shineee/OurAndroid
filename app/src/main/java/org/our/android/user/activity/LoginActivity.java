package org.our.android.user.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import org.our.android.BuildConfig;
import org.our.android.R;

/**
 * Created by wangyang on 2016/6/21.
 */
public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        Log.d("LoginActivity", "debug=" + BuildConfig.DEBUG + " version=" + BuildConfig.BUILD_TYPE);
    }
}
