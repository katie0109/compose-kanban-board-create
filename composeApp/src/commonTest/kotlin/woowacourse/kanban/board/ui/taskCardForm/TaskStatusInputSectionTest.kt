package woowacourse.kanban.board.ui.taskCardForm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.model.TaskStatus
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class TaskStatusInputSectionTest {

    @Test
    fun `화면에서 상태가 모두 표시된다`() = runComposeUiTest {

        setContent {
            var selectedTaskStatus by remember { mutableStateOf(TaskStatus.TODO) }

            TaskStatusInputSection(
                selectedTaskStatus = selectedTaskStatus,
                onStatusChange = { selectedTaskStatus = it }
            )
        }

        onNodeWithText("To Do").assertIsDisplayed()
        onNodeWithText("In Progress").assertIsDisplayed()
        onNodeWithText("Done").assertIsDisplayed()
    }

    @Test
    fun `TODO 상태가 기본 선택값으로 렌더링된다`() = runComposeUiTest {

        setContent {
            var selectedTaskStatus by remember { mutableStateOf(TaskStatus.TODO) }

            TaskStatusInputSection(
                selectedTaskStatus = selectedTaskStatus,
                onStatusChange = { selectedTaskStatus = it }
            )
        }

        onNodeWithText("To Do").assertIsDisplayed().assertHasClickAction()
    }

    @Test
    fun `In Progress 버튼을 클릭하면 클릭 이벤트가 동작한다`() = runComposeUiTest {

        setContent {
            var selectedTaskStatus by remember { mutableStateOf(TaskStatus.TODO) }

            TaskStatusInputSection(
                selectedTaskStatus = selectedTaskStatus,
                onStatusChange = { selectedTaskStatus = it }
            )
        }

        onNodeWithText("In Progress").performClick()
        onNodeWithText("In Progress").assertIsDisplayed()
    }
}
