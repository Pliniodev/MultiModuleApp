package feature.marvelapi.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import feature.commons.utils.StateMachine
import feature.marvelapi.databinding.FragmentOfflineBinding
import feature.marvelapi.marvelModule
import feature.marvelapi.presentation.adapter.SeriesAdapter
import feature.marvelapi.presentation.viewmodel.DataBaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class OfflineFragment : Fragment() {

    private var _binding: FragmentOfflineBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DataBaseViewModel by viewModel()
    private val mAdapter = SeriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOfflineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadKoinModules(marvelModule)
        onEnter()
    }

    private fun onEnter() {
        setUpAdapter()
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.getCachedDAta().observe(viewLifecycleOwner) { event ->
            when (event) {
                is StateMachine.Loading -> some()
                is StateMachine.Success -> {

                    val cachedData = event.value

                    mAdapter.submitList(cachedData)
                }
                is StateMachine.ApiError -> {
                    event.error
                    some()
                }
                is StateMachine.UnknownError -> some()

                else -> some()
            }
        }
    }

    private fun setUpAdapter() {

        binding.rvMain.adapter = mAdapter
    }

    private fun some() {}

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(marvelModule)
        _binding = null
    }
}
