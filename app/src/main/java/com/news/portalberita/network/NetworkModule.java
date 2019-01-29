package com.news.portalberita.network;

import android.util.Log;

import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.news.portalberita.constant.Constant.BASE_URL;

public class NetworkModule {

    public static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .client(provideOkHttpClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                        .serializeNulls()
                        .create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static OkHttpClient provideOkHttpClient() {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        HttpLoggingInterceptor interceptor =
                new HttpLoggingInterceptor(message -> Log.d("Portal Berita", message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().
                connectTimeout(40, TimeUnit.SECONDS).
                readTimeout(40, TimeUnit.SECONDS).
                cookieJar(new JavaNetCookieJar(cookieManager)).
        addInterceptor(interceptor).
                        addInterceptor(chain -> {
                            Request request = chain.request();

                            Request newRequest = request.newBuilder()
                                    .addHeader("Accept", "application/json")
                                    .addHeader("Cache-Control", "no-cache")
                                    .addHeader("Cache-Control", "no-store")
                                    .build();

                            return chain.proceed(newRequest);
                        }).
                        build();
    }
}
