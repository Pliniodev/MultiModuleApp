package feature.marvelapi.presentation.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import feature.commons.utils.StateMachine
import feature.marvelapi.databinding.FragmentCharacterDetailsBinding
import feature.marvelapi.presentation.home.viewmodel.CharacterDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment : Fragment() {

    private var _binding: FragmentCharacterDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: CharacterDetailsFragmentArgs by navArgs()
    private val viewModel: CharacterDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onEnter()
    }

    private fun onEnter() {
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.getCharacterDetails(args.characterId).observe(viewLifecycleOwner) { state ->
            when (state) {
                is StateMachine.Loading -> doNothing()
                is StateMachine.Success -> {
                    binding.testTv.text = state.value.name
                }
                is StateMachine.ApiError -> {
                    Toast.makeText(requireContext(), "${state.error}", Toast.LENGTH_SHORT).show()
                }
                is StateMachine.UnknownError -> doNothing()
                is StateMachine.Finish -> doNothing()
            }
        }
    }

    private fun doNothing() {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}