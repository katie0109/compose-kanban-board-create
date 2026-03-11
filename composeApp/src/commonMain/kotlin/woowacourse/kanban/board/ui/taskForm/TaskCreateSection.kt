package woowacourse.kanban.board.ui.taskForm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskCreateSection() {
    Column {
        TaskCreateHeaderSection()
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            TitleInputSection()
            DescriptionInputSection()
            TagInputSection()
            ConditionInputSection()
            AssigneeInputSection()
        }
        TaskCreateBottomSection()
    }
}


@Preview(showBackground = true)
@Composable
fun TaskCreateSectionPreview() {
    MaterialTheme {
        TaskCreateSection()
    }
}