package feature.marvelapi.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import feature.marvelapi.databinding.MainRecyclerBinding
import feature.marvelapi.presentation.model.CharactersPresentation

class MainMarvelAdapter :
    androidx.recyclerview.widget.ListAdapter<CharactersPresentation, MainMarvelAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            MainRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: MainRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharactersPresentation) {
            binding.name.text = item.name
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CharactersPresentation>() {
            override fun areItemsTheSame(
                oldItem: CharactersPresentation,
                newItem: CharactersPresentation
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: CharactersPresentation,
                newItem: CharactersPresentation
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}