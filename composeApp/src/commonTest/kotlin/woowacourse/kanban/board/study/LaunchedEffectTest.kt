package woowacourse.kanban.board.study

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class LaunchedEffectTest {

    @Test
    fun launchedEffect() = runComposeUiTest {
        var flag = mutableStateOf(true)
        var count = 0
        setContent{
            LaunchedEffect(key1 = flag){
                count++
            }
        }
        waitForIdle()
        assertThat(count).isEqualTo(1)
        flag.value = false
        waitForIdle()
        assertThat(count).isEqualTo(1)
    }
    @Test
    fun launchedEffectTrigger() = runComposeUiTest {
        var count = 0
        setContent {
            var trigger by remember { mutableStateOf(false) }

            LaunchedEffect(key1 = trigger) {
                count++
            }
            Button(onClick = { trigger = !trigger }) {
                Text("트리거")
            }
        }
        onNodeWithText("트리거").performClick()
        assertThat(count).isEqualTo(1)
        onNodeWithText("트리거").performClick()
        assertThat(count).isEqualTo(2)
    }

    @Test
    fun launchedEffectTrigger2() = runComposeUiTest {
        setContent{
            var flag by remember {mutableStateOf(true)}
            var flag2 by remember {mutableStateOf(true)}
            var triggerCount by remember { mutableStateOf(0) }
            LaunchedEffect(key1 = flag, key2 = flag2) {
                triggerCount++
            }
            Button(onClick = { flag = !flag }) {
                Text("트리거")
            }
            Button(onClick = { flag2 = !flag2 }) {
                Text("트리거2")
            }
        }

    }
}


