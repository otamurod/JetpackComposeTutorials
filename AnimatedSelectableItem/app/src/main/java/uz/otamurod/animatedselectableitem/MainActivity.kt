package uz.otamurod.animatedselectableitem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.animatedselectableitem.ui.theme.AnimatedSelectableItemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedSelectableItemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var isSelected by remember { mutableStateOf(false) }
                    var isSelected2 by remember { mutableStateOf(false) }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(80.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SelectableItem(
                            isSelected = isSelected,
                            title = "Lorem Ipsum",
                            onClick = {
                                isSelected = !isSelected
                            }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        SelectableItem(
                            isSelected = isSelected2,
                            title = "Lorem \"Ipsum Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\"",
                            subTitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent viverra pharetra risus sed molestie. Nunc interdum libero velit, dapibus dictum lectus blandit eget. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed non lorem ut augue lobortis venenatis et vel dui. Fusce ut ipsum vel mi efficitur vulputate eget a ipsum. Mauris lobortis erat ut mi fringilla pretium. Vestibulum luctus magna vitae lacus consectetur, ac malesuada nulla elementum. Aenean in augue ligula. Nam at eleifend velit. Donec id interdum diam. Praesent rutrum lorem nisi, a bibendum tortor varius sit amet. Vestibulum sed dolor non lectus placerat condimentum vel lacinia nisl. Cras eget vestibulum diam, pellentesque rhoncus nisl. Suspendisse bibendum odio urna. Curabitur commodo neque ac sapien efficitur, eget egestas nunc faucibus.",
                            onClick = {
                                isSelected2 = !isSelected2
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimatedSelectableItemTheme {
        var isSelected by remember { mutableStateOf(false) }
        var isSelected2 by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SelectableItem(
                isSelected = isSelected,
                title = "Lorem Ipsum",
                onClick = {
                    isSelected = !isSelected
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            SelectableItem(
                isSelected = isSelected2,
                title = "Lorem Ipsum \"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\"",
                subTitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent viverra pharetra risus sed molestie. Nunc interdum libero velit, dapibus dictum lectus blandit eget. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed non lorem ut augue lobortis venenatis et vel dui. Fusce ut ipsum vel mi efficitur vulputate eget a ipsum. Mauris lobortis erat ut mi fringilla pretium. Vestibulum luctus magna vitae lacus consectetur, ac malesuada nulla elementum. Aenean in augue ligula. Nam at eleifend velit. Donec id interdum diam. Praesent rutrum lorem nisi, a bibendum tortor varius sit amet. Vestibulum sed dolor non lectus placerat condimentum vel lacinia nisl. Cras eget vestibulum diam, pellentesque rhoncus nisl. Suspendisse bibendum odio urna. Curabitur commodo neque ac sapien efficitur, eget egestas nunc faucibus.",
                onClick = {
                    isSelected2 = !isSelected2
                }
            )
        }
    }
}