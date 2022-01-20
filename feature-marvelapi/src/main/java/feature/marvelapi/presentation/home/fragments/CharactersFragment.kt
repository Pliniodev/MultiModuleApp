package feature.marvelapi.presentation.home.fragments

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import feature.commons.utils.PaginationListener
import feature.commons.utils.StateMachine
import feature.marvelapi.R
import feature.marvelapi.databinding.FragmentCharactersBinding
import feature.marvelapi.marvelModule
import feature.marvelapi.presentation.home.adapter.MainMarvelAdapter
import feature.marvelapi.presentation.home.viewmodel.MarvelHomeViewModel
import feature.marvelapi.presentation.model.CharactersPresentation
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MarvelHomeViewModel by viewModel()
    private var offset = 0
    private var name: String? = null
    private var isLoading = false
    private var mList = mutableListOf<CharactersPresentation>()
    private var canLoadMore = false
    private val mAdapter = MainMarvelAdapter(){
        val action = CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(it)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadKoinModules(marvelModule)
        onEnter()
    }

    private fun onEnter() {
        setUpObservers(offset)
        initAdapter()
        isLoading = true
        setUpSearchAnimations()
        performSearch()
    }

    private fun setUpObservers(offSet: Int, name: String? = null) {

        viewModel.getCharacters(offSet, name).observe(viewLifecycleOwner) { event ->
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
                        requireContext(),
                        "${event.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is StateMachine.UnknownError -> handleLoading(false)

                else -> handleLoading(false)
            }
        }
    }

    private fun setUpSearchAnimations() {

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
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun performSearch() {

        binding.inputText.editText?.setOnEditorActionListener(object :
            TextView.OnEditorActionListener {

            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    isLoading = true
                    name = binding.inputText.editText?.text.toString()
                    offset = 0
                    mList.clear()
                    mAdapter.notifyDataSetChanged()

                    if (!name.isNullOrBlank()) {
                        setUpObservers(offset, name)
                    } else {
                        setUpObservers(offset, null)
                    }
                    return true
                }
                return false
            }
        })
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

            val slideDown = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_down)
            val slideTop = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_top)

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
        _binding = null
        unloadKoinModules(listOf(marvelModule))
    }
}