package org.our.android.user.api;

import org.our.android.user.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by wangyang on 2016/7/30.
 */
public interface IApiServiceRegister {
    /**
     * 注册
     */
    @POST("/1/users")
    Call<User> register(@Body User user);
}
