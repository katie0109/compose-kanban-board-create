package woowacourse.kanban.board.ui.taskForm

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskCreateSection() {
    Column {
        TitleInputSection()
        DescriptionInputSection()
        TagInputSection()
        ConditionInputSection()
        AssigneeInputSection()
    }
}


@Preview(showBackground = true)
@Composable
fun TaskCreateSectionPreview() {
    MaterialTheme {
        TaskCreateSection()
    }
}