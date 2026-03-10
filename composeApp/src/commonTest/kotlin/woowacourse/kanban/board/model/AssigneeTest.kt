package woowacourse.kanban.board.model

import kotlin.test.Test
import kotlin.test.assertFailsWith

class AssigneeTest {
    @Test
    fun `담당자는 빈 텍스트일 수 없다`() {
        assertFailsWith<IllegalArgumentException> {
            Assignee(" ")
        }
    }

    @Test
    fun `담당자는 텍스트 입력 시, 객체가 생성된다`() {
        val assignee = Assignee("다이노")
        assert(assignee.name == "다이노")
    }
}
