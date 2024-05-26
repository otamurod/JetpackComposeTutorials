package uz.otamurod.expandablecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.expandablecard.ui.theme.ExpandableCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableCardTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                        .padding(16.dp),
                ) {
                    ExpandableCard(
                        title = "My Title",
                        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus venenatis porttitor orci non pulvinar. Vestibulum leo neque, dictum eget vulputate eu, volutpat in purus. Fusce ultricies malesuada ipsum ac cursus. Nunc pharetra ex quis felis ullamcorper faucibus. Sed rhoncus blandit lorem, a maximus ex gravida vel. Nullam nec dolor viverra, feugiat magna sed, ullamcorper justo. Aenean nec quam semper, blandit massa eget, sagittis nisl. Nunc et molestie nulla. Duis mi odio, egestas id ultricies ac, iaculis id quam. Aenean commodo, dolor at mollis gravida, nibh lorem malesuada justo, in egestas eros tortor vel massa. Fusce laoreet ex sit amet euismod congue. Vestibulum vel nunc in mauris interdum consequat.",
                        shape = RoundedCornerShape(12.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExpandableCardTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(16.dp),
        ) {
            ExpandableCard(
                title = "My Title",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus venenatis porttitor orci non pulvinar. Vestibulum leo neque, dictum eget vulputate eu, volutpat in purus. Fusce ultricies malesuada ipsum ac cursus. Nunc pharetra ex quis felis ullamcorper faucibus. Sed rhoncus blandit lorem, a maximus ex gravida vel. Nullam nec dolor viverra, feugiat magna sed, ullamcorper justo. Aenean nec quam semper, blandit massa eget, sagittis nisl. Nunc et molestie nulla. Duis mi odio, egestas id ultricies ac, iaculis id quam. Aenean commodo, dolor at mollis gravida, nibh lorem malesuada justo, in egestas eros tortor vel massa. Fusce laoreet ex sit amet euismod congue. Vestibulum vel nunc in mauris interdum consequat.",
                shape = RoundedCornerShape(12.dp)
            )
        }
    }
}