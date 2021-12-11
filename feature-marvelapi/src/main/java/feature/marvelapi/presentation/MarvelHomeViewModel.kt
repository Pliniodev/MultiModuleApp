package feature.marvelapi.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import feature.marvelapi.data.model.Someeeee
import feature.marvelapi.data.repository.MarvelRepository
import kotlinx.coroutines.launch

class MarvelHomeViewModel(private val repository: MarvelRepository) : ViewModel() {

    val test = MutableLiveData<Someeeee>()

    init {
        test()
    }

    private fun test()  {

        viewModelScope.launch {
            test.value = repository.test()
        }
    }
}