package com.news.portalberita.util.dialog;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.news.portalberita.R;

public class MessageDialog {

    public static void showMessage(Context context, int message) {
        showMessage(context, context.getString(message));
    }

    public static void showMessage(Context context, String message) {
        new MaterialDialog.Builder(context)
                .content(message)
                .positiveText(R.string.ok)
                .onPositive((dialog, which) -> dialog.dismiss())
                .show();
    }
}

