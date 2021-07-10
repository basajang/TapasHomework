package com.tapas.homework.browse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.tapas.homework.R;
import com.tapas.homework.api.client.ApiClient;
import com.tapas.homework.model.BrowseModel;
import com.tapas.homework.model.PaginationModel;

import com.tapas.homework.ui.decoration.SpacesItemDecoration;
import com.tapas.homework.util.Logger;

import aglibs.loading.skeleton.layout.SkeletonRecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * Created by jiHoon on 2021. 7. 10.
 */

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    private String seriesType = "COMICS";

    private PaginationModel paginationModel = new PaginationModel();

    private SkeletonRecyclerView rcBrowse;
    private BrowseAdapter browseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcBrowse = findViewById(R.id.rcBrowse);

        browseAdapter = new BrowseAdapter(this);
        rcBrowse.setAdapter(browseAdapter);
        rcBrowse.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcBrowse.addItemDecoration(new SpacesItemDecoration(15));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(this.getDrawable(R.drawable.divider_color));

        rcBrowse.addItemDecoration(dividerItemDecoration);
        if(paginationModel.getPage() == 1){
            loadSeries(paginationModel.getPage());
        }
    }




    private void loadSeries(int pageNum){

        ApiClient.getApiInstance().getApiService().getBrowse(seriesType, pageNum).enqueue(new Callback<BrowseModel>() {
            @Override
            public void onResponse(Call<BrowseModel> call, Response<BrowseModel> response) {

                BrowseModel browseModel = response.body();
                paginationModel = browseModel.getPagination();

                Logger.d(TAG, browseModel.getSeries());
                browseAdapter.addItemList(browseModel.getSeries());
                rcBrowse.stopLoading();
            }

            @Override
            public void onFailure(Call<BrowseModel> call, Throwable t) {
                Log.d(TAG, "onFailure: "+call.toString());
                t.fillInStackTrace();
            }
        });
    }
}