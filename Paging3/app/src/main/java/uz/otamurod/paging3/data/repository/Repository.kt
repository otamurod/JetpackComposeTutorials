package uz.otamurod.paging3.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.otamurod.paging3.data.local.UnsplashDatabase
import uz.otamurod.paging3.data.local.dao.UnsplashImageDao
import uz.otamurod.paging3.data.local.dao.UnsplashRemoteKeysDao
import uz.otamurod.paging3.data.paging.SearchPagingSource
import uz.otamurod.paging3.data.paging.UnsplashRemoteMediator
import uz.otamurod.paging3.data.remote.UnsplashApi
import uz.otamurod.paging3.model.UnsplashImage
import uz.otamurod.paging3.util.Constants.ITEMS_PER_PAGE
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase,
    private val unsplashImageDao: UnsplashImageDao,
    private val unsplashRemoteKeysDao: UnsplashRemoteKeysDao
) {
    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unsplashImageDao.getAllImages() } // Single source of truth

        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase,
                unsplashImageDao = unsplashImageDao,
                unsplashRemoteKeysDao = unsplashRemoteKeysDao
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    fun searchImages(query: String): Flow<PagingData<UnsplashImage>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchPagingSource(unsplashApi = unsplashApi, query = query)
            }
        ).flow
    }
}