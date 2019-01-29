package com.news.portalberita.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.news.portalberita.util.dialog.ProgressDialog;

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog = ProgressDialog.create();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    public FragmentManager getBaseFragmentManager() {
        return getSupportFragmentManager();
    }


    public void showLoading() {
        progressDialog.show(getBaseFragmentManager());
    }

    public void dismissLoading() {
        progressDialog.dismiss();
    }

    /***** Check connectivity *****/
    protected boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo ni = cm.getActiveNetworkInfo();
            return ni != null;
        } else {
            return false;
        }
    }
}
