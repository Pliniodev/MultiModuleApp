package feature.jsonplaceholder.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import feature.commons.utils.StateMachine
import feature.commons.utils.liveResponse
import feature.jsonplaceholder.domain.Post
import feature.jsonplaceholder.domain.service.JsonPlaceHolderService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO

internal class JsonPlaceHolderHomeViewModel(
    private val service: JsonPlaceHolderService,
    private val dispatcher: CoroutineDispatcher = IO
) : ViewModel() {

    fun getPosts(): LiveData<StateMachine<List<Post>>> = liveResponse(dispatcher) {
        service.getPosts()
    }
}
