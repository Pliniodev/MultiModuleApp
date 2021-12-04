package feature.examples.recyclerview.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_examples.databinding.ActivityRecyclerExampleBinding
import feature.commons.utils.navigateTo
import feature.examples.exampleModule
import feature.examples.recyclerview.presentation.adapter.RecyclerExampleAdapter
import feature.examples.recyclerview.presentation.adapter.listener.ExampleClickListener
import feature.examples.recyclerview.presentation.viewmodel.ExampleRecyclerViewModel
import feature.examples.screensnavigation.ScreensNavigationFirstActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

internal class ExamplesRecyclerHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerExampleBinding
    private lateinit var mListener: ExampleClickListener
    private val mAdapterRecycler: RecyclerExampleAdapter = RecyclerExampleAdapter()

    /**
     * This val viewModel is the instance of our ExampleViewModel, here we are using a library to
     * inject the dependency of this class for us, this library is called of Koin.
     */
    private val recyclerViewModel: ExampleRecyclerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**
         * In this onCreate method, it's a good practice just instantiate your methods to configure
         * your screen.
         */
        onEnterActivity()
    }

    private fun onEnterActivity() {
        setAdapter()
        setListener()
        initListener()
        setObservers()
    }

    private fun setAdapter() {
        /**
         * In here we are saying to the recyclerView who is gonna be the adapter for it.
         */
        binding.mainRecycler.adapter = mAdapterRecycler
    }

    private fun setObservers() {
        /**
         * As we use LiveData to pass data to the view, we need an observer to be always observing
         * to data changes. In the first parameter we pass "this" activity as the lifeCycleOwner,
         * this means that the observer of this liveData is gonna live while this activity is alive.
         */
        recyclerViewModel.exampleList.observe(
            this,
            { exampleList ->
                mAdapterRecycler.setList(exampleList)
            }
        )
    }

    /**
     * In here we are capturing the listener implemented in the adapter class
     */
    private fun initListener() {
        mAdapterRecycler.attachListener(mListener)
    }

    private fun setListener() {
        /**
         * an object to implement our click. In this case, wen the view is clicked, we
         * pass the data that is contained in that position to the other screen.
         */
        mListener = object : ExampleClickListener {
            override fun onClick(position: Int) {
                sendExtras(position)
            }
        }
    }

    /**
     * This is the most simple way to pass data between screens. Using an intent, we can use a
     * simple constant to "storage" this data and receive it in the other screen.
     */
    private fun sendExtras(position: Int) {
        if (mAdapterRecycler.data().isNotEmpty()) {
            val item = mAdapterRecycler.data()[position]
            item.let { modelExample ->
                if (modelExample.title?.equals("Usando o Navigator") == true) {
                    navigateTo<ScreensNavigationFirstActivity>()
                } else {
                    val intent = Intent(this, ExampleRecyclerDetailsActivity::class.java)
                    intent.putExtra(INTENT_DETAILS, modelExample.title)
                    startActivity(intent)
                }
            }
        }
    }

    /**
     * We are gonna "storage" the data we want to pass to the another activity in this constant
     */
    companion object {
        const val INTENT_DETAILS = "INTENT_DETAILS"
    }
}
