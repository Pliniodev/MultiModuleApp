package feature.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import feature.domain.repository.ApiRepository
import feature.presentation.model.InfoPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RickyAndMortyHomeViewModel(
    private val api: ApiRepository
) : ViewModel() {

    private val _info = MutableLiveData<InfoPresentation>()
    val info: LiveData<InfoPresentation> = _info

    private val _episodeInfo = MutableLiveData<Pair<String?, Int?>>()
    val episodeInfo: LiveData<Pair<String?, Int?>> = _episodeInfo

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> = _errorMsg

    fun getInfoObserver(): MutableLiveData<InfoPresentation> {
        return _info
    }

    fun getEpisodes() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                api.getEpisodeInfo()
            }.onSuccess {
                _episodeInfo.postValue(
                    Pair(it.next, it.count)
                )
            }.onFailure { exception -> _errorMsg.postValue(exception.message) }
        }
    }
}