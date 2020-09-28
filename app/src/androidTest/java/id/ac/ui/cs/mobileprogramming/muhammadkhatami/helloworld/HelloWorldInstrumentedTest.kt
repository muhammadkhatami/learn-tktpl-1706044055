package id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class HelloWorldInstrumentedTest {
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testHelloWorldExist() {
        onView(ViewMatchers.withId(R.id.mainText)).check(ViewAssertions.matches(ViewMatchers.withText("Hello World!")))
    }

    @Test
    fun testThemeChanged() {
        onView(ViewMatchers.withId(R.id.clickMe)).perform(click()).check(ViewAssertions.matches(not(ViewMatchers.withText("Dark"))))
    }
}