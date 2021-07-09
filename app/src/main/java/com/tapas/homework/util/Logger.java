package com.tapas.homework.util;/*
 * Created by jiHoon on 2021. 7. 10.
 */

import android.util.Log;

import androidx.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Response;

public class Logger {

    private static int MAX_LINE_TEXT = 500;

    private static String nunTAG = "NunTAG";

    public static void d(String TAG, Object o) {
        if (TAG == null) {
            TAG = nunTAG;
        }
        LogD(TAG, o.toString());
    }

    public static void d(Object o) {
        d(nunTAG, o);
    }

    public static void e(String TAG, Call<String> call, @Nullable Response<String> response, @Nullable Throwable t){

        if(TAG == null){
            TAG = nunTAG;
        }

        logE(TAG, call, response, t);

    }

    public static void e(Call<String> call, @Nullable Response<String> response, @Nullable Throwable t){

        logE(nunTAG, call, response, t);
    }


    private static void logE(String TAG, Call<String> call, @Nullable Response<String> response, @Nullable Throwable t) {

        try{

            if (response != null) {
                LogE(TAG, call.request().url()+ " " +response.errorBody().string());
            }

            if (t != null) {
                t.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void LogD(String TAG, String str) {
        if (str.length() > MAX_LINE_TEXT) {    // 텍스트가 MAX_LINE_TEXT 이상이 넘어가면 줄
            Log.d(TAG, str.substring(0, MAX_LINE_TEXT));
            LogD(TAG, str.substring(MAX_LINE_TEXT));
        } else {
            Log.d(TAG, str);
        }
    }


    private static void LogE(String TAG, String str) {
        if (str.length() > MAX_LINE_TEXT) {    // 텍스트가 MAX_LINE_TEXT 이상이 넘어가면 줄
            Log.e(TAG, str.substring(0, MAX_LINE_TEXT));
            LogD(TAG, str.substring(MAX_LINE_TEXT));
        } else {
            Log.e(TAG, str);
        }
    }
}
