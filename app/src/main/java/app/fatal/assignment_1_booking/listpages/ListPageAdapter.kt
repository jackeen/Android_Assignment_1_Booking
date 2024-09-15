package app.fatal.assignment_1_booking.listpages

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import app.fatal.assignment_1_booking.model.Country


class ListPageAdapter(
    fm: FragmentManager,
    private val country: Country
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ListPagePlaceFragment(country)
            1 -> ListPageRestaurantsFragment(country)
            2 -> ListPageStayFragment(country)
            else -> ListPagePlaceFragment(country)
        }
    }

    override fun getCount(): Int {
        return 3 // Number of fragments
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Thing of place"
            1 -> "Restaurants"
            2 -> "Stay"
            else -> null
        }
    }
}
