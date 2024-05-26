package uz.otamurod.swipablecomponent

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import uz.otamurod.swipablecomponent.ui.theme.SwipableComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipableComponentTheme {

                val archive = SwipeAction(
                    onSwipe = {
                        Log.d("MainActivity", "onCreate: Archive")
                    },
                    icon = {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Archive",
                                style = TextStyle(
                                    color = MaterialTheme.colors.onPrimary,
                                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                modifier = Modifier.padding(16.dp),
                                painter = painterResource(id = R.drawable.ic_archive),
                                contentDescription = "Archive Icon",
                                tint = Color.White
                            )
                        }
                    },
                    isUndo = true,
                    background = Color.Green
                )

                val email = SwipeAction(
                    onSwipe = {
                        Log.d("MainActivity", "onCreate: Email")
                    },
                    icon = {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.padding(16.dp),
                                painter = painterResource(id = R.drawable.ic_email),
                                contentDescription = "Archive Icon",
                                tint = Color.White
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Send Email",
                                style = TextStyle(
                                    color = MaterialTheme.colors.onPrimary,
                                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }
                    },
                    background = Color.Blue
                )

                SwipeableActionsBox(
                    startActions = listOf(archive),
                    endActions = listOf(email),
                    swipeThreshold = 100.dp
                ) {
                    Row(
                        modifier = Modifier
                            .background(MaterialTheme.colors.surface)
                            .padding(horizontal = 16.dp)
                            .padding(vertical = 8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(size = 50.dp))
                                .background(MaterialTheme.colors.primary)
                                .size(50.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(modifier = Modifier.weight(7f)) {
                            Text(
                                text = "Title",
                                style = TextStyle(
                                    fontSize = MaterialTheme.typography.h5.fontSize,
                                    fontWeight = FontWeight.Bold
                                )
                            )

                            Text(text = "Some random text")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SwipableComponentTheme {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .padding(horizontal = 16.dp)
                .padding(vertical = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(size = 50.dp))
                    .background(MaterialTheme.colors.primary)
                    .size(50.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(7f)) {
                Text(
                    text = "Title",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(text = "Some random text")
            }
        }
    }
}