package woowacourse.kanban.board.model

data class TaskCard(
    val title: Title,
    val description: Description = Description.empty,
    val tags: TagGroup = TagGroup(emptyList()),
    val assignee: Assignee,
)
