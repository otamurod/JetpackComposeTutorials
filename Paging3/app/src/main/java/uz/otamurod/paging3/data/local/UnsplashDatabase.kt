package uz.otamurod.paging3.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.otamurod.paging3.data.local.dao.UnsplashImageDao
import uz.otamurod.paging3.data.local.dao.UnsplashRemoteKeysDao
import uz.otamurod.paging3.model.UnsplashImage
import uz.otamurod.paging3.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {
    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao
}