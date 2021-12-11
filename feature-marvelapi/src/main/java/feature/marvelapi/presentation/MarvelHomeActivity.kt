package feature.marvelapi.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import feature.marvelapi.databinding.ActivityMarvelHomeBinding
import feature.marvelapi.marvelModule
import feature.marvelapi.presentation.adapter.MainMarvelAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class MarvelHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarvelHomeBinding

    private val viewModel: MarvelHomeViewModel by viewModel()

    private val mAdapter = MainMarvelAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(marvelModule)

        binding.homeRecycler.apply {
            adapter = mAdapter
            setHasFixedSize(true)
        }

        viewModel.test.observe(this, {
            mAdapter.submitList(it.data.results)
        })

        viewModel.error.observe(this, {
            Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
            onBackPressed()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(listOf(marvelModule))
    }
}