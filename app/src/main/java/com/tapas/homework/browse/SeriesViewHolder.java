package com.tapas.homework.browse;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.tapas.homework.BaseApplication;
import com.tapas.homework.R;
import com.tapas.homework.api.client.ApiClient;
import com.tapas.homework.model.SeriesModel;
import com.tapas.homework.seriesdetail.SeriesDetailActivity;
import com.tapas.homework.util.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * Created by jiHoon on 2021. 7. 10.
 */

public class SeriesViewHolder extends RecyclerView.ViewHolder {
    private final String TAG = this.getClass().getSimpleName();
    private ImageView ivBookCover;
    private TextView tvTitle, tvCreators;
    private TextView tvRestrictedMsg, tvPaidMsg, tvOnSale;

    private SeriesModel model;
    private FrameLayout flRestricted;
    private LinearLayout liItemBack, flPaid;

    private Activity activity;

    public SeriesViewHolder(@NonNull View itemView) {
        super(itemView);
        liItemBack = itemView.findViewById(R.id.liItemBack);
        flRestricted = itemView.findViewById(R.id.flRestricted);
        flPaid = itemView.findViewById(R.id.flPaid);
        tvOnSale = itemView.findViewById(R.id.tvOnSale);
        tvPaidMsg = itemView.findViewById(R.id.tvPaidMsg);
        ivBookCover = itemView.findViewById(R.id.ivBookCover);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvCreators = itemView.findViewById(R.id.tvCreators);
    }


    public void bind(SeriesModel seriesModel, Activity activity) {
        model = seriesModel;
        this.activity = activity;
        RequestManager glide = Glide.with(BaseApplication.getContext());
        if (model.getBook_cover_url() != null) {

            glide.load(model.getBook_cover_url()).override(250, 375).fitCenter().into(ivBookCover);
        } else {
            glide.load(model.getThumb().getFile_url()).override(250).fitCenter().into(ivBookCover);
        }

        String title = model.getTitle();
        if (title == null) {
            title = "";
        }
        tvTitle.setText(title);

        int rgb = Color.parseColor(model.getRgb_hex());
        liItemBack.setBackgroundColor(rgb);

        setState();

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < model.getCreators().size(); i++){

            stringBuilder.append(model.getCreators().get(i).getDisplay_name());
            if(i < model.getCreators().size()-1){
                stringBuilder.append(", ");
            }
        }

        tvCreators.setText(stringBuilder);
        Logger.d(TAG, stringBuilder.length());
        if(stringBuilder.length() > 10){
            tvCreators.setSelected(true);
        }


        liItemBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiClient.getApiInstance().getApiService().getSeries(seriesModel.getId()).enqueue(new Callback<SeriesModel>() {
                    @Override
                    public void onResponse(Call<SeriesModel> call, Response<SeriesModel> response) {
                        if(response.isSuccessful()){

                            Logger.d(TAG, response.body());

                            Intent intent = new Intent(activity, SeriesDetailActivity.class);
                            intent.putExtra("seriesModel", response.body());
                            activity.startActivity(intent);


                        }
                    }

                    @Override
                    public void onFailure(Call<SeriesModel> call, Throwable t) {

                    }
                });
            }
        });
    }


    private void setState() {
        if (model.isRestricted()) {
            flRestricted.setVisibility(View.VISIBLE);
            tvRestrictedMsg.setText(model.getRestricted_msg());
            return;
        }

        setSaleType();

        if (model.isOnSale()) {
            flPaid.setVisibility(View.VISIBLE);
            tvOnSale.setVisibility(View.VISIBLE);
        }





    }

    private void setSaleType() {
        switch (model.getSale_type()) {
            case "PAID":
                flPaid.setVisibility(View.VISIBLE);
                break;
            case "FREE":
                flPaid.setVisibility(View.GONE);
                break;
            case "WAIT_OR_MUST_PAY":
                flPaid.setVisibility(View.VISIBLE);
                tvPaidMsg.setText(R.string.wait_or_must_pay);
                break;
            default:
                flRestricted.setVisibility(View.VISIBLE);
                tvRestrictedMsg.setText(R.string.can_not_be_used);
                tvTitle.setEnabled(false);
                break;
        }
    }
}