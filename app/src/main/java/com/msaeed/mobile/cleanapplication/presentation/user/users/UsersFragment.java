package com.msaeed.mobile.cleanapplication.presentation.user.users;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.msaeed.mobile.cleanapplication.R;
import com.msaeed.mobile.cleanapplication.data.model.User;
import com.msaeed.mobile.cleanapplication.presentation.UIManger;
import com.msaeed.mobile.cleanapplication.presentation.user.users.model.UserItemEvent;

/**
 * Created by msaeed on 1/5/2017.
 */

public class UsersFragment extends Fragment implements UsersViewCallback {
    @BindView(R.id.fragment_users_recyclerview_users)
    RecyclerView mRecyclerViewUsers;
    @BindString(R.string.fragment_users_msg_loading_users)
    String mLoadingUserStr;
    private Unbinder mUnbinder;
    private View mParentView;
    private UsersAdapter mAdapterUsers;
    private List<User> mUsers;
    private UsersViewCallback mUsersViewCallback;
    private EventBus mBus;


    public UsersFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mBus = EventBus.getDefault();
        if (this instanceof UsersViewCallback) {
            this.mUsersViewCallback = this;

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mParentView = inflater.inflate(R.layout.fragment_users, container, false);
        mUnbinder = ButterKnife.bind(this, mParentView);
        initViews();

        return mParentView;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().attachView(this.mUsersViewCallback);
        if (savedInstanceState == null) {
            getPresenter().getUsers();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // registering the bus
        if (!mBus.isRegistered(this)) {
            mBus.register(this);
        }
    }

    @Override
    public void onStop() {
        // un-registering the bus
        if (mBus.isRegistered(this)) {
            mBus.unregister(this);
        }
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().destroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mRecyclerViewUsers.setAdapter(null);
        mUnbinder.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mUsersViewCallback = null;
    }

    @Override
    public void showLoading() {
        UIManger.showLoading(getActivity(),mLoadingUserStr);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideLoading() {
        UIManger.hideLoading();
    }

    @Override
    public void renderUsers(List<User> users) {
        this.mUsers = users;
        mRecyclerViewUsers.setAdapter(getAdapter());

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserClick(UserItemEvent event) {
        UIManger.showUserDetails(getActivity(), event.getUserName());
    }

    private void initViews() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewUsers.setLayoutManager(layoutManager);
        mRecyclerViewUsers.smoothScrollToPosition(0);
    }

    private UsersAdapter getAdapter() {
        if (mAdapterUsers == null) {
            mAdapterUsers = new UsersAdapter(getActivity(), mUsers);
        }
        return mAdapterUsers;
    }

    private UserPresenter getPresenter() {
        UserPresenter userPresenter = null;
        if (userPresenter == null) {
            userPresenter = new UserPresenter();

        }
        return userPresenter;
    }
}
