package com.msaeed.mobile.cleanapplication.presentation;

import android.app.Activity;
import android.app.Application;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.msaeed.mobile.cleanapplication.presentation.user.userdetails.UserDetailsActivity;

/**
 * Created by msaeed on 1/5/2017.
 */

public class UIManger extends Application {
    private static ProgressDialog mProgressDialog;


    public static void showLoading(Context context, String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.setMessage(message);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }
    }

    public static void hideLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    public static void replaceFragment(Activity activity, Fragment fragment, int view) {
        FragmentTransaction ft = ((AppCompatActivity) activity).getSupportFragmentManager().beginTransaction();
        ft.replace(view, fragment, fragment.toString());
        ft.commit();
    }

    public static void showUserDetails(Activity activity, String userName) {
        Intent userDetailsIntent = new Intent(activity, UserDetailsActivity.class);
        userDetailsIntent.putExtra(Constants.EXTRA_USER_NAME, userName);
        activity.startActivity(userDetailsIntent);
    }
}
