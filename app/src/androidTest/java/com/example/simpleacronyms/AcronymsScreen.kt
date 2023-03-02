package com.example.simpleacronyms

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId

class AcronymsScreen {

    fun getAcronymsEditText(): ViewInteraction =
        onView(withId(R.id.short_form_edit_text))

    fun getEmptyTextView(): ViewInteraction = onView(withId(R.id.empty_view))

    fun getRecyclerView(): ViewInteraction = onView(withId(R.id.main_recycler_view))
}