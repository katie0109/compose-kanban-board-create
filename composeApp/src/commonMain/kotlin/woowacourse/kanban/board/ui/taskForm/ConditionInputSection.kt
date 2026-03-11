package woowacourse.kanban.board.ui.taskForm

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.design.Font
import woowacourse.kanban.board.model.Condition
import woowacourse.kanban.board.ui.AssigneeSection


@Composable
fun ConditionInputSection() {
    Column {
        Text(
            text = "상태 *",
            fontSize = Font.FORMTITLE.size,
            fontWeight = Font.FORMTITLE.weight,
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
        )
        ConditionField()
    }
}

@Preview(showBackground = true)
@Composable
private fun ConditionInputPreview() {
    MaterialTheme {
        ConditionInputSection()
    }
}


@Composable
fun ConditionField() {
    var selectedCondition by remember { mutableStateOf(Condition.TODO) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Condition.entries.forEach {
            val borderColor = if (selectedCondition == it) Color(0xFF1447E6) else Color(0xFFE5E7EB)
            val backgroundColor = if(selectedCondition == it) Color(0xFFEEF2FF) else Color(0xFFFFFFFF)
            val textColor = if (selectedCondition == it) Color(0xFF1447E6) else Color(0xFF364153)
            Box (
                modifier = Modifier
                    .weight(1f)
                    .border(
                        width = 2.dp,
                        color = borderColor,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(
                        color = backgroundColor
                    )
                    .clickable { selectedCondition = it }
                    .padding(8.dp)
            ) {
                Text(text = it.text, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, color = textColor)
            }
        }
    }
}