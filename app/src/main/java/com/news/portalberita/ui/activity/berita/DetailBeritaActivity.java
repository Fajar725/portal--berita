package com.news.portalberita.ui.activity.berita;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.portalberita.R;
import com.news.portalberita.base.BaseActivity;
import com.news.portalberita.model.articles.Article;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBeritaActivity extends BaseActivity {

    public SimpleDateFormat responseDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    public SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");

    @BindView(R.id.ivBerita)
    public ImageView ivBerita;
    @BindView(R.id.tvBeritaTitle)
    public TextView tvBeritaTitle;
    @BindView(R.id.tvSource)
    public TextView tvSource;
    @BindView(R.id.tvDate)
    public TextView tvDate;
    @BindView(R.id.tvOtherSource)
    public TextView tvOtherSource;
    @BindView(R.id.tvBerita)
    public TextView tvBerita;

    Article mArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        ButterKnife.bind(this);

        mArticle = getIntent().getParcelableExtra(Article.class.getSimpleName());
        initView();
    }

    private void initView() {
        Picasso.get().load(mArticle.getUrlToImage()).into(ivBerita);
        tvBeritaTitle.setText(mArticle.getTitle());
        tvSource.setText(mArticle.getSource().getName());
        tvDate.setText(mArticle.getPublishedAt());
        tvOtherSource.setText(mArticle.getSource().getName());
        tvBerita.setText(Html.fromHtml(mArticle.getContent() == null? "" : mArticle.getContent()));
    }

    private String getFormattedDate(String date){
        String resultDate = "";
        try {
            resultDate = formattedDate.format(responseDate.parse(date));
        } catch (ParseException e) {
            resultDate = date;
        }
        return date;
    }
}

