package uz.otamurod.paging3.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.otamurod.paging3.data.repository.Repository
import uz.otamurod.paging3.model.UnsplashImage
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _allImages = MutableStateFlow<PagingData<UnsplashImage>>(PagingData.empty())
    val allImages: StateFlow<PagingData<UnsplashImage>> get() = _allImages

    init {
        getAllImages()
    }

    private fun getAllImages() {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    repository.getAllImages()
                        .cachedIn(viewModelScope)
                        .collectLatest {
                            _allImages.value = it
                        }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching images", e)
            }
        }
    }

    companion object{
        private const val TAG = "HomeViewModel"
    }
}
