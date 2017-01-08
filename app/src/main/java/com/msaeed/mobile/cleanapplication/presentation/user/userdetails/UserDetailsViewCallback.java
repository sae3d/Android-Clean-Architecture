package com.msaeed.mobile.cleanapplication.presentation.user.userdetails;

import com.msaeed.mobile.cleanapplication.data.model.User;
import com.msaeed.mobile.cleanapplication.presentation.base.ViewCallback;

/**
 * Created by msaeed on 1/5/2017.
 */

public interface UserDetailsViewCallback extends ViewCallback {
    void showUser(User user);
}
