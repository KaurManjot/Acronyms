package com.example.simpleacronyms

import androidx.test.espresso.action.ViewActions.typeText

class AcronymsViewActions {

    fun typeAcronym(acronym: String) {
        AcronymsScreen().getAcronymsEditText().perform(typeText(acronym))
    }
}