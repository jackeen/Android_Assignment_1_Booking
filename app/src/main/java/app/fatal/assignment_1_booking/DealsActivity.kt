package app.fatal.assignment_1_booking


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import app.fatal.assignment_1_booking.data.deals
import app.fatal.assignment_1_booking.deals.DealListAdapter
import app.fatal.assignment_1_booking.deals.IDealItemListener
import app.fatal.assignment_1_booking.model.Deal

class DealsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_deals)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.deals_toolbar)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            finish()
        })

        val dealList = findViewById<RecyclerView>(R.id.deal_list)
        val adapter = DealListAdapter(deals, object : IDealItemListener {
            override fun onItemClick(position: Int, item: Deal) {
                val intent = Intent(this@DealsActivity, DealDetailActivity::class.java)
                intent.putExtra("id", item.id)
                startActivity(intent)
            }
        })
        dealList.adapter = adapter
        dealList.layoutManager = LinearLayoutManager(this)
    }
}