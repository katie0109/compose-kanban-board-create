package woowacourse.kanban.board.ui.taskBoard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.model.TaskCard
import woowacourse.kanban.board.model.TaskStatus
import woowacourse.kanban.board.model.statusToBorderColor
import woowacourse.kanban.board.model.statusToContentColor
import woowacourse.kanban.board.model.statusToHeaderColor
import woowacourse.kanban.board.ui.taskCard.TaskCardSection

@Composable
fun StatusBoardSection(
    status: TaskStatus,
    statusCount: Int
){
    Column(
        modifier = Modifier
            .padding(24.dp)
    ){
        StatusBoardHeader(status = status, statusCount = statusCount)
        StatusBoardContent(status = status, tasks = emptyList())
    }
}

@Composable
private fun StatusBoardHeader(
    status: TaskStatus,
    statusCount: Int
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            .background(color = statusToHeaderColor(status))
            .padding(start = 16.dp, top = 12.dp, bottom = 12.dp, end = 16.dp),
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            Text(
                text = status.text,
                fontSize = 16.sp,
                color = Color(0xFFFFFFFF),
            )
            Box(
                modifier = Modifier
                    .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(16.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ){
                Text(
                    text = statusCount.toString(),
                    fontSize = 14   .sp,
                    color = Color(0xFF000000),
                )
            }
        }
    }
}

@Composable
private fun StatusBoardContent(status:TaskStatus, tasks: List<TaskCard> = emptyList()){
    Column(
        modifier = Modifier
            .background(color = statusToContentColor(status))
            .fillMaxSize()
            .border(
            width = 1.dp,
            color = statusToBorderColor(status)
            )
            .padding(8.dp),
    ){
        tasks.forEach { task ->
            TaskCardSection(taskCard = task)
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun StatusBoardSectionPreview(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ){
        StatusBoardSection(TaskStatus.TODO,2)
        StatusBoardSection(TaskStatus.INPROGRESS,1)
        StatusBoardSection(TaskStatus.DONE,3)
    }
}
