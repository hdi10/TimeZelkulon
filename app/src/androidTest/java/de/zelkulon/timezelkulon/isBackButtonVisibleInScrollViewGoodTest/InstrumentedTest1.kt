package de.zelkulon.timezelkulon.isBackButtonVisibleInScrollViewGoodTest

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import de.zelkulon.timezelkulon.MainActivity
import de.zelkulon.timezelkulon.R
import de.zelkulon.timezelkulon.SundayActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentedTest1 {

    @get:Rule
    val activityRule = ActivityScenarioRule(SundayActivity::class.java)

    @Test
    fun scrollImViewGutTest1() {
        // Simulate a back press
        //Espresso.pressBack()

        // Check if a specific view is displayed after pressing back
//        Espresso.onView(withId(R.drawable.back_arrow_button_icon))
//            .check(matches(isDisplayed()))
    }
}
