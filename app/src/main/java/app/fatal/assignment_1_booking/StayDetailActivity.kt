package app.fatal.assignment_1_booking

import android.content.Intent
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
import app.fatal.assignment_1_booking.data.stays
import com.google.android.material.timepicker.TimeFormat
import kotlin.time.Duration.Companion.hours

class StayDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_stay_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.stay_detail_toolbar)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            finish()
        })

        val title = intent.getStringExtra("title")
        val data = stays.find{ it.name == title } ?: return

        toolbar.title = title

        findViewById<ImageView>(R.id.stay_detail_image).setImageResource(data.imageSrc)
        findViewById<TextView>(R.id.stay_detail_title).text = data.name
        findViewById<RatingBar>(R.id.stay_detail_rating).rating = data.rating
        findViewById<TextView>(R.id.stay_detail_room_type_name).text = data.roomTypeName
        findViewById<TextView>(R.id.stay_detail_bed_type_name).text = data.bedTypeName
        findViewById<TextView>(R.id.stay_detail_price).text = "$${data.price}"
        findViewById<TextView>(R.id.stay_detail_location).text = data.location
        findViewById<TextView>(R.id.stay_detail_description).text = data.description

        findViewById<TextView>(R.id.stay_detail_check_time).text =
            "Check in: ${data.checkInTime.hours}, Check out: ${data.checkOutTime.hours}"

        val btnCall = findViewById<Button>(R.id.stay_detail_call_btn)
        btnCall.text = data.phone
        btnCall.setOnClickListener(View.OnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                android.net.Uri.parse(data.phone)
            }
            startActivity(dialIntent)
        })

        findViewById<Button>(R.id.stay_detail_add_btn).setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Stay added.", Toast.LENGTH_SHORT).show()
        })
    }
}