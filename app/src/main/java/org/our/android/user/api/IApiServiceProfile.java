package org.our.android.user.api;

import org.our.android.user.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wangyang on 2016/7/30.
 */
public interface IApiServiceProfile {
    /**
     * 登录
     */
    @GET("1/login")
    Call<User> profile(@Query("username") String userName);

}
