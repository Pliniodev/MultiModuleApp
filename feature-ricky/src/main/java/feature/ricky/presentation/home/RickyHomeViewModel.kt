package feature.ricky.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import feature.ricky.domain.repository.ApiRepository
import feature.ricky.presentation.model.EpisodePresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class RickyHomeViewModel(
    private val api: ApiRepository
) : ViewModel() {

    private val _episode = MutableLiveData<EpisodePresentation>()
    val episode: LiveData<EpisodePresentation> = _episode

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> = _errorMsg

    fun getEpisodes() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching { api.getEpisode() }
                .onSuccess { _episode.postValue(it) }
                .onFailure { exception -> _errorMsg.postValue(exception.message) }
        }
    }
}
