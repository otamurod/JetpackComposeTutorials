package uz.otamurod.reorder.onboardingcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.otamurod.reorder.onboardingcompose.data.DataStoreRepository

class SplashViewModelProviderFactory(private val repository: DataStoreRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SplashViewModel(repository) as T
    }
}