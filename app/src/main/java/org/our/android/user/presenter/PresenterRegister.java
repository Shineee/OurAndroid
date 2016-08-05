package org.our.android.user.presenter;

import org.our.android.databinding.LayoutRegisterBinding;
import org.our.android.http.RetrofitPresenter;
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

    public PresenterRegister(LayoutRegisterBinding layoutLoginBinding) {
        mLayoutRegisterBinding = layoutLoginBinding;
    }

    public void register(User user) {
        IApiServiceRegister iApiServiceRegister = RetrofitPresenter.getInstance().create(IApiServiceRegister.class);
        Call<User> call = iApiServiceRegister.register(user);
        L.v(TAG, "register %s url=%s", call.request().method(), call.request().url().encodedPath());

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                L.v(TAG, "register onResponse message=%s", response.message());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
                L.e(TAG, t, "register onFailure");
            }
        });
    }
}
