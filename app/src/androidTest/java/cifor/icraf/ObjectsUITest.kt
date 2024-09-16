package cifor.icraf

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import cifor.icraf.objects.R
import cifor.icraf.objects.feature.ui.fragments.CountriesFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(value = AndroidJUnit4::class)
class ObjectsUITest {

    @Test
    fun testHomeFragmentToolBar() {
        launchFragmentInContainer<CountriesFragment>(
            themeResId = R.style.AppTheme
        )
        onView(withId(R.id.homeFragmentToolBar)).check(matches(isDisplayed()))
    }

    @Test
    fun testHomeFragmentToolBarText() {
        launchFragmentInContainer<CountriesFragment>(
            themeResId = R.style.AppTheme
        )
        onView(withId(R.id.homeFragmentToolBar)).check(matches(hasDescendant(withText(R.string.app_name))))
    }

    @Test
    fun testHomeFragmentSpinnerExists() {
        launchFragmentInContainer<CountriesFragment>(
            themeResId = R.style.AppTheme
        )
        onView(withId(R.id.homeFragmentSpinner)).check(matches(isDisplayed()))
    }

    @Test
    fun testHomeFragmentSpinnerIsClickable() {
        launchFragmentInContainer<CountriesFragment>(
            themeResId = R.style.AppTheme
        )
        onView(withId(R.id.homeFragmentSpinner)).check(matches(isDisplayed()))
    }

    @Test
    fun testHomeFragmentNextButtonExists() {
        launchFragmentInContainer<CountriesFragment>(
            themeResId = R.style.AppTheme
        )
        onView(withId(R.id.homeFragmentNextButton)).check(matches(isDisplayed()))
    }

    @Test
    fun testHomeFragmentNextButtonIsClickable() {
        launchFragmentInContainer<CountriesFragment>(
            themeResId = R.style.AppTheme
        )
        onView(withId(R.id.homeFragmentNextButton)).check(matches(isClickable()))
    }

    @Test
    fun testHomeFragmentNextButtonTextIsVisible() {
        launchFragmentInContainer<CountriesFragment>(
            themeResId = R.style.AppTheme
        )
        onView(withId(R.id.homeFragmentNextButton)).check(matches(withText("Next")))
    }

    @Test
    fun testCountiesFragmentToolBar() {
        launchFragmentInContainer<CountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countryName" to "Kenya")
        )
        onView(withId(R.id.countiesFragmentToolBar)).check(matches(isDisplayed()))
    }

    @Test
    fun testCountiesFragmentToolBarText() {
        launchFragmentInContainer<CountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countryName" to "Kenya")
        )
        onView(withId(R.id.countiesFragmentToolBar)).check(matches(hasDescendant(withText("Counties"))))
    }

    @Test
    fun testCountiesFragmentToolBarButtonExists() {
        launchFragmentInContainer<CountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countryName" to "Kenya")
        )
        onView(withId(R.id.countiesFragmentNextButton)).check(matches(isDisplayed()))
    }

    @Test
    fun testCountiesFragmentToolBarButtonIsClickable() {
        launchFragmentInContainer<CountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countryName" to "Kenya")
        )
        onView(withId(R.id.countiesFragmentNextButton)).check(matches(isClickable()))
    }

    @Test
    fun testCountiesFragmentSpinnerExists() {
        launchFragmentInContainer<CountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countryName" to "Kenya")
        )
        onView(withId(R.id.countiesFragmentSpinner)).check(matches(isDisplayed()))
    }

    @Test
    fun testCountiesFragmentSpinnerIsClickable() {
        launchFragmentInContainer<CountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countryName" to "Kenya")
        )
        onView(withId(R.id.countiesFragmentSpinner)).check(matches(isClickable()))
    }

    @Test
    fun testCountiesFragmentNextButtonExists() {
        launchFragmentInContainer<CountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countryName" to "Kenya")
        )
        onView(withId(R.id.countiesFragmentNextButton)).check(matches(isDisplayed()))
    }

    @Test
    fun testCountiesFragmentNextButtonIsClickable() {
        launchFragmentInContainer<CountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countryName" to "Kenya")
        )
        onView(withId(R.id.countiesFragmentNextButton)).check(matches(isClickable()))
    }

    @Test
    fun testCountiesFragmentNextButtonTextIsVisible() {
        launchFragmentInContainer<CountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countryName" to "Kenya")
        )
        onView(withId(R.id.countiesFragmentNextButton)).check(matches(withText("Next")))
    }

    @Test
    fun testSubCountiesFragmentToolBar() {
        launchFragmentInContainer<SubCountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countyName" to "Kitui")
        )
        onView(withId(R.id.subCountiesFragmentToolBar)).check(matches(isDisplayed()))
    }

    @Test
    fun testSubCountiesFragmentToolBarText() {
        launchFragmentInContainer<SubCountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countyName" to "Kitui")
        )
        onView(withId(R.id.subCountiesFragmentToolBar)).check(matches(hasDescendant(withText("SubCounties"))))
    }

    @Test
    fun testSubCountiesFragmentSpinnerExists() {
        launchFragmentInContainer<SubCountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countyName" to "Kitui")
        )
        onView(withId(R.id.subCountiesFragmentSpinner)).check(matches(isDisplayed()))
    }

    @Test
    fun testSubCountiesFragmentSpinnerIsClickable() {
        launchFragmentInContainer<SubCountiesFragment>(
            themeResId = R.style.AppTheme,
            fragmentArgs = bundleOf("countyName" to "Kitui")
        )
        onView(withId(R.id.subCountiesFragmentSpinner)).check(matches(isDisplayed()))
    }

}