package org.our.android.main.base;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import org.our.android.dialog.LoadingProgressDialog;

/**
 * 公共activity
 * Created by wangyang on 2016/7/29.
 */
public class BaseActivity extends AppCompatActivity {
    private static String TAG = "BaseActivity";
    private LoadingProgressDialog mLoadingProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoadingProgressDialog = new LoadingProgressDialog(this);
    }

    protected void showLoadingDialog() {
        if (!isFinishing() && mLoadingProgressDialog != null && !mLoadingProgressDialog.isShowing()) {
            mLoadingProgressDialog.show();
        }
    }

    protected void dismissLoadingDialog() {
        if (!isFinishing() && mLoadingProgressDialog != null && mLoadingProgressDialog.isShowing()) {
            mLoadingProgressDialog.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
        mLoadingProgressDialog = null;
    }

    /**
     * 关闭软键盘
     */
    public void closeKeyboard() {
        final InputMethodManager imm = (InputMethodManager) this
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        // 得到InputMethodManager的实例
        if (imm.isActive()) {
            final IBinder windowToken = this.getCurrentFocus() == null ? null : this.getCurrentFocus()
                    .getWindowToken();
            if (windowToken != null) {
                imm.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        closeKeyboard();
    }
}
