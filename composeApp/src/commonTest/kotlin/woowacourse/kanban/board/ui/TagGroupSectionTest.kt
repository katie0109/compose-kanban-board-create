package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.TagGroup

@OptIn(ExperimentalTestApi::class)
class TagGroupSectionTest {
    @Test
    fun `태그 그룹 뷰는 비어있는 태그 그룹을 처리할 수 있다`() = runComposeUiTest {
        val tagGroup = TagGroup(emptyList())

        setContent {
            TagGroupView(tagGroup = tagGroup)
        }
    }

    @Test
    fun `태그 그룹 뷰는 하나 이상의 태그를 표시한다`() = runComposeUiTest {
        val tagGroup = TagGroup(listOf(Tag("Front")))

        setContent {
            TagGroupView(tagGroup = tagGroup)
        }

        onNodeWithText("Front").assertIsDisplayed()
    }

    @Test
    fun `태그 그룹 뷰는 5개 이하의 태그를 표시한다`() = runComposeUiTest {
        val tagGroup = TagGroup(
            listOf(
                Tag("1"),
                Tag("2"),
                Tag("3"),
                Tag("4"),
                Tag("5")
            ),
        )

        setContent {
            TagGroupView(tagGroup = tagGroup)
        }

        onNodeWithText("1").assertIsDisplayed()
        onNodeWithText("2").assertIsDisplayed()
        onNodeWithText("3").assertIsDisplayed()
        onNodeWithText("4").assertIsDisplayed()
        onNodeWithText("5").assertIsDisplayed()
    }
}
