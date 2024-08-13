package cifor.icraf

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import cifor.icraf.objects.R
import cifor.icraf.objects.feature.ui.fragments.HomeFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(value = AndroidJUnit4::class)
class ObjectsUITest {

    @Test
    fun testHomeFragmentToolBar() {
        val homeFragmentScenario = launchFragmentInContainer<HomeFragment>()
        onView(withId(R.id.homeFragmentToolBar)).check(matches(isDisplayed()))
    }

    fun testHomeFragmentToolBarText() {
        val homeFragmentScenario = launchFragmentInContainer<HomeFragment>()
        onView(withId(R.id.homeFragmentToolBar)).check(matches(withText(R.string.app_name)))
    }

}