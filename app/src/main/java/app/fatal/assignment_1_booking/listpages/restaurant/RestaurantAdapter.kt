package app.fatal.assignment_1_booking.listpages.restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.fatal.assignment_1_booking.R
import app.fatal.assignment_1_booking.model.Restaurant
import java.util.zip.Inflater

class RestaurantAdapter(
    val data: List<Restaurant>,
    val listener: IRestaurantListener
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_page_recycler_item_restaurant, parent, false)
        return RestaurantHolder(view)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: RestaurantHolder, position: Int) {
        val d = data.get(position)
        holder.imageView.setImageResource(d.imageSrc)
        holder.discountView.text = "${d.discount.toString()}%"
        holder.priceView.text = "$${d.price.toString()}"
        holder.ratingView.rating = d.rating
        holder.spaceView.text = d.spaces.toString()
        holder.titleView.text = d.name

        holder.view.setOnClickListener(View.OnClickListener {
            listener.onItemClick(position, d)
        })
    }

    inner class RestaurantHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view = itemView
        val imageView: ImageView = view.findViewById<ImageView>(R.id.list_restaurant_item_image)
        val titleView: TextView = view.findViewById<TextView>(R.id.list_restaurant_item_title)
        val ratingView: RatingBar = view.findViewById<RatingBar>(R.id.list_restaurant_item_rating)
        val discountView: TextView = view.findViewById<TextView>(R.id.list_restaurant_item_discount)
        val priceView: TextView = view.findViewById<TextView>(R.id.list_restaurant_item_price)
        val spaceView: TextView = view.findViewById<TextView>(R.id.list_restaurant_item_space)
    }
}