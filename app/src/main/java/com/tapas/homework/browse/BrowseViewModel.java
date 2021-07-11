package com.tapas.homework.browse;/*
 * Created by jiHoon on 2021. 7. 11.
 */

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.tapas.homework.model.SeriesModel;
import com.tapas.homework.utils.NetworkState;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BrowseViewModel extends ViewModel {

    private Executor executor;
    private LiveData<NetworkState> networkState;
    private LiveData<PagedList<SeriesModel>> pagedListLiveData;

    public BrowseViewModel() {
        init();
    }

    private void init(){
        executor = Executors.newFixedThreadPool(5);

        BrowseFactory browseFactory = new BrowseFactory();
        networkState = Transformations.switchMap(browseFactory.getMutableLiveData(), dataSource -> dataSource.getPaginationModel());

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(true)
                        .setInitialLoadSizeHint(5)
                        .setPageSize(20).build();

        pagedListLiveData = (new LivePagedListBuilder(browseFactory, pagedListConfig))
                .setFetchExecutor(executor)
                .build();

    }

    public LiveData<NetworkState> getNetworkState() {
        return networkState;
    }

    public LiveData<PagedList<SeriesModel>> getPagedListLiveData() {
        return pagedListLiveData;
    }
}
