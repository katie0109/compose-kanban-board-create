package woowacourse.kanban.board.ui.taskCardForm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.model.Description
import woowacourse.kanban.board.model.TagGroup
import woowacourse.kanban.board.model.TaskCard
import woowacourse.kanban.board.model.TaskStatus
import woowacourse.kanban.board.model.Title

@Composable
fun TaskCreateSection(
    onTaskCreate: (TaskCard) -> Unit = {},
    onCancel: () -> Unit = {},
) {
    val assignees = remember {
        listOf(
            Assignee("다이노"),
            Assignee("페임스"),
        )
    }

    var titleInput by remember { mutableStateOf("") }
    var tagInput by remember { mutableStateOf("") }
    var descriptionInput by remember { mutableStateOf("") }
    var selectedAssignee by remember { mutableStateOf(assignees.first()) }
    var selectedTaskStatus by remember { mutableStateOf(TaskStatus.TODO) }
    
    val titleErrorMessage by remember(titleInput) {
        derivedStateOf { Title.validate(titleInput) }
    }

    val tagErrorMessage by remember(tagInput) {
        derivedStateOf { TagGroup.validate(tagInput) }
    }
    
    val description by remember(descriptionInput) {
        derivedStateOf { Description(descriptionInput) }
    }
    
    val isCreateEnabled by remember(titleErrorMessage, tagErrorMessage) {
        derivedStateOf {
            titleErrorMessage == null && tagErrorMessage == null && titleInput.isNotBlank()
        }
    }

    val resetForm = {
        titleInput = ""
        tagInput = ""
        descriptionInput = ""
        selectedAssignee = assignees.first()
        selectedTaskStatus = TaskStatus.TODO
    }

    val createTask: () -> Unit = {
        if (isCreateEnabled) {
            val taskCard = TaskCard(
                title = Title(titleInput),
                status = selectedTaskStatus,
                description = description,
                tags = TagGroup.parse(tagInput),
                assignee = selectedAssignee,
            )

            onTaskCreate(taskCard)
            resetForm()
        }
    }

    Column {
        TaskCreateHeaderSection()
        Column(
            modifier = Modifier.padding(24.dp),
        ) {
            TitleInputSection(
                title = titleInput,
                onTitleChange = { titleInput = it },
                errorMessage = titleErrorMessage,
            )
            DescriptionInputSection(
                description = descriptionInput,
                onDescriptionChange = { descriptionInput = it },
            )
            TagInputSection(
                tags = tagInput,
                onTagsChange = { tagInput = it },
                errorMessage = tagErrorMessage,
            )
            TaskStatusInputSection(
                selectedTaskStatus = selectedTaskStatus,
                onStatusChange = { selectedTaskStatus = it }
            )
            AssigneeInputSection(
                assignees = assignees,
                selected = selectedAssignee,
                onSelect = { selectedAssignee = it },
            )
        }
        TaskCreateBottomSection(
            isCreateEnabled = isCreateEnabled,
            onCreateClick = createTask,
            onCancelClick = onCancel,
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun TaskCreateSectionPreview() {
    MaterialTheme {
        TaskCreateSection()
    }
}
