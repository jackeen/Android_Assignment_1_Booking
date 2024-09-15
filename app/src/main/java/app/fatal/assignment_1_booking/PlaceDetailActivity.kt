package app.fatal.assignment_1_booking

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import destinations

class PlaceDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_place_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val toolbar = findViewById<Toolbar>(R.id.place_detail_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val name = intent.getStringExtra("name")
        val data = destinations.find {
            it.name == name
        }

        if (data == null) {
            return
        }

        toolbar.title = name

        findViewById<ImageView>(R.id.place_detail_image).setImageResource(data.imageSrc)
        findViewById<TextView>(R.id.place_detail_title).text = data.name
        findViewById<RatingBar>(R.id.place_detail_rating).rating = data.rating
        findViewById<TextView>(R.id.place_detail_price).text = "$${data.price}"
        findViewById<TextView>(R.id.place_detail_save).text = "$${data.price * data.discount / 100}"
        findViewById<TextView>(R.id.place_detail_location).text = data.location
        findViewById<TextView>(R.id.place_detail_best_month).text = data.bestMonth
        findViewById<TextView>(R.id.place_detail_description).text = data.description

        val btnAddToList = findViewById<Button>(R.id.btn_add_to_list)
        btnAddToList.setOnClickListener(View.OnClickListener {

        })
    }


}