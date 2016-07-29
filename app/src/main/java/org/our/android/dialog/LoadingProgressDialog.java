package org.our.android.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import org.our.android.R;

/**
 * Created by wangyang on 2016/5/26.
 */
public class LoadingProgressDialog extends ProgressDialog {
    public LoadingProgressDialog(Context context) {
        super(context, R.style.Progress_Dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_loading_dialog);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        LogicManage logicManage = new LogicManage();
//        logicManage.what = LogicManage.LOGIC_MANAGE_LOADING_DIALOG_KEY_BACK;
//        EventBus.getDefault().post(logicManage);
    }
}
