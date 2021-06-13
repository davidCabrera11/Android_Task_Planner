package com.example.taskplanner

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.taskplanner.ui.fragments.TaskDetailFragment
import com.example.taskplanner.ui.main.CreateAccountActivity
import com.example.taskplanner.ui.main.LoginActivity
import com.example.taskplanner.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class CreateAccountBehaviourTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<CreateAccountActivity> =
        ActivityScenarioRule(CreateAccountActivity::class.java)



    @Test
    fun fieldsAreEmptyValidationTest(){
        onView(ViewMatchers.withId(R.id.btnCreateAccount)).perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.editTextIdCreate)).check(matches(hasErrorText(TestsUtils.getResourceString(R.string.field_cannot_be_empty))))


    }
    @Test
    fun emailValidationWhenCreatingNewAccount(){

        onView(ViewMatchers.withId(R.id.editTextIdCreate)).perform(ViewActions.clearText(),
            ViewActions.typeText("12495823"))
        Espresso.closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.editTextNameCreate)).perform(ViewActions.clearText(),
            ViewActions.typeText("Leonardo"))
        Espresso.closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.editTextProfilePicture)).perform(ViewActions.clearText(),
            ViewActions.typeText("imugur.com"))
        Espresso.closeSoftKeyboard()

        onView(ViewMatchers.withId(R.id.editTextEmailCreate)).perform(ViewActions.clearText(),
            ViewActions.typeText("leogmail.com"))
        Espresso.closeSoftKeyboard()

        onView(ViewMatchers.withId(R.id.editTextPasswordCreate)).perform(ViewActions.clearText(),
            ViewActions.typeText("test1234"))
        Espresso.closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.btnCreateAccount)).perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.editTextEmailCreate)).check(matches(hasErrorText(TestsUtils.getResourceString(R.string.invalid_email_address))))

    }



    @Test
    fun creatingNewAccountThenToastSuccessMessageShown(){

        onView(ViewMatchers.withId(R.id.editTextIdCreate)).perform(ViewActions.clearText(),
            ViewActions.typeText("1928374650"))
        Espresso.closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.editTextNameCreate)).perform(ViewActions.clearText(),
            ViewActions.typeText("Lelouch"))
        Espresso.closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.editTextProfilePicture)).perform(ViewActions.clearText(),
            ViewActions.typeText("instagram.com"))
        Espresso.closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.editTextEmailCreate)).perform(ViewActions.clearText(),
            ViewActions.typeText("codegeass@gmail.com"))
        Espresso.closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.editTextPasswordCreate)).perform(ViewActions.clearText(),
            ViewActions.typeText("test1234"))
        Espresso.closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.btnCreateAccount)).perform(ViewActions.click()).inRoot(ToastMatcher()).
        check(matches(ViewMatchers.isDisplayed()))




    }


}