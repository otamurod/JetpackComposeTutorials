package uz.otamurod.pass_object_by_navigation.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val firstName: String,
    val lastName: String
) : Parcelable