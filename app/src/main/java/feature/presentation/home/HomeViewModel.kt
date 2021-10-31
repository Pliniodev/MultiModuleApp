package feature.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import feature.presentation.FeatureFlag
import feature.presentation.FeaturePresentation

internal class HomeViewModel: ViewModel() {
    private val _featureList = MutableLiveData<List<FeaturePresentation>>()
    val featureList: LiveData<List<FeaturePresentation>> = _featureList

    fun getFeaturesList() {
        val features = mutableListOf<FeaturePresentation>()
        for (feature in FeatureFlag.values()){
            features.add(FeaturePresentation(feature))
        }
        _featureList.value = features
    }
}