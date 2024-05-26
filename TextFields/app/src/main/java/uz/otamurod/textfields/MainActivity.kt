package uz.otamurod.textfields

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.rounded.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.textfields.ui.theme.TextFieldsTheme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember { mutableStateOf("TextField. Type here...") }
        var text2 by remember { mutableStateOf("OutlinedTextField. Type here...") }
        var text3 by remember { mutableStateOf("BasicTextField. Type here...") }
        TextField(value = text, onValueChange = { newText ->
            text = newText
        },
            label = { Text("Email") },
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Rounded.Email, contentDescription = "Email Icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    Log.d(TAG, "Greeting: Done Clicked")
                }
            )
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(value = text2, onValueChange = { newText ->
            text = newText
        },
            label = { Text("Email") },
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Rounded.Email, contentDescription = "Email Icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    Log.d(TAG, "Greeting: Done Clicked")
                }
            )
        )
        Spacer(modifier = Modifier.height(12.dp))

        BasicTextField(modifier = Modifier
            .background(Color.LightGray)
            .padding(16.dp),
            value = text3,
            onValueChange = { newText ->
                text = newText
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    Log.d(TAG, "Greeting: Done Clicked")
                }
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextFieldsTheme {
        Greeting("Android")
    }
}