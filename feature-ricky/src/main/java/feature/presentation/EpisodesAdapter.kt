package feature.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import feature.feature_ricky.databinding.ItemEpisodesBinding

class EpisodesAdapter() : RecyclerView.Adapter<EpisodesAdapter.ViewHolder>() {

    private lateinit var mListener: ClickListener
    private var episodes: List<EpisodeModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemEpisodesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(episodes[position])
    }

    override fun getItemCount(): Int = episodes.size

    inner class ViewHolder(private val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(episode: EpisodeModel) {
            binding.episodeName.text = episode.title
        }

        init {
            binding.root.setOnClickListener {
                mListener.onClick(adapterPosition)
            }
        }
    }

    fun setList(list: List<EpisodeModel>) {
        episodes = list
    }

    fun attachListener(listener: ClickListener) {
        mListener = listener
    }

    fun data() = episodes
}
