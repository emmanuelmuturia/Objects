package cifor.icraf.objects

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import cifor.icraf.objects.feature.ui.fragments.HomeFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(value = AndroidJUnit4::class)
class HomeFragmentTest {

    @Before
    fun setup() {
        val homeFragmentScenario = launchFragmentInContainer<HomeFragment>(themeResId = R.style.AppTheme)
        homeFragmentScenario.moveToState(newState = Lifecycle.State.STARTED)
    }

    @Test
    fun homeFragmentToolbarBarIsVisible() {
        onView(withId(R.id.homeFragmentToolBar)).check(matches(isDisplayed()))
    }

    @Test
    fun homeFragmentToolbarBarTextIsVisible() {
        onView(withId(R.id.homeFragmentToolBar)).check(matches(hasDescendant(withText(R.string.app_name))))
    }

}