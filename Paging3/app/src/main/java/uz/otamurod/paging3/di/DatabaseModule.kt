package uz.otamurod.paging3.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import uz.otamurod.paging3.data.local.UnsplashDatabase
import uz.otamurod.paging3.data.local.dao.UnsplashImageDao
import uz.otamurod.paging3.data.local.dao.UnsplashRemoteKeysDao
import uz.otamurod.paging3.util.Constants.DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideUnsplashDatabase(@ApplicationContext context: Context): UnsplashDatabase {
        return Room.databaseBuilder(
            context,
            UnsplashDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideUnsplashImageDao(unsplashDatabase: UnsplashDatabase): UnsplashImageDao =
        unsplashDatabase.unsplashImageDao()

    @Provides
    @Singleton
    fun provideUnsplashRemoteKeysDao(unsplashDatabase: UnsplashDatabase): UnsplashRemoteKeysDao =
        unsplashDatabase.unsplashRemoteKeysDao()
}