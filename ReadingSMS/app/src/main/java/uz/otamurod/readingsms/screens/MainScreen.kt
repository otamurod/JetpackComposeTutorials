package uz.otamurod.readingsms.screens

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import uz.otamurod.readingsms.components.MessageView
import uz.otamurod.readingsms.components.SenderView
import uz.otamurod.readingsms.model.SMSMessage
import uz.otamurod.readingsms.model.parsedDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
    val context = LocalContext.current
    val allMessages = remember {
        mutableStateMapOf<String, List<SMSMessage>>()
    }

    LaunchedEffect(key1 = Unit) {
        val messages = readMessages(context = context, type = "inbox") +
                readMessages(context = context, type = "sent")
        allMessages += messages.sortedBy { it.date }.groupBy { it.sender }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface)
    ) {
        allMessages.forEach { (sender, messages) ->
            stickyHeader(key = sender) {
                SenderView(sender = sender)
            }

            messages.groupBy { it.date.parsedDate().split(" ").first() }
                .forEach { (date, smsMessages) ->
                    item {
                        Text(
                            text = date, modifier = Modifier
                                .fillMaxWidth()
                                .alpha(0.38f),
                            textAlign = TextAlign.Center,
                            fontSize = MaterialTheme.typography.body2.fontSize,
                            color = MaterialTheme.colors.onSurface
                        )
                    }

                    items(
                        items = smsMessages,
                        key = { it.date }
                    ) {
                        MessageView(message = it)
                    }
                }
        }
    }
}

private fun readMessages(context: Context, type: String): List<SMSMessage> {
    val messages = mutableListOf<SMSMessage>()
    val cursor = context.contentResolver.query(
        Uri.parse("content://sms/$type"),
        null,
        null,
        null,
        null
    )
    cursor?.use {
        val indexMessage = it.getColumnIndex("body")
        val indexSender = it.getColumnIndex("address")
        val indexDate = it.getColumnIndex("date")
        val indexRead = it.getColumnIndex("read")
        val indexType = it.getColumnIndex("type")
        val indexThread = it.getColumnIndex("thread_id")
        val indexService = it.getColumnIndex("service_center")

        while (it.moveToNext()) {
            messages.add(
                SMSMessage(
                    message = it.getString(indexMessage),
                    sender = it.getString(indexSender),
                    date = it.getLong(indexDate),
                    read = it.getString(indexRead).toBoolean(),
                    type = it.getInt(indexType),
                    thread = it.getInt(indexThread),
                    service = it.getString(indexService) ?: ""
                )
            )
        }
    }

    return messages
}

@Preview(name = "MainScreen")
@Composable
private fun PreviewMainScreen() {
    MainScreen()
}