package app.fatal.assignment_1_booking

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

import app.fatal.assignment_1_booking.listpages.ListPageAdapter
import app.fatal.assignment_1_booking.model.Country
import com.google.android.material.tabs.TabLayout

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val locationCode = intent.getStringExtra("locationCode")
        if (locationCode == null) {
            return
        }
        val country = Country.valueOf(locationCode)

        // notice the Toolbar class and its xml layout should be same package
        var toolbar: Toolbar = findViewById<Toolbar>(R.id.tool_bar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = country.value
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            finish()
        })

        val pager = findViewById<ViewPager>(R.id.list_pager)
        val pageAdapter = ListPageAdapter(supportFragmentManager, country)
        pager.adapter = pageAdapter

        val tabLayout = findViewById<TabLayout>(R.id.list_tab_layout)
        tabLayout.setupWithViewPager(pager)

//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                tab?.let {
//                    // println(it.position)
//                    when (it.position) {
//                        0 -> println()
//                        1 -> println()
//                        2 -> println()
//                    }
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                tab?.let {
//
//                }
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                tab?.let {
//
//                }
//            }
//
//        })
    }


}