package woowacourse.kanban.board.model

data class TagGroup(val tags: List<Tag>) {
    init {
        if (tags.size > MAXIMUM_TAG_COUNT) {
            throw ValidationException(ValidationErrorCode.TAG_LIMIT_INVALID)
        }
    }

    fun isEmpty(): Boolean = tags.isEmpty()

    companion object {
        const val MAXIMUM_TAG_COUNT = 5

        fun validate(input: String): String? {
            if (input.isBlank()) return null

            val tagTexts = input.split(",").map { it.trim() }

            if (tagTexts.any { it.isBlank() }) return ValidationMessages.TAG_FORMAT_INVALID

            if (tagTexts.size > MAXIMUM_TAG_COUNT || tagTexts.any { it.length > Tag.MAXIMUM_TAG_LENGTH }) {
                return ValidationMessages.TAG_LIMIT_INVALID
            }

            return null
        }

        fun parse(input: String): TagGroup {
            if (input.isBlank()) return TagGroup(emptyList())

            val tagTexts = input.split(",").map { it.trim() }

            if (tagTexts.any { it.isBlank() }) {
                throw ValidationException(ValidationErrorCode.TAG_FORMAT_INVALID)
            }

            if (tagTexts.size > MAXIMUM_TAG_COUNT) {
                throw ValidationException(ValidationErrorCode.TAG_LIMIT_INVALID)
            }

            val tags = try {
                tagTexts.map { Tag(it) }
            } catch (e: ValidationException) {
                throw ValidationException(ValidationErrorCode.TAG_LIMIT_INVALID)
            }

            return TagGroup(tags)
        }
    }
}
