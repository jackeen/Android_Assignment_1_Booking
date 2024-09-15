package app.fatal.assignment_1_booking.deals

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.fatal.assignment_1_booking.R

class DealListHolder(item: View) : RecyclerView.ViewHolder(item) {
    val view = item
    val iconView = item.findViewById<ImageView>(R.id.deals_item_icon)
    val nameView = item.findViewById<TextView>(R.id.deals_item_name)
    val dateView = item.findViewById<TextView>(R.id.deals_item_date)
    val priceView = item.findViewById<TextView>(R.id.deals_item_price)
}