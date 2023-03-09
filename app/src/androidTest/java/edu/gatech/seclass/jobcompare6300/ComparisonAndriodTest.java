package edu.gatech.seclass.jobcompare6300;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.platform.app.InstrumentationRegistry;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;




///
import edu.gatech.seclass.jobcompare6300.CompareActivity;



/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ComparisonAndriodTest {

//    @Rule
//    public ActivityScenarioRule<CompareActivity> tActivityRule = new ActivityScenarioRule<>(
//            CompareActivity.class);

//    @Rule
//    public ActivityScenarioRule <CompareActivity> activityRule
//            = new ActivityScenarioRule <>(
//            CompareActivity.class,
//            true,     // initialTouchMode
//            false);

    @Before
    public void setUp(){
        Job job1 = new Job("title1","Company1","City1","State1", 2000,100000.0,10000.0,2.0,1000.0,10,false);
        Job job2 = new Job("title2","Company2","City2","State2", 1000,200000.0,10000.0,2.0,1000.0,10,false);
        Job job3 = new Job("title3","Company3","City3","State3", 1000,300000.0,10000.0,2.0,1000.0,10,false);
        Job job4 = new Job("title4","Company4","City4","State4", 1000,400000.0,10000.0,2.0,1000.0,10,false);

        MainActivity.jobs.add(job1);
        MainActivity.jobs.add(job3);
        MainActivity.jobs.add(job4);
        MainActivity.jobs.add(job2);
    }

    @Test
    public void showRanking(){
        ActivityScenario<CompareActivity> scenario = ActivityScenario.launch(CompareActivity.class);
        assertEquals(1, 1);

    }


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("edu.gatech.seclass.jobcompare6300", appContext.getPackageName());
    }
}