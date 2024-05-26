package uz.otamurod.paging3.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.otamurod.paging3.model.UnsplashRemoteKeys
import uz.otamurod.paging3.util.Constants.UNSPLASH_REMOTE_KEYS_TABLE

@Dao
interface UnsplashRemoteKeysDao {
    @Query("SELECT * FROM $UNSPLASH_REMOTE_KEYS_TABLE WHERE id =:id")
    suspend fun getRemoteKeys(id: String): UnsplashRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<UnsplashRemoteKeys>)

    @Query("DELETE FROM $UNSPLASH_REMOTE_KEYS_TABLE")
    suspend fun deleteAllRemoteKeys()
}