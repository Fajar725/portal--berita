package com.news.portalberita.ui.activity.berita;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.news.portalberita.R;
import com.news.portalberita.adapter.BeritaAdapter;
import com.news.portalberita.base.BaseActivity;
import com.news.portalberita.model.articles.Article;
import com.news.portalberita.presenter.BeritaPresenter;
import com.news.portalberita.util.RxUtils;
import com.news.portalberita.util.dialog.MessageDialog;
import com.news.portalberita.util.handler.ErrorHandler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListBeritaActivity extends BaseActivity {

    @BindView(R.id.rvContent)
    RecyclerView rvContent;

    private BeritaAdapter beritaAdapter;
    private List<Article> articleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_berita);
        ButterKnife.bind(this);

        initAdapter();
        getListBerita();
    }

    private void initAdapter() {
        beritaAdapter = new BeritaAdapter(this, articleList);
        rvContent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvContent.setNestedScrollingEnabled(false);
        rvContent.setAdapter(beritaAdapter);
    }

    /***** API Connection *****/
    private void getListBerita() {
        if (!isNetworkConnected()){
            MessageDialog.showMessage(this, "Oops, Connection Error");
            return;
        }
        showLoading();
        BeritaPresenter.getListBerita("bbc-news", "publishedAt")
                .doOnTerminate(() -> runOnUiThread(this::dismissLoading))
                .compose(RxUtils.applyApiCall())
                .subscribe(response -> runOnUiThread(() -> {
                    if (response != null) {
                        if (response.getArticles().size() > 0) {
                            initData(response.getArticles());
                            return;
                        }
                    }

                    MessageDialog.showMessage(this, "Data not found");
                }), throwable -> {
                    Toast.makeText(this, ErrorHandler.handleError(throwable), Toast.LENGTH_SHORT).show();
                });
    }

    private void initData(List<Article> articles) {
        articleList.clear();
        articleList.addAll(articles);
        beritaAdapter.replaceItem(articleList);
    }
}
