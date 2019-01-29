package com.news.portalberita.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

public class BaseDialogFragment extends DialogFragment {

    protected Context mContext;
    protected LayoutInflater mLayoutInflater;
//
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    protected Dialog getDefaultDialog() {
        Dialog dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        return dialog;
    }

    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

}
