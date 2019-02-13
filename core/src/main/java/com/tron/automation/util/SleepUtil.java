package com.tron.automation.util;

/**
 * 休眠工具类
 */
public class SleepUtil {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
