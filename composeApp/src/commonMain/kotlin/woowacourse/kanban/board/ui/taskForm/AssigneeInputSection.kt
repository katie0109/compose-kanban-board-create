package woowacourse.kanban.board.ui.taskForm

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.ui.AssigneeSection

@Preview(showBackground = true)
@Composable
private fun AssigneeInputSection() {
    val assignees = listOf(
        Assignee("다이노"),
        Assignee("페임스")
    )
    var selected by remember { mutableStateOf(assignees.first()) }
    MaterialTheme {
        AssigneeField(
            assignees = assignees,
            selected = selected,
            onSelect = { selected = it }
        )
    }
}

@Composable
fun AssigneeField(
    assignees: List<Assignee>,
    selected: Assignee,
    onSelect: (Assignee) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        assignees.forEach { assignee ->
            val isSelected = assignee == selected
            val borderColor = if (isSelected) Color(0xFF615FFF) else Color(0xFFE5E7EB)
            val backgroundColor = if(isSelected) Color(0xFFEEF2FF) else Color(0xFFFFFFFF)
            Box(
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = borderColor,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(
                        color = backgroundColor
                    )
                    .clickable { onSelect(assignee) }
                    .padding(4.dp)
            ) {
                AssigneeSection(assignee)
            }
        }
    }
}