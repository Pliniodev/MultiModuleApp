package feature.marvelapi.presentation.home.activity

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import feature.commons.utils.PaginationListener
import feature.commons.utils.StateMachine
import feature.marvelapi.R
import feature.marvelapi.databinding.ActivityMarvelHomeBinding
import feature.marvelapi.marvelModule
import feature.marvelapi.presentation.home.adapter.MainMarvelAdapter
import feature.marvelapi.presentation.home.viewmodel.MarvelHomeViewModel
import feature.marvelapi.presentation.model.CharactersPresentation
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import okhttp3.internal.notify
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class MarvelHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarvelHomeBinding
    private val viewModel: MarvelHomeViewModel by viewModel()
    private val mAdapter = MainMarvelAdapter()
    private var offset = 0
    private var name: String? = null
    private var isLoading = false
    private var mList = mutableListOf<CharactersPresentation>()
    private var canLoadMore = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(marvelModule)

        onEnterActivity()
    }

    private fun onEnterActivity() {
        setUpObservers(offset)
        initAdapter()
        isLoading = true
        setUpSearch()
    }

    private fun setUpObservers(offSet: Int, name: String? = null) {

        viewModel.getCharacters(offSet, name).observe(this) { event ->
            when (event) {
                is StateMachine.Loading -> handleLoading(isLoading)
                is StateMachine.Success -> {
                    isLoading = false
                    handleLoading(isLoading)
                    setList(event.value.data.results)
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

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpSearch() {

        binding.apply {

            searchBtn.apply {

                setOnClickListener {

                    ObjectAnimator.ofFloat(layoutLogo, "translationX", -320f).apply {
                        duration = 1000
                        start()
                    }

                    ObjectAnimator.ofFloat(marvelLogo, "alpha", 1.0f, 0f).apply {
                        duration = 1000
                        start()
                    }

                    ObjectAnimator.ofFloat(replaceLogo, "alpha", 0f, 1.0f).apply {
                        replaceLogo.isVisible = true
                        duration = 1500
                        start()
                    }

                    ObjectAnimator.ofFloat(inputText, "translationX", 0f).apply {
                        duration = 1000
                        start()
                    }
                }
            }

            ObjectAnimator.ofFloat(layoutLogo, "alpha", 0.2f, 1.0f).apply {
                duration = 2000
                start()
            }

            layoutLogo.apply {
//                startAnimation(
//                    AnimationUtils.loadAnimation(
//                        this@MarvelHomeActivity,
//                        R.anim.translate_first
//                    )
//                )

                setOnClickListener {
                    isLoading = true
                    name = inputText.editText?.text.toString()
                    offset = 0
                    mList.clear()
                    mAdapter.notifyDataSetChanged()

                    if (!name.isNullOrBlank()) {
                        setUpObservers(offset, name)
                    } else {
                        setUpObservers(offset, null)
                    }
                }
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
        mList.addAll(list)
        mAdapter.submitList(mList)

        canLoadMore = mAdapter.currentList.size >= 40

        binding.homeRecycler.addOnScrollListener(object :
            PaginationListener(binding.homeRecycler.layoutManager as LinearLayoutManager) {

            override fun loadMoreItems() {

                if (canLoadMore) {
                    isLoading = true
                    offset += PAGINATION_OFFSET

                    runBlocking {
                        delay(1000)
                        setUpObservers(offset)
                    }
                }
            }

            override fun isLoading(): Boolean {
                return isLoading
            }
        })
    }

    private fun handleLoading(isLoading: Boolean) {
        binding.mainProgressBar.apply {

            val slideDown = AnimationUtils.loadAnimation(this@MarvelHomeActivity, R.anim.slide_down)
            val slideTop = AnimationUtils.loadAnimation(this@MarvelHomeActivity, R.anim.slide_top)

            if (isLoading) {
                startAnimation(slideDown)
                isVisible = isLoading
                show()
            } else {
                startAnimation(slideTop)
                isVisible = isLoading
                hide()
            }
        }
    }

    companion object {
        const val PAGINATION_OFFSET = 40
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(listOf(marvelModule))
    }
}
