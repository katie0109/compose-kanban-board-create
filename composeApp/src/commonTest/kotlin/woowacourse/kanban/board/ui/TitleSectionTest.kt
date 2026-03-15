package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.model.Title
import woowacourse.kanban.board.ui.taskCard.TitleSection

@OptIn(ExperimentalTestApi::class)
class TitleSectionTest {
    @Test
    fun `제목 뷰는 제목 텍스트를 표시한다`() = runComposeUiTest {
        val title = Title("제목입니다")

        setContent {
            TitleSection(title = title)
        }

        onNodeWithText("제목입니다").assertIsDisplayed()
    }
}
