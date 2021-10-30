package feature.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_examples.databinding.ItemExampleRecyclerBinding
import feature.presentation.model.ExampleModel
import feature.utils.ExampleClickListener
/**
 * This class has the responsibility to recycler our views from a list. Every time that we do
 * a scroll in the screen, the recyclerView "recycle" the views.
 *
 * RecyclerView needs three things to work:
 * - An Adapter(This class);
 * - An ViewHolder(The inner class);
 * - An view to inflate every time that a new element appears in the list(item_example_recycler.xml).
 */
class ExampleAdapter(
) : RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {

    /**
     * This variable (mListener) is responsible for make every view clickable.
     */
    private lateinit var mListener: ExampleClickListener
    private var items: List<ExampleModel> = mutableListOf()

    /**
     * inflate our views in the list. Notice that in here we are using viewBinding.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemExampleRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    /**
     *  makes the binding between the view recycled and the data that it's
     * gonna change.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(items[position])
    }

    /**
     * we just say to the recycler the size of our list to be inflated.
     */
    override fun getItemCount(): Int = items.size

    /**
     *  is gonna make the changes in every view.
     */
    inner class ViewHolder(private val binding: ItemExampleRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Here we are just making the title from our model be displayed in the view.
         */
        fun bind(example: ExampleModel) {
            binding.mainTitle.text = example.title
        }

        /**
         *  just to initialize the click in every view.
         */
        init {
            binding.root.setOnClickListener {
                mListener.onClick(adapterPosition)
            }
        }
    }

    /**
     * This is gonna be called on the view to set the data to the adapter.
     */
    fun setList(list: List<ExampleModel>) {
        items = list
    }

    /**
     * make the activity know that we have a clickListener.
     */
    fun attachListener(listener: ExampleClickListener) {
        mListener = listener
    }

    /**
     * Right now this method is just to say to the activity what we have inside of our list.
     * CTRL+left - click to navigate we we are using this method.
     */
    fun data() = items
}