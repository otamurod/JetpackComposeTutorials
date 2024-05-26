package uz.otamurod.animatedsplashscreen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import uz.otamurod.animatedsplashscreen.navigation.Screen
import uz.otamurod.animatedsplashscreen.ui.theme.Purple700

@Composable
fun AnimatedSplashScreen(
    navHostController: NavHostController
) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navHostController.popBackStack()
        navHostController.navigate(Screen.Home.route)
    }

    Splash(alphaAnim.value)
}

@Preview(name = "AnimatedSplashScreen", showBackground = true, showSystemUi = true)
@Composable
private fun PreviewAnimatedSplashScreen() {
    val navController = rememberNavController()
    AnimatedSplashScreen(navController)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else Purple700)
            .fillMaxSize()
            .alpha(alpha = alpha),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(120.dp),
            imageVector = Icons.Default.Face,
            contentDescription = "Logo Icon",
            tint = Color.White,
        )
    }
}

@Preview(name = "Splash", showBackground = true, showSystemUi = true)
@Composable
private fun PreviewSplash() {
    Splash(alpha = 1f)
}

@Preview(name = "Splash", showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PreviewSplashDark() {
    Splash(alpha = 1f)
}