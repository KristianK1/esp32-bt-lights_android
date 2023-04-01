package hr.kristiankliskovic.bt_sender_basic_control.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun StateButton(
    state: Boolean,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        modifier = modifier
//            .padding(20.dp)
            .clip(RoundedCornerShape(5.dp))
            .clickable {
                onClick()
            }.background(
                color = if(state) Color.DarkGray else Color.LightGray
            )
            .padding(20.dp),
        textAlign = TextAlign.Center,
    )
}
