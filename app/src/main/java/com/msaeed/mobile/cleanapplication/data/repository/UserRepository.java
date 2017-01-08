package com.msaeed.mobile.cleanapplication.data.repository;

import java.util.List;

import com.msaeed.mobile.cleanapplication.data.model.User;
import com.msaeed.mobile.cleanapplication.networking.retrofit.RetrofitApi;
import rx.Observable;

/**
 * Created by msaeed on 1/5/2017.
 */

public class UserRepository {

    public Observable<List<User>> getUsers() {
        return RetrofitApi.getsInstance().getService().getUsers();
    }

    public Observable<User> getUserDetails(String user) {
        return RetrofitApi.getsInstance().getService().getUserDetails(user);
    }
}
