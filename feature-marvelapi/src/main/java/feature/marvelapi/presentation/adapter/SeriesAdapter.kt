package feature.marvelapi.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import feature.commons.utils.BaseItemCallBack
import feature.marvelapi.R
import feature.marvelapi.data.localdatasource.entity.CharacterEntity
import feature.marvelapi.databinding.SeriesCardBinding

internal class SeriesAdapter :
    ListAdapter<CharacterEntity, SeriesAdapter.ViewHolder>(BaseItemCallBack<CharacterEntity>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            SeriesCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: SeriesCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterEntity) {

            binding.apply {
                tvTitle.text = item.name
                Glide.with(binding.root)
                    .load(item.image)
                    .placeholder(R.drawable.ic_baseline_portrait_24)
                    .centerCrop()
                    .into(characterImage)
            }
        }
    }
}