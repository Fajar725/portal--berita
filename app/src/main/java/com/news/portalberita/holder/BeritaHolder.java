package com.news.portalberita.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.portalberita.R;
import com.news.portalberita.base.BaseHolder;

import butterknife.BindView;

public class BeritaHolder extends BaseHolder {

    @BindView(R.id.ivBerita)
    public ImageView ivBerita;
    @BindView(R.id.tvBeritaTitle)
    public TextView tvBeritaTitle;
    @BindView(R.id.tvSource)
    public TextView tvSource;
    @BindView(R.id.tvBerita)
    public TextView tvBerita;

    public BeritaHolder(View itemView) {
        super(itemView);
    }
}
