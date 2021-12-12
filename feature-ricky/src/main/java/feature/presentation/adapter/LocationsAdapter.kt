package feature.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import feature.feature_ricky.databinding.ItemLocationsRecyclerBinding
import feature.presentation.ClickListener
import feature.presentation.model.LocationsModel

class LocationsAdapter:RecyclerView.Adapter<LocationsAdapter.ViewHolder>() {
    private lateinit var mListener: ClickListener
    private var items: List<LocationsModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemLocationsRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ItemLocationsRecyclerBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(locations: LocationsModel) {
            binding.textTitle.text = locations.name
        }

    }
    fun setList(list:List<LocationsModel>){
        items = list
    }
}