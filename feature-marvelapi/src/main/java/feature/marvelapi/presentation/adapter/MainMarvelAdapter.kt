package feature.marvelapi.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import feature.commons.utils.BaseItemCallBack
import feature.marvelapi.R
import feature.marvelapi.databinding.CharactersCardRecyclerBinding
import feature.marvelapi.presentation.model.CharactersPresentation
import androidx.recyclerview.widget.ListAdapter

internal class MainMarvelAdapter(private val onClick: (id: Int) -> Unit = {}) :
    ListAdapter<CharactersPresentation, MainMarvelAdapter.ViewHolder>(
        BaseItemCallBack<CharactersPresentation>()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            CharactersCardRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: CharactersCardRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharactersPresentation) {

            val imagePath = "${item.thumbnail.path}/portrait_incredible.${item.thumbnail.extension}"

            binding.apply {
                characterName.text = item.name
                Glide.with(binding.root)
                    .load(imagePath)
                    .placeholder(R.drawable.ic_baseline_portrait_24)
                    .centerCrop()
                    .into(characterImage)
            }

            itemView.setOnClickListener {
                onClick.invoke(item.id)
            }
        }
    }
}
