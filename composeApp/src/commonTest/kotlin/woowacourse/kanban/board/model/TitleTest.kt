package woowacourse.kanban.board.model

import kotlin.test.Test
import kotlin.test.assertFailsWith

class TitleTest {
    @Test
    fun `제목은 빈 텍스트일 수 없다`() {
        assertFailsWith<IllegalArgumentException> {
            Title(" ")
        }
    }

    @Test
    fun `제목은 텍스트로 입력 시, text에 입력된다`() {
        val title = Title("제대로 된 제목입니다.")
        assert(title.text == "제대로 된 제목입니다.")
    }
}
