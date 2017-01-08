package com.msaeed.mobile.cleanapplication.presentation.user.userdetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.msaeed.mobile.cleanapplication.R;
import com.msaeed.mobile.cleanapplication.presentation.UIManger;


/**
 * Created by msaeed on 1/5/2017.
 */

public class UserDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        UserDetailsFragment userDetailsFragment = new UserDetailsFragment();
        userDetailsFragment.setArguments(getIntent().getExtras());
        UIManger.replaceFragment(this, userDetailsFragment,
                R.id.activity_user_details_framelayout_container);


    }


}
