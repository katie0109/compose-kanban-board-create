package woowacourse.kanban.board.model

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertIs

class DescriptionTest {
    @Test
    fun `텍스트로 Description 객체를 생성할 수 있다`() {
        val description = Description("이건 설명 텍스트입니다.")
        assertIs<Description>(description)
        val content = description as Description
        assert(content.text == "이건 설명 텍스트입니다.")
    }
    @Test
    fun `빈 공란으로도 isEmpty()가 true가 된다`() {
        val description = Description("")
        assertTrue(description.isBlank())
    }
    @Test
    fun `공백 한 칸으로도 isEmpty()가 true가 된다`() {
        val description = Description(" ")
        assertTrue(description.isBlank())
    }
}
