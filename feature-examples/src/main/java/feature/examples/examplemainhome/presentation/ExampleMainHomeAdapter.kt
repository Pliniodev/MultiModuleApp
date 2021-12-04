package feature.examples.examplemainhome.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_examples.databinding.ItemMainHomeExampleBinding
import feature.examples.examplemainhome.ExampleFlag
import feature.examples.examplemainhome.ExamplesMainPresentation

internal class ExampleMainHomeAdapter(
    val action: (ExampleFlag) -> Unit,
    val presentations: List<ExamplesMainPresentation>
) : RecyclerView.Adapter<ExampleMainHomeAdapter.ExampleMainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleMainViewHolder {
        val binding = ItemMainHomeExampleBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ExampleMainViewHolder(binding, onClick = { exampleFlag -> action(exampleFlag) })
    }

    override fun onBindViewHolder(holder: ExampleMainViewHolder, position: Int) {
        holder.bind(presentations[position])
    }

    override fun getItemCount() = presentations.size

    inner class ExampleMainViewHolder(
        private val binding: ItemMainHomeExampleBinding,
        private val onClick: (ExampleFlag) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(examplePresentation: ExamplesMainPresentation) {
            binding.apply {
                exampleTitle.text = root.context.getString(examplePresentation.title)
                root.setOnClickListener { onClick(examplePresentation.exampleFlag) }
            }
        }
    }
}
