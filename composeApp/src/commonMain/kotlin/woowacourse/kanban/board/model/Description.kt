package woowacourse.kanban.board.model

data class Description(val text: String) {
    fun isBlank(): Boolean = text.isBlank()

    companion object {
        val empty: Description = Description("")
    }
}
