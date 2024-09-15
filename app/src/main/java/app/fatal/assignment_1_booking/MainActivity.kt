package app.fatal.assignment_1_booking

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.fatal.assignment_1_booking.home.HomePopularDestAdapter
import app.fatal.assignment_1_booking.listpages.place.IPlaceItemListener
import app.fatal.assignment_1_booking.model.Country
import app.fatal.assignment_1_booking.model.Destination
import destinations

class MainActivity : AppCompatActivity() {

    var currentDest: String = Country.NZ.code

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // prepare data for popular destinations
        val popularDestNZ = destinations.filter { it.country == Country.NZ }
        val popularDestAU = destinations.filter { it.country == Country.AU }
        val popularDestFJ = destinations.filter { it.country == Country.FJ }

        // dest recycle list
        val layoutManager = GridLayoutManager(this, 2)
        val adapter = HomePopularDestAdapter(popularDestNZ, object : IPlaceItemListener{
            override fun onItemClick(position: Int, item: Destination) {
                val intent = Intent(this@MainActivity, PlaceDetailActivity::class.java)
                intent.putExtra("name", item.name)
                startActivity(intent)
            }
        })
        val recyclerView = findViewById<RecyclerView>(R.id.home_dest_recycler)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        // notice the Toolbar class and its xml layout should be same package
        var toolbar: Toolbar = findViewById<Toolbar>(R.id.main_tool_bar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Booking"

        //
        val btnDestActivity = findViewById<CardView>(R.id.btn_go_dest_list)
        val btnDestActivityText = findViewById<TextView>(R.id.btn_go_dest_list_text)
        val popularTitle = findViewById<TextView>(R.id.home_popular_title)

        val imgCountry = findViewById<ImageView>(R.id.country_img)
        val btnNZ = findViewById<Button>(R.id.btn_country_nz)
        val btnAU = findViewById<Button>(R.id.btn_country_au)
        val btnFJ = findViewById<Button>(R.id.btn_country_fj)
        btnNZ.setOnClickListener(View.OnClickListener {
            currentDest = Country.NZ.code
            imgCountry.setImageResource(R.drawable.bookme_heade_nz)
            //btnDestActivity.text = generateFindingButtonText()
            btnDestActivityText.text = generateFindingButtonText()
            popularTitle.text = generateDestTitle()
            adapter.UpdateDataset(popularDestNZ)

        })
        btnAU.setOnClickListener(View.OnClickListener {
            currentDest = Country.AU.code
            imgCountry.setImageResource(R.drawable.bookme_header_au)
            //btnDestActivity.text = generateFindingButtonText()
            btnDestActivityText.text = generateFindingButtonText()
            popularTitle.text = generateDestTitle()
            adapter.UpdateDataset(popularDestAU)
        })
        btnFJ.setOnClickListener(View.OnClickListener {
            currentDest = Country.FJ.code
            imgCountry.setImageResource(R.drawable.bookme_header_fj)
            //btnDestActivity.text = generateFindingButtonText()
            btnDestActivityText.text = generateFindingButtonText()
            popularTitle.text = generateDestTitle()
            adapter.UpdateDataset(popularDestFJ)
        })

        //
        btnDestActivity.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("locationCode", currentDest)
            startActivity(intent)
        })

    }

    // menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_person -> {
                val intent = Intent(this, UserStateActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun generateFindingButtonText(): String {
        return "Find more in ${Country.valueOf(currentDest).value}"
    }

    private fun generateDestTitle(): String {
        return "Popular ${Country.valueOf(currentDest).value} Destinations"
    }


}