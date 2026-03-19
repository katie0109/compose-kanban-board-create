package woowacourse.kanban.board

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kanban Board",
    ) {
        App()
    }
}
