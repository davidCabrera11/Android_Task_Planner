package com.example.taskplanner

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.taskplanner.ui.main.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class CreateAccountAndLoginBehaviourTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<LoginActivity> =
        ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun createNewAccountAndLogin(){

        onView(withId(R.id.btnCreateAccount)).perform(click())
        onView(withId(R.id.createAccountLayout)).check(matches(isDisplayed()))

        //Creating new account
        onView(withId(R.id.editTextIdCreate)).perform(ViewActions.clearText(),
            ViewActions.typeText("10203256"))
        closeSoftKeyboard()
        onView(withId(R.id.editTextNameCreate)).perform(ViewActions.clearText(),
            ViewActions.typeText("Jose"))
        closeSoftKeyboard()
        onView(withId(R.id.editTextProfilePicture)).perform(ViewActions.clearText(),
            ViewActions.typeText("imugur.com"))
        closeSoftKeyboard()
        onView(withId(R.id.editTextEmailCreate)).perform(ViewActions.clearText(),
            ViewActions.typeText("jose@gmail.com"))
        closeSoftKeyboard()
        onView(withId(R.id.editTextPasswordCreate)).perform(ViewActions.clearText(),
            ViewActions.typeText("test1234"))
        closeSoftKeyboard()
        onView(withId(R.id.btnCreateAccount)).perform(click()).inRoot(ToastMatcher()).
        check(matches(isDisplayed()))

        pressBack()

        //Login with new account credentials
        onView(withId(R.id.loginScreenLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextEmail)).perform(ViewActions.clearText(),
            ViewActions.typeText("jose@gmail.com"))
        closeSoftKeyboard()
        onView(withId(R.id.editTextPassword)).perform(ViewActions.clearText(),
            ViewActions.typeText("test1234"))
        closeSoftKeyboard()
        onView(withId(R.id.btnLogin)).perform(click())



    }


}