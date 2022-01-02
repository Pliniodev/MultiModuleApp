package feature.marvelapi.presentation.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import feature.marvelapi.R
import feature.marvelapi.databinding.FragmentCharactersBinding
import feature.marvelapi.databinding.FragmentComicsBinding

class ComicsFragment : Fragment() {

    private var _binding: FragmentComicsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onEnter()
    }

    private fun onEnter() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}