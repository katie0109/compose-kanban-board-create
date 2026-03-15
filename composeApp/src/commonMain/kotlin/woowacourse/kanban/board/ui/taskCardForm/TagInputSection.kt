package woowacourse.kanban.board.ui.taskCardForm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.design.Font
import java.util.regex.Pattern

@Composable
fun TagInputSection(
    onTagsChange: (String) -> Unit = {},
    onErrorChange: (Boolean) -> Unit = {},
) {
    Column {
        Text(
            text = "태그",
            fontSize = Font.FORMTITLE.size,
            fontWeight = Font.FORMTITLE.weight,
            modifier = Modifier.padding(8.dp),
        )
        TagInputField(
            onTagsChange = onTagsChange,
            onErrorChange = onErrorChange,
        )
    }
}

@Composable
private fun TagInputField(
    onTagsChange: (String) -> Unit,
    onErrorChange: (Boolean) -> Unit,
) {
    var tags: String by remember { mutableStateOf("") }
    val tagsPattern = remember {
        Pattern.compile("^[^,]+(\\s*,\\s*[^,]+)*\$")
    }

    val isFormError by remember {
        derivedStateOf {
            tags.isNotEmpty() && !tagsPattern.matcher(tags).matches()
        }
    }

    val isCountError by remember {
        derivedStateOf {
            val splitTags = tags.split(",")
            tags.isNotEmpty() && (splitTags.size > 5 || !splitTags.all { it.trim().length in 1..5 })
        }
    }

    val supportingText by remember {
        derivedStateOf {
            if (isFormError) {
                "태그 형식이 올바르지 않습니다."
            } else {
                "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다."
            }
        }
    }

    LaunchedEffect(isFormError, isCountError) {
        onErrorChange(isFormError || isCountError)
    }

    OutlinedTextField(
        value = tags,
        onValueChange = {
            tags = it
            onTagsChange(it)
        },
        textStyle = TextStyle(color = if (isFormError || isCountError) MaterialTheme.colorScheme.error else Color.Black),
        isError = isFormError || isCountError,
        placeholder = {
            Text(
                text = "태그를 쉼표로 구분하여 입력하세요(예: 버그, 긴급)",
                fontSize = Font.FORMINPUT.size,
                fontWeight = Font.FORMINPUT.weight,
                color = Color(0xFFAAAAAA),
            )
        },
        supportingText = {
            Text(
                text = supportingText,
                fontSize = Font.FORMEXPLAIN.size,
                fontWeight = Font.FORMEXPLAIN.weight,
            )
        },
        trailingIcon = {
            if (isFormError || isCountError) {
                Icon(
                    Icons.Filled.Error, "error", tint = MaterialTheme.colorScheme.error,
                )
            }
        },
        modifier = Modifier.fillMaxWidth(),
    )
}

@Preview(showBackground = true)
@Composable
private fun TagInputPreview() {
    MaterialTheme {
        TagInputSection(
            onTagsChange = {},
            onErrorChange = {},
        )
    }
}
