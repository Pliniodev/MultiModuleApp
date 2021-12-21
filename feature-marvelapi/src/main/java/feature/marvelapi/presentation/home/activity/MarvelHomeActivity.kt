package feature.marvelapi.presentation.home.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat.postDelayed
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import feature.commons.utils.StateMachine
import feature.marvelapi.R
import feature.marvelapi.databinding.ActivityMarvelHomeBinding
import feature.marvelapi.marvelModule
import feature.marvelapi.presentation.home.adapter.MainMarvelAdapter
import feature.marvelapi.presentation.home.viewmodel.MarvelHomeViewModel
import feature.marvelapi.presentation.model.CharactersPresentation
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class MarvelHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarvelHomeBinding
    private val viewModel: MarvelHomeViewModel by viewModel()
    private val mAdapter = MainMarvelAdapter()
    private var offset = 0
    private var isLoading = false
    private var mList = mutableListOf<CharactersPresentation>()

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
        isLoading = true
    }

    private fun initObservers(offSet: Int) {

        viewModel.getCharacters(offSet).observe(this) { event ->
            when (event) {
                is StateMachine.Loading -> handleLoading(isLoading)
                is StateMachine.Success -> {
                    isLoading = false
                    handleLoading(isLoading)
                    mList.addAll(event.value.data.results)
                    setList()
                }
                is StateMachine.ApiError -> {
                    isLoading = false
                    handleLoading(isLoading)
                    Toast.makeText(
                        this,
                        "${event.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is StateMachine.UnknownError -> handleLoading(false)

                else -> handleLoading(false)
            }
        }
    }

    private fun initAdapter() {

        binding.homeRecycler.apply {
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }

    private fun setList() {

        mAdapter.submitList(mList)

        binding.homeRecycler.addOnScrollListener(object :
            PaginationListener(binding.homeRecycler.layoutManager as LinearLayoutManager) {

            override fun loadMoreItems() {

                isLoading = true
                offset += PAGINATION_OFFSET

                runBlocking {
                    delay(1000)
                    initObservers(offset)
                }
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

    private fun handleLoading(isLoading: Boolean) {
        binding.mainProgressBar.apply {

            if (isLoading) {
                val slideDown =
                    AnimationUtils.loadAnimation(this@MarvelHomeActivity, R.anim.slide_down)
                startAnimation(slideDown)
                isVisible = true
                show()
            } else {
                val slideTop =
                    AnimationUtils.loadAnimation(this@MarvelHomeActivity, R.anim.slide_top)
                startAnimation(slideTop)
                isVisible = false
                hide()
            }
        }
    }

    companion object {
        const val PAGINATION_OFFSET = 49
    }
}
