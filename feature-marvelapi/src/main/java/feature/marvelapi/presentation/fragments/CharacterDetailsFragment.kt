package feature.marvelapi.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import feature.commons.utils.StateMachine
import feature.marvelapi.data.localdatasource.entity.CharacterEntity
import feature.marvelapi.databinding.FragmentCharacterDetailsBinding
import feature.marvelapi.marvelModule
import feature.marvelapi.presentation.viewmodel.CharacterDetailsViewModel
import feature.marvelapi.presentation.model.CharactersPresentation
import feature.marvelapi.presentation.model.ImagesPresentation
import feature.marvelapi.presentation.notification.MarvelNotificationManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class CharacterDetailsFragment : Fragment() {

    private var _binding: FragmentCharacterDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: CharacterDetailsFragmentArgs by navArgs()
    private val viewModel: CharacterDetailsViewModel by viewModel()
    private val notificationMn: MarvelNotificationManager by lazy { MarvelNotificationManager() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadKoinModules(marvelModule)
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
                    binding.characterName.text = state.value.name

                    binding.saveCharacter.setOnClickListener {
                        saveCharacter(state.value)
                        notificationMn.createDefaultNotification(requireActivity())
                    }
                    loadCharacterImage(state.value.thumbnail)
                }
                is StateMachine.ApiError -> {
                    Toast.makeText(requireContext(), "${state.error}", Toast.LENGTH_SHORT).show()
                }
                is StateMachine.UnknownError -> doNothing()
                is StateMachine.Finish -> doNothing()
            }
        }
    }

    private fun loadCharacterImage(path: ImagesPresentation) {
        val url = "${path.path}/landscape_amazing.${path.extension}"

        Glide.with(this)
            .load(url)
            .into(binding.characterImage)
    }

    private fun saveCharacter(characterRemote: CharactersPresentation) {

        val character = CharacterEntity(name = characterRemote.name)

        viewModel.saveCharacterOnDB(character)


    }

    private fun doNothing() {}

    override fun onDestroyView() {
        super.onDestroyView()
        unloadKoinModules(marvelModule)
        _binding = null
    }
}
