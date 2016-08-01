package org.our.android.user.api;

import org.our.android.user.model.User;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wangyang on 2016/7/30.
 */
public interface IApiServiceLogin {
    /**
     * 登录
     */
    @GET("/1/login")
    void login(@Query(value = "email") String email, @Query(value = "password") String password, Callback<User> callback);
}
