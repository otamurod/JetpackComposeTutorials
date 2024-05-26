package uz.otamurod.paging3.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.otamurod.paging3.model.UnsplashImage
import uz.otamurod.paging3.util.Constants.UNSPLASH_IMAGE_TABLE

@Dao
interface UnsplashImageDao {
    @Query("SELECT * FROM $UNSPLASH_IMAGE_TABLE")
    fun getAllImages(): PagingSource<Int, UnsplashImage>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addImages(images: List<UnsplashImage>)

    @Query("DELETE FROM $UNSPLASH_IMAGE_TABLE")
    suspend fun deleteAllImages()
}