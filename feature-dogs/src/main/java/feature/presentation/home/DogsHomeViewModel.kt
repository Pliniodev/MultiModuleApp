package feature.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import feature.domain.repository.DogsApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class DogsHomeViewModel(
    private val api: DogsApiRepository
) : ViewModel(){

    private val _breedsByPage = MutableLiveData<String>()
    val breeds: LiveData<String> = _breedsByPage

    fun getApi(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                api.getBreeds(page)
            }.onSuccess {
                for (breed in it){
                    _breedsByPage.postValue(breed.name)
                }

            }
//                .onFailure { exception -> _errorMsg.postValue(exception.message) }
        }
    }
}