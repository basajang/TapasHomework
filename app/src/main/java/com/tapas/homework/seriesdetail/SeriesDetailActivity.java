package com.tapas.homework.seriesdetail;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.material.tabs.TabLayout;
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
    private Activity activity;

    private ImageView ivBookCover;
    private RecyclerView rcSeriesDetail;
    private TextView tvTitle;

    private SeriesDetailAdapter seriesDetailAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_detail);
        this.getSupportActionBar().hide();

        activity = this;

        initView();

        initData();
    }

    private void initView() {
        ivBookCover = findViewById(R.id.ivBookCover);
        rcSeriesDetail = findViewById(R.id.rcSeriesDetail);
        tvTitle = findViewById(R.id.tvTitle);
    }

    private void initData(){
        seriesModel = getIntent().getParcelableExtra("seriesModel");
        tvTitle.setText(seriesModel.getTitle());
        RequestManager glide = Glide.with(BaseApplication.getContext());

        if (seriesModel.getBook_cover_url() != null) {
            glide.load(seriesModel.getBook_cover_url()).centerInside().into(ivBookCover);
        } else {
            glide.load(seriesModel.getThumb().getFile_url()).centerInside().into(ivBookCover);
        }

        seriesDetailAdapter = new SeriesDetailAdapter(activity, seriesModel);
        seriesDetailAdapter.addTypeList(SeriesDetailAdapter.STATE);
        seriesDetailAdapter.addTypeList(SeriesDetailAdapter.INFO);
        seriesDetailAdapter.addTypeList(SeriesDetailAdapter.EPISODE);

        rcSeriesDetail.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        rcSeriesDetail.addItemDecoration(new SpacesItemDecoration(15));

        rcSeriesDetail.setAdapter(seriesDetailAdapter);
    }
}
