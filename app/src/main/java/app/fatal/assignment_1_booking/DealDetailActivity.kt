package app.fatal.assignment_1_booking

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.fatal.assignment_1_booking.data.deals
import app.fatal.assignment_1_booking.model.DealType

class DealDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_deal_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.deal_detail_toolbar)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            finish()
        })

        val id = intent.getIntExtra("id", 0)
        if (id == 0) {
            return
        }

        val data = deals.find { it.id == id }
        if (data == null) {
            return
        }

        findViewById<TextView>(R.id.deal_detail_title).text = data.dealName
        findViewById<TextView>(R.id.deal_detail_type).text = data.dealType.name
        findViewById<TextView>(R.id.deal_detail_payment).text = "$${data.payment}"
        findViewById<TextView>(R.id.deal_detail_date).text = data.dealDate.toLocaleString()

        val btn = findViewById<Button>(R.id.deal_detail_target_btn)
        btn.text = "Go ${data.dealType.name.lowercase()} details"
        btn.setOnClickListener(View.OnClickListener {

            if (data.dealType == DealType.PLACE) {
                val intent = Intent(this@DealDetailActivity, PlaceDetailActivity::class.java)
                intent.putExtra("title", data.dealName)
                startActivity(intent)
            } else if (data.dealType == DealType.RESTAURANT) {
                val intent = Intent(this@DealDetailActivity, RestaurantDetailActivity::class.java)
                intent.putExtra("title", data.dealName)
                startActivity(intent)
            } else {
                val intent = Intent(this@DealDetailActivity, StayDetailActivity::class.java)
                intent.putExtra("title", data.dealName)
                startActivity(intent)
            }


        })
    }
}