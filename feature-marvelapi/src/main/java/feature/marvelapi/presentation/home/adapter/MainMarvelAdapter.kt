package feature.marvelapi.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import feature.commons.utils.BaseItemCallBack
import feature.marvelapi.R
import feature.marvelapi.databinding.MainRecyclerBinding
import feature.marvelapi.presentation.model.CharactersPresentation

internal class MainMarvelAdapter :
    androidx.recyclerview.widget.ListAdapter<CharactersPresentation, MainMarvelAdapter.ViewHolder>(
        BaseItemCallBack<CharactersPresentation>()
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

            binding.apply {
                characterName.text = item.name
                Glide.with(binding.root)
                    .load("${item.thumbnail.path}.${item.thumbnail.extension}")
                    .placeholder(R.drawable.ic_baseline_portrait_24)
                    .centerCrop()
                    .into(characterImage)
            }
        }
    }
}
