package woowacourse.kanban.board.ui.taskCardForm

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class DescriptionInputSectionTest {
    @Test
    fun `설명 입력은 상태를 갱신한다`() = runComposeUiTest {
        var description by mutableStateOf("")

        setContent {
            MaterialTheme {
                DescriptionInputSection(
                    description = description,
                    onDescriptionChange = { description = it },
                )
            }
        }

        onNode(hasSetTextAction()).performTextInput("상세 설명")

        runOnIdle {
            assertEquals("상세 설명", description)
        }
    }
}
