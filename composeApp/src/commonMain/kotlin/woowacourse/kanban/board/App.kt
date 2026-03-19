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
import woowacourse.kanban.board.ui.taskCardForm.TaskCreateSection

@Composable
fun App() {
    MaterialTheme {
        TaskCreateSection()
    }
}

@Preview(showBackground = true)
@Composable
private fun AppPreview() {
    App()
}

