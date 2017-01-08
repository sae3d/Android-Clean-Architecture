package com.msaeed.mobile.cleanapplication.presentation.base;

/**
 * Created by msaeed on 1/5/2017.
 */

public interface PresenterCallback<T extends ViewCallback> {
    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    void destroy();

    /**
     * Method that attach view inside presenter
     */
    void attachView(T view);
}
