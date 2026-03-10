package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.model.Title

@OptIn(ExperimentalTestApi::class)
class TitleSectionTest {
    @Test
    fun `제목 뷰는 제목 텍스트를 표시한다`() = runComposeUiTest {
        val title = Title("제목입니다")

        setContent {
            TitleView(title = title)
        }

        onNodeWithText("제목입니다").assertIsDisplayed()
    }

    @Test
    fun `제목 뷰는 긴 제목을 한 줄로 표시한다`() = runComposeUiTest {
        val longTitle = "너무너무 긴 제목은 한 줄이지만 노출되고 말줄임표로 처리합니다 123"
        val title = Title(longTitle)

        setContent {
            TitleView(title = title)
        }

        val titleNode = onNodeWithText("너무너무 긴", substring = true)
        titleNode.assertIsDisplayed()

        onNodeWithText("123").assertDoesNotExist()
    }
}
