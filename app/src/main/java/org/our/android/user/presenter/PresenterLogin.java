package org.our.android.user.presenter;

import android.util.Log;

import org.our.android.databinding.LayoutLoginBinding;
import org.our.android.http.RetrofitPresenter;
import org.our.android.user.api.IApiServiceLogin;
import org.our.android.user.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wangyang on 2016/7/30.
 */
public class PresenterLogin {
    private LayoutLoginBinding mLayoutLoginBinding;

    public PresenterLogin(LayoutLoginBinding layoutLoginBinding) {
        mLayoutLoginBinding = layoutLoginBinding;
    }

    public void login(String userName, String password) {
        IApiServiceLogin iApiServiceLogin = RetrofitPresenter.getInstance().create(IApiServiceLogin.class);
        Call<User> call = iApiServiceLogin.login(userName, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e("PresenterLogin", "onResponse " + response.message());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("PresenterLogin", "onFailure" + t.getMessage());
            }
        });
    }
}
