package org.our.android.user.api;

import org.our.android.user.model.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by wangyang on 2016/7/30.
 */
public interface IApiServiceLogin {
    /**
     * 登录
     */
    @GET("1/login")
    Call<User> login(@QueryMap Map<String, String> options);
}
