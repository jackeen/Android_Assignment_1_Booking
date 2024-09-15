package app.fatal.assignment_1_booking.listpages

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.fatal.assignment_1_booking.PlaceDetailActivity
import app.fatal.assignment_1_booking.R
import app.fatal.assignment_1_booking.listpages.place.IPlaceItemListener
import app.fatal.assignment_1_booking.listpages.place.PlaceAdapter
import app.fatal.assignment_1_booking.model.Country
import app.fatal.assignment_1_booking.model.Destination
import destinations

class ListPagePlaceFragment(private val country: Country) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment_place, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = destinations.filter { it.country == country}
        val adapter = PlaceAdapter(data, object: IPlaceItemListener {
            override fun onItemClick(position: Int, item: Destination) {
                val intent = Intent(requireContext(), PlaceDetailActivity::class.java)
                intent.putExtra("name", item.name)
                startActivity(intent)
            }
        })
        val recyclerView = view.findViewById<RecyclerView>(R.id.list_place_recycler)
        recyclerView.adapter = adapter;
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        val searchBar = view.findViewById<SearchView>(R.id.list_place_searchbar)
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                val keyword = newText?.trim(' ')
                if (keyword != null && keyword != "") {
                    adapter.updateData(data.filter { it.name.contains(keyword, true) })
                } else {
                    adapter.updateData(data)
                }
                return true
            }

        })



    }
}