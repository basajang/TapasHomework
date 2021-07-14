package com.tapas.homework.browse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tapas.homework.R;
import com.tapas.homework.model.PaginationModel;

import com.tapas.homework.ui.decoration.SpacesItemDecoration;
/*
 * Created by jiHoon on 2021. 7. 10.
 */

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    private String seriesType = "COMICS";

    private PaginationModel paginationModel = new PaginationModel();

    private RecyclerView rcBrowse;
    private BrowseAdapter browseAdapter;

    private BrowseViewModel browseViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcBrowse = findViewById(R.id.rcBrowse);

        browseAdapter = new BrowseAdapter(this);

        rcBrowse.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcBrowse.addItemDecoration(new SpacesItemDecoration(15));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(this.getDrawable(R.drawable.divider_color));

        browseViewModel = new BrowseViewModel();

        rcBrowse.addItemDecoration(dividerItemDecoration);

        browseViewModel.getPagedListLiveData().observe(this, series -> {browseAdapter.submitList(series);});


        rcBrowse.setAdapter(browseAdapter);



    }




}