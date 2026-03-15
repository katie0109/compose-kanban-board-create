package woowacourse.kanban.board.ui.taskCard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.model.Description
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.TagGroup
import woowacourse.kanban.board.model.TaskCard
import woowacourse.kanban.board.model.Title

@Composable
fun TaskCardSection(taskCard: TaskCard) {
    Box(
        modifier = Modifier.border(
            border = BorderStroke(1.dp, Color.LightGray),
            shape = RoundedCornerShape(8.dp),
        ).width(250.dp).padding(8.dp),
    ) {
        Column {
            TitleSection(title = taskCard.title)
            if (!taskCard.description.isBlank()) {
                DescriptionSection(description = taskCard.description)
            }
            if (!taskCard.tags.isEmpty()) {
                TagGroupSection(tagGroup = taskCard.tags)
            }
            HorizontalDivider(modifier = Modifier.background(Color.Gray))
            AssigneeSection(assignee = taskCard.assignee)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TaskCardSectionPreview() {
    TaskCardSection(
        taskCard = TaskCard(
            title = Title("LazyColumn 컴포넌트 구현"),
            description = Description("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."),
            tags = TagGroup(listOf(Tag("컴포넌트"), Tag("성능"))),
            assignee = Assignee("다이노"),
        ),
    )
}
