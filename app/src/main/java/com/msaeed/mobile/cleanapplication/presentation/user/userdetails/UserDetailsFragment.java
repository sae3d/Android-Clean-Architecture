package com.msaeed.mobile.cleanapplication.presentation.user.userdetails;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;


import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.msaeed.mobile.cleanapplication.R;
import com.msaeed.mobile.cleanapplication.data.model.User;
import com.msaeed.mobile.cleanapplication.presentation.Constants;
import com.msaeed.mobile.cleanapplication.presentation.UIManger;

/**
 * Created by msaeed on 1/5/2017.
 */

public class UserDetailsFragment extends Fragment implements UserDetailsViewCallback {

    @BindView(R.id.fragment_user_details_scrollview)
    ScrollView mScrollingViewUserDetails;
    @BindView(R.id.fragment_user_details_textview_userid)
    TextView mTextViewUserId;
    @BindView(R.id.fragment_user_details_textview_username)
    TextView mTextViewUserName;
    @BindView(R.id.fragment_user_details_textview_type)
    TextView mTextViewUserType;
    @BindView(R.id.fragment_user_details_textview_admin)
    TextView mTextViewAdmin;
    @BindView(R.id.fragment_user_details_imageview_userimage)
    ImageView mImageViewUserImage;
    @BindString(R.string.fragment_users_msg_loading_user_details)
    String mLoadingUserDetailsStr;
    private UserDetailsPresenter mUserDetailsPresenter;
    private UserDetailsViewCallback mUserDetailsViewCallback;
    private View mParentView;
    private Unbinder mUnbinder;
    private EventBus mBus;
    private String mUserName;

    public UserDetailsFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this instanceof UserDetailsViewCallback) {
            this.mUserDetailsViewCallback = this;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mParentView = inflater.inflate(R.layout.fragment_user_details, container, false);
        mUnbinder = ButterKnife.bind(this, mParentView);
        return mParentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getUserDetailsFragmentArguments();
        getPresenter().attachView(this.mUserDetailsViewCallback);
        if (savedInstanceState == null) {
            getPresenter().getUser(this.mUserName);
        }

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().destroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mUserDetailsViewCallback = null;
    }


    @Override
    public void showLoading() {
        UIManger.showLoading(getActivity(),
                mLoadingUserDetailsStr);
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
    public void showUser(User user) {
        ButterKnife.apply(mScrollingViewUserDetails, VISIBLE);
        bindViews(user);
    }

    static final ButterKnife.Action<View> VISIBLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(View view, int index) {
            view.setVisibility(View.VISIBLE);
        }
    };

    private void getUserDetailsFragmentArguments() {
        if (getArguments() != null) {
            this.mUserName = getArguments().getString(Constants.EXTRA_USER_NAME);
        }
    }


    private UserDetailsPresenter getPresenter() {
        UserDetailsPresenter userDetailsPresenter = null;
        if (userDetailsPresenter == null) {
            userDetailsPresenter = new UserDetailsPresenter();
        }
        return userDetailsPresenter;
    }

    private void bindViews(User user) {
        mTextViewUserId.setText(user.getUserId());
        mTextViewUserName.setText(user.getUserName());
        mTextViewUserType.setText(user.getUserType());
        if (user.getUserImage() != null && !user.getUserImage().isEmpty()) {
            // Glide part
            Glide.with(getActivity())
                    .load(user.getUserImage())
                    .centerCrop()
                    .placeholder(R.color.colorWhite)
                    .crossFade()
                    .into(mImageViewUserImage);
        } else {
            mImageViewUserImage.setImageResource(R.color.colorWhite);
        }


    }

}
