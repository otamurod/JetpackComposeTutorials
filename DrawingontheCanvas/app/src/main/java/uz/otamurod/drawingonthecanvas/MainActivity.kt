package uz.otamurod.drawingonthecanvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import uz.otamurod.drawingonthecanvas.helper.activityChooser
import uz.otamurod.drawingonthecanvas.helper.checkAndAskPermission
import uz.otamurod.drawingonthecanvas.helper.saveImage
import uz.otamurod.drawingonthecanvas.ui.components.Root
import uz.otamurod.drawingonthecanvas.ui.screens.HomeScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Root(window = window) {
                HomeScreen {
                    checkAndAskPermission {
                        CoroutineScope(Dispatchers.IO).launch {
                            val uri = saveImage(it)
                            withContext(Dispatchers.Main) {
                                startActivity(activityChooser(uri))
                            }
                        }
                    }
                }
            }
        }
    }
}


