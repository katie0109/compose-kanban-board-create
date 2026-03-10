package woowacourse.kanban.board.model

data class Assignee(val name: String) {
    init {
        require(name.isNotBlank()) { "[ERROR] 담당자는 빈 값일 수 없습니다." }
    }
}
