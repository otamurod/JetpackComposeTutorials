package uz.otamurod.paging3.model

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @Embedded
    val links: Links,
    val username: String
)