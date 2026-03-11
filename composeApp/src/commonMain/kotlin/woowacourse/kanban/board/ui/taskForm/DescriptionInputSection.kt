package woowacourse.kanban.board.ui.taskForm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
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
fun DescriptionInputSection() {
    Column {
        Text(
            text = "설명",
            fontSize = Font.FORMTITLE.size,
            fontWeight = Font.FORMTITLE.weight,
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
        )
        DescriptionInputField()
    }
}


@Preview(showBackground = true)
@Composable
private fun DescriptionInputPreview() {
    MaterialTheme {
        DescriptionInputSection()
    }
}

@Composable
private fun DescriptionInputField() {
    var description: String by remember { mutableStateOf("") }
    OutlinedTextField(
        value = description,
        onValueChange = {
            description = it
        },
        placeholder = {
            Text(
                text = "태스크에 대한 자세한 설명을 입력하세요",
                fontSize = Font.FORMINPUT.size,
                fontWeight = Font.FORMINPUT.weight,
                color = Color(0xFFAAAAAA)
            )
        },
        modifier = Modifier.height(150.dp).fillMaxWidth(),
    )
}