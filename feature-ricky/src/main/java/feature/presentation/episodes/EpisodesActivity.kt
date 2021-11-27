package feature.presentation.episodes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import feature.feature_ricky.databinding.ActivityEpisodesBinding
import feature.presentation.EpisodeModel
import feature.presentation.adapter.EpisodesAdapter

class EpisodesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEpisodesBinding
    private val mAdapter = EpisodesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEpisodesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onEnterActivity()
    }

    private fun onEnterActivity() {
        setAdapter()
    }

    private fun setAdapter() {
        val list = listOf(
            EpisodeModel("Titulo 1"),
            EpisodeModel("Titulo 2"),
            EpisodeModel("Titulo 3"),
            EpisodeModel("Titulo 4"),
            EpisodeModel("Titulo 5")
        )

        binding.episodeRecycler.adapter = mAdapter
        mAdapter.setList(list)
    }
}
