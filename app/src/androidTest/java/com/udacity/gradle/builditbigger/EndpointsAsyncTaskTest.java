package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.util.Pair;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> activityScenarioRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void asyncTaskTest() throws Exception {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(new Pair<Context, String>(activityScenarioRule.getActivity()
                ,"Manfred"));
        Assert.assertFalse(endpointsAsyncTask.get().isEmpty());
    }
}
