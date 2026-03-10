package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.model.Assignee

@OptIn(ExperimentalTestApi::class)
class AssigneeSectionTest {
    @Test
    fun `담당자 뷰는 담당자 이름을 표시한다`() = runComposeUiTest {
        val assignee = Assignee("다이노")

        setContent {
            AssigneeView(assignee = assignee)
        }

        onNodeWithText("다이노").assertIsDisplayed()
    }

    @Test
    fun `담당자 뷰는 담당자 아이콘을 표시한다`() = runComposeUiTest {
        val assignee = Assignee("다이노")

        setContent {
            AssigneeView(assignee = assignee)
        }

        onNodeWithContentDescription("사용자 기본 이미지").assertIsDisplayed()
    }

    @Test
    fun `담당자 뷰는 아이콘과 이름을 함께 표시한다`() = runComposeUiTest {
        val assignee = Assignee("다이노")

        setContent {
            AssigneeView(assignee = assignee)
        }

        onNodeWithContentDescription("사용자 기본 이미지").assertIsDisplayed()
        onNodeWithText("다이노").assertIsDisplayed()
    }

    @Test
    fun `담당자 뷰는 긴 이름을 한 줄로 표시한다`() = runComposeUiTest {
        val longName = "너무너무너무 긴 담당자도 한 줄이지만 노출되고 말줄임표로 처리합니 다"
        val assignee = Assignee(longName)

        setContent {
            AssigneeView(assignee = assignee)
        }

        val assigneeNode = onNodeWithText("너무너무", substring = true)

        assigneeNode.assertIsDisplayed()
        onNodeWithText("다").assertDoesNotExist()

    }
}
