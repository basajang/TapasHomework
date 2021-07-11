package com.tapas.homework.browse;
/*
 * Created by jiHoon on 2021. 7. 11.
 */

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class BrowseFactory extends DataSource.Factory {

    private MutableLiveData<BrowsePageKeyedDataSource> mutableLiveData;
    private BrowsePageKeyedDataSource browsePageKeyedDataSource;

    public BrowseFactory() {
        this.mutableLiveData = new MutableLiveData<BrowsePageKeyedDataSource>();
    }

    @NonNull
    @Override
    public DataSource create() {
        browsePageKeyedDataSource = new BrowsePageKeyedDataSource();
        mutableLiveData.postValue(browsePageKeyedDataSource);
        return browsePageKeyedDataSource;
    }

    public MutableLiveData<BrowsePageKeyedDataSource> getMutableLiveData() {
        return mutableLiveData;
    }
}
