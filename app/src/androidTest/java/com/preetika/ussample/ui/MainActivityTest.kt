package com.preetika.ussample.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.preetika.ussample.R
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule


@RunWith(AndroidJUnit4::class)
@LargeTest

class MainActivityTest {

    private lateinit var stringToBetyped: String

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        // Specify a valid string.
        stringToBetyped = ""
    }

    @Test
    fun changeText_sameActivity() {

        // Check that the text was changed.
        activityRule.activity.getData()
        onView(withId(R.id.user_name))
            .check(matches(withText(stringToBetyped)))
    }

    @Test fun checkVisibilityName() {
        onView(withId(R.id.summary)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    @Test fun checkVisibilityEducation() {
        onView(withId(R.id.education_layout)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    @Test fun checkVisibilitySkills() {
        onView(withId(R.id.skill_layout)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

}