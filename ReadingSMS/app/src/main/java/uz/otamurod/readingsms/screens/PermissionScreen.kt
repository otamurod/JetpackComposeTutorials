package uz.otamurod.readingsms.screens

import android.Manifest
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@Composable
fun PermissionScreen(onPermissionGranted: () -> Unit) {
    RequestSmsPermission(onPermissionGranted = onPermissionGranted)
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestSmsPermission(onPermissionGranted: () -> Unit) {
    val readSmsPermission = rememberPermissionState(permission = Manifest.permission.READ_SMS)

    if (readSmsPermission.status.isGranted) {
        onPermissionGranted()
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val textToSHow = if (readSmsPermission.status.shouldShowRationale) {
                "Permission is important for this app. Please grant the permission!"
            } else {
                "Permission required for this app to work. Please grant the permission!"
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 20.dp),
                text = textToSHow,
                textAlign = TextAlign.Center
            )

            Button(onClick = { readSmsPermission.launchPermissionRequest() }) {
                Text(text = "Request Permission")
            }
        }
    }
}

@Preview(name = "PermissionScreen")
@Composable
private fun PreviewPermissionScreen() {
    PermissionScreen({})
}