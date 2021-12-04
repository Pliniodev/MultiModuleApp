package feature.examples.apirequest.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import feature.examples.apirequest.domain.Post
import feature.examples.apirequest.domain.service.JsonPlaceHolderService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class ExampleApiRequestHomeViewModel(
    private val service: JsonPlaceHolderService
) : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> = _errorMsg

    fun getPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                service.getPosts()
            }.onSuccess {
                _posts.postValue(it)
            }.onFailure { exception -> _errorMsg.postValue(exception.message) }
        }
    }
}
