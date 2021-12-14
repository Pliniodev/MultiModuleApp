package feature.dogs.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import feature.dogs.presentation.model.BreedPresentation
import feature.feature_dogs.R
import feature.feature_dogs.databinding.ItemDogsFeatureBinding

internal class DogsAdapter(
    private val breedPresentations: List<BreedPresentation> = mutableListOf(),
    val action: (BreedPresentation) -> Unit
) : RecyclerView.Adapter<DogsAdapter.DogsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
        val binding = ItemDogsFeatureBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return DogsViewHolder(binding, onClick = { breed -> action(breed) })
    }

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        holder.bind(breedPresentations[position])
    }

    override fun getItemCount() = breedPresentations.size

    inner class DogsViewHolder(
        private val binding: ItemDogsFeatureBinding,
        private val onClick: (BreedPresentation) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(breedPresentation: BreedPresentation) {
            binding.apply {
                title.text = breedPresentation.name
                root.setOnClickListener { onClick(breedPresentation) }
                Glide.with(root.context)
                    .load(breedPresentation.image?.url)
                    .placeholder(R.drawable.ic_baseline_portrait_24)
                    .into(binding.dogsImage)
            }
        }
    }
}
