package feature.marvelapi.presentation.home.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import feature.commons.utils.StateMachine
import feature.marvelapi.databinding.ActivityMarvelHomeBinding
import feature.marvelapi.marvelModule
import feature.marvelapi.presentation.home.adapter.MainMarvelAdapter
import feature.marvelapi.presentation.home.viewmodel.MarvelHomeViewModel
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

        onEnterActivity()
    }

    private fun onEnterActivity() {
        initObservers()
        initAdapter()
    }

    private fun initAdapter() {
        binding.homeRecycler.apply {
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }

    private fun initObservers() {

        viewModel.getCharacters().observe(this) { event ->
            when (event) {
                is StateMachine.Loading -> doNothingForNow()
                is StateMachine.Success -> mAdapter.submitList(event.value.data.results)
                is StateMachine.ApiError -> Toast.makeText(
                    this,
                    "${event.error}",
                    Toast.LENGTH_SHORT
                ).show()
                is StateMachine.UnknownError -> doNothingForNow()
                else -> doNothingForNow()
            }
        }
    }

    private fun doNothingForNow() {}

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(listOf(marvelModule))
    }
}
