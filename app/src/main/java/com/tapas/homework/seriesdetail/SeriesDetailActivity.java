package com.tapas.homework.seriesdetail;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.tapas.homework.BaseApplication;
import com.tapas.homework.R;
import com.tapas.homework.model.SeriesModel;
import com.tapas.homework.seriesdetail.adapter.SeriesDetailAdapter;
import com.tapas.homework.ui.decoration.SpacesItemDecoration;
import com.tapas.homework.util.Logger;

/**
 * Created by jiHoon on 2021-07-13.
 */
public class SeriesDetailActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    private SeriesModel seriesModel;

    private ImageView ivBookCover;
    private RecyclerView rcSeriesDetail;

    private SeriesDetailAdapter seriesDetailAdapter;

    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_detail);
        this.getSupportActionBar().hide();

        initView();

        seriesModel = getIntent().getParcelableExtra("seriesModel");

        RequestManager glide = Glide.with(BaseApplication.getContext());
        Logger.d(TAG, "getBook_cover_url is "+seriesModel.getBook_cover_url());
        if (seriesModel.getBook_cover_url() != null) {
            glide.load(seriesModel.getBook_cover_url()).centerInside().into(ivBookCover);
        } else {
            glide.load(seriesModel.getThumb().getFile_url()).centerInside().into(ivBookCover);
        }

        seriesDetailAdapter = new SeriesDetailAdapter(this, seriesModel);
        seriesDetailAdapter.addTypeList(SeriesDetailAdapter.STATE);
        seriesDetailAdapter.addTypeList(SeriesDetailAdapter.INFO);
        seriesDetailAdapter.addTypeList(SeriesDetailAdapter.EPISODE);

        rcSeriesDetail.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcSeriesDetail.addItemDecoration(new SpacesItemDecoration(15));

        rcSeriesDetail.setAdapter(seriesDetailAdapter);
    }

    private void initView(){
        ivBookCover = findViewById(R.id.ivBookCover);
        rcSeriesDetail = findViewById(R.id.rcSeriesDetail);
    }
}
