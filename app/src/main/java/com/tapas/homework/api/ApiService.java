package com.tapas.homework.api;

/*
 * Created by jiHoon on 2021. 7. 9.
 */

import com.tapas.homework.model.BrowseModel;
import com.tapas.homework.model.EpisodeModel;
import com.tapas.homework.model.SeriesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/browse/fresh")
    Call<BrowseModel> getBrowse(@Query("series_type") String comics, @Query("page") int pageNum );

    @GET("/series/{series_id}")
    Call<SeriesModel> getSeries(@Path("series_id") int seriesId);

    @GET("/series/{series_id}/episodes")
    Call<List<EpisodeModel>> getSeriesEpisodes(@Path("series_id") int seriesId);
}
