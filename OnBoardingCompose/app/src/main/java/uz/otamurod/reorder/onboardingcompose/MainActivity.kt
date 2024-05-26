package uz.otamurod.reorder.onboardingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.otamurod.reorder.onboardingcompose.data.DataStoreRepository
import uz.otamurod.reorder.onboardingcompose.navigation.Screen.Welcome
import uz.otamurod.reorder.onboardingcompose.navigation.SetUpNavGraph
import uz.otamurod.reorder.onboardingcompose.ui.theme.OnBoardingComposeTheme
import uz.otamurod.reorder.onboardingcompose.viewmodel.SplashViewModel
import uz.otamurod.reorder.onboardingcompose.viewmodel.SplashViewModelProviderFactory

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = DataStoreRepository(this)
        val viewModelFactory = SplashViewModelProviderFactory(repository)
        val splashViewModel = ViewModelProvider(this, viewModelFactory)[SplashViewModel::class.java]

        installSplashScreen().setKeepOnScreenCondition {
            !splashViewModel.isLoading.value
        }

        setContent {
            OnBoardingComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val screen by splashViewModel.startDestination
                    val navHostController = rememberNavController()
                    if (screen != "") {
                        SetUpNavGraph(
                            navHostController = navHostController,
                            startDestination = screen
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
    OnBoardingComposeTheme {
        SetUpNavGraph(navHostController = rememberNavController(), Welcome.route)
    }
}