package com.msaeed.mobile.cleanapplication.presentation.user.users;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.msaeed.mobile.cleanapplication.R;
import com.msaeed.mobile.cleanapplication.presentation.UIManger;

public class UsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        UIManger.replaceFragment(this, new UsersFragment(),
                R.id.activity_users_framelayout_container);
    }
}
