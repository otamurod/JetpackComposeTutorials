package uz.otamurod.paging3.data.remote

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import uz.otamurod.paging3.BuildConfig
import uz.otamurod.paging3.model.SearchResult
import uz.otamurod.paging3.model.UnsplashImage

interface UnsplashApi {

    @Headers("Authorization: Client-ID ${BuildConfig.UNSPLASH_API_SECRET_KEY}")
    @GET("photos")
    fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<UnsplashImage>

    @Headers("Authorization: Client-ID ${BuildConfig.UNSPLASH_API_SECRET_KEY}")
    @GET("search/photos")
    suspend fun searchImages(
        @Query("query") query: String,
        @Query("per_page") perPage: Int
    ): SearchResult

}