package com.tapas.homework.api.client;

import com.tapas.homework.api.ApiService;
import com.tapas.homework.api.interceptor.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * Created by jiHoon on 2021. 7. 11.
 */

public class ApiClient implements IApiClient {

    private volatile static IApiClient instance;
    private ApiService apiService;
    private static final String base_url = "https://f30ab4e8-ee15-415c-98b8-d2004c5d2b9e.mock.pstmn.io";


    public ApiClient() {
        this(false);
    }

    public ApiClient( boolean useLoadingUI) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor());
        if (useLoadingUI) {
            builder.eventListener(new EventListener() {
                @Override
                public void callStart(Call call) {

                    super.callStart(call);
                }
            });
        }

        OkHttpClient client = builder
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        this.apiService = retrofit.create(ApiService.class);

    }

    public static IApiClient getApiInstance() {
        if (instance == null) {
            synchronized (ApiClient.class) {
                if (instance == null) {
                    instance = new ApiClient();
                }
            }
        }

        return instance;
    }

    @Override
    public ApiService getApiService() {
        return apiService;
    }


}
