package feature.marvelapi.presentation.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import feature.marvelapi.databinding.FragmentSeriesBinding
import feature.marvelapi.marvelModule
import feature.marvelapi.presentation.home.adapter.SeriesAdapter
import feature.marvelapi.presentation.home.viewmodel.SeriesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class SeriesFragment : Fragment() {

    private var _binding: FragmentSeriesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SeriesViewModel by viewModel()
    private val mAdapter = SeriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadKoinModules(marvelModule)
        onEnter()
    }

    private fun onEnter() {
        setList()
        setUpObservers()
    }

    private fun setUpObservers() {
//        viewModel.getSeries().observe(viewLifecycleOwner) { event ->
//            when (event) {
//                is StateMachine.Loading -> some()
//                is StateMachine.Success -> {
//
//                    val something = event.value.data.results
//
//                    mAdapter.submitList(something)
//                    mAdapter.notifyDataSetChanged()
//                }
//                is StateMachine.ApiError -> {
//                    event.error
//                    some()
//                }
//                is StateMachine.UnknownError -> some()
//
//                else -> some()
//            }
//        }
    }

    private fun setList() {

        binding.rvMain.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }

    private fun some() {}

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(listOf(marvelModule))
        _binding = null
    }
}
