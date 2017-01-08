package com.msaeed.mobile.cleanapplication.networking.retrofit;


import java.util.List;

import com.msaeed.mobile.cleanapplication.data.model.User;
import retrofit2.http.GET;

import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by msaeed on 10/24/2016.
 */
public interface RetrofitAPIService {

    @GET(NetworkingConstants.END_POINT_GET_USERS)
    Observable<List<User>> getUsers();

    @GET(NetworkingConstants.END_POINT_GET_USER_DETAILS)
    Observable<User> getUserDetails(@Path(NetworkingConstants.PATH_USER) String user);


}
