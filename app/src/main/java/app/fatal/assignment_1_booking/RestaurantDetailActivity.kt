package app.fatal.assignment_1_booking

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.fatal.assignment_1_booking.data.restaurants

class RestaurantDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_restaurant_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("title")
        if (name == null) {
            return
        }

        val data = restaurants.find {
            it.name == name
        }

        if (data == null) {
            return
        }

        val toolbar = findViewById<Toolbar>(R.id.restaurant_detail_toolbar)
        toolbar.title = name
        toolbar.setNavigationOnClickListener {
            finish()
        }

        findViewById<ImageView>(R.id.restaurant_detail_image).setImageResource(data.imageSrc)
        findViewById<TextView>(R.id.restaurant_detail_title).text = data.name
        findViewById<RatingBar>(R.id.restaurant_detail_rating).rating = data.rating
        findViewById<TextView>(R.id.restaurant_detail_price).text = "$${data.price}"
        findViewById<TextView>(R.id.restaurant_detail_discount).text = "${data.discount}%"
        findViewById<TextView>(R.id.restaurant_detail_week_days).text = data.weekDays.joinToString {
            it.toString()
        }
        findViewById<TextView>(R.id.restaurant_detail_location).text = data.location
        findViewById<TextView>(R.id.restaurant_detail_description).text = data.description

        findViewById<Button>(R.id.restaurant_detail_add_btn).setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Dealed", Toast.LENGTH_SHORT).show()
        })

    }
}