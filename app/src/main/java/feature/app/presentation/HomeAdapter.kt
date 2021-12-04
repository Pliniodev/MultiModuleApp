package feature.app.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import feature.app.FeatureFlag
import feature.multimoduleapp.databinding.ItemHomeFeatureBinding

internal class HomeAdapter(
    val action: (FeatureFlag) -> Unit,
    val presentations: List<FeaturePresentation>
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeFeatureBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding, onClick = { featureFlag -> action(featureFlag) })
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(presentations[position])
    }

    override fun getItemCount() = presentations.size

    inner class HomeViewHolder(
        private val binding: ItemHomeFeatureBinding,
        private val onClick: (FeatureFlag) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(featurePresentation: FeaturePresentation) {
            binding.apply {
                with(root.context) {
                    title.text = getString(featurePresentation.title)
                    root.setOnClickListener { onClick(featurePresentation.featureFlag) }
                }
            }
        }
    }
}
