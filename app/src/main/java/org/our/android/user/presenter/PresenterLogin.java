package org.our.android.user.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import org.our.android.databinding.LayoutLoginBinding;
import org.our.android.http.RetrofitPresenter;
import org.our.android.user.activity.ProfileActivity;
import org.our.android.user.api.IApiServiceLogin;
import org.our.android.user.model.User;
import org.our.android.utils.L;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 登陆控制模块
 * Created by wangyang on 2016/7/30.
 */
public class PresenterLogin {
    private static final String TAG = "PresenterLogin";
    private LayoutLoginBinding mLayoutLoginBinding;
    private Context mContext;

    public PresenterLogin(@NonNull LayoutLoginBinding layoutLoginBinding) {
        mLayoutLoginBinding = layoutLoginBinding;
        mContext = layoutLoginBinding.getRoot().getContext();
    }

    public void login(@NonNull HashMap map) {
        IApiServiceLogin iApiServiceLogin = RetrofitPresenter.getInstance().create(IApiServiceLogin.class);
        Call<User> call = iApiServiceLogin.login(map);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    L.v(TAG, "login onResponse Successful");
                    Intent intent = new Intent(mContext, ProfileActivity.class);
                    mContext.startActivity(intent);
                } else {
                    L.e(TAG, "login onResponse message=%s", response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                L.e(TAG, t, "login onFailure");
            }
        });
    }
}
