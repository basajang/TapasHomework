package com.tapas.homework.seriesdetail.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tapas.homework.BaseApplication;
import com.tapas.homework.R;
import com.tapas.homework.api.client.ApiClient;
import com.tapas.homework.model.EpisodeModel;
import com.tapas.homework.model.SeriesModel;
import com.tapas.homework.seriesdetail.adapter.EpisodeListAdapter;
import com.tapas.homework.ui.decoration.SpacesItemDecoration;
import com.tapas.homework.util.Logger;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by james on 2021-07-13.
 */
public class EpisodeListViewHolder extends RecyclerView.ViewHolder {
    private final String TAG = this.getClass().getSimpleName();
    private SeriesModel model;

    private RecyclerView rcEpisodes;
    private EpisodeListAdapter episodeListAdapter = new EpisodeListAdapter();

    public EpisodeListViewHolder(@NonNull View itemView) {
        super(itemView);
        rcEpisodes = itemView.findViewById(R.id.rcEpisodes);
        rcEpisodes.setLayoutManager(new LinearLayoutManager(BaseApplication.getContext(), LinearLayoutManager.VERTICAL, false));
        rcEpisodes.addItemDecoration(new SpacesItemDecoration(15));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(BaseApplication.getContext(),LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(BaseApplication.getContext().getDrawable(R.drawable.divider_color));
        rcEpisodes.setAdapter(episodeListAdapter);

    }

    public void bind(SeriesModel seriesModel){
        model = seriesModel;
        ApiClient.getApiInstance().getApiService().getSeriesEpisodes(model.getId()).enqueue(new Callback<List<EpisodeModel>>() {
            @Override
            public void onResponse(Call<List<EpisodeModel>> call, Response<List<EpisodeModel>> response) {
                if(response.isSuccessful()){

                    episodeListAdapter.setEpisodeModelList(response.body());

                }
            }

            @Override
            public void onFailure(Call<List<EpisodeModel>> call, Throwable t) {

            }
        });
    }
}
