package com.tapas.homework.browse;/*
 * Created by jiHoon on 2021. 7. 11.
 */

import android.app.usage.NetworkStats;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import com.tapas.homework.api.client.ApiClient;
import com.tapas.homework.model.BrowseModel;
import com.tapas.homework.model.PaginationModel;
import com.tapas.homework.model.SeriesModel;
import com.tapas.homework.util.Logger;
import com.tapas.homework.utils.NetworkState;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrowsePageKeyedDataSource extends PageKeyedDataSource<Integer, SeriesModel> {

    private final String TAG = this.getClass().getSimpleName();
    private String seriesType = "COMICS";

    private PaginationModel paginationModel;


    public BrowsePageKeyedDataSource() {
        paginationModel = new PaginationModel();
    }

    public PaginationModel getPaginationModel() {
        return paginationModel;
    }

    @Override
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<Integer> params, @NonNull PageKeyedDataSource.LoadInitialCallback<Integer, SeriesModel> callback) {
        Logger.d(TAG, "loadInitial      ");
        if (paginationModel.isHas_next()) {
            ApiClient.getApiInstance().getApiService().getBrowse(seriesType, 1).enqueue(new Callback<BrowseModel>() {
                @Override
                public void onResponse(Call<BrowseModel> call, Response<BrowseModel> response) {
                    if (response.isSuccessful()) {
                        paginationModel = response.body().getPagination();
                        callback.onResult(response.body().getSeries(), null, response.body().getPagination().getPage());
                    }
                }

                @Override
                public void onFailure(Call<BrowseModel> call, Throwable t) {

                }
            });
        }
    }

    @Override
    public void loadBefore(@NonNull PageKeyedDataSource.LoadParams<Integer> params, @NonNull PageKeyedDataSource.LoadCallback<Integer, SeriesModel> callback) {

    }

    @Override
    public void loadAfter(@NonNull PageKeyedDataSource.LoadParams<Integer> params, @NonNull PageKeyedDataSource.LoadCallback<Integer, SeriesModel> callback) {

        Logger.d(TAG, "loadAfter  paginationModel  "+paginationModel.toString() );
        if (paginationModel.isHas_next()) {

            ApiClient.getApiInstance().getApiService().getBrowse(seriesType, params.key).enqueue(new Callback<BrowseModel>() {
                @Override
                public void onResponse(Call<BrowseModel> call, Response<BrowseModel> response) {
                    if (response.isSuccessful()) {
                        callback.onResult(response.body().getSeries(), response.body().getPagination().getPage());
                        paginationModel = response.body().getPagination();
//                        paginationModel.postValue((PaginationModel) response.body().getPagination());
                    }
                }

                @Override
                public void onFailure(Call<BrowseModel> call, Throwable t) {
                    String errorMessage = t == null ? "unknown error" : t.getMessage();

                }
            });
        }
    }
}
