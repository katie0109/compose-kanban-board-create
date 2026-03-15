package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.ui.taskCard.TagSection

@OptIn(ExperimentalTestApi::class)
class TagSectionTest {
    @Test
    fun `태그 뷰는 태그 텍스트를 표시한다`() = runComposeUiTest {
        val tag = Tag("태그")

        setContent {
            TagSection(tag = tag)
        }

        onNodeWithText("태그").assertIsDisplayed()
    }

    @Test
    fun `태그 뷰는 여러 태그를 표시할 수 있다`() = runComposeUiTest {
        val tags = listOf(Tag("1"), Tag("2"), Tag("3"))

        setContent {
            androidx.compose.foundation.layout.Row {
                tags.forEach { tag ->
                    TagSection(tag = tag)
                }
            }
        }

        onNodeWithText("1").assertIsDisplayed()
        onNodeWithText("2").assertIsDisplayed()
        onNodeWithText("3").assertIsDisplayed()
    }

    @Test
    fun `태그 뷰는 최대 길이 태그 텍스트를 표시한다`() = runComposeUiTest {
        val tag = Tag("다섯글자다")

        setContent {
            TagSection(tag = tag)
        }

        onNodeWithText("다섯글자다").assertIsDisplayed()
    }
}
