package woowacourse.kanban.board

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.model.Description
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.TagGroup
import woowacourse.kanban.board.model.TaskCard
import woowacourse.kanban.board.model.Title
import woowacourse.kanban.board.ui.taskCard.TaskCardSection

@Composable
fun App(taskCards: List<TaskCard> = emptyList()) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.padding(20.dp),
    ) {
        taskCards.forEach { taskCard ->
            TaskCardSection(taskCard = taskCard)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppPreview() {
    MaterialTheme {
        App(taskCards = TaskCardProvider().values.toList())
    }
}

private class TaskCardProvider : PreviewParameterProvider<TaskCard> {
    override val values: Sequence<TaskCard> = sequenceOf(
        TaskCard(
            title = Title("LazyColumn 컴포넌트 구현"),
            description = Description("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."),
            tags = TagGroup(listOf(Tag("컴포넌트"), Tag("성능"))),
            assignee = Assignee("다이노"),
        ),
        TaskCard(
            title = Title("LazyColumn 컴포넌트 구현"),
            tags = TagGroup(listOf(Tag("컴포넌트"), Tag("성능"))),
            assignee = Assignee("다이노"),
        ),
        TaskCard(
            title = Title("LazyColumn 컴포넌트 구현"),
            description = Description("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."),
            assignee = Assignee("다이노"),
        ),
        TaskCard(
            title = Title("LazyColumn 컴포넌트 구현"),
            assignee = Assignee("다이노"),
        ),
        TaskCard(
            title = Title("너무너무 긴 제목은 한 줄이지만 노출되고 말줄임표로 처리합니다"),
            description = Description("너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다"),
            tags = TagGroup(listOf(Tag("너무너무"), Tag("긴 태그"), Tag("최대로"), Tag("5자까지"), Tag("5개제한임"))),
            assignee = Assignee("너무너무너무 긴 담당자도 한 줄이지만 노출되고 말줄임표로 처리합니다"),
        ),
    )
}
