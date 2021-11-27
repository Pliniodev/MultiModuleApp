package feature.ricky.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import feature.ricky.domain.repository.DogsApiRepository
import feature.ricky.presentation.model.BreedPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class DogsHomeViewModel(
    private val api: DogsApiRepository
) : ViewModel() {

    private val _breedsByPage = MutableLiveData<List<BreedPresentation>>()
    val breeds: LiveData<List<BreedPresentation>> = _breedsByPage

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> = _errorMsg

    fun getBreedsList(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                api.getBreeds(page)
            }.onSuccess { breedPresentations ->
                _breedsByPage.postValue(breedPresentations)
            }.onFailure { exception -> _errorMsg.postValue(exception.message) }
        }
    }
}
