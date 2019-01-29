package com.news.portalberita.network;

import com.news.portalberita.base.BaseResponse;

public class NetworkException extends Exception {

    private final int mResponseCode;
    private final BaseResponse mBaseResponse;

    public NetworkException(BaseResponse baseResponse, int responseCode) {
        this.mBaseResponse = baseResponse;
        this.mResponseCode = responseCode;
    }

    public BaseResponse getResponse() {
        return mBaseResponse;
    }

    public int getResponseCode() {
        return mResponseCode;
    }
}

