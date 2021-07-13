package com.tapas.homework.seriesdetail.viewholder;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.tapas.homework.BaseApplication;
import com.tapas.homework.R;
import com.tapas.homework.model.CreatorModel;
import com.tapas.homework.model.GenreModel;
import com.tapas.homework.model.SeriesModel;
import com.tapas.homework.util.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by james on 2021-07-13.
 */
public class InfoViewHolder extends RecyclerView.ViewHolder{

    private final String TAG = this.getClass().getSimpleName();

    private ChipGroup cgCreartors, cgGenre;
    private TextView tvDescription;

    private SeriesModel model;

    public InfoViewHolder(@NonNull View itemView) {
        super(itemView);
        cgCreartors = itemView.findViewById(R.id.cgCreartors);
        cgGenre = itemView.findViewById(R.id.cgGenre);
        tvDescription = itemView.findViewById(R.id.tvDescription);

    }

    public void bind(SeriesModel seriesModel, Activity activity){
        model = seriesModel;
        addCreartorsChip();

        Logger.d(TAG, model);

//        Chip chip = new Chip(activity);
//        chip.setText(model.getGenre().getName());
//        chip.setCheckable(false);
//        chip.setChipBackgroundColorResource(R.color.color_base_000_background);
//        chip.setChipStrokeColorResource(R.color.color_base_035_meduim);
//        chip.setChipStrokeWidth(2.0f);
//        chip.setElevation(5.0f);
//        chip.setCloseIconVisible(false);
//        cgCreartors.addView(chip);

        tvDescription.setText(model.getBlurb());
    }

    private void addCreartorsChip() {
        for(CreatorModel creatorModel : model.getCreators()){
            Chip chip = new Chip(BaseApplication.getContext());
            chip.setText(creatorModel.getDisplay_name());
            chip.setCheckable(false);
            chip.setChipBackgroundColorResource(R.color.color_base_000_background);
            chip.setChipStrokeColorResource(R.color.color_base_035_meduim);
            chip.setChipStrokeWidth(2.0f);
            chip.setElevation(5.0f);
            chip.setCloseIconVisible(false);
            try{
                chip.setChipIcon(Glide.with(BaseApplication.getContext()).asDrawable().load(creatorModel.getProfile_pic_url()).submit().get());
            }catch (Exception e){
                e.printStackTrace();
            }
            cgCreartors.addView(chip);

        }
    }

}
