package woowacourse.kanban.board.ui.taskBoard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.model.Description
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.TagGroup
import woowacourse.kanban.board.model.TaskCard
import woowacourse.kanban.board.model.TaskStatus
import woowacourse.kanban.board.model.Title

@Composable
fun TaskBoardSection(
    tasks: List<TaskCard>,
    onCreateTaskClick: () -> Unit,
) {
    val todoTasks = tasks.filter { it.status == TaskStatus.TODO }
    val inProgressTasks = tasks.filter { it.status == TaskStatus.INPROGRESS }
    val doneTasks = tasks.filter { it.status == TaskStatus.DONE }

    val doneCount = doneTasks.size
    val totalCount = tasks.size
    val ratio = calculateProgress(doneCount, totalCount)

    Column {
        TaskBoardHeader(onCreateTaskClick = onCreateTaskClick)
        TaskBoardProgressSection(
            doneCount = doneCount,
            totalCount = totalCount,
            ratio = ratio,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            StatusBoardSection(
                status = TaskStatus.TODO,
                statusCount = todoTasks.size,
                tasks = todoTasks,
                modifier = Modifier.weight(1f),
            )
            StatusBoardSection(
                status = TaskStatus.INPROGRESS,
                statusCount = inProgressTasks.size,
                tasks = inProgressTasks,
                modifier = Modifier.weight(1f),
            )
            StatusBoardSection(
                status = TaskStatus.DONE,
                statusCount = doneCount,
                tasks = doneTasks,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TaskBoardSectionPreview() {
    TaskBoardSection(
        tasks = previewTasks,
        onCreateTaskClick = {},
    )
}

private val previewTasks = listOf(
    TaskCard(
        title = Title("LazyColumn 컴포넌트 구현"),
        status = TaskStatus.TODO,
        assignee = Assignee("다이노"),
        description = Description("세로 스크롤 가능한 리스트 컴포넌트를 만듭니다."),
        tags = TagGroup(listOf(Tag("컴포넌트"), Tag("성능"))),
    ),
    TaskCard(
        title = Title("Side-effect API 학습"),
        status = TaskStatus.TODO,
        assignee = Assignee("페임스"),
        description = Description("LaunchedEffect, DisposableEffect 예제를 학습합니다."),
        tags = TagGroup(listOf(Tag("학습"), Tag("API"))),
    ),
    TaskCard(
        title = Title("상태 관리 리팩토링"),
        status = TaskStatus.INPROGRESS,
        assignee = Assignee("다이노"),
        description = Description("복잡한 상태를 효율적으로 관리합니다."),
        tags = TagGroup(listOf(Tag("리팩토"), Tag("상태"))),
    ),
    TaskCard(
        title = Title("Mock API 설정"),
        status = TaskStatus.DONE,
        assignee = Assignee("페임스"),
        description = Description("소개 데이터를 로드하는 로직을 구현합니다."),
        tags = TagGroup(listOf(Tag("API"), Tag("비동기"))),
    ),
    TaskCard(
        title = Title("Drag & Drop 기능 구현"),
        status = TaskStatus.DONE,
        assignee = Assignee("다이노"),
        description = Description("다른 컬럼으로 이동하는 기능을 구현합니다."),
        tags = TagGroup(listOf(Tag("기능"), Tag("UX"))),
    ),
    TaskCard(
        title = Title("리컴포지션 최적화"),
        status = TaskStatus.DONE,
        assignee = Assignee("페임스"),
        description = Description("불필요한 리컴포지션을 줄입니다."),
        tags = TagGroup(listOf(Tag("최적화"), Tag("성능"))),
    ),
)

