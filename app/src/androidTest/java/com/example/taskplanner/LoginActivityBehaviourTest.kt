package com.example.taskplanner

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.taskplanner.ui.main.LoginActivity
import junit.framework.TestSuite
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class LoginActivityBehaviourTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<LoginActivity> =
        ActivityScenarioRule(LoginActivity::class.java)


    @Test
    fun emailInputValidationTest(){
        onView(withId(R.id.editTextEmail)).perform(clearText(),typeText("testmail.com"))
        closeSoftKeyboard()
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.editTextEmail)).check(matches(hasErrorText(TestsUtils.getResourceString(R.string.invalid_email_address))))

    }

    @Test
    fun fieldIsEmptyValidationTest(){
        onView(withId(R.id.editTextEmail)).perform(clearText(),typeText("test@mail.com"))
        closeSoftKeyboard()
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.editTextPassword)).check(matches(hasErrorText(TestsUtils.getResourceString(R.string.field_cannot_be_empty))))

    }


}