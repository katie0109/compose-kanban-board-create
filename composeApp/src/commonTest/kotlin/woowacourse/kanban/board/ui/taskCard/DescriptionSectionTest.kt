package woowacourse.kanban.board.ui.taskCard

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.model.Description

@OptIn(ExperimentalTestApi::class)
class DescriptionSectionTest {
    @Test
    fun `설명 뷰는 설명 텍스트를 표시한다`() = runComposeUiTest {
        val description = Description("이걸 설명입니다.")

        setContent {
            DescriptionSection(description = description)
        }

        onNodeWithText("이걸 설명입니다.").assertIsDisplayed()
    }

    @Test
    fun `설명 뷰는 최대 두 줄까지 표시한다`() = runComposeUiTest {
        val description = Description("1\n2")

        setContent {
            DescriptionSection(description = description)
        }

        val descriptionNode = onNodeWithText("2", substring = true)
        descriptionNode.assertIsDisplayed()
    }

}
