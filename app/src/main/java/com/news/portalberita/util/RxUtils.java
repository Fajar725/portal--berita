package com.news.portalberita.util;

import com.google.gson.Gson;
import com.news.portalberita.base.BaseResponse;
import com.news.portalberita.network.NetworkException;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxUtils {

    public static <T> Observable.Transformer<T, T> applyScheduler() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> Observable.Transformer<T, T> applyApiCall() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {

                    if (throwable instanceof HttpException) {
                        try {
                            HttpException httpException = (HttpException) throwable;
                            String res = httpException.response().errorBody().string();

                            Gson gson = new Gson();
                            BaseResponse baseResponse = gson.fromJson(res, BaseResponse.class);
                            NetworkException e = new NetworkException(baseResponse, httpException.response().code());
                            return Observable.error(e);

                        } catch (IOException e) {
                            return Observable.empty();
                        }
                    } else
                        return Observable.empty();
                });
    }
}
