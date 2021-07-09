package com.tapas.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.tapas.homework.api.client.ApiClient;
import com.tapas.homework.model.BrowseModel;
import com.tapas.homework.util.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiClient.getApiInstance().getApiService().getBrowse("COMICS", 1).enqueue(new Callback<BrowseModel>() {
            @Override
            public void onResponse(Call<BrowseModel> call, Response<BrowseModel> response) {

                BrowseModel browseModel = response.body();
                Logger.d(TAG, browseModel.getPagination());

            }

            @Override
            public void onFailure(Call<BrowseModel> call, Throwable t) {
                Log.d(TAG, "onFailure: "+call.toString());
                t.fillInStackTrace();
            }
        });
    }
}