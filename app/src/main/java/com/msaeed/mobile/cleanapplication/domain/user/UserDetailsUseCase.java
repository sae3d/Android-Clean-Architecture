package com.msaeed.mobile.cleanapplication.domain.user;

import com.msaeed.mobile.cleanapplication.data.repository.UserRepository;
import com.msaeed.mobile.cleanapplication.domain.UseCase;
import rx.Observable;

/**
 * Created by msaeed on 1/5/2017.
 */

public class UserDetailsUseCase extends UseCase {
    private String mUser;


    public UserDetailsUseCase(String user) {

        this.mUser = user;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return getUserRepository().getUserDetails(mUser);
    }

    private UserRepository getUserRepository() {
        UserRepository userRepository = null;
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }
}
