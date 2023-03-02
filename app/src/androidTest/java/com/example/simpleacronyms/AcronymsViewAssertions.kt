package com.example.simpleacronyms

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*

class AcronymsViewAssertions {

    fun validateEmptyTextViewIsShown() {
        AcronymsScreen().getEmptyTextView().check(matches(isDisplayed()))
    }

    fun validateAcronymsListIsShown() {
        AcronymsScreen().getRecyclerView().check(matches(isDisplayed()))
    }

    fun validateEmptyTextViewIsNotShown() {
        AcronymsScreen().getEmptyTextView().check(matches(withEffectiveVisibility(Visibility.GONE)))
    }

    fun validateAcronymsListIsNotShown() {
        AcronymsScreen().getRecyclerView().check(matches(withEffectiveVisibility(Visibility.GONE)))
    }

    fun validateLongFormRowIsPresentInRecyclerViewAtIndex(recyclerViewIndex: Int) {
        AcronymsScreen().getRecyclerView()
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(recyclerViewIndex))
            .check(
                matches(
                    isDisplayed()
                )
            )
    }
}