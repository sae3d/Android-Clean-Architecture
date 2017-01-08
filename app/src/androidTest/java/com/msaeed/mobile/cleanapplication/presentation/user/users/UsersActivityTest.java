package com.msaeed.mobile.cleanapplication.presentation.user.users;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.msaeed.mobile.cleanapplication.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UsersActivityTest {

    @Rule
    public ActivityTestRule<UsersActivity> mActivityTestRule = new ActivityTestRule<>(UsersActivity.class);

    @Test
    public void usersActivityTest() {
        ViewInteraction relativeLayout = onView(
                allOf(withId(R.id.recyclerview_relativelayout_parent), isDisplayed()));
        relativeLayout.perform(click());

        pressBack();

        pressBack();

    }

}
