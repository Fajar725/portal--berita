package com.news.portalberita.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.portalberita.R;
import com.news.portalberita.holder.BeritaHolder;
import com.news.portalberita.model.articles.Article;
import com.news.portalberita.ui.activity.berita.DetailBeritaActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaHolder> {

    private List<Article> articleList = new ArrayList<>();
    private LayoutInflater inflater;
    private Context mContext;

    public BeritaAdapter(Context mContext, List<Article> articleList) {
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
        this.articleList.clear();
        this.articleList.addAll(articleList);
    }

    public void replaceItem(List<Article> articles) {
        this.articleList.clear();
        this.articleList.addAll(articles);
        notifyDataSetChanged();
    }

    @Override
    public BeritaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list_berita, parent, false);
        return new BeritaHolder(view);
    }

    @Override
    public void onBindViewHolder(BeritaHolder holder, int position) {
        Picasso.get().load(articleList.get(position).getUrlToImage()).into(holder.ivBerita);
        holder.tvBeritaTitle.setText(articleList.get(position).getTitle());
        holder.tvSource.setText(articleList.get(position).getSource().getName());
        holder.tvBerita.setText(Html.fromHtml(articleList.get(position).getContent() == null? "" : articleList.get(position).getContent()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, DetailBeritaActivity.class)
                        .putExtra(Article.class.getSimpleName(), articleList.get(position)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
