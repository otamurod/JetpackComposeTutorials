package uz.otamurod.readingsms.model

import java.text.SimpleDateFormat
import java.util.*

data class SMSMessage(
    val message: String,
    val sender: String,
    val date: Long,
    val read: Boolean,
    val type: Int,
    val thread: Int,
    val service: String,
)

fun Long.parsedDate(): String {
    val date = Date(this)
    val dateFormat = SimpleDateFormat("dd/MMM/yyyy HH:mm", Locale.getDefault())
    return dateFormat.format(date)
}