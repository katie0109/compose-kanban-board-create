package woowacourse.kanban.board.ui.taskForm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.design.Font

@Composable
fun TagInputSection() {
    Column {
        Text(
            text = "태그",
            fontSize = Font.FORMTITLE.size,
            fontWeight = Font.FORMTITLE.weight,
            modifier = Modifier.padding(8.dp),
        )
        Spacer(modifier = Modifier.height(8.dp))
        TagInputField()
    }
}

@Preview(showBackground = true)
@Composable
private fun TagInputPreview() {
    MaterialTheme {
        TagInputSection()
    }
}

@Composable
private fun TagInputField() {
    var tags: String by remember { mutableStateOf("") }
    OutlinedTextField(
        value = tags,
        onValueChange = {
            tags = it
        },
        placeholder = {
            Text(
                text = "태그를 쉼표로 구분하여 입력하세요(예: 버그, 긴급)",
                fontSize = Font.FORMINPUT.size,
                fontWeight = Font.FORMINPUT.weight,
                color = Color(0xFFAAAAAA)
            )
        },
        supportingText = {
            Text(
                text = "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다.",
                fontSize = Font.FORMEXPLAIN.size,
                fontWeight = Font.FORMEXPLAIN.weight
            )
        }
    )
}