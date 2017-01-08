package com.msaeed.mobile.cleanapplication.presentation.user.users;

import android.support.annotation.NonNull;

import java.util.List;

import com.msaeed.mobile.cleanapplication.data.model.User;
import com.msaeed.mobile.cleanapplication.domain.DefaultSubscriber;
import com.msaeed.mobile.cleanapplication.domain.user.UsersUseCase;
import com.msaeed.mobile.cleanapplication.presentation.base.PresenterCallback;

/**
 * Created by msaeed on 1/5/2017.
 */

public class UserPresenter implements PresenterCallback<UsersViewCallback> {

    private  static UsersViewCallback mUsersViewCallback;


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getUsersUseCase().unsubscribe();
        this.mUsersViewCallback = null;
    }

    @Override
    public void attachView(@NonNull UsersViewCallback view) {
        this.mUsersViewCallback = view;


    }

    public void getUsers() {
        this.mUsersViewCallback.showLoading();
        this.getUsersUseCase().execute(new UserListSubscriber());
    }

    public UsersUseCase getUsersUseCase() {
        UsersUseCase usersUseCase = null;
        if (usersUseCase == null) {
            usersUseCase = new UsersUseCase();
        }
        return usersUseCase;
    }


    private final class UserListSubscriber extends DefaultSubscriber<List<User>> {

        @Override
        public void onCompleted() {
            UserPresenter.this.mUsersViewCallback.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            UserPresenter.this.mUsersViewCallback.hideLoading();
            UserPresenter.this.mUsersViewCallback.showError(e.getMessage());
        }

        @Override
        public void onNext(List<User> users) {
            UserPresenter.this.mUsersViewCallback.renderUsers(users);

        }
    }

}
