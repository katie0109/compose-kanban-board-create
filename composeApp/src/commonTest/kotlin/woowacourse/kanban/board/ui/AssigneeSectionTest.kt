package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.ui.taskCard.AssigneeSection

@OptIn(ExperimentalTestApi::class)
class AssigneeSectionTest {
    @Test
    fun `담당자 뷰는 담당자 이름을 표시한다`() = runComposeUiTest {
        val assignee = Assignee("다이노")

        setContent {
            AssigneeSection(assignee = assignee)
        }

        onNodeWithText("다이노").assertIsDisplayed()
    }

    @Test
    fun `담당자 뷰는 담당자 아이콘을 표시한다`() = runComposeUiTest {
        val assignee = Assignee("다이노")

        setContent {
            AssigneeSection(assignee = assignee)
        }

        onNodeWithContentDescription("사용자 기본 이미지").assertIsDisplayed()
    }

    @Test
    fun `담당자 뷰는 아이콘과 이름을 함께 표시한다`() = runComposeUiTest {
        val assignee = Assignee("다이노")

        setContent {
            AssigneeSection(assignee = assignee)
        }

        onNodeWithContentDescription("사용자 기본 이미지").assertIsDisplayed()
        onNodeWithText("다이노").assertIsDisplayed()
    }
}
