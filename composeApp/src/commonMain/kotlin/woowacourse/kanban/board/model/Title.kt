package woowacourse.kanban.board.model

@JvmInline
value class Title(val text: String) {
    init {
        if (text.isBlank()) {
            throw ValidationException(ValidationErrorCode.TITLE_REQUIRED)
        }
    }

    companion object {
        fun validate(input: String): String? =
            if (input.isBlank()) ValidationMessages.TITLE_REQUIRED else null
    }
}
