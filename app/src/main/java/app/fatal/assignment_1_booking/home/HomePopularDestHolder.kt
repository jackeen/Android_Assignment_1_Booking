package app.fatal.assignment_1_booking.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.fatal.assignment_1_booking.R

class HomePopularDestHolder(item: View) : RecyclerView.ViewHolder(item) {
    val view = item
    val titleView = item.findViewById<TextView>(R.id.home_dest_recycler_item_title)
    val imageView = item.findViewById<ImageView>(R.id.home_dest_recycler_item_image)
}