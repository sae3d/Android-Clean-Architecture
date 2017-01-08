package com.msaeed.mobile.cleanapplication.presentation.base;

/**
 * Created by msaeed on 1/5/2017.
 */

public interface ViewCallback {
    void showLoading();

    void showError(String message);

    void hideLoading();
}
