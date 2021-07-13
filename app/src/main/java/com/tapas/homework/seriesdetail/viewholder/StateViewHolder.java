package com.tapas.homework.seriesdetail.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tapas.homework.R;
import com.tapas.homework.model.SeriesModel;

/**
 * Created by james on 2021-07-13.
 */
public class StateViewHolder extends RecyclerView.ViewHolder {

    private TextView tvSubscribeCnt, tvLikeCnt, tvViewCnt, tvColophon;
    private SeriesModel series;

    public StateViewHolder(@NonNull View itemView) {
        super(itemView);

        tvSubscribeCnt = itemView.findViewById(R.id.tvSubscribeCnt);
        tvLikeCnt = itemView.findViewById(R.id.tvLikeCnt);
        tvViewCnt = itemView.findViewById(R.id.tvViewCnt);
    }

    public void bind(SeriesModel seriesModel) {
        series = seriesModel;
        tvSubscribeCnt.setText(series.getSubscribe_cnt()+"");
        tvLikeCnt.setText(series.getLike_cnt()+"");
        tvViewCnt.setText(series.getView_cnt()+"");
    }
}
