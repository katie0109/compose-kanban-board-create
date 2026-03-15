package woowacourse.kanban.board.ui.taskCardForm

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class TitleInputSectionTest {
    @Test
    fun `제목 입력은 상태를 갱신한다`() = runComposeUiTest {
        var title by mutableStateOf("")

        setContent {
            MaterialTheme {
                TitleInputSection(
                    title = title,
                    onTitleChange = { title = it },
                    onErrorChange = {},
                )
            }
        }

        onNode(hasSetTextAction()).performTextInput("제목입니다")

        runOnIdle {
            assertEquals("제목입니다", title)
        }
    }

    @Test
    fun `제목이 비어있고 커서가 다른데에 위치할 시, 에러 메시지를 표시한다`() = runComposeUiTest {
        var title by mutableStateOf("")

        setContent {
            MaterialTheme {
                Column {
                    TitleInputSection(
                        title = title,
                        onTitleChange = { title = it },
                        onErrorChange = {},
                    )
                    Button(onClick = {}) {
                        Text("다른 곳")
                    }
                }
            }
        }

        onNode(hasSetTextAction()).performClick()
        onNodeWithText("다른 곳").performClick()

        onNodeWithText("제목을 입력해주세요", useUnmergedTree = true).assertIsDisplayed()
    }

    @Test
    fun `제목이 있으면 커서가 다른데에 위치해도 에러 메시지를 표시하지 않는다`() = runComposeUiTest {
        var title by mutableStateOf("")

        setContent {
            MaterialTheme {
                Column {
                    TitleInputSection(
                        title = title,
                        onTitleChange = { title = it },
                        onErrorChange = {},
                    )
                    Button(onClick = {}) {
                        Text("다른 곳")
                    }
                }
            }
        }

        onNode(hasSetTextAction()).performTextInput("제목")
        onNodeWithText("다른 곳").performClick()

        onNodeWithText("제목을 입력해주세요", useUnmergedTree = true).assertDoesNotExist()
    }
}
