package com.tapas.homework.seriesdetail.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tapas.homework.BaseApplication;
import com.tapas.homework.R;
import com.tapas.homework.model.EpisodeModel;

/**
 * Created by james on 2021-07-14.
 */
public class EpisodeViewHolder extends RecyclerView.ViewHolder {

    private TextView tvScene, tvtitle, tvViewCnt;
    private ImageView ivThumb;

    private EpisodeModel model;

    public EpisodeViewHolder(@NonNull View itemView) {
        super(itemView);

        tvScene = itemView.findViewById(R.id.tvScene);
        tvtitle = itemView.findViewById(R.id.tvtitle);
        tvViewCnt = itemView.findViewById(R.id.tvViewCnt);
        ivThumb = itemView.findViewById(R.id.ivThumb);

    }

    public void bind(EpisodeModel episodeModel){
        model = episodeModel;
        tvScene.setText(model.getScene()+"");
        tvtitle.setText(model.getTitle()+"");
        tvViewCnt.setText(model.getView_cnt()+"");

        Glide.with(BaseApplication.getContext())
                .load(model.getThumb().getFile_url())
                .override(model.getThumb().getHeight(), model.getThumb().getWidth())
                .into(ivThumb);
    }
}
