package feature.marvelapi.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import feature.marvelapi.data.model.Someeeee
import feature.marvelapi.data.repository.MarvelRepository
import kotlinx.coroutines.runBlocking

class MarvelHomeViewModel(private val repository: MarvelRepository) : ViewModel() {


    val test =  MutableLiveData<Someeeee>()

    init {
        test()
    }

    private fun test() = runBlocking {
        test.value = repository.test()
    }
}