package feature.presentation.locations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import feature.feature_ricky.R
import feature.feature_ricky.databinding.ActivityLocationsBinding
import feature.presentation.adapter.LocationsAdapter
import feature.presentation.model.LocationsModel

class LocationsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLocationsBinding
    private val mAdapter = LocationsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.locationsRecyclerView.adapter = mAdapter
        val list = listOf(
            LocationsModel("1"),
            LocationsModel("1"),
            LocationsModel("1"),
            LocationsModel("1"),
            LocationsModel("1"),
            LocationsModel("1"),
            LocationsModel("1"),
            LocationsModel("1"),
            LocationsModel("1"),
            LocationsModel("1"),
            LocationsModel("1"),
            LocationsModel("1"),
        )
        mAdapter.setList(list)

    }
}