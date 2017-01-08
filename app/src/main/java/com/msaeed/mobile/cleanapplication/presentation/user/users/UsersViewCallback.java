package com.msaeed.mobile.cleanapplication.presentation.user.users;

import java.util.List;

import com.msaeed.mobile.cleanapplication.data.model.User;
import com.msaeed.mobile.cleanapplication.presentation.base.ViewCallback;

/**
 * Created by msaeed on 1/5/2017.
 */

public interface UsersViewCallback extends ViewCallback {
    void renderUsers(List<User> users);
}
