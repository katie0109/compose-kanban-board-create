package woowacourse.kanban.board.ui.taskForm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.design.Font
import woowacourse.kanban.board.model.Condition

@Composable
fun ConditionInputSection() {
    Column {
        Text(
            text = "태그",
            fontSize = Font.FORMTITLE.size,
            fontWeight = Font.FORMTITLE.weight,
            modifier = Modifier.padding(8.dp),
        )
        Spacer(modifier = Modifier.height(8.dp))
        ConditionInputField()
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
private fun ConditionInputField() {
    Row {
        Condition.entries.forEach {
            ConditionButton(it.text)
        }
    }
}

@Composable
private fun ConditionButton(condition: String) {
    Button(onClick = {}) {
        Text(
            text = condition
        )
    }
}