package com.news.portalberita.network;

import com.news.portalberita.model.articles.ResponseBerita;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {

    @GET("v2/top-headlines")
    Observable<ResponseBerita> getListBerita(@Query("sources") String sources,
                                             @Query("sortBy") String sortBy,
                                             @Query("apiKey") String apiKey);
}
