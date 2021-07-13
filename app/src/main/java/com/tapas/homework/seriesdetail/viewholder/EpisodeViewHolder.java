package com.tapas.homework.seriesdetail.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tapas.homework.api.client.ApiClient;
import com.tapas.homework.model.EpisodeModel;
import com.tapas.homework.model.SeriesModel;
import com.tapas.homework.util.Logger;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by james on 2021-07-13.
 */
public class EpisodeViewHolder extends RecyclerView.ViewHolder {
    private final String TAG = this.getClass().getSimpleName();
    private SeriesModel model;

    public EpisodeViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(SeriesModel seriesModel){
        model = seriesModel;
        ApiClient.getApiInstance().getApiService().getSeriesEpisodes(model.getId()).enqueue(new Callback<List<EpisodeModel>>() {
            @Override
            public void onResponse(Call<List<EpisodeModel>> call, Response<List<EpisodeModel>> response) {
                if(response.isSuccessful()){
                    for(EpisodeModel episodeModel : response.body()){
                        Logger.d(TAG, episodeModel.getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<EpisodeModel>> call, Throwable t) {

            }
        });
    }
}
