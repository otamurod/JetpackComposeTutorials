package uz.otamurod.paging3.screens.search

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
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

@ExperimentalPagingApi
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> get() = _searchQuery

    private val _searchedImages = MutableStateFlow<PagingData<UnsplashImage>>(PagingData.empty())
    val searchedImages: StateFlow<PagingData<UnsplashImage>> get() = _searchedImages

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun searchHeroes(query: String) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO){
                    repository.searchImages(query = query)
                        .cachedIn(viewModelScope)
                        .collectLatest {
                            _searchedImages.value = it
                        }
                }
            }catch (e:Exception){
                Log.e(TAG, "Error fetching images", e)
            }
        }
    }

    companion object{
        private const val TAG = "SearchViewModel"
    }
}