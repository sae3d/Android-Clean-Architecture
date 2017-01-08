package com.msaeed.mobile.cleanapplication.presentation.user.userdetails;

import com.msaeed.mobile.cleanapplication.data.model.User;
import com.msaeed.mobile.cleanapplication.domain.DefaultSubscriber;
import com.msaeed.mobile.cleanapplication.domain.user.UserDetailsUseCase;
import com.msaeed.mobile.cleanapplication.presentation.base.PresenterCallback;

/**
 * Created by msaeed on 1/5/2017.
 */

public class UserDetailsPresenter implements PresenterCallback<UserDetailsViewCallback> {

    private static UserDetailsViewCallback mUserDetailsViewCallback;
    private String mUser;


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void attachView(UserDetailsViewCallback view) {
        this.mUserDetailsViewCallback = view;

    }

    public void getUser(String userName) {
        UserDetailsPresenter.this.mUserDetailsViewCallback.showLoading();
        this.mUser = userName;
        this.getUsersUseCase().execute(new UserDetailsSubscriber());
    }

    private final class UserDetailsSubscriber extends DefaultSubscriber<User> {

        @Override
        public void onCompleted() {
            UserDetailsPresenter.this.mUserDetailsViewCallback.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            UserDetailsPresenter.this.mUserDetailsViewCallback.hideLoading();
            UserDetailsPresenter.this.mUserDetailsViewCallback.showError(e.getMessage());
        }

        @Override
        public void onNext(User user) {
            UserDetailsPresenter.this.mUserDetailsViewCallback.showUser(user);

        }
    }

    public UserDetailsUseCase getUsersUseCase() {
        UserDetailsUseCase userDetailsUseCase = null;
        if (userDetailsUseCase == null) {
            userDetailsUseCase = new UserDetailsUseCase(mUser);
        }
        return userDetailsUseCase;
    }

}
