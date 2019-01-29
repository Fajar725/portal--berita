package com.news.portalberita.presenter;

import com.news.portalberita.model.articles.ResponseBerita;
import com.news.portalberita.network.ApiService;
import com.news.portalberita.network.NetworkModule;

import rx.Observable;
import rx.schedulers.Schedulers;

import static com.news.portalberita.constant.Constant.API_KEY;

public class BeritaPresenter {

    public static Observable<ResponseBerita> getListBerita(String sources, String sortBy) {
        return NetworkModule.provideRetrofit()
                .create(ApiService.class)
                .getListBerita(sources, sortBy, API_KEY)
                .subscribeOn(Schedulers.computation());
    }
}
