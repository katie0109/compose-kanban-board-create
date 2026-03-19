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
        private val TAG_FORMAT_REGEX = Regex("^[^,]+(\\s*,\\s*[^,]+)*$")

        fun validateCode(input: String): ValidationErrorCode? {
            if (input.isBlank()) return null
            if (!TAG_FORMAT_REGEX.matches(input)) return ValidationErrorCode.TAG_FORMAT_INVALID

            val tagTexts = input.split(",").map { it.trim() }
            if (tagTexts.size > MAXIMUM_TAG_COUNT || tagTexts.any { it.length > Tag.MAXIMUM_TAG_LENGTH }) {
                return ValidationErrorCode.TAG_LIMIT_INVALID
            }

            return null
        }

        fun validate(input: String): String? {
            return validateCode(input)?.let(ValidationMessages::messageOf)
        }

        fun parse(input: String): TagGroup {
            if (input.isBlank()) return TagGroup(emptyList())
            if (!TAG_FORMAT_REGEX.matches(input)) {
                throw ValidationException(ValidationErrorCode.TAG_FORMAT_INVALID)
            }

            val tagTexts = input.split(",").map { it.trim() }

            if (tagTexts.size > MAXIMUM_TAG_COUNT) {
                throw ValidationException(ValidationErrorCode.TAG_LIMIT_INVALID)
            }

            val tags = try {
                tagTexts.map { Tag(it) }
            } catch (_: ValidationException) {
                throw ValidationException(ValidationErrorCode.TAG_LIMIT_INVALID)
            }

            return TagGroup(tags)
        }
    }
}
