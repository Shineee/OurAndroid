package org.our.android.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangyang on 2016/7/30.
 */
public class RetrofitPresenter {
    private static final String END_POINT = "";
    private static final Retrofit sInstance = new Retrofit.Builder()
            .baseUrl(END_POINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Retrofit getInstance() {
        return sInstance;
    }
}
