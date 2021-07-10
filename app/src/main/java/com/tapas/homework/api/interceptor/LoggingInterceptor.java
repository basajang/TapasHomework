package com.tapas.homework.api.interceptor;

/*
 * Created by jiHoon on 2021. 7. 10.
 */

import com.tapas.homework.util.Logger;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/*
 * Created by jiHoon on 2021. 7. 11.
 */

public class LoggingInterceptor implements Interceptor {

    private String TAG = this.getClass().getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Logger.d(TAG, String.format("Sending request %s Connection %s body is %s", request.url(), chain.connection(), request.body() != null ? request.body().toString() : ""));

        Response response = chain.proceed(request);

        return response;
    }
}
