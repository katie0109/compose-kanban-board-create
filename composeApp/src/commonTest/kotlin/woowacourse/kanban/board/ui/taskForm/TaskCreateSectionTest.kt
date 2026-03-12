package woowacourse.kanban.board.ui.taskForm

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class TaskCreateSectionTest {

    @Test
    fun `폼의 주요 섹션 데이터가 화면에 표시된다`() = runComposeUiTest {
        setContent { TaskCreateSection() }

        onNodeWithText("새 태스크 생성").assertIsDisplayed()
        onNodeWithText("제목 *").assertIsDisplayed()
        onNodeWithText("설명").assertIsDisplayed()
        onNodeWithText("태그").assertIsDisplayed()
        onNodeWithText("상태 *").assertIsDisplayed()
        onNodeWithText("담당자 *").assertIsDisplayed()

        onNodeWithText("다이노").assertIsDisplayed()
        onNodeWithText("페임스").assertIsDisplayed()

        onNodeWithText("To Do").assertIsDisplayed()
        onNodeWithText("In Progress").assertIsDisplayed()
        onNodeWithText("Done").assertIsDisplayed()

        onNodeWithText("취소").assertIsDisplayed()
        onNodeWithText("생성").assertIsDisplayed()
    }
}
