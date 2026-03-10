package woowacourse.kanban.board.ui.taskForm

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.design.ColorPalette
import woowacourse.kanban.board.design.Font


@Composable
fun TitleInputSection() {
    Column {
        Text(
            text = "제목 *",
            fontSize = Font.FORMTITLE.size,
            fontWeight = Font.FORMTITLE.weight,
            modifier = Modifier.padding(8.dp),
        )
        Spacer(modifier = Modifier.height(8.dp))
        TitleInputField()
    }
}

@Preview(showBackground = true)
@Composable
private fun TitleInputPreview() {
    MaterialTheme {
        TitleInputSection()
    }
}

@Composable
private fun TitleInputField() {
    var title: String by remember { mutableStateOf("") }
    OutlinedTextField(

        value = title,
        onValueChange = {
            title = it
        },
        placeholder = {
            Text(
                text = "태스크 제목을 입력하세요",
                fontSize = Font.FORMINPUT.size,
                fontWeight = Font.FORMINPUT.weight,
                color = Color(0xFFAAAAAA)
            )
        }
    )
}