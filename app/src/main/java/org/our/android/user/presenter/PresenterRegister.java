package org.our.android.user.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;

import org.our.android.R;
import org.our.android.databinding.LayoutRegisterBinding;
import org.our.android.http.RetrofitPresenter;
import org.our.android.user.activity.LoginActivity;
import org.our.android.user.api.IApiServiceRegister;
import org.our.android.user.model.User;
import org.our.android.utils.L;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wangyang on 2016/7/30.
 */
public class PresenterRegister {
    private static final String TAG = "";
    private LayoutRegisterBinding mLayoutRegisterBinding;
    private Context mContext;

    public PresenterRegister(@NonNull LayoutRegisterBinding layoutLoginBinding) {
        mLayoutRegisterBinding = layoutLoginBinding;
        mContext = layoutLoginBinding.getRoot().getContext();
    }

    public void register(@NonNull User user) {
        IApiServiceRegister iApiServiceRegister = RetrofitPresenter.getInstance().create(IApiServiceRegister.class);
        Call<User> call = iApiServiceRegister.register(user);
        L.v(TAG, "register %s url=%s", call.request().method(), call.request().url().encodedPath());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    L.v(TAG, "onResponse Successful");
                    Snackbar.make(mLayoutRegisterBinding.getRoot(), R.string.registerSuccessText, Snackbar.LENGTH_LONG).show();
                    Intent intent = new Intent(mLayoutRegisterBinding.getRoot().getContext(), LoginActivity.class);
                    mContext.startActivity(intent);
                } else {
                    L.e(TAG, "register onResponse message=%s", response.message());
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
                L.e(TAG, t, "register onFailure");
            }
        });
    }
}
