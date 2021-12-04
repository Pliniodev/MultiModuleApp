package feature.jsonplaceholder.presentation.home

import androidx.lifecycle.*
import feature.commons.utils.safeRequest
import feature.jsonplaceholder.domain.service.JsonPlaceHolderService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO

internal class JsonPlaceHolderHomeViewModel(
    private val service: JsonPlaceHolderService,
    private val dispatcher: CoroutineDispatcher = IO
) : ViewModel() {

    fun getPosts() = liveData {
        emit(safeRequest(dispatcher) { service.getPosts() })
    }
}
