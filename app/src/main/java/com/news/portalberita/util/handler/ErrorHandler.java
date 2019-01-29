package com.news.portalberita.util.handler;

import com.news.portalberita.base.BaseResponse;
import com.news.portalberita.network.NetworkException;

public class ErrorHandler {

    public static String handleError(Throwable throwable) {

        if (throwable == null) return "Connection Problem";
        if (throwable instanceof NetworkException) {
            NetworkException networkException = (NetworkException) throwable;
            BaseResponse baseResponse = networkException.getResponse();
            if (baseResponse.getStatus() != null) {
                return baseResponse.getStatus();
            } else {
                return "Connection Problem";
            }
        }
        return "Connection Problem";
    }
}

