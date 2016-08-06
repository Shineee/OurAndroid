package org.our.android.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangyang on 2016/7/30.
 */
public class RetrofitPresenter {
    private static final String END_POINT = "https://api.bmob.cn/";
    private static final String APP_ID = "60485096e0a82579c8379fd743e27547";
    private static final String API_KEY = "a65b41ab52705d5ca92d7fdab7343505";

    private static final Retrofit sInstance = new Retrofit.Builder()
            .baseUrl(END_POINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(genericClient())
            .build();

    public static Retrofit getInstance() {
        return sInstance;
    }

    public static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("X-Bmob-Application-Id", APP_ID)
                                .addHeader("X-Bmob-REST-API-Key", API_KEY)
                                .addHeader("Content-Type", "application/json")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();

        return httpClient;
    }
}
