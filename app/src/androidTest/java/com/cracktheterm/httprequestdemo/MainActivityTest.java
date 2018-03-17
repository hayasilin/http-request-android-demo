package com.cracktheterm.httprequestdemo;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by kuan-weilin on 3/17/18.
 */

@RunWith(AndroidJUnit4.class) // run test runner，並使用 JUnit 4
@LargeTest // 代表這個 Test 會跑比較久

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Before
    public void setup() throws Exception {
        //do something…
    }

    @Test
    public void demoTest() throws InterruptedException {
        // Test Code

        ViewInteraction cityEditView = onView(withId(R.id.cityEditText));
        cityEditView.perform(replaceText("newyork"), closeSoftKeyboard());

        ViewInteraction getTimeButton = onView(withId(R.id.getTimeButton));
        getTimeButton.perform(click());

//        Thread.sleep(2 * 1000);

        ViewInteraction resultTextView = onView(withId(R.id.resultTextView));
        resultTextView.check(matches(withText("sunset:7:5 pmsunrise:7:5 am")));

    }

    @After
    public void teardown() throws Exception {
        // do something
    }
}
