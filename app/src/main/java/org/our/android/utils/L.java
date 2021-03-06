package org.our.android.utils;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Log工具类
 * Created by wangyang on 2016/8/4.
 */
public class L {
    private static final String TAG = "OurAndroid";
    /**
     * Release版本将此设置为None
     */
    private static LogLevel mLogLevel = LogLevel.FULL;

    private L() {
    }

    public static void init() {
        Logger.init(TAG).hideThreadInfo().logLevel(mLogLevel);
    }

    public static void v(String msg, Object... args) {
        Logger.v(msg, args);
    }

    public static void v(String tag, String msg, Object... args) {
        Logger.t(tag).v(msg, args);
    }

    public static void e(String tag, String msg, Object... args) {
        Logger.t(tag).e(msg, args);
    }

    public static void e(String tag, Throwable throwable, String msg, Object... args) {
        Logger.t(tag).e(throwable, msg, args);
    }
}
