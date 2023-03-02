package com.example.simpleacronyms

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.simpleacronyms.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class AcronymsTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun registerCountingIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun unregisterCountingIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun enterShortFormShowsResult() {
        AcronymsViewActions().typeAcronym("HMM")
        AcronymsViewAssertions().validateAcronymsListIsShown()
        AcronymsViewAssertions().validateLongFormRowIsPresentInRecyclerViewAtIndex(7)
    }

    @Test
    fun validateNoResultShownWhenNoServiceResponse() {
        AcronymsViewActions().typeAcronym("HMMMM")
        AcronymsViewAssertions().validateEmptyTextViewIsShown()
        AcronymsViewAssertions().validateAcronymsListIsNotShown()
    }
}