package feature.marvelapi.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import feature.marvelapi.databinding.MainRecyclerBinding
import feature.marvelapi.presentation.model.SomePresentation

class MainMarvelAdapter :
    androidx.recyclerview.widget.ListAdapter<SomePresentation, MainMarvelAdapter.ViewHolder>(
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

        fun bind(item: SomePresentation) {
            binding.name.text = item.name
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SomePresentation>() {
            override fun areItemsTheSame(
                oldItem: SomePresentation,
                newItem: SomePresentation
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: SomePresentation,
                newItem: SomePresentation
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}