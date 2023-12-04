package com.jli.countrycollection

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.jli.countrycollection.countrylist.ui.CountryRowViewHolder
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CountryListEspressoTest {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.jli.countrycollection", appContext.packageName)
    }

    @Test
    fun clickAndEnterDetailScreen() {
        Thread.sleep(500)
        onView(withId(R.id.country_list_recycler_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<CountryRowViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.detailLabel)).check(matches(isDisplayed()))
    }
}