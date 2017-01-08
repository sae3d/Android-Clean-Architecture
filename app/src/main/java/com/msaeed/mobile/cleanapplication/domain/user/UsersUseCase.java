package com.msaeed.mobile.cleanapplication.domain.user;

import com.msaeed.mobile.cleanapplication.data.repository.UserRepository;
import com.msaeed.mobile.cleanapplication.domain.UseCase;
import rx.Observable;

/**
 * Created by msaeed on 1/5/2017.
 */

public class UsersUseCase extends UseCase {


    @Override
    protected Observable buildUseCaseObservable() {
        return getUserRepository().getUsers();
    }

    public UserRepository getUserRepository() {
        UserRepository UserRepository = null;
        if (UserRepository == null) {
            UserRepository = new UserRepository();
        }
        return UserRepository;
    }
}
