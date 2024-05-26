package uz.otamurod.drawingonthecanvas.ui.components

import android.view.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import uz.otamurod.drawingonthecanvas.ui.theme.DrawBoxTheme
import uz.otamurod.drawingonthecanvas.ui.theme.StatusBarConfig
import uz.otamurod.drawingonthecanvas.ui.theme.isSystemInDarkThemeCustom

@Composable
fun Root(window: Window, content: @Composable () -> Unit) {
    val isDark = isSystemInDarkThemeCustom()
    DrawBoxTheme(isDark) {
        window.StatusBarConfig(isDark)
        Surface(color = MaterialTheme.colors.background) {
            content.invoke()
        }
    }
}