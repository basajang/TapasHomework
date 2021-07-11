package com.tapas.homework.api;

/*
 * Created by jiHoon on 2021. 7. 9.
 */

import com.tapas.homework.model.BrowseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/browse/fresh")
    Call<BrowseModel> getBrowse(@Query("series_type") String comics, @Query("page") int pageNum );
}
