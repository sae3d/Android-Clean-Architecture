package com.msaeed.mobile.cleanapplication.presentation.user.users;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import com.msaeed.mobile.cleanapplication.R;
import com.msaeed.mobile.cleanapplication.data.model.User;
import com.msaeed.mobile.cleanapplication.presentation.user.users.model.UserItemEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by msaeed on 1/6/2017.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private List<User> mUsers;
    private Context mContext;

    public UsersAdapter(Context mContext, List<User> mUsers) {
        this.mUsers = mUsers;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user = mUsers.get(position);
        holder.mTextViewUserName.setText(user.getUserName());
        if (user.getUserImage() != null && !user.getUserImage().isEmpty()) {
            // Glide part
            Glide.with(mContext)
                    .load(user.getUserImage())
                    .centerCrop()
                    .placeholder(R.color.colorWhite)
                    .crossFade()
                    .into(holder.mImageViewUserImage);
        } else {
            holder.mImageViewUserImage.setImageResource(R.color.colorWhite);
        }
        holder.mRelativeLayoutUserParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new UserItemEvent(user.getUserName()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recyclerview_textview_username)
        TextView mTextViewUserName;
        @BindView(R.id.recyclerview_imageview_userimage)
        ImageView mImageViewUserImage;
        @BindView(R.id.recyclerview_relativelayout_parent)
        RelativeLayout mRelativeLayoutUserParent;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
