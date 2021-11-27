package featureexamples.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_examples.databinding.ActivityExamplesHomeBinding
import featureexamples.exampleModule
import featureexamples.presentation.adapter.ExampleAdapter
import featureexamples.presentation.adapter.listener.ExampleClickListener
import featureexamples.presentation.viewmodel.ExampleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class ExamplesHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExamplesHomeBinding
    private lateinit var mListener: ExampleClickListener
    private val mAdapter: ExampleAdapter = ExampleAdapter()

    /**
     * This val viewModel is the instance of our ExampleViewModel, here we are using a library to
     * inject the dependency of this class for us, this library is called of Koin.
     */
    private val viewModel: ExampleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamplesHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadModules()
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
        binding.mainRecycler.adapter = mAdapter
    }

    private fun setObservers() {
        /**
         * As we use LiveData to pass data to the view, we need an observer to be always observing
         * to data changes. In the first parameter we pass "this" activity as the lifeCycleOwner,
         * this means that the observer of this liveData is gonna live while this activity is alive.
         */
        viewModel.exampleList.observe(
            this,
            { exampleList ->
                mAdapter.setList(exampleList)
            }
        )
    }

    /**
     * In here we are capturing the listener implemented in the adapter class
     */
    private fun initListener() {
        mAdapter.attachListener(mListener)
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
        if (mAdapter.data().isNotEmpty()) {
            val item = mAdapter.data()[position]
            item.let { modelExample ->
                val intent = Intent(this, ExampleDetailsActivity::class.java)
                intent.putExtra(INTENT_DETAILS, modelExample.title)
                startActivity(intent)
            }
        }
    }

    private fun loadModules() {
        loadKoinModules(listOf(exampleModule))
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(exampleModule)
    }

    /**
     * We are gonna "storage" the data we want to pass to the another activity in this constant
     */
    companion object {
        const val INTENT_DETAILS = "INTENT_DETAILS"
    }
}
