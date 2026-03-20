package woowacourse.kanban.board.ui.taskBoard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TaskBoardProgressSection(
    doneCount: Int,
    totalCount: Int,
    ratio: Double,
    modifier: Modifier = Modifier,
){
    Column{
        ProgressText(doneCount, totalCount, ratio)
        ProgressBar(ratio.toFloat())
    }
}

@Composable
private fun ProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
){
    LinearProgressIndicator(
        progress = {progress},
        modifier = modifier.fillMaxWidth()
            .padding(vertical = 16.dp),
        gapSize = 0.dp,
        color = Color(0xFF4F39F6),
        trackColor = Color(0xFFE5E7EB),
        drawStopIndicator = {}
    )

}

@Composable
private fun ProgressText(
    doneCount: Int,
    totalCount: Int,
    ratio: Double,
){
    Text(
        text = "완료율: ${ratio*100}% ($doneCount/$totalCount)",
        modifier = Modifier.padding(top = 4.dp),
        color =  Color(0xFF6A7282)
    )
}

@Preview(showBackground = true)
@Composable
private fun TaskBoardProgressSectionPreview() {
    TaskBoardProgressSection(3,6,0.5)
}


