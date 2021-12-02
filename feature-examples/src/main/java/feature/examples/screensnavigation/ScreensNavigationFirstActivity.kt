package feature.examples.screensnavigation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_examples.R
import com.example.feature_examples.databinding.ActivityScreensNavigationFirstBinding
import feature.commons.utils.navigateAndAggregate
import feature.commons.utils.navigateTo
import feature.examples.screensnavigation.model.Address
import feature.examples.screensnavigation.model.StrangePerson

/**
 * Using -> navigateTo
 * We simply pass the activity to go in <>. Ex:
 * navigateTo<ActivityToGo>()
 *
 * Using -> navigateAndAggregate
 * We pass on <> the activity to go and the type of object that we want to send to other activity,
 * on constructor, we pass the intentName(String) and the object that we want to send. Ex:
 * navigateAndAggregate<ActivityToGo, TypeOfObjectToPassWithIntent>(
 *      intentName = OBJECT_NAME_CONSTANT,
 *      send = objectToSend
 * )
 *
 * Using a overload of -> navigateAndAggregate
 * We pass the activity to go in <> and in this case we can send many intents using putExtra or,
 * we can do some extra configs on scope or intent. Ex:
 * navigateAndAggregate<ActivityToGo> {
 *      putExtras(nameOfObjectToSend, objectToSend)
 *      here we can do some extra config in intent scope if we want
 * }
 */

/**
 * PLUS :D -> Other way to use OnClickListener
 * In this case we extends View.OnCLickListener Interface and using "when", we can create a
 * condition to each "id" of the views.
 */
internal class ScreensNavigationFirstActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityScreensNavigationFirstBinding
    private val person = StrangePerson(
        name = "Fulano da Silva",
        age = 1,
        address = Address(
            street = "Rua dos morros",
            postalCode = 123L
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreensNavigationFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.proccedBtn.setOnClickListener(this)
        binding.agregateAndproccedBtn.setOnClickListener(this)
        binding.agregateVariousAndproccedBtn.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.proccedBtn -> navigateTo<ScreenNavigationSecondActivity>()
            R.id.agregateAndproccedBtn -> {
                navigateAndAggregate<ScreenNavigationSecondActivity, String>(
                    intentName = FIRST_INTENT,
                    send = "This is the firs intent"
                )
            }
            R.id.agregateVariousAndproccedBtn -> {
                navigateAndAggregate<ScreenNavigationSecondActivity> {
                    putExtra(SECOND_INTENT, 1)
                    putExtra(THIRD_INTENT, person)
                }
            }
        }
    }
    companion object {
        const val FIRST_INTENT = "first.intent"
        const val SECOND_INTENT = "second.intent"
        const val THIRD_INTENT = "third.intent"
    }
}
