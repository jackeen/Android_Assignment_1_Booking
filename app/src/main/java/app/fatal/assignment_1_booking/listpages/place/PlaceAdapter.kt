package app.fatal.assignment_1_booking.listpages.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import app.fatal.assignment_1_booking.R
import app.fatal.assignment_1_booking.model.Destination
import java.util.zip.Inflater

// the recycle view of 'thing of place'
class PlaceAdapter(
    private var data: List<Destination>,
    private var clickEvent: IPlaceItemListener
): RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_page_recycler_item_place, parent, false)
        return PlaceHolder(view)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.imageView.setImageResource(data[position].imageSrc)
        holder.ratingView.rating = data[position].rating
        holder.titleView.text = data[position].name
        holder.priceView.text = "$${data[position].price}"

        // IPlaceItemListener use defined interface to pass params
        holder.contentView.setOnClickListener(View.OnClickListener {
            clickEvent.onItemClick(position, data.get(position))
        })
    }

    public fun updateData(data: List<Destination>) {
        this.data = data
        this.notifyDataSetChanged()
    }

    inner class PlaceHolder(view : View): RecyclerView.ViewHolder(view) {
        var contentView = view
        var titleView = view.findViewById<TextView>(R.id.list_place_item_title)
        var imageView = view.findViewById<ImageView>(R.id.list_place_item_image)
        var ratingView = view.findViewById<RatingBar>(R.id.list_place_item_rating)
        var priceView = view.findViewById<TextView>(R.id.list_place_item_price)
    }

}