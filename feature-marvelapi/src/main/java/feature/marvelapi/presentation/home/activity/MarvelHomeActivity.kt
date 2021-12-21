package feature.marvelapi.presentation.home.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import feature.commons.utils.StateMachine
import feature.marvelapi.R
import feature.marvelapi.databinding.ActivityMarvelHomeBinding
import feature.marvelapi.marvelModule
import feature.marvelapi.presentation.home.adapter.MainMarvelAdapter
import feature.marvelapi.presentation.home.viewmodel.MarvelHomeViewModel
import feature.marvelapi.presentation.model.CharactersPresentation
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class MarvelHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarvelHomeBinding
    private val viewModel: MarvelHomeViewModel by viewModel()
    private val mAdapter = MainMarvelAdapter()
    private var offset = 0
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(marvelModule)

        onEnterActivity()
    }

    private fun onEnterActivity() {
        initObservers(offset)
        initAdapter()
    }

    private fun initObservers(offSet: Int) {

        viewModel.getCharacters(offSet).observe(this) { event ->
            when (event) {
                is StateMachine.Loading -> showLoading()
                is StateMachine.Success -> {
                    hideLoading()
                    setList(event.value.data.results)
                    isLoading = false
                }
                is StateMachine.ApiError -> {
                    hideLoading()
                    Toast.makeText(
                        this,
                        "${event.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is StateMachine.UnknownError -> hideLoading()

                else -> hideLoading()
            }
        }
    }

    private fun initAdapter() {

        binding.homeRecycler.apply {
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }

    private fun setList(list: List<CharactersPresentation>) {

        mAdapter.submitList(list)

        binding.homeRecycler.addOnScrollListener(object :
                PaginationListener(binding.homeRecycler.layoutManager as LinearLayoutManager) {

                override fun loadMoreItems() {
                    isLoading = true
                    offset += PAGINATION_OFFSET

                    Handler(Looper.myLooper()!!).postDelayed(
                        {
                            initObservers(offset)
                        },
                        1000
                    )
                }

                override fun isLoading(): Boolean {
                    return isLoading
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(listOf(marvelModule))
    }

    companion object {
        const val PAGINATION_OFFSET = 49
    }

    private fun showLoading() {
        val slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
        binding.mainProgressBar.startAnimation(slideDown)
        binding.mainProgressBar.isVisible = true
        binding.mainProgressBar.show()
    }

    private fun hideLoading() {
        val slideTop = AnimationUtils.loadAnimation(this, R.anim.slide_top)
        binding.mainProgressBar.startAnimation(slideTop)
        binding.mainProgressBar.isVisible = false
        binding.mainProgressBar.hide()
    }
}
